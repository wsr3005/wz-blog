<template>
  <div id="ContributionsChart">

  </div>
</template>

<script>
import { Heatmap, G2 } from '@antv/g2plot'

export default {
  name: 'ContributionsChart',
  data: () => ({}),
  mounted () {
    G2.registerShape('polygon', 'boundary-polygon', {
      draw (cfg, container) {
        const group = container.addGroup()
        const attrs = {
          stroke: '#fff',
          lineWidth: 20,
          fill: cfg.color,
          paht: []
        }
        const points = cfg.points
        const path = [
          ['M', points[0].x, points[0].y],
          ['L', points[1].x, points[1].y],
          ['L', points[2].x, points[2].y],
          ['L', points[3].x, points[3].y],
          ['Z']
        ]
        // @ts-ignore
        attrs.path = this.parsePath(path)
        group.addShape('path', {
          attrs
        })

        // if (cfg.data.lastWeek) {
        //   const linePath = [
        //     ['M', points[2].x, points[2].y],
        //     ['L', points[3].x, points[3].y]
        //   ]
        //   // 最后一周的多边形添加右侧边框
        //   group.addShape('path', {
        //     attrs: {
        //       path: this.parsePath(linePath),
        //       lineWidth: 4,
        //       stroke: '#404040'
        //     }
        //   })
        //   if (cfg.data.lastDay) {
        //     group.addShape('path', {
        //       attrs: {
        //         path: this.parsePath([
        //           ['M', points[1].x, points[1].y],
        //           ['L', points[2].x, points[2].y]
        //         ]),
        //         lineWidth: 4,
        //         stroke: '#404040'
        //       }
        //     })
        //   }
        // }
        return group
      }
    })

    fetch('https://gw.alipayobjects.com/os/antvdemo/assets/data/github-commit.json')
      .then((res) => res.json())
      .then((data) => {
        const heatmapPlot = new Heatmap(document.getElementById('ContributionsChart'), {
          data,
          height: 400,
          autoFit: true,
          xField: 'week',
          yField: 'day',
          colorField: 'commits',
          color: '#BAE7FF-#1890FF-#0050B3',
          reflect: 'y',
          shape: 'boundary-polygon',
          meta: {
            day: {
              type: 'cat',
              values: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
            },
            week: {
              type: 'cat'
            },
            commits: {
              sync: true
            },
            date: {
              type: 'cat'
            }
          },
          yAxis: {
            grid: null
          },
          tooltip: {
            title: 'date',
            showMarkers: false
          },
          interactions: [{ type: 'element-active' }],
          xAxis: {
            position: 'top',
            tickLine: null,
            line: null,
            label: {
              offset: 12,
              style: {
                fontSize: 12,
                fill: '#666',
                textBaseline: 'top'
              },
              formatter: (val) => {
                if (val === '2') {
                  return 'MAY'
                } else if (val === '6') {
                  return 'JUN'
                } else if (val === '10') {
                  return 'JUL'
                } else if (val === '15') {
                  return 'AUG'
                } else if (val === '19') {
                  return 'SEP'
                } else if (val === '24') {
                  return 'OCT'
                }
                return ''
              }
            }
          }
        })
        heatmapPlot.render()
      })
  }
}
</script>

<style scoped>
#ContributionsChart {
  width: 100%;
  padding: 10px;
  margin: 0 auto;
}
</style>
