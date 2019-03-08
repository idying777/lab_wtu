import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import store from './store'
import './plugins/element.js'
import 'element-ui/lib/theme-chalk/display.css'

Vue.config.productionTip = false

export const api = axios.create(
  {
    baseURL: 'http://localhost:8081/api',
    headers: {
      'Content-Type': 'application/json'
    }
  }
)
Vue.use({
  install(Vue) {
    Vue.prototype.$api = api
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
