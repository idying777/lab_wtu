<!--suppress ES6CheckImport -->
<template>
  <main>
    <el-row class="container">
      <el-col :span="20">
        <el-button v-on:click="Save">Save</el-button>
        <el-input v-model="title"/>
        <editor v-model="content"
                language="zh_CN"
                mode="wysiwyg"/>
        <el-upload
          :action="actionUrl"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :before-remove="beforeRemove"
          multiple
          :file-list="fileList">
          <el-button size="small" type="primary">点击上传</el-button>
        </el-upload>
      </el-col>
    </el-row>
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
    components:
      {
        Editor
      }
    ,
    props: ['category'],
    data() {
      return {
        actionUrl: 'http://localhost:8081/api/admin/files',
        title: '',
        content: '',
        fileList: []
      }
    }
    ,
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

      beforeRemove(file) {
        return this.$confirm(`确定移除 ${file.name}？`)
      }

    }

  }
</script>

<style scoped lang="scss">

  .container {
    /*position: absolute;*/
    margin: 0;
    top: 0;
    bottom: 0;
    width: 100%;
  }
</style>
