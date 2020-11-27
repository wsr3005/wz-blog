<template>
  <div>
    <v-row>
      <v-col cols="12" align="end">
        <v-btn color="primary" elevation="2" width="100" @click="createItem">+ 新建</v-btn>
        <v-btn style="margin-left: 20px" color="warning" elevation="2" width="100"
        >删除
        </v-btn
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
          item-key="title"
          :expanded.sync="expanded"
          show-expand
        >
          <template v-slot:item.actions="{ item }">
            <v-icon small class="mr-2" @click="editItem(item)">
              mdi-pencil
            </v-icon>
            <v-icon small @click="deleteItem(item)"> mdi-delete</v-icon>
          </template>
          <template v-slot:expanded-item="{ headers, item }">
            <td :colspan="headers.length">
              More info about {{ item.name }}
            </td>
          </template>
          <template v-slot:item.avatar="{ item }">
            <v-avatar color="indigo" size="36">
              <span class="white--text headline">{{ item.avatar }}</span>
            </v-avatar>
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
      {
        text: '头像',
        value: 'avatar'
      },
      {
        text: '昵称',
        value: 'title'
      },
      {
        text: '用户名',
        value: 'type'
      },
      {
        text: '用户类型',
        value: 'autor'
      },
      {
        text: '用户邮箱',
        value: 'publishDate'
      },
      {
        text: '性别',
        value: 'editTime'
      },
      {
        text: '账号状态',
        value: 'state'
      },
      {
        text: '最后登录IP',
        value: 'tags'
      },
      {
        text: '最后登录时间',
        value: 'tags'
      },
      {
        text: '创建者',
        value: 'tags'
      },
      {
        text: '创建时间',
        value: 'tags'
      },
      {
        text: '更新者',
        value: 'tags'
      },
      {
        text: '更新时间',
        value: 'tags'
      },
      {
        text: '备注',
        value: 'tags'
      },
      {
        text: '操作',
        value: 'actions'
      }
    ],
    desserts: [
      {
        avatar: 'zx',
        title: 'nginx如何部署1',
        type: '前端',
        autor: '王煜桥',
        publishDate: '2020-9-11',
        editTime: '2020-10-26',
        state: '已发布',
        tags: 'nginx'
      },
      {
        avatar: '王',
        title: 'nginx如何部署2',
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
    createItem () {
      this.$router.push('/ceditorcreate/-1')
    }
  }
}
</script>

<style lang="scss" scoped>
</style>
