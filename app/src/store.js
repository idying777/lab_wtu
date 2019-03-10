import Vue from 'vue'
import Vuex from 'vuex'
import { FETCH_DATA, SET_FILES, SET_LOGGED_IN, SET_POSTS } from './store-types'
import { api } from './main'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    posts: [],
    files: [],
    logged_in: false
  },
  mutations: {
    [SET_POSTS](state, posts) {
      state.posts = posts
    },
    [SET_LOGGED_IN](state, is) {
      state.logged_in = is
      if (is) {
        localStorage.setItem(SET_LOGGED_IN, 'true')
      } else {
        localStorage.removeItem(SET_LOGGED_IN)
      }
    },
    [SET_FILES](state, files) {
      state.files = files
    }
  },

  actions: {
    async [FETCH_DATA]({commit}) {
      const posts = await api.get('posts')
      commit(SET_POSTS, posts.data._embedded.posts)

      const files = await api.get('files')
      commit(SET_FILES, files.data)

      const logged = localStorage.getItem(SET_LOGGED_IN)
      if (logged) {
        commit(SET_LOGGED_IN, true)
      }
    }
  },

  getters: {
    getPostsByCategory: state => category =>
      state.posts.filter(
        post => post.category === category)
  }
})
