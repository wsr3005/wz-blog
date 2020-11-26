<template>
  <div>
    <v-row>
      <v-col cols="12" align="end">
        <v-btn color="primary" elevation="2" width="100" @click="create(-1)">+ 新建</v-btn>
        <v-btn style="margin-left: 20px" color="warning" elevation="2" width="100"
        >删除
        </v-btn
        >
      </v-col>
    </v-row>
    <v-dialog
      v-model="dialog"
      width="500"
    >
      <v-card>
        <v-card-title class="headline grey lighten-2">
          {{ dialog_title }}
        </v-card-title>

        <v-card-text>
           <v-row class="mt-5">
             <v-col>
               <v-text-field dense hide-details label="标签名称" :value="dialog_content"></v-text-field>
             </v-col>
           </v-row>
        </v-card-text>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="primary"
            text
            @click="dialog = false"
          >
            确定
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
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
            <v-icon small class="mr-2" @click="create(item)">
              mdi-pencil
            </v-icon>
            <v-icon small @click="deleteItem(item)"> mdi-delete</v-icon>
          </template>
        </v-data-table>
      </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: 'tagsTable',
  data: () => ({
    headers: [
      {
        text: '标签名称',
        value: 'name'
      },
      {
        text: '文章数量',
        value: 'autor'
      },
      {
        text: '发布时间',
        value: 'date'
      },
      {
        text: '操作',
        value: 'actions'
      }
    ],
    desserts: [
      {
        name: 'Frozen Yogurt',
        type: '前端',
        date: '2020-10-11',
        autor: 'wyq',
        state: '已发布',
        tags: 'nginx'
      }
    ],
    dialog: false,
    dialog_title: '',
    dialog_content: ''
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
    create (index) {
      if (index === -1) {
        this.dialog_title = '标签新建'
        this.dialog_content = ''
      } else {
        this.dialog_title = '标签编辑'
        this.dialog_content = 'ssss'
      }
      this.dialog = true
    }
  }
}
</script>

<style lang="scss" scoped>
</style>
