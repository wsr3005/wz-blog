<template>
  <div id="RoseChart"></div>
</template>

<script>
import { Rose } from '@antv/g2plot'

export default {
  name: 'RoseChart',
  data: () => ({}),
  mounted () {
    const data = [
      {
        type: '分类一',
        value: 27
      },
      {
        type: '分类二',
        value: 25
      },
      {
        type: '分类三',
        value: 18
      },
      {
        type: '分类四',
        value: 15
      },
      {
        type: '分类五',
        value: 10
      },
      {
        type: '其他',
        value: 5
      }
    ]

    const rosePlot = new Rose('RoseChart', {
      data,
      padding: 5,
      xField: 'type',
      yField: 'value',
      seriesField: 'type',
      radius: 0.9,
      innerRadius: 0.1,
      legend: {
        position: 'bottom'
      }
    })
    rosePlot.render()
  }
}
</script>

<style scoped>
#RoseChart {
  height: 300px;
}
</style>
