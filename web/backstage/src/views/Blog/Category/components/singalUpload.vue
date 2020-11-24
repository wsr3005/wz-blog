<template>
  <div id="singalUpload">
    <el-upload
      action="https://jsonplaceholder.typicode.com/posts/"
      list-type="picture-card"
      limit="1"
      :on-preview="handlePictureCardPreview"
      :on-remove="handleRemove"
    >
      <i class="el-icon-plus"></i>
    </el-upload>
    <el-dialog :visible.sync="dialogVisible">
      <img width="100%" :src="dialogImageUrl" alt="" />
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: 'singalUpload',
  data: () => ({
    dialogImageUrl: '',
    dialogVisible: false
  }),
  methods: {
    handleRemove (file, fileList) {
      console.log(file, fileList)
    },
    handlePictureCardPreview (file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    }
  }
}
</script>

<style lang="scss" scoped>
#singalUpload {
   margin-left: -24px;
  ::v-deep.el-upload--picture-card {
    margin-bottom: 24px;
    &:hover {
      border-color: #4052b2;
    }
  }
}
</style>
<style>

</style>
