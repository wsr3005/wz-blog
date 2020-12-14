<template>
  <v-container class="home">
    <v-row>
      <v-col cols="12">
        <carousels></carousels>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="8">
        <v-row>
          <v-col cols="4" class="pt-0 mt-0">
            <v-sheet rounded="lg" min-height="268">
              文章标签
            </v-sheet>
          </v-col>
          <v-col cols="8" class="pt-0 mt-0">
            <v-sheet rounded="lg" min-height="268">
              最近访客
            </v-sheet>
          </v-col>
          <v-col cols="12">
            <v-sheet rounded="lg" min-height="268">
              文章列表
            </v-sheet>
          </v-col>
        </v-row>
      </v-col>

      <v-col cols="4">
        <v-sheet min-height="70vh" rounded="lg">
          代办
        </v-sheet>
      </v-col>

    </v-row>
  </v-container>
</template>

<script>
import carousels from '@/views/Home/components/carousels'

export default {
  name: 'Home',
  components: {
    carousels
  }
}
</script>

<style scoped>
.home {
  width: 1200px;
  margin: 0 auto;
}
</style>
