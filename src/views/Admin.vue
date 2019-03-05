<!--suppress ES6CheckImport -->
<template>
  <editor v-model="editorText"
          language="zh_CN"
          mode="wysiwyg"/>
</template>

<script>
  import 'tui-editor/dist/tui-editor.css'
  import 'tui-editor/dist/tui-editor-contents.css'
  import 'codemirror/lib/codemirror.css'
  import { Editor } from '@toast-ui/vue-editor'

  export default {
    name: 'Admin',
    components: {
      Editor,
    },
    data() {
      return {
        editorText: '',
      }
    },
  }
</script>

<style scoped>

</style>
