import Vue from 'vue'
import App from './App.vue'
import router from './router'
/*require('bootstrap/dist/css/bootstrap.min.css')
require('../public/_module/icon/iconfont.css')
require('../public/myLayer/layer/skin/layer.css')*/
// ajax
import VueResource from 'vue-resource'
Vue.use(VueResource)

// 国际化 目前还有问题
// import i18n from 'plugin/i18n'
// Vue.use(i18n)
new Vue({
  router,
  /*store,*/
  render: h => h(App)
}).$mount("#app")