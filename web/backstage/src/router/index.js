import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Layouts',
    component: () => import('../layouts/index.vue'),
    children: [{
      path: 'home',
      name: 'Home',
      meta: {
        name: '首页管理'
      },
      component: () => import('../views/HomeSeeting/Home.vue')
    }, {
      path: 'documents',
      name: 'Documents',
      meta: {
        name: '文章分享'
      },
      component: () => import('../views/Documents/index.vue')
    }, {
      path: 'deditorcreate/:id',
      name: 'EditorCreate',
      component: () => import('../views/Documents/editorcreate.vue')
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
