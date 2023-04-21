import Vue from 'vue'

import Cookies from 'js-cookie'

import 'normalize.css/normalize.css'

import Element from 'element-ui'
import './styles/element-variables.scss'

import '@/styles/index.scss'

import App from './App'
import store from './store'
import router from './router'

import './icons' // icon
import './permission' // permission control
import './registerServiceWorker'

import * as filters from './filters' // global filters

//引入echarts样式
import '@/utils/echarts/macarons.js'
import 'echarts-liquidfill'
Vue.use(Element, {
  size: Cookies.get('size') || 'mini', // set element-ui default size
})

// register global utility filters
Object.keys(filters).forEach(key => {
  Vue.filter(key, filters[key])
})


Vue.config.productionTip = true;
import {getApiBaseUrl,getFileBaseUrl} from '@/utils/get-base-config'
import LOG from './utils/self-log'
import * as echarts from 'echarts';

Vue.prototype.LOG = LOG;
Vue.prototype.API_BASE_URL = getApiBaseUrl();
Vue.prototype.FILE_BASE_URL = getFileBaseUrl();
Vue.prototype.$echarts = echarts;

new Vue({
  el: '#app',
  router,
  store,
  created(){
    window.ISLOG = false;
  },
  render: h => h(App)
})
