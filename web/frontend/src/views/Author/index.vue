<template>
  <v-container id="author">

    <v-row>
      <v-col cols="12">
        <v-sheet rounded="lg">
          <h1 class="text-center pt-3 pb-3">关于作者</h1>
          <p v-html="text" class="pa-8"></p>
        </v-sheet>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
export default {
  name: 'index',
  data: () => ({
    text: '一个帅气的90后男生，约炮请加qq'
  })
}
</script>

<style scoped>
#author {
  width: 1200px;
  margin: 0 auto;
}
</style>
