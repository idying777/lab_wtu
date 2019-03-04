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
  </el-menu>
</template>

<script>
  export default {
    name: 'Nav',
  }
</script>

<style scoped>
  a {
    display: block;
    text-decoration: none;
  }
</style>
