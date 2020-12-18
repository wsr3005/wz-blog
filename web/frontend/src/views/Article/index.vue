<template>
  <v-container fluid id="article">
    <v-row>
      <v-col cols="3">
        <v-sheet width="275px" rounded="lg" style="position: fixed;">
          <v-list flat rounded="lg">
            <v-subheader>文章分类</v-subheader>
            <v-list-item-group v-model="item" color="primary">
              <v-list-item
                v-for="(item, i) in items"
                :key="i"
              >
                <v-list-item-content>
                  <v-list-item-title v-text="item.text"></v-list-item-title>
                </v-list-item-content>
              </v-list-item>
            </v-list-item-group>
          </v-list>
        </v-sheet>
      </v-col>

      <v-col cols="9" class="pa-0">
        <v-col cols="12" v-for="(file, index) in fileList" :key="index">
          <file-list :file="file"></file-list>
        </v-col>
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
    item: 0,
    items: [
      {
        text: '全部'
      },
      {
        text: 'vue'
      },
      {
        text: 'Spring Boot'
      }
    ],
    fileList: [{
      id: 0,
      title: 'wyq真帅',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/1.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      id: 1,
      title: 'wyq真丑',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/2.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      id: 2,
      title: 'wyq不帅的',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/3.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      id: 3,
      title: 'wyq不帅的',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/4.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      id: 4,
      title: 'wyq不帅的',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/5.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      id: 5,
      title: 'wyq不帅的',
      createTime: '2020.12.15',
      coverUrl: require('@assets/images/6.jpg'),
      dres: '呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜呜~'
    }, {
      id: 6,
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
