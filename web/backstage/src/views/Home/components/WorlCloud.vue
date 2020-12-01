<template>
  <div id="WorlCloud"></div>
</template>

<script>
import { WordCloud } from '@antv/g2plot'

export default {
  name: 'WorlCloud',
  data: () => ({}),
  mounted () {
    fetch('https://gw.alipayobjects.com/os/antvdemo/assets/data/world-population.json')
      .then((res) => res.json())
      .then((data) => {
        const wordCloud = new WordCloud('WorlCloud', {
          data,
          wordField: 'x',
          weightField: 'value',
          imageMask: 'www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png',
          colorField: 'x',
          wordStyle: {
            fontFamily: 'Verdana',
            fontSize: [24, 80]
          },
          // 设置交互类型
          interactions: [{ type: 'element-active' }],
          state: {
            active: {
              // 这里可以设置 active 时的样式
              style: {
                lineWidth: 3
              }
            }
          }
        })

        wordCloud.render()
      })
  }
}
</script>

<style scoped>
#WorlCloud {
  height: 300px;

}
</style>
