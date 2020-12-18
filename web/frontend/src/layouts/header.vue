<template>
  <v-system-bar flat color="white" height="50" min-width="1200px">

    <div class="header-blog-title">{{ title }}</div>

    <v-tabs centered color="grey darken-1" height="50">
      <v-tab v-for="(link, index) in links" :to="link.url" :key="index"><span class="header-title-item">{{
          link.title
        }}</span></v-tab>
    </v-tabs>

    <div class="header-login">
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
      url: '/home'
    }, {
      title: '作者',
      url: '/home'
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
  width: 400px;
  color: black;
  font-size: 23px;
  font-weight: 500;
  margin-left: 8%;
}

.header-login {
  width: 400px;
  margin-right: 8%;
}

.header-title-item {
  font-size: 15px;
  color: black;
}

</style>
