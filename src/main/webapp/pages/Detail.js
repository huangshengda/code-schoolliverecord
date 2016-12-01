import Vue from 'vue'
import App from './Detail.vue'
import router from './two-router'

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
}).$mount("#detail")