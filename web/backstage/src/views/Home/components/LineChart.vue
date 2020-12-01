<template>
  <div id="LineChart"></div>
</template>

<script>
import { Line } from '@antv/g2plot'

export default {
  name: 'LineChart',
  data: () => ({}),
  mounted () {
    fetch('https://gw.alipayobjects.com/os/bmw-prod/1d565782-dde4-4bb6-8946-ea6a38ccf184.json')
      .then((res) => res.json())
      .then((data) => {
        const line = new Line('LineChart', {
          data,
          padding: 'auto',
          xField: 'Date',
          yField: 'scales',
          xAxis: {
            type: 'timeCat',
            tickCount: 5
          },
          smooth: true
        })
        line.render()
      })
  }
}
</script>

<style scoped>
#LineChart {
  padding: 10px;
  height: 300px;
}
</style>
