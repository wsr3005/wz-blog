<template>
  <v-app id="inspire">
    <headers></headers>
    <v-main class="grey lighten-3">
      <router-view/>
    </v-main>
    <backToTop></backToTop>
  </v-app>
</template>

<script>
import backToTop from '@/components/backToTop'
import headers from '@/layouts/header'
export default {
  name: 'layouts',
  components: {
    headers,
    backToTop
  }
}
</script>
<style>

html {
  overflow: auto;
}

#inspire {
  min-width: 1200px;
}

.header-title-item {
  font-size: 15px;
  color: black;
}

</style>
