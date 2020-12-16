<template>
  <v-card flat class="mx-auto file-list-border" rounded="0" height="300">
    <v-card-title class="black--text">{{ file.title }}</v-card-title>
    <v-card-subtitle class="pb-0">2020.12.15</v-card-subtitle>
    <v-row dense no-gutters>
      <v-col cols="8">
        <v-card-text class="text--primary">
          <p v-html="file.dres"></p>
        </v-card-text>
      </v-col>
      <v-col cols="4">
        <div style="overflow: hidden" @click="handelClick">
          <v-img class="images" width="90%" height="180px" :src="file.coverUrl"></v-img>
        </div>
      </v-col>
    </v-row>
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
@import "../../../assets/styles/tools";

.images {
  @include image-hover;
  cursor: pointer;
}

.file-list-border {
  border-top: 1px solid #e8eaec;
}

.titles {
  position: absolute;
  top: 0;
  margin-top: 220px
}
</style>
