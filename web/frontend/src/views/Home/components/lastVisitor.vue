<template>
  <v-sheet rounded="lg">
    <div class="titles">最近访客</div>
    <v-item-group class="pa-4">
      <v-row>
        <v-col v-for="n in 10" :key="n" class="d-flex justify-center pa-0 pb-3" cols="3">
          <v-item>
            <div style="text-align: center">
              <v-avatar>
                <img src="https://cdn.vuetifyjs.com/images/john.jpg" alt="John">
              </v-avatar>
              <div>wyq</div>
            </div>
          </v-item>
        </v-col>
      </v-row>
    </v-item-group>
  </v-sheet>
</template>

<script>
export default {
  name: 'lastVisitor',
  data: () => ({
  })
}
</script>

<style scoped>
.titles {
  color: black;
  font-size: 18px;
  font-weight: bolder;
  padding: 10px 0 10px 0;
  margin:0 10px 0 10px;
  border-bottom: 1px solid #e8e9e7;
}
</style>
