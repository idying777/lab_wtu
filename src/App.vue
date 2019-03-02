<template>
  <el-container id="app">
    <el-header>
      <el-row>
        <el-col :span="16" :push="4">
          <el-menu default-active="1" mode="horizontal" :router="true">
            <el-menu-item index="home">首页</el-menu-item>
            <el-menu-item index="function">机构职能</el-menu-item>
            <el-menu-item index="team">研究团队</el-menu-item>
            <el-menu-item index="result">科研成果</el-menu-item>
            <el-menu-item index="instrument">仪器设备</el-menu-item>
            <el-menu-item index="exchange">开发交流</el-menu-item>
            <el-menu-item><a href="https://www.wtu.edu.cn">学校首页</a></el-menu-item>
          </el-menu>
        </el-col>
      </el-row>
    </el-header>
    <router-view/>
  </el-container>
</template>

<script>
  export default {
    name: 'app',
    components: {},
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
    margin-top: 60px;
  }


</style>
