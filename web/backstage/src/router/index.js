import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Layouts',
    component: () => import('../layouts/index.vue'),
    children: [{
      path: '/home',
      name: 'Home',
      meta: {
        name: '首页管理'
      },
      component: () => import('../views/HomeSeeting/Home.vue')
    }]
  },
  {
    path: '/about',
    name: 'About',
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
