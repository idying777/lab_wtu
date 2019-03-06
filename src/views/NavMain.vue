<!--suppress ES6CheckImport -->
<template>
  <div>
    <el-menu default-active="1" mode="horizontal" :router="true"
             background-color="#545c64"
             text-color="#fff"
             active-text-color="#ffd04b">
      <el-menu-item index="/home">首页</el-menu-item>
      <el-menu-item index="/function">机构职能</el-menu-item>
      <el-menu-item index="/category/team">研究团队</el-menu-item>
      <el-menu-item index="/category/result">科研成果</el-menu-item>
      <el-menu-item index="/category/instrument">仪器设备</el-menu-item>
      <el-menu-item index="/category/exchange">开发交流</el-menu-item>
      <el-menu-item><a href="https://www.wtu.edu.cn">学校首页</a></el-menu-item>

      <template v-if="$store.state.logged_in">
        <el-menu-item>
          <el-button v-on:click="addPost">添加</el-button>
        </el-menu-item>
        <el-menu-item>
          <el-button v-on:click="logout">退出登录</el-button>
        </el-menu-item>
      </template>

      <template v-else>
        <el-menu-item>
          <el-button v-on:click="login">登录</el-button>
        </el-menu-item>
      </template>
    </el-menu>


    <el-dialog
      title="add"
      :visible.sync="postVisible"
      width="70%">
      <el-upload class="el-col-12"
                 :action="fileUrl"
                 :on-remove="handleRemove"
                 multiple
                 :file-list="fileList">
        <el-button class="el-col-24" size="small" type="primary">点击上传</el-button>
      </el-upload>
      <el-button class="el-col-12" v-on:click="Save">Save</el-button>
      <el-input v-model="post.title"/>
      <editor v-model="post.content"
              language="zh_CN"
              mode="wysiwyg"/>
    </el-dialog>

    <el-dialog
      title="系统登录"
      :visible.sync="loginVisible"
      width="30%">
      <el-form :model="form" ref="form" label-position="left" label-width="0">
        <el-form-item>
          <el-input type="text" v-model="form.username" auto-complete="on" placeholder="账号"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="password" v-model="form.password" auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item>
          <el-checkbox v-model="remember" class="remember">记住密码</el-checkbox>
        </el-form-item>
        <el-form-item style="display: flex;justify-content: center">
          <el-button type="primary" style="flex:1 0 0" v-on:click="submit" :loading="logging">登录
          </el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import 'tui-editor/dist/tui-editor.css'
  import 'tui-editor/dist/tui-editor-contents.css'
  import 'codemirror/lib/codemirror.css'
  import { SET_LOGGED_IN, SET_POSTS } from '../store-types'
  import { Editor } from '@toast-ui/vue-editor'
  import * as _ from 'lodash'

  export default {
    name: 'Nav',
    data() {
      return {
        loginVisible: false,
        postVisible: false,
        logging: false,
        remember: false,
        form: {
          username: 'admin',
          password: ''
        },
        fileUrl: 'http://localhost:8081/api/admin/files',
        fileList: [],
        post: {
          title: '',
          content: ''
        }
      }
    },
    components:
      {
        Editor
      },
    methods: {
      logout() {
        this.$confirm('确认退出吗?', '提示', {}).then(() => {
          this.$store.commit(SET_LOGGED_IN, false)
        }).catch()
      },

      login() {
        this.loginVisible = true
      },

      submit() {
        this.logging = true
        this.$api.post('/admin/login', this.form).then(() => {
          this.$store.commit(SET_LOGGED_IN, true)
          this.loginVisible = false
          this.logging = false
        }).catch(() => {
          this.logging = false
          this.$message('Password Error')
        })
      },

      addPost() {
        this.postVisible = true
      },

      Save() {
        const n = _.now()
        const category = this.$route.params.category
        let post = {
          category,
          title: this.post.title,
          content: this.post.content,
          createdAt: n,
          lastModifiedAt: n,
          fileList: this.fileList.map(v => v.name)
        }
        this.$api.post('posts', post).then(r => {
          this.$store.commit(SET_POSTS, _.concat(this.$store.state.posts, r.data))
          this.$message('Save successful')
        }).catch(() => {
          this.$message('save failed')
        })
      },

      handleRemove(file, fileList) {
        console.log(file, fileList)
      }

    }

  }
</script>

<style scoped>
  a {
    display: block;
    text-decoration: none;
  }
</style>
