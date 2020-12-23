<template>
  <v-app id="backstage">
    <!--  header  -->
    <v-system-bar height="40" color="primary" app>
      <div class="header-left">
        <v-btn icon color="primary" @click="drawer = true" v-if="!drawer">
          <v-icon color="#fff">mdi-menu</v-icon>
        </v-btn>
        <span class="title">博客后台管理系统</span>
      </div>
      <v-spacer></v-spacer>
      <b-menu></b-menu>
    </v-system-bar>
    <!--  侧边栏  -->
    <v-navigation-drawer v-model="drawer" app>
      <v-sheet color="lighten-4" class="pa-4">
        <v-avatar class="mb-4" size="64" tile>
          <img src="https://www.yunboys.cn/sjtx/api.php">
          <!--        <img :src="autorPic"/>-->
        </v-avatar>
        <div class="onekey">{{ oneKey }}</div>
      </v-sheet>
      <v-divider></v-divider>
      <v-list>
        <v-list-item to="/home">
          <v-list-item-icon>
            <v-icon>mdi-home</v-icon>
          </v-list-item-icon>
          <v-list-item-title>首页</v-list-item-title>
        </v-list-item>

        <v-list-group
          prepend-icon="mdi-blogger"
          color=""
          no-action
        >
          <template v-slot:activator>
            <v-list-item-title>博客管理</v-list-item-title>
          </template>

          <v-list-item to="/documents">
            <v-list-item-title>文章管理</v-list-item-title>
          </v-list-item>
          <v-list-item to="/category">
            <v-list-item-title>分类管理</v-list-item-title>
          </v-list-item>
          <v-list-item to="/tags">
            <v-list-item-title>标签管理</v-list-item-title>
          </v-list-item>
          <v-list-item>
            <v-list-item-title>评论管理</v-list-item-title>
          </v-list-item>
        </v-list-group>

        <v-list-item to="/consumer">
          <v-list-item-icon>
            <v-icon>mdi-account-circle</v-icon>
          </v-list-item-icon>
          <v-list-item-title>用户管理</v-list-item-title>
        </v-list-item>

        <v-list-item>
          <v-list-item-icon>
            <v-icon>mdi-toolbox</v-icon>
          </v-list-item-icon>
          <v-list-item-title>资源管理</v-list-item-title>
        </v-list-item>

        <v-list-group
          prepend-icon="mdi-file-cog"
          color=""
          no-action
        >
          <template v-slot:activator>
            <v-list-item-title>日志管理</v-list-item-title>
          </template>

          <v-list-item>
            <v-list-item-title>操作日志</v-list-item-title>
          </v-list-item>
          <v-list-item>
            <v-list-item-title>用户日志</v-list-item-title>
          </v-list-item>
          <v-list-item>
            <v-list-item-title>异常日志</v-list-item-title>
          </v-list-item>
        </v-list-group>

      </v-list>
    </v-navigation-drawer>
    <!--  中心区域  -->
    <v-main>
      <tags-view class="tags-view"></tags-view>
      <keep-alive :include="cachedViews">
        <router-view/>
      </keep-alive>
    </v-main>
  </v-app>
</template>

<script>
import BMenu from '@/layouts/BMenu'
import Identicon from 'identicon.js'
import axios from 'axios'
import tagsView from '@/layouts/TagsView/index'

export default {
  data: () => ({
    autorPic: null,
    oneKey: '',
    drawer: true
  }),
  computed: {
    cachedViews () {
      return this.$store.state.tagsView.cachedViews
    }
  },
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
    BMenu,
    tagsView
  }
}
</script>
<style lang="scss">

::-webkit-scrollbar-track
{
  -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
  background-color: #F5F5F5;
}

::-webkit-scrollbar
{
  width: 6px;
  height: 6px;
  background-color: #F5F5F5;
}

::-webkit-scrollbar-thumb
{
  background-color: #000000;
}

#backstage {
  .header-left {
    display: flex;
    align-items: center;
    margin-left: 20px;
    color: #fff;
  }

  .onekey {
    font-weight: bold;
  }

  .tags-view {
    //position: sticky;
    //top: 40px;
  }
}

</style>
