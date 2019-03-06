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
      <el-menu-item>
        <el-button v-if="$store.logged_in" v-on:click="logout">退出登录</el-button>
        <el-button v-else v-on:click="login">登录</el-button>
      </el-menu-item>
    </el-menu>
    <el-dialog
      title="系统登录"
      :visible.sync="loginVisible"
      width="30%">
      <el-form :model="form" ref="form" label-position="left" label-width="0"
               class="login-container">
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
          <el-button type="primary" style="flex:1 0 0" v-on:click="submit" :loading="logged_in">登录
          </el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>

  import { LOGIN } from '../store-types'

  export default {
    name: 'Nav',
    data() {
      return {
        loginVisible: false,
        logged_in: false,
        remember: false,
        form: {
          username: 'admin',
          password: ''
        }
      }
    },
    components: {},
    methods: {
      logout() {
        this.$confirm('确认退出吗?', '提示', {}).then(() => {
          sessionStorage.removeItem('username')
          this.$router.push('/')
        })
      },

      login() {
        this.loginVisible = true
      },

      submit() {
        this.logged_in = true
        this.$store.dispatch(LOGIN, this.form).then(() => {
          this.logged_in = this.loginVisible = false
          this.$router.push('/admin')
        }).catch(() => {
          this.logged_in = false
          this.$message('Password Error')
        })
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
