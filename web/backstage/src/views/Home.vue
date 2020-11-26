<template>
  <div id="home">
    <v-container>
      <v-row>
        <v-col xl="4" lg="4" md="4" sm="12" xs="12">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-title>总访问量</v-card-title>
              <v-card-text>
                <echarts :options="zfw" style="width:100%;height: 300px"></echarts>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
        <v-col xl="4" lg="4" md="4" sm="12" xs="12">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-title>日访问量</v-card-title>
              <v-card-text>
                <echarts :options="rfw" style="width:100%;height: 300px"></echarts>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
        <v-col xl="4" lg="4" md="4" sm="12" xs="12">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-title>数据比例</v-card-title>
              <v-card-text>
                <echarts :options="sjbl" style="width:100%;height: 300px"></echarts>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
      <v-row>
        <v-col xl="12" lg="12" md="12" sm="12" xs="12">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-title>xxx</v-card-title>
              <v-card-text>
                <div>sssss</div>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
      <v-row>
        <v-col xl="12" lg="12" md="12" sm="12" xs="12">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-title>词云</v-card-title>
              <v-card-text>
                <echartsWordcloud :options="cy" style="height: 300px;width:100%"></echartsWordcloud>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
      </v-row>

    </v-container>
  </div>

</template>

<script>
import echarts from '@/components/echarts'
import echartsWordcloud from '@/components/echartsWordcloud'

export default {
  name: 'Home',
  data () {
    const data = []

    for (let i = 0; i <= 360; i++) {
      const t = i / 180 * Math.PI
      const r = Math.sin(2 * t) * Math.cos(2 * t)
      data.push([r, i])
    }
    return {
      zfw: {
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          data: [820, 932, 901, 934, 1290, 1330, 1320],
          type: 'line',
          areaStyle: {}
        }]
      },
      rfw: {
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          data: [120, 200, 150, 80, 70, 110, 130],
          type: 'bar',
          showBackground: true,
          backgroundStyle: {
            color: 'rgba(220, 220, 220, 0.8)'
          }
        }]
      },
      sjbl: {
        angleAxis: {
          max: 2,
          startAngle: 30,
          splitLine: {
            show: false
          }
        },
        radiusAxis: {
          type: 'category',
          data: ['v', 'w', 'x', 'y', 'z'],
          z: 10
        },
        polar: {},
        series: [{
          type: 'bar',
          data: [4, 3, 2, 1, 0],
          coordinateSystem: 'polar',
          name: 'Without Round Cap',
          color: 'rgba(200, 0, 0, 0.5)',
          itemStyle: {
            borderColor: 'red',
            borderWidth: 1
          }
        }, {
          type: 'bar',
          data: [4, 3, 2, 1, 0],
          coordinateSystem: 'polar',
          name: 'With Round Cap',
          roundCap: true,
          color: 'rgba(0, 200, 0, 0.5)',
          itemStyle: {
            borderColor: 'green',
            borderWidth: 1
          }
        }],
        legend: {
          show: false,
          data: ['Without Round Cap', 'With Round Cap']
        }
      },
      cy: {
        tooltip: {},
        series: [{
          type: 'wordCloud',
          gridSize: 2,
          sizeRange: [12, 50],
          rotationRange: [-90, 90],
          shape: 'pentagon',
          width: '100%',
          height: '100%',
          drawOutOfBound: true,
          textStyle: {
            normal: {
              color: function () {
                return 'rgb(' + [
                  Math.round(Math.random() * 160),
                  Math.round(Math.random() * 160),
                  Math.round(Math.random() * 160)
                ].join(',') + ')'
              }
            },
            emphasis: {
              shadowBlur: 10,
              shadowColor: '#333'
            }
          },
          data: [
            {
              name: 'Sam S Club',
              value: 10000,
              textStyle: {
                normal: {
                  color: 'black'
                },
                emphasis: {
                  color: 'red'
                }
              }
            },
            {
              name: 'Macys',
              value: 6181
            },
            {
              name: 'Amy Schumer',
              value: 4386
            },
            {
              name: 'Jurassic World',
              value: 4055
            },
            {
              name: 'Charter Communications',
              value: 2467
            },
            {
              name: 'Chick Fil A',
              value: 2244
            },
            {
              name: 'Planet Fitness',
              value: 1898
            },
            {
              name: 'Pitch Perfect',
              value: 1484
            },
            {
              name: 'Express',
              value: 1112
            },
            {
              name: 'Home',
              value: 965
            },
            {
              name: 'Johnny Depp',
              value: 847
            },
            {
              name: 'Lena Dunham',
              value: 582
            },
            {
              name: 'Lewis Hamilton',
              value: 555
            },
            {
              name: 'KXAN',
              value: 550
            },
            {
              name: 'Mary Ellen Mark',
              value: 462
            },
            {
              name: 'Farrah Abraham',
              value: 366
            },
            {
              name: 'Rita Ora',
              value: 360
            },
            {
              name: 'Serena Williams',
              value: 282
            },
            {
              name: 'NCAA baseball tournament',
              value: 273
            },
            {
              name: 'Point Break',
              value: 265
            }
          ]
        }]
      }
    }
  },
  components: {
    echarts,
    echartsWordcloud
  }
}
</script>

<style scoped>
#home {
  /*min-height: 100vh;*/
  padding: 10px;
  background-color: #f6f8f9;
}
</style>
