<template>
  <editor
    :initialValue="editorText"
    :options="editorOptions"
    height="500px"
    initialEditType="markdown"
    previewStyle="vertical"
  />
</template>

<script>
import 'codemirror/lib/codemirror.css'
import '@toast-ui/editor/dist/toastui-editor.css'

import { Editor } from '@toast-ui/vue-editor'

export default {
  name: 'markdownEditor',
  components: {
    editor: Editor
  },
  data () {
    const defaultOptions = {
      minHeight: '200px',
      previewStyle: 'vertical',
      useCommandShortcut: true,
      useDefaultHTMLSanitizer: true,
      usageStatistics: false,
      hideModeSwitch: true,
      toolbarItems: [
        'heading',
        'bold',
        'italic',
        'strike',
        'divider',
        'hr',
        'quote',
        'divider',
        'ul',
        'ol',
        'task',
        'indent',
        'outdent',
        'divider',
        'table',
        'image',
        'link',
        'divider',
        'code',
        'codeblock'
      ]
    }
    return {
      editorText: '',
      editorOptions: defaultOptions
    }
  }
}
</script>

<style scoped>

</style>
