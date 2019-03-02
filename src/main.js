import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
import axios from 'axios'
import 'element-ui/lib/theme-chalk/display.css'

Vue.config.productionTip = false

const api = axios.create(
  {
    baseURL: 'http://localhost:8081/api',
  },
)
Vue.use({
  install(Vue) {
    Vue.prototype.$api = api
  },
})

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
