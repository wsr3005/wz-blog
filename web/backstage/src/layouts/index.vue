<template>
  <v-app id="backstage">
    <!--  header  -->
    <v-system-bar height="40" color="primary" app>
      <h1 class="title">博客后台管理系统</h1>
      <v-spacer></v-spacer>
      <b-menu></b-menu>
    </v-system-bar>
    <!--  侧边栏  -->
    <v-navigation-drawer v-model="drawer" app>
      <v-sheet color="grey lighten-4" class="pa-4">
        <v-avatar class="mb-4" size="64" tile>
          <img :src="autorPic">
        </v-avatar>
        <div class="onekey">{{ oneKey }}</div>
      </v-sheet>
      <v-divider></v-divider>
      <v-list>
        <v-list-item v-for="[icon, text, pathName] in links" :key="icon" link @click="handleClick(pathName)">
          <v-list-item-icon>
            <v-icon>{{ icon }}</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>{{ text }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <!--  中心区域  -->
    <v-main>
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
import BMenu from '@/layouts/BMenu'
import Identicon from 'identicon.js'
import axios from 'axios'

export default {
  data: () => ({
    autorPic: null,
    oneKey: '',
    drawer: null,
    links: [
      ['mdi-home', '页面管理', 'Home'],
      ['mdi-file-document-edit', '文章分享', 'Documents'],
      ['mdi-toolbox', '资源分享', '/about'],
      ['mdi-account-supervisor', '作者简介', '/about']
    ]
  }),
  created () {
    this.autorPic = 'data:image/png;base64,' + new Identicon(this.createHash(15), {
      foreground: '#4153af',
      background: '#4153af',
      margin: 0.8,
      size: 420,
      format: 'svg'
    }.toString())
    axios.get('https://v1.hitokoto.cn/').then((res) => {
      this.oneKey = res.data.hitokoto
    }).catch(() => {
      this.oneKey = '呜呜呜~'
    })
  },
  methods: {
    // 生成hash码
    createHash (hashLength) {
      return Array.from(Array(Number(hashLength) || 24), () => Math.floor(Math.random() * 36).toString(36)).join('')
    },
    // 路由跳转
    handleClick (pathName) {
      this.$router.push({
        name: pathName
      })
    }
  },
  components: {
    BMenu
  }
}
</script>
<style lang="scss" scoped>

#backstage {
  .title {
    margin-left: 5%;
    color: #fff;
  }

  .onekey {
    font-weight: bold;
  }
}

</style>
