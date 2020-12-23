<template>
  <v-card class="mx-auto" rounded="lg" height="300">
    <v-card-title class="black--text">{{ file.title }}</v-card-title>
    <v-card-subtitle class="pb-0">2020.12.15</v-card-subtitle>
    <v-row dense no-gutters>
      <v-col cols="8">
        <v-card-text class="text--primary">
          <p v-html="file.dres"></p>
        </v-card-text>
      </v-col>
      <v-col cols="4">
        <div style="overflow: hidden;width: 90%" class="rounded-lg" @click="handelClick">
          <v-img class="images" width="100%" height="180px" :src="file.coverUrl"></v-img>
        </div>
      </v-col>
    </v-row>
    <v-card-actions class="d-flex justify-space-between">
      <v-btn color="orange" text @click="handelClick">开始阅读</v-btn>
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
</template>

<script>
export default {
  name: 'fileList',
  props: ['file'],
  data: () => ({}),
  methods: {
    handelClick () {
      this.$router.push(`/articledetails/${this.file.id}`)
    }
  }
}
</script>

<style lang="scss" scoped>
@import "../../../assets/styles/tools";

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
