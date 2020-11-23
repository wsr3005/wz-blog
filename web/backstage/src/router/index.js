import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Layouts',
    component: () => import('../layouts/index.vue'),
    redirect: '/home',
    children: [{
      path: 'home',
      name: 'Home',
      meta: {
        name: '首页'
      },
      component: () => import('../views/Home.vue')
    }, {
      path: 'pagesetting',
      name: 'PageSetting',
      meta: {
        name: '页面管理'
      },
      component: () => import('../views/PageSetting/index.vue')
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
    }, {
      path: 'author',
      name: 'Author',
      meta: {
        name: '作者介绍'
      },
      component: () => import('../views/Author/index.vue')
    }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../views/Login.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
