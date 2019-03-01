<template>
  <div id="app">
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-menu-item index="1">
        <router-link to="/">首页</router-link>
      </el-menu-item>
      <el-menu-item index="2">
        <router-link to="/">机构职能</router-link>
      </el-menu-item>
      <el-menu-item index="3">
        <router-link to="/">研究团队</router-link>
      </el-menu-item>
      <el-menu-item index="4">
        <router-link to="/">科研成果</router-link>
      </el-menu-item>
      <el-menu-item index="5">
        <a href="https://www.wtu.edu.cn">学校首页</a>
      </el-menu-item>
    </el-menu>
    <router-view/>
  </div>
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
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
