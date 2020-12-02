<template>
  <div id="home">
    <v-container>
      <v-row>
        <v-col xl="3" lg="3" md="3" sm="6" xs="6">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-text>
                <div class="card-ds">
                  <v-img src="../../assets/记录.png" contain width="80px" height="80px" position="left"></v-img>
                  <div>
                    <div class="card-title">文章总数</div>
                    <div class="card-number">123</div>
                  </div>
                </div>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
        <v-col xl="3" lg="3" md="3" sm="6" xs="6">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-text>
                <div class="card-ds">
                  <v-img src="../../assets/个人资料.png" contain width="80px" height="80px" position="left"></v-img>
                  <div>
                    <div class="card-title">用户总数</div>
                    <div class="card-number">123</div>
                  </div>
                </div>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
        <v-col xl="3" lg="3" md="3" sm="6" xs="6">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-text>
                <div class="card-ds">
                  <v-img src="../../assets/信息.png" contain width="80px" height="80px" position="left"></v-img>
                  <div>
                    <div class="card-title">评论总数</div>
                    <div class="card-number">123</div>
                  </div>
                </div>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
        <v-col xl="3" lg="3" md="3" sm="6" xs="6">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-text>
                <div class="card-ds">
                  <v-img src="../../assets/位置.png" contain width="80px" height="80px" position="left"></v-img>
                  <div>
                    <div class="card-title">IP 总数</div>
                    <div class="card-number">123</div>
                  </div>
                </div>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
      <v-row>
        <v-col xl="4" lg="4" md="4" sm="12" xs="12">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-title>类别</v-card-title>
              <v-card-text>
                <RoseChart></RoseChart>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
        <v-col xl="4" lg="4" md="4" sm="12" xs="12">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-title>访问量</v-card-title>
              <v-card-text>
                <LineChart></LineChart>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
        <v-col xl="4" lg="4" md="4" sm="12" xs="12">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-title>标签</v-card-title>
              <v-card-text>
                <WorlCloud></WorlCloud>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
      <v-row>
        <v-col xl="12" lg="12" md="12" sm="12" xs="12">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-title>贡献值</v-card-title>
              <v-card-text>
                <ContributionsChart></ContributionsChart>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
      <v-row>
        <v-col xl="7" lg="8" md="8" sm="12" xs="12">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-title>归档</v-card-title>
              <v-card-text>
                <TimeList></TimeList>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
        <v-col xl="5" lg="4" md="4" sm="12" xs="12">
          <v-hover v-slot="{ hover }">
            <v-card :elevation="hover ? 16 : 2" :class="{ 'on-hover': hover }">
              <v-card-title>代办</v-card-title>
              <v-card-text>
                <TodoList></TodoList>
              </v-card-text>
            </v-card>
          </v-hover>
        </v-col>
      </v-row>
    </v-container>
  </div>

</template>

<script>
import LineChart from '@/views/Home/components/LineChart'
import RoseChart from '@/views/Home/components/RoseChart'
import WorlCloud from '@/views/Home/components/WorlCloud'
import TimeList from '@/views/Home/components/TimeList'
import TodoList from '@/views/Home/components/TodoList'
import ContributionsChart from '@/views/Home/components/ContributionsChart'

export default {
  name: 'Home',
  data () {
    return {}
  },
  components: {
    LineChart,
    RoseChart,
    WorlCloud,
    TimeList,
    TodoList,
    ContributionsChart
  }
}
</script>

<style lang="scss" scoped>
#home {
  /*min-height: 100vh;*/
  padding: 10px;
  background-color: #f6f8f9;

  .card-ds {
    color: #000000;
    display: flex;
    justify-content: space-between;
    align-items: center;

    .card-title {
      font-size: 1.25rem;
      font-weight: 500;
      letter-spacing: 0.0125em;
      line-height: 2rem;
      margin-bottom: 0.2em;
    }

    .card-number {
      color: #898989
    }
  }

}
</style>
