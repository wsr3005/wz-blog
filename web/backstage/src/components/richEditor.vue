<template>
  <div id="richEditor"></div>
</template>

<script>
import E from 'wangeditor'

export default {
  name: 'richEditor',
  data: () => ({
    richEditor: null
  }),
  mounted () {
    this.richEditor = new E('#richEditor')
    this.richEditor.config.height = 500
    this.richEditor.config.zIndex = 1
    this.richEditor.config.uploadImgShowBase64 = true
    this.richEditor.create()
  },
  methods: {
    getHtml () {
      return this.richEditor.txt.html()
    }
  }
}
</script>

<style scoped>

</style>
