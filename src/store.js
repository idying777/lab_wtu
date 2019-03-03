import Vue from 'vue'
import Vuex from 'vuex'
import { FETCH_DATA } from './store-types'
import { api } from './main'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    posts: [],
  },
  mutations: {
    setPosts(state, posts) {
      state.posts = posts
    },
  },
  actions: {
    async [FETCH_DATA](context) {
      const posts = await api.get('posts')
      context.commit('setPosts', posts.data._embedded.posts)
    },
  },
  getters: {
    getPostsByCategory: state => category =>
      state.posts.filter(
        post => post.category === category),
  },
})
