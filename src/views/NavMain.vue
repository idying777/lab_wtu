<template>
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
</template>

<script>
  import { LOGIN, LOGOUT } from '../store-types'

  export default {
    name: 'Nav',
    methods: {
      logout() {
        this.$confirm('确认退出吗?', '提示', {}).then(() => {
          sessionStorage.removeItem('username')
          this.$router.push('/')
        })
      },

      login() {
        this.$router.push('/admin/login')
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
