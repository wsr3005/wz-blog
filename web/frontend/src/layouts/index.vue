<template>
  <v-app id="inspire" v-scroll="onScroll">
    <vheader  v-bind:offsetTop=offsetTop></vheader>
    <v-main class="grey lighten-3">
      <router-view />
    </v-main>
    <backToTop></backToTop>
    <music-play></music-play>
  </v-app>
</template>

<script>
import backToTop from '@/components/backToTop'
import vheader from '@/layouts/header'
import musicPlay from '@/components/musicPlay'
export default {
  name: 'layouts',
  data: () => ({
    offsetTop: document.body.scrollTop
  }),
  methods: {
    onScroll () {
      this.offsetTop = window.pageYOffset
    }
  },
  components: {
    vheader,
    backToTop,
    musicPlay
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

::-webkit-scrollbar-track {
  -webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
  background-color: #f5f5f5;
}

::-webkit-scrollbar {
  width: 6px;
  height: 6px;
  background-color: #f5f5f5;
}

::-webkit-scrollbar-thumb {
  background-color: #000000;
}
</style>
