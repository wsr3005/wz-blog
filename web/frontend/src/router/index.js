import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Layout',
    redirect: '/home',
    component: () => import('../layouts/index'),
    children: [
      {
        path: 'home',
        name: 'Home',
        component: () => import('../views/Home/index')
      },
      {
        path: 'article',
        name: 'Article',
        component: () => import('../views/Article/index')
      },
      {
        path: 'articledetails/:id',
        name: 'ArticleDetails',
        component: () => import('../views/Article/articleDetails')
      },
      {
        path: 'filing',
        name: 'Filing',
        component: () => import('../views/Filing/index')
      }
    ]
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
