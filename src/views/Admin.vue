<!--suppress ES6CheckImport -->
<template>
  <main>
    <el-button v-on:click="Save">Save</el-button>
    <el-input v-model="title"></el-input>
    <editor v-model="content"
            language="zh_CN"
            mode="wysiwyg"/>
    <el-upload
      action=""
      :on-preview="handlePreview"
      :on-remove="handleRemove"
      :before-remove="beforeRemove"
      multiple
      :limit="3"
      :on-exceed="handleExceed"
      :file-list="fileList">
      <el-button size="small" type="primary">点击上传</el-button>
    </el-upload>
  </main>
</template>

<script>
  import 'tui-editor/dist/tui-editor.css'
  import 'tui-editor/dist/tui-editor-contents.css'
  import 'codemirror/lib/codemirror.css'
  import { Editor } from '@toast-ui/vue-editor'
  import { SET_POSTS } from '../store-types'
  import * as _ from 'lodash'

  export default {
    name: 'Admin',
    components: {
      Editor
    },
    props: ['category'],
    data() {
      return {
        title: '',
        content: '',
        fileList: []
      }
    },
    methods: {
      Save() {
        let n = _.now()
        let post = {
          'title': this.title,
          'content': this.content,
          'category': 'team',
          'createdAt': n,
          'lastModifiedAt': n
        }
        this.$api.post('posts', post).then(r => {
          this.$store.commit(SET_POSTS, _.concat(this.$store.state.posts, r.data))
          this.$message('Save successful')
        })
      },

      handleRemove(file, fileList) {
        console.log(file, fileList)
      },
      handlePreview(file) {
        console.log(file)
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`)
      },
      beforeRemove(file) {
        return this.$confirm(`确定移除 ${file.name}？`)
      }
    }
  }
</script>

<style scoped>

</style>
