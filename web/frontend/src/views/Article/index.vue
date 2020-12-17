<template>
  <v-container fluid id="article">
    <v-row>
      <v-col cols="12">
        <v-card class="mx-auto" rounded="lg">
          <v-card-title>搜索文章</v-card-title>
          <v-card-text>

            <v-row class="search">
              <v-text-field dense
                            outlined
                            placeholder="搜索"
                            hide-details
                            @keypress.enter.native="handleClick"
                            v-model="searchText">
                <v-icon slot="append" color="red" style="cursor: pointer" @click.native="handleClick">
                  mdi-magnify
                </v-icon>
              </v-text-field>
            </v-row>

            <v-row no-gutters align="center">
              <v-col cols="1">
                <div class="filter-text">分类：</div>
              </v-col>
              <v-col cols="11">
                <v-chip-group show-arrows mandatory multiple active-class="primary">
                  <v-chip label v-for="tag in tags" :key="tag">{{ tag }}</v-chip>
                </v-chip-group>
              </v-col>
            </v-row>

            <v-row no-gutters align="center">
              <v-col cols="1">
                <div class="filter-text">分类：</div>
              </v-col>
              <v-col cols="11">
                <v-chip-group show-arrows mandatory multiple active-class="primary">
                  <v-chip label v-for="tag in tags" :key="tag">{{ tag }}</v-chip>
                </v-chip-group>
              </v-col>
            </v-row>

          </v-card-text>
        </v-card>
      </v-col>

    </v-row>
    <v-row>
      <v-col cols="12" v-for="(file, index) in fileList" :key="index">
        <file-list :file="file"></file-list>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import fileList from '@/views/Article/components/fileList'

export default {
  name: 'index',
  data: () => ({
    searchText: '',
    tags: [
      'web前端', 'java基础', 'springboot', 'vue'
    ],
    fileList: [{
      title: 'wyq真帅',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/1.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      title: 'wyq真丑',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/2.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      title: 'wyq不帅的',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/3.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      title: 'wyq不帅的',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/4.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      title: 'wyq不帅的',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/5.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      title: 'wyq不帅的',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/6.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      title: 'wyq不帅的',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/7.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }]
  }),
  methods: {
    handleClick () {
      alert('123')
    }
  },
  components: {

    fileList

  }
}
</script>

<style lang="scss" scoped>
#article {
  width: 1200px;
  margin: 0 auto;

  .search {
    width: 50%;
    margin: 0 auto;
  }

  .filter-text {
    font-size: 14px;
    color: black;
    text-align: center;
  }
}
</style>
