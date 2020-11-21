<template>
  <div>
    <div
      v-for="(item, index) in footerList"
      :key="index"
      class="footer-display"
    >
      <v-text-field placeholder="请输入页脚内容" :value="item"></v-text-field>
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
    </div>
    <v-btn class="mx-2" fab dark small color="primary" @click="handleAdd">
      <v-icon dark> mdi-plus </v-icon>
    </v-btn>
    <div class="button-display">
      <v-btn color="primary" elevation="2" width="100">保存</v-btn>
      <v-btn style="margin-left: 20px" color="primary" elevation="2" width="100"
        >发布</v-btn
      >
    </div>
  </div>
</template>

<script>
export default {
  name: 'footerEdit',
  data: () => ({
    footerList: ['123', '222']
  }),
  methods: {
    handleAdd () {
      this.footerList.push('')
    },
    handleDelete (index) {
      this.footerList.splice(index, 1)
    }
  }
}
</script>

<style lang="scss" scoped>
.footer-display {
  display: flex;
  align-items: center;
  width: 60%;
}
.button-display {
  text-align: right;
  margin-right: 3%;
}
</style>
