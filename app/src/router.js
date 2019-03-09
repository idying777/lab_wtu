import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },

    {
      path: '/home',
      redirect: '/'
    },

    {
      path: '/login',
      name: 'login',
      component: () => import('./views/Login')
    },

    {
      path: '/files',
      name: 'files',
      component: () => import('./views/Files')
    },

    {
      path: '/category/:category',
      name: 'tab',
      component: () => import('./views/CategoryView')
    },

    {
      path: '/category/:category/new',
      name: 'PostNew',
      component: () => import('./views/PostNew')
    },

    {
      path: '/post/:title',
      name: 'PostView',
      component: () => import('./views/PostView')
    },

    {
      path: '/post/:title/edit',
      name: 'PostEdit',
      component: () => import('./views/PostEdit')
    }
  ]
})
