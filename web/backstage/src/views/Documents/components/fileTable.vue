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
      { text: '文章名称', value: 'name' },
      { text: '文章类型', value: 'type' },
      { text: '创建时间', value: 'createtime' },
      { text: '创建人', value: 'autor' },
      { text: '状态', value: 'state' },
      { text: '标签', value: 'tags' },
      { text: '操作', value: 'actions' }
    ],
    desserts: [
      {
        name: 'Frozen Yogurt',
        type: '前端',
        createtime: '2020-10-11',
        autor: 'wyq',
        state: '已发布',
        tags: 'nginx'
      },
      {
        name: 'Frozen Yogurt',
        type: '前端',
        createtime: '2020-10-11',
        autor: 'wyq',
        state: '已发布',
        tags: 'nginx'
      },
      {
        name: 'Frozen Yogurt',
        type: '前端',
        createtime: '2020-10-11',
        autor: 'wyq',
        state: '已发布',
        tags: 'nginx'
      },
      {
        name: 'Frozen Yogurt',
        type: '前端',
        createtime: '2020-10-11',
        autor: 'wyq',
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
