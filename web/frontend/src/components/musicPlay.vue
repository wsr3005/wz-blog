<template>
  <aplayer
           listFolded
           :list="list"
           :music="{
    title: '给电影人的情书',
    artist: '单依纯',
    src: 'http://chuangshicdn.data.mvbox.cn/music/fc/20/11/15/20111510081167333662.mp3?attachment=1&contextPath=&opusType=fc&opusId=7332395',
    pic: 'https://y.gtimg.cn/music/photo_new/T001R300x300M000002ug9Ha2zYM1y.jpg?max_age=2592000',
  }"
           class="musicplay"

  />
</template>

<script>
import Aplayer from 'vue-aplayer'

export default {
  name: 'musicPlay',
  data: () => ({
    list: []
  }),
  components: {
    Aplayer
  }
}
</script>

<style lang="scss" scoped>
.musicplay {
  position: fixed;
  bottom: 0;
  width: 66px;

  &:hover {
    width: 300px;
    transition-duration: 600ms;
  }

  &:not(hover){
    transition-duration: 600ms;

  }
}

</style>
