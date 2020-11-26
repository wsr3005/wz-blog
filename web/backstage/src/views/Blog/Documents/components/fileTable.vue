<template>
  <div>
    <v-row>
      <v-col cols="12" align="end">
        <v-btn color="primary" elevation="2" width="100" @click="createDocument">+ 新建</v-btn>
        <v-btn style="margin-left: 20px" color="warning" elevation="2" width="100"
          >删除</v-btn
        >
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-data-table
          :headers="headers"
          :items="desserts"
          :items-per-page="10"
          class="elevation-0"
          show-select
          item-key="name"
        >
          <template v-slot:item.actions="{ item }">
            <v-icon small class="mr-2" @click="editItem(item)">
              mdi-pencil
            </v-icon>
            <v-icon small @click="deleteItem(item)"> mdi-delete </v-icon>
          </template>
        </v-data-table>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: 'footerEdit',
  data: () => ({
    headers: [
      { text: '标题', value: 'title' },
      { text: '类型', value: 'type' },
      { text: '创建人', value: 'autor' },
      { text: '发布日期', value: 'publishDate' },
      { text: '编辑时间', value: 'editTime' },
      { text: '状态', value: 'state' },
      { text: '标签', value: 'tags' },
      { text: '操作', value: 'actions' }
    ],
    desserts: [
      {
        title: 'nginx如何部署',
        type: '前端',
        autor: '王煜桥',
        publishDate: '2020-9-11',
        editTime: '2020-10-26',
        state: '已发布',
        tags: 'nginx'
      }
    ]
  }),
  methods: {
    deleteItem (item) {
      this.desserts.splice(
        this.desserts.findIndex((e) => {
          return e === item
        }),
        1
      )
    },
    createDocument () {
      this.$router.push('/deditorcreate/-1')
    }
  }
}
</script>

<style lang="scss" scoped>
</style>
