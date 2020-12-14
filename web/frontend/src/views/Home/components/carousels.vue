<template>
  <v-carousel class="rounded-lg" height="600" v-model="model" cycle delimiter-icon="mdi-heart" hide-delimiter-background
              show-arrows-on-hover>
    <v-carousel-item v-for="(pic, i) in pics" :key="i" @click.native="handleClick(i)" style="cursor: pointer">
      <div>
        <div class="carousels-title">
          <span>{{ pic.title }}</span>
        </div>
        <v-img class="images" :src="pic.cover" width="100%" height="600"></v-img>
      </div>
    </v-carousel-item>
  </v-carousel>
</template>

<script>

export default {
  name: 'carousels',
  data: () => ({
    model: 0,
    pics: [
      {
        title: 'wyq的老婆1',
        cover: require('../../../assets/images/1.jpg')
      },
      {
        title: 'wyq的老婆2',
        cover: require('../../../assets/images/2.jpg')
      },
      {
        title: 'wyq的老婆3',
        cover: require('../../../assets/images/3.jpg')
      },
      {
        title: 'wyq的老婆4',
        cover: require('../../../assets/images/4.jpg')
      },
      {
        title: 'wyq的老婆5',
        cover: require('../../../assets/images/5.jpg')
      },
      {
        title: 'wyq的老婆6',
        cover: require('../../../assets/images/6.jpg')
      }
    ]
  }),
  methods: {
    handleClick (index) {
      alert('wyq的老婆' + index)
    }
  }
}
</script>

<style lang="scss" scoped>
@import "../../../assets/styles/tools.scss";

.carousels-title {
  display: flex;
  flex-direction: column;
  position: absolute;
  z-index: 999;
  bottom: 0;
  margin-left: 50px;
  margin-bottom: 70px;

  span {
    font-size: 35px;
    font-weight: 500;
  }
}

.images {
  @include image-hover
}

</style>
