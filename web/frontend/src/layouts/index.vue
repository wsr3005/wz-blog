<template>
  <v-app id="inspire">
    <v-app-bar app color="white" flat>
      <v-avatar :color="$vuetify.breakpoint.smAndDown ? 'grey darken-1' : 'transparent'" size="32"></v-avatar>
      <v-tabs centered class="ml-n9" color="grey darken-1">
        <v-tab v-for="link in links" :key="link">{{ link }}</v-tab>
      </v-tabs>
      <v-avatar class="hidden-sm-and-down" color="grey darken-1 shrink" size="32"></v-avatar>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <router-view/>
    </v-main>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    links: [
      '首页',
      '文档',
      '归档',
      '留言'
    ]
  })
}
</script>
<style>
#inspire {
  font-family:, Roboto, sans-serif !important;
}
</style>
