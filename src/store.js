import Vue from 'vue'
import Vuex from 'vuex'
import { FETCH_DATA, LOGIN, LOGOUT, SET_POSTS } from './store-types'
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
    }
  },

  actions: {
    async [FETCH_DATA]({commit}) {
      let posts = await api.get('posts')
      posts = posts.data._embedded.posts
      commit(SET_POSTS, posts)
    },

    [LOGIN]({commit, state}, form) {
      return api.post('admin/login', JSON.stringify(form), () => {
        // localStorage.setItem('username', form.username)
        state.logged_in = true
      })
    },

    [LOGOUT]({commit, state}) {
      state.logged_in = false
    }
  },

  getters: {
    getPostsByCategory: state => category =>
      state.posts.filter(
        post => post.category === category)
  }
})
