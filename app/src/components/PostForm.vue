<!--suppress ES6CheckImport -->
<template>
  <el-form label-width="80px" label-position="left">
    <el-form-item label="上传附件">
      <el-upload :action="fileUrl" multiple
                 :file-list="post.fileList"
                 :on-success="handleSuccess"
                 accept="*">
        <el-button>上传</el-button>
      </el-upload>
    </el-form-item>
    <el-form-item>
      <el-button v-on:click="handleSave">保存</el-button>
    </el-form-item>
    <el-form-item label="标题">
      <el-input v-model="post.title"/>
    </el-form-item>
    <el-form-item>
      <editor v-model="post.content"
              language="zh_CN"
              :options="editorOptions"
              mode="wysiwyg"></editor>
    </el-form-item>
  </el-form>
</template>

<script>
  import 'tui-editor/dist/tui-editor.css'
  import 'tui-editor/dist/tui-editor-contents.css'
  import 'codemirror/lib/codemirror.css'
  import { Editor } from '@toast-ui/vue-editor'

  export default {
    name: 'PostForm',
    components: {
      Editor
    },
    props: {
      onSave: {
        type: Function,
        require: true
      },
      post: {
        type: Object,
        default() {
          return {
            title: '',
            content: '',
            fileList: []
          }
        }
      }
    },
    data() {
      return {
        fileUrl: 'http://localhost:8081/api/admin/files',
        editorOptions: {
          hideModeSwitch: true
        }
      }
    },

    methods: {
      handleSave() {
        this.onSave(this.post)
      },
      handleSuccess(r, file, fileList) {
        console.log(fileList, file)
        this.post.fileList = fileList
      }
    }

  }
</script>

<style scoped>

</style>
