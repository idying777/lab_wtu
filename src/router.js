import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import EditTest from './views/nav1/EditTest.vue'
import Admin from './views/Admin.vue'


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
      name: 'admin',
      component: () => import('./views/Admin'),
    },
    {
      path: '/admin/login',
      name: 'login',
      component: () => import('./views/Login'),
    },
    {
      path: '/category/:category',
      name: 'tab',
      component: () => import('./components/Tab'),
    },
    {
      path: '/admin',
      component: Admin,
      name: 'nav1',
      iconCls: 'el-icon-message',//图标样式class
      children: [
        { path: '/edit', component: EditTest, name: '主页'},
        { path: '/test2', component: EditTest, name: 'Table' },
        { path: '/test3', component: EditTest, name: 'Form' },
        { path: '/test4', component: EditTest, name: '列表' },
      ]
    },

  ],
})
