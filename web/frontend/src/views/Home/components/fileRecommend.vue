<template>
  <v-sheet rounded="lg">
    <div class="titles">热门文章</div>
    <div class="pa-4">
      <div v-for="(file, index) in files" :key="index" class="item">
        <v-avatar :color="file.color" size="24">
          <span class="white--text  heading">{{ index + 1 }}</span>
        </v-avatar>
        <span class="item-title">{{ file.title }}</span>
      </div>

    </div>
  </v-sheet>
</template>

<script>
export default {
  name: 'todoList',
  data: () => ({
    files: [
      {
        title: '测试1',
        color: 'indigo'
      }, {
        title: '测试2',
        color: 'teal'
      }, {
        title: '测试3',
        color: 'orange'
      }, {
        title: '测试4',
        color: '#808080'
      }, {
        title: '测试5',
        color: '#808080'
      }, {
        title: '测试6',
        color: '#808080'
      }, {
        title: '测试7',
        color: '#808080'
      }, {
        title: '测试8',
        color: '#808080'
      }, {
        title: '测试9',
        color: '#808080'
      }, {
        title: '测试10',
        color: '#808080'
      }
    ]
  })
}
</script>

<style lang="scss" scoped>
.titles {
  color: black;
  font-size: 18px;
  font-weight: bolder;
  padding: 10px 0 10px 0;
  margin: 0 10px 10px 10px;
  border-bottom: 1px solid #e8e9e7;
}

.item {
  margin: 0 0 15px 5px;

  .item-title {
    margin-left: 20px
  }
}
</style>
