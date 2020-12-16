<template>
  <v-app id="inspire">
    <vheader></vheader>
    <v-main class="grey lighten-3">
      <router-view/>
    </v-main>
    <backToTop></backToTop>
  </v-app>
</template>

<script>
import backToTop from '@/components/backToTop'
import vheader from '@/layouts/header'
export default {
  name: 'layouts',
  components: {
    vheader,
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

</style>
