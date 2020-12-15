<template>
  <v-container fluid class="home">
    <v-row>
      <v-col cols="12">
        <carousels></carousels>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="8">
        <v-row>
          <v-col cols="4" class="pt-0 mt-0">
            <file-tags ref="fileTags"></file-tags>
          </v-col>
          <v-col cols="8" class="pt-0 mt-0">
            <last-visitor ref="lastVisitor"></last-visitor>
          </v-col>
          <v-col cols="12" v-for="(file, index) in fileList" :key="index">
            <file-list :file="file"></file-list>
          </v-col>
        </v-row>
      </v-col>
      <v-col cols="4">
        <todo-list></todo-list>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import carousels from '@/views/Home/components/carousels'
import fileList from '@/views/Home/fileList'
import fileTags from '@/views/Home/fileTags'
import lastVisitor from '@/views/Home/lastVisitor'
import todoList from '@/views/Home/todoList'

export default {
  name: 'Home',
  data: () => ({
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
  mounted () {
    const height = Math.max(this.$refs.fileTags.$el.clientHeight, this.$refs.lastVisitor.$el.clientHeight)
    this.$refs.fileTags.$el.style.height = height + 'px'
    this.$refs.lastVisitor.$el.style.height = height + 'px'
  },
  components: {
    carousels,
    fileList,
    fileTags,
    lastVisitor,
    todoList
  }
}
</script>

<style scoped>
.home {
  width: 1200px;
  margin: 0 auto;
}
</style>
