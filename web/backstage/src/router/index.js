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
        name: '首页',
        noCache: false,
        affix: true
      },
      component: () => import('../views/Home.vue')
    }, {
      path: 'pagesetting',
      name: 'PageSetting',
      meta: {
        name: '页面管理',
        noCache: false
      },
      component: () => import('../views/PageSetting/index.vue')
    }, {
      path: 'documents',
      name: 'Documents',
      meta: {
        name: '文章管理',
        noCache: false
      },
      component: () => import('../views/Blog/Documents/index.vue')
    }, {
      path: 'deditorcreate/:id',
      name: 'DEditorCreate',
      meta: {
        name: '文章 编辑/新建',
        noCache: true
      },
      component: () => import('../views/Blog/Documents/editorcreate.vue')
    }, {
      path: 'category',
      name: 'Category',
      meta: {
        name: '分类管理',
        noCache: false
      },
      component: () => import('../views/Blog/Category/index.vue')
    }, {
      path: 'tags',
      name: 'Tags',
      meta: {
        name: '标签管理',
        noCache: false
      },
      component: () => import('../views/Blog/Tags/index.vue')
    }, {
      path: 'consumer',
      name: 'Consumer',
      meta: {
        name: '用户管理',
        noCache: false
      },
      component: () => import('../views/Consumer/index.vue')
    }, {
      path: 'ceditorcreate/:id',
      name: 'CEditorCreate',
      meta: {
        name: '用户 编辑/新建',
        noCache: true
      },
      component: () => import('../views/Consumer/editorcreate.vue')
    }, {
      path: 'author',
      name: 'Author',
      meta: {
        name: '作者介绍',
        noCache: false
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

export { router, routes }
