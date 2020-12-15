<template>
  <v-sheet rounded="lg">
    <v-card class="mx-auto">
      <div style="overflow: hidden" @click="handelClick">
        <v-img class="images" width="100%" height="300px" :src="file.coverUrl"></v-img>
        <v-card-title class="titles white--text">{{ file.title }}</v-card-title>
      </div>
      <v-card-subtitle class="pb-0">2020.12.15</v-card-subtitle>
      <v-card-text class="text--primary">
        <p v-html="file.dres"></p>
      </v-card-text>
      <v-card-actions class="d-flex justify-space-between">
        <v-btn color="orange" text>开始阅读</v-btn>
        <div>
          <v-btn icon color="deep-orange">
            <v-icon>mdi-thumb-up</v-icon>
          </v-btn>
          <v-btn icon color="indigo">
            <v-icon>mdi-star</v-icon>
          </v-btn>
          <v-btn icon color="teal">
            <v-icon>mdi-share-variant</v-icon>
          </v-btn>
        </div>
      </v-card-actions>
    </v-card>
  </v-sheet>
</template>

<script>
export default {
  name: 'fileList',
  props: ['file'],
  data: () => ({}),
  methods: {
    handelClick () {
      alert(123)
    }
  }
}
</script>

<style lang="scss" scoped>
@import "../../assets/styles/tools.scss";

.images {
  @include image-hover;
  cursor: pointer;
}

.titles {
  position: absolute;
  top: 0;
  margin-top: 220px
}
</style>
