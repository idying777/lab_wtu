import Vue from 'vue'
import Router from 'vue-router'
import HomeIndex from './views/home/HomeIndex'
import HomeView from './views/home/HomeView'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: HomeIndex,
      children: [
        {
          path: '/',
          component: HomeView
        },
        {
          path: '/category/:category',
          component: () => import('./views/home/Category')
        },
        {
          path: '/files',
          component: () => import('./views/home/Files')
        },
        {
          path: '/post/:title',
          name: 'PostView',
          component: () => import('./views/home/PostView')
        }
      ]
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
      path: '/post/:title/edit',
      name: 'PostEdit',
      component: () => import('./views/PostEdit')
    },
    {
      path: '/about/edit',
      name: 'AboutEdit',
      component: () => import('./views/AboutEdit')
    }
  ]
})
