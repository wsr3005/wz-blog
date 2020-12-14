<template>
  <v-app id="inspire">
    <v-app-bar app flat dense color="white" height="50">

      <v-col cols="4">
        <v-toolbar-title style="text-align: center">{{ title }}</v-toolbar-title>
      </v-col>
      <v-col cols="4">
        <v-tabs centered color="grey darken-1" height="50">
          <v-tab v-for="link in links" :key="link"><span class="header-title-item">{{ link }}</span></v-tab>
        </v-tabs>
      </v-col>
      <v-col cols="4">
        <v-text-field dense :solo="solo" style="width:300px;" placeholder="请输入搜索内容..." hide-details @focus="handleFocus"
                      @blur="handleBlur"
                      @keypress.enter.native="handleClick"
                      v-model="searchText">
          <v-icon slot="append" color="red" v-show="solo" style="cursor: pointer" @click.native="handleClick">
            mdi-magnify
          </v-icon>
        </v-text-field>
      </v-col>
      <!--      <v-avatar class="hidden-sm-and-down" color="grey darken-1 shrink" size="32"></v-avatar>-->

    </v-app-bar>

    <v-main class="grey lighten-3">
      <router-view/>
    </v-main>
    <backToTop></backToTop>
  </v-app>
</template>

<script>
import backToTop from '@/components/backToTop'

export default {
  data: () => ({
    links: [
      '首页',
      '文章',
      '归档',
      '留言'
    ],
    title: 'wyq-blog!',
    solo: false,
    searchText: ''
  }),
  methods: {
    handleFocus () {
      this.solo = true
    },
    handleBlur () {
      this.solo = false
      this.searchText = ''
    },
    handleClick () {
      alert(this.searchText)
    }
  },
  components: {
    backToTop
  }
}
</script>
<style scoped>

#inspire {
  font-family: Roboto, sans-serif !important;
}

.header-title-item {
  font-size: 14px;
  font-weight: bold;
  color: black;
}

</style>
