import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router/router'
import axios from 'axios';
import jsCookie from 'js-cookie'
import App from './App.vue'


Vue.use(ElementUI)
Vue.config.productionTip = false


new Vue({
  router,
  render: h => h(App),
  beforeCreate() {
    Vue.prototype.$axios = axios;
    Vue.prototype.$cookie = jsCookie;
    Vue.prototype.$bus = this //安装全局事件总线
  }
}).$mount('#app')
