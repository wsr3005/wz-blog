import Vue from 'vue'
import App from './App.vue'
import { router } from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import { Upload, Dialog, Scrollbar } from 'element-ui'

// element 按需引入
Vue.use(Upload)
Vue.use(Dialog)
Vue.use(Scrollbar)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
