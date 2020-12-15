<template>
  <v-app-bar dense color="white" height="50" min-width="1200px">
    <v-col cols="4">
      <v-toolbar-title style="text-align: center">{{ title }}</v-toolbar-title>
    </v-col>
    <v-col cols="4">
      <v-tabs centered color="grey darken-1" height="50">
        <v-tab v-for="link in links" :key="link"><span class="header-title-item">{{ link }}</span></v-tab>
      </v-tabs>
    </v-col>
    <v-col cols="4">
      <v-text-field dense :solo="solo" flat style="width:250px;margin: 0 auto" placeholder="搜索" hide-details
                    @focus="handleFocus"
                    @blur="handleBlur"
                    @keypress.enter.native="handleClick"
                    v-model="searchText">
        <v-icon slot="append" color="red" style="cursor: pointer" @click.native="handleClick">
          mdi-magnify
        </v-icon>
      </v-text-field>
    </v-col>
    <!--      <v-avatar class="hidden-sm-and-down" color="grey darken-1 shrink" size="32"></v-avatar>-->
  </v-app-bar>
</template>

<script>
export default {
  name: 'header',
  data: () => ({
    links: [
      '首页',
      '文章',
      '归档',
      '留言'
    ],
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

</style>
