<template>
  <v-system-bar app lights-out color="red" height="50" min-width="1200px">

    <v-col xs="0" sm="0" md="0" lg="3" xl="3" class="d-none d-lg-flex">
      <div class="header-blog-title">{{ title }}</div>
    </v-col>

    <v-col xs="8" sm="8" md="8" lg="6" xl="6">
      <v-tabs centered color="grey darken-1" background-color="transparent" height="50">
        <v-tab v-for="(link, index) in links" :to="link.url" :key="index"><span class="header-title-item">{{
            link.title
          }}</span></v-tab>
      </v-tabs>
    </v-col>

    <v-col xs="4" sm="4" md="4" lg="3" xl="3">
      <div class="header-blog-login">
        <v-text-field dense
                      :solo="solo"
                      flat
                      placeholder="搜索"
                      hide-details
                      @focus="handleFocus"
                      @blur="handleBlur"
                      @keypress.enter.native="handleClick"
                      v-model="searchText">
          <v-icon slot="append" color="red" style="cursor: pointer" @click.native="handleClick">
            mdi-magnify
          </v-icon>
        </v-text-field>
      </div>
    </v-col>

    <!--      <v-avatar class="hidden-sm-and-down" color="grey darken-1 shrink" size="32"></v-avatar>-->

  </v-system-bar>
</template>

<script>
export default {
  name: 'header',
  data: () => ({
    links: [{
      title: '首页',
      url: '/home'
    }, {
      title: '文章',
      url: '/article'
    }, {
      title: '归档',
      url: '/filing'
    }, {
      title: '留言',
      url: '/message'
    }, {
      title: '作者',
      url: '/author'
    }],
    title: 'wyq-blog',
    solo: true,
    searchText: ''
  }),
  methods: {
    handleFocus () {
      this.solo = false
    },
    handleBlur () {
      this.solo = true
      this.searchText = ''
    },
    handleClick () {
      alert(this.searchText)
    }
  }
}
</script>

<style scoped>

.header-blog-title {
  color: black;
  font-size: 23px;
  font-weight: 500;
  margin: 0 auto;
}

.header-blog-login {
  width: 70%;
  margin: 0 auto
}
</style>
