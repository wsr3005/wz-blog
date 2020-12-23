<template>
  <v-container id="message">

    <v-row>
      <v-col cols="12">
        <v-sheet rounded="lg" class="pa-3">
          <h1 class="text-center pb-6">留言板</h1>
          <v-textarea outlined
                      auto-grow
                      name="input-7-4"
                      label="沟通交流，拉近你我！"
                      class="pl-3 pr-3"
                      autofocus
          ></v-textarea>
          <v-btn color="primary" class="ml-3 mb-3" width="100">提交留言</v-btn>
        </v-sheet>
      </v-col>
    </v-row>

    <v-row>
      <v-col cols="12">
        <v-sheet rounded="lg" class="pa-3">
          留言板啦啦啦啦啦
        </v-sheet>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
export default {
  name: 'index'
}
</script>

<style scoped>
#message {
  width: 1200px;
  margin: 0 auto;
}
</style>
