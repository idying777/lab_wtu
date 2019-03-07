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
      path: '/category/:category',
      name: 'tab',
      component: () => import('./components/Tab')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('./views/Login')
    },
    {
      path: '/category/:category/new',
      name: 'PostNew',
      component: () => import('./views/PostNew')
    },
    {
      path: '/post/:title',
      name: 'PostEdit',
      component: () => import('./views/PostEdit')
    }
  ]
})
