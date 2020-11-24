<template>
  <div class="index">
    <div class="banner">
      <v-banner class="pt-6 px-6">
        <span>{{ $route.meta.name }}</span>
      </v-banner>
    </div>
    <v-container class="pt-6 px-6" fluid>
      <v-row align="center">
        <v-col cols="3">
          <v-text-field label="分类名称" value="10.00"></v-text-field>
        </v-col>
        <v-col cols="6">
          <v-btn color="primary" elevation="2" width="100">查询</v-btn>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="12">
          <category-table></category-table>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import categoryTable from '@/views/Blog/Category/components/categoryTable'

export default {
  name: 'index',
  data: () => ({
    items: ['123', '321'],
    typeList: ['1', '2']
  }),
  methods: {
  },
  components: {
    categoryTable
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
