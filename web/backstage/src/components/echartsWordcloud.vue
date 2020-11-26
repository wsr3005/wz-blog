<template>
  <v-chart :options="options" :autoresize="true"></v-chart>
</template>

<script>
// import echarts from 'echarts'
import 'echarts-wordcloud/dist/echarts-wordcloud'
import 'echarts-wordcloud/dist/echarts-wordcloud.min'

export default {
  name: 'echartsWordcloud',
  props: {
    options: {
      type: Object,
      default: null
    }
  },
  data: () => ({
  })
}
</script>
