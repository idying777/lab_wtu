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
    }
  },

  actions: {
    async [FETCH_DATA]({commit}) {
      let posts = await api.get('posts')
      posts = posts.data._embedded.posts
      commit(SET_POSTS, posts)
    }
  },

  getters: {
    getPostsByCategory: state => category =>
      state.posts.filter(
        post => post.category === category)
  }
})
