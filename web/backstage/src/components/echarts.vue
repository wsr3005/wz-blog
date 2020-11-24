<template>
  <v-chart :options="options" :autoresize="true"></v-chart>
</template>

<script>
export default {
  name: 'echarts',
  props: ['options'],
  data: () => ({

  }),
  created () {
    console.log(this.options)
  }
}
</script>

<style scoped>
.echarts {
  width: 100%;
  height: 100%;
}
</style>
