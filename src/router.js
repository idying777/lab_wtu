import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import Login from './views/Login.vue'
import Admin from './views/Admin'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/home',
      redirect: '/',
    },
    {
      path: '/admin',
      component: Admin,
      name: 'admin',
    },
    {
      path: '/admin/login',
      component: Login,
      name: 'login',
    },
    {
      path: '/category/:category',
      name: 'tab',
      component: () => import('./components/Tab'),
    },

  ],
})
