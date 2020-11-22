<template>
  <div class="index">
    <div class="banner">
      <v-banner class="pt-6 px-6">
        <span>{{ $route.meta.name }}</span>
      </v-banner>
    </div>
    <v-container class="px-6" fluid>
      <v-row>
        <!-- 文章分享 -->
        <v-col cols="12">
          <v-row align="center">
            <v-col cols="3">
              <v-text-field label="文章类型" value="10.00"></v-text-field>
            </v-col>
            <v-col cols="3">
              <v-select label="状态" :items="items" value="123"></v-select>
            </v-col>
            <v-col cols="6">
              <v-btn color="primary" elevation="2" width="100">查询</v-btn>
              <v-btn
                style="margin-left: 20px"
                color="info"
                elevation="2"
                width="100"
                @click="dialog = !dialog"
                >编辑类型</v-btn
              >
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12">
              <file-table></file-table>
            </v-col>
          </v-row>
          <!-- 类型编辑框 -->
          <v-row>
            <v-dialog v-model="dialog" persistent max-width="600px">
              <v-card>
                <v-card-title>
                  <span class="headline">类型</span>
                </v-card-title>
                <v-card-text>
                  <v-container>
                    <v-row
                      v-for="(item, index) in typeList"
                      :key="index"
                      align="center"
                    >
                      <v-col cols="8">
                        <v-text-field
                          label="类型名称"
                          :value="item"
                          dense
                          hide-details
                          required
                        ></v-text-field>
                      </v-col>
                      <v-col colos="4">
                        <v-btn
                          class="mx-5"
                          fab
                          dark
                          small
                          color="warning"
                          @click="handleDelete(index)"
                        >
                          <v-icon dark> mdi-delete </v-icon>
                        </v-btn>
                      </v-col>
                    </v-row>
                    <v-row>
                      <v-btn
                        class="mx-2"
                        fab
                        dark
                        small
                        color="primary"
                        @click="handleAdd"
                      >
                        <v-icon dark> mdi-plus </v-icon>
                      </v-btn>
                    </v-row>
                  </v-container>
                  <small>*indicates required field</small>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="dialog = false">
                    Close
                  </v-btn>
                  <v-btn color="blue darken-1" text @click="dialog = false">
                    Save
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-row>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import fileTable from '@/views/Documents/components/fileTable'
export default {
  name: 'index',
  data: () => ({
    items: ['123', '321'],
    typeList: ['1', '2'],
    dialog: false
  }),
  methods: {
    handleDelete (index) {
      this.typeList.splice(index, 1)
    },
    handleAdd () {
      this.typeList.push('')
    }
  },
  components: {
    fileTable
  }
}
</script>

<style lang="scss" scoped>
.index {
  .banner {
    span {
      color: black;
      font-weight: bold;
      font-size: 1.3em;
    }
  }
}
</style>
