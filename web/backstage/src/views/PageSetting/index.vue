<template>
  <div class="index">
    <div class="banner">
      <v-banner class="py-6 px-6">
        <span>{{ $route.meta.name }}</span>
      </v-banner>
    </div>
    <v-container class="px-6" fluid>
      <v-row>
        <!-- 轮播图 -->
        <v-col cols="12">
          <v-card elevation="5">
            <v-card-title>轮播图</v-card-title>
            <v-card-text>
              <pic-upload></pic-upload>
            </v-card-text>
          </v-card>
        </v-col>
        <!-- 页脚设置 -->
        <v-col cols="12">
          <v-card elevation="5">
            <v-card-title>页脚</v-card-title>
            <v-card-text>
              <footer-edit></footer-edit>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import picUpload from '@/views/PageSetting/components/picUpload'
import footerEdit from '@/views/PageSetting/components/footerEdit'
export default {
  name: 'index',
  data: () => ({
    filelist: []
  }),
  components: {
    picUpload,
    footerEdit
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
