import Vue from 'vue'
import Vuex from 'vuex'
import { FETCH_DATA, LOGIN } from './store-types'
import { api } from './main'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    posts: []
  },
  mutations: {
    setPosts(state, posts) {
      state.posts = posts
    }

  },

  actions: {
    async [FETCH_DATA](context) {
      const posts = await api.get('posts')
      context.commit('setPosts', posts.data._embedded.posts)
    },

    [LOGIN](context, form) {
      return api.post('admin/login', JSON.stringify(form), () => {
        localStorage.setItem('username', form.username)
      })
    }
  },

  getters: {
    getPostsByCategory: state => category =>
      state.posts.filter(
        post => post.category === category)
  }
})
