import Vue from 'vue'
import Vuex from 'vuex'
import {
  EDIT_POST,
  EDIT_POST_CLOSE,
  FETCH_DATA,
  SET_LOGGED_IN,
  SET_POSTS
} from './store-types'
import { api } from './main'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    posts: [],
    logged_in: false,
    edit: false,
    edit_post: null
  },
  mutations: {
    [SET_POSTS](state, posts) {
      state.posts = posts
    },
    [SET_LOGGED_IN](state, is) {
      state.logged_in = is
    },

    [EDIT_POST](state, post) {
      state.edit = true
      state.edit_post = post
    },
    [EDIT_POST_CLOSE](state) {
      state.edit = false
      state.edit_post = null
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
