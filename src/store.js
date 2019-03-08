import Vue from 'vue'
import Vuex from 'vuex'
import { FETCH_DATA, SET_LOGGED_IN, SET_POSTS } from './store-types'
import { api } from './main'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    posts: [],
    logged_in: false
  },
  mutations: {
    [SET_POSTS](state, posts) {
      state.posts = posts
    },
    [SET_LOGGED_IN](state, is) {
      state.logged_in = is
      if (!is) {
        localStorage.removeItem('logged_in')
      }
    }
  },

  actions: {
    async [FETCH_DATA]({commit}) {
      let posts = await api.get('posts')
      posts = posts.data._embedded.posts
      commit(SET_POSTS, posts)
      const logged_username = localStorage.getItem('logged_in')
      if (logged_username) {
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
