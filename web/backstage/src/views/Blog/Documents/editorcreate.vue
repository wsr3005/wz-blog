<template>
  <div class="editorcreate">
    <div class="banner">
      <v-banner class="pt-6 px-6">
        <span>{{ title }}</span>
      </v-banner>
    </div>
    <v-container class="px-10 pt-5" fluid>
      <v-row align="baseline" dense>
        <v-col cols="1">
          <v-subheader>标题</v-subheader>
        </v-col>
        <v-col cols="3">
          <v-text-field dense hide-details :value="form.title"></v-text-field>
        </v-col>
      </v-row>
      <v-row align="baseline" dense>
        <v-col cols="1">
          <v-subheader>类型</v-subheader>
        </v-col>
        <v-col cols="3">
          <v-select
            :items="items"
            dense
            hide-details
            :value="form.type"
          ></v-select>
        </v-col>
      </v-row>
      <v-row align="baseline" dense>
        <v-col cols="1">
          <v-subheader>发布时间</v-subheader>
        </v-col>
        <v-col cols="3">
          <v-menu
            ref="menu"
            v-model="form.createTime"
            :close-on-content-click="false"
            :return-value.sync="date"
            transition="scale-transition"
            offset-y
            min-width="290px"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                v-model="date"
                readonly
                v-bind="attrs"
                v-on="on"
                dense
                hide-details
              ></v-text-field>
            </template>
            <v-date-picker v-model="date" no-title scrollable>
              <v-spacer></v-spacer>
              <v-btn text color="primary" @click="menu = false"> Cancel</v-btn>
              <v-btn text color="primary" @click="$refs.menu.save(date)">
                OK
              </v-btn>
            </v-date-picker>
          </v-menu>
        </v-col>
      </v-row>
      <v-row align="baseline" dense>
        <v-col cols="1">
          <v-subheader>创建人</v-subheader>
        </v-col>
        <v-col cols="3">
          <v-text-field dense hide-details :value="form.autor"></v-text-field>
        </v-col>
      </v-row>
      <v-row align="baseline" dense>
        <v-col cols="1">
          <v-subheader>标签</v-subheader>
        </v-col>
        <v-col cols="3">
          <v-icon class="add-button" @click="handelAddTag">mdi-plus</v-icon>
        </v-col>
      </v-row>
      <v-row align="baseline" dense>
        <v-col cols="1">
          <v-subheader>封面上传</v-subheader>
        </v-col>
        <v-col cols="11">
          <singal-upload></singal-upload>
        </v-col>
      </v-row>
      <v-row align="start" dense>
        <v-col cols="1">
          <v-subheader>文章内容</v-subheader>
        </v-col>
        <v-col cols="11">
          <v-radio-group v-model="form.contentType" mandatory row dense>
            <v-radio label="markdown" value="1"></v-radio>
            <v-radio label="富文本" value="2"></v-radio>
          </v-radio-group>
          <rich-editor ref="richeditor" v-if="form.contentType == 2"></rich-editor>
          <markdown-editor v-else></markdown-editor>
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
import singalUpload from '@/components/singalUpload'
import richEditor from '@/components/richEditor'
import markdownEditor from '@/components/markdownEditor'

export default {
  name: 'DEditorCreate',
  data: () => ({
    form: {
      title: '',
      type: '',
      createTime: '',
      autor: '',
      tags: '',
      picUrl: '',
      contentType: '',
      richText: ''
    },
    richEditor: null,
    dialog: false
  }),
  computed: {
    title: function () {
      if (this.$route.params.id === '-1') {
        return '文章新建'
      } else {
        return '文章编辑'
      }
    }
  },
  methods: {
    handelAddTag () {
      alert(123)
    },
    save () {
      console.log(this.$refs.richeditor.getHtml())
    }
  },
  components: {
    singalUpload,
    richEditor,
    markdownEditor
  }
}
</script>

<style lang="scss" scoped>
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
