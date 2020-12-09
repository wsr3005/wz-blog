<template>
  <div class="home">
    <v-container>
      <v-row>
        <v-col cols="12">
          <carousels></carousels>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="12" sm="2">
          <v-sheet rounded="lg" min-height="268">
            ssss
          </v-sheet>
        </v-col>

        <v-col cols="12" sm="8">
          <v-sheet min-height="70vh" rounded="lg">
            <!--  -->
          </v-sheet>
        </v-col>

        <v-col cols="12" sm="2">
          <v-sheet rounded="lg" min-height="268">
            <!--  -->
          </v-sheet>
        </v-col>
      </v-row>
    </v-container>
  </div>
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
