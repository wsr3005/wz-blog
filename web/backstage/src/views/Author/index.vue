<template>
  <div class="editorcreate">
    <div class="banner">
      <v-banner class="pt-6 px-6">
        <span>{{ $route.meta.name }}</span>
      </v-banner>
    </div>
    <v-container class="px-10 pt-5" fluid>

      <v-row align="start" dense>
        <v-col cols="12">
          <rich-editor ref="richeditor"></rich-editor>
        </v-col>
      </v-row>
      <div class="button-display">
        <v-btn color="primary" elevation="2" width="100" @click="save">保存</v-btn>
        <v-btn
          style="margin-left: 20px"
          color="primary"
          elevation="2"
          width="100"
        >发布
        </v-btn
        >
        <v-btn
          style="margin-left: 20px"
          color="info"
          elevation="2"
          width="100"
        >取消
        </v-btn
        >
      </div>
    </v-container>
  </div>
</template>

<script>
import richEditor from '@/components/richEditor'
export default {
  name: 'index',
  data: () => ({
    form: {}
  }),
  components: {
    richEditor
  }
}
</script>

<style scoped lang="scss">
.editorcreate {
  .banner {
    span {
      color: black;
      font-weight: bold;
      font-size: 1.3em;
    }
  }

  .add-button:hover {
    color: #4052b2;
    cursor: pointer;
  }

  .button-display {
    text-align: right;
    margin: 20px 3% 10px 0;
  }
}
</style>
