<template>
  <el-row id="app" type="flex" justify="center">
    <el-col :xs="24" :sm="22" :md="20" :lg="18" :xl="16">
      <el-header>
        <el-menu default-active="1" mode="horizontal" :router="true">
          <el-menu-item index="/home">首页</el-menu-item>
          <el-menu-item index="/function">机构职能</el-menu-item>
          <el-menu-item index="/category/team">研究团队</el-menu-item>
          <el-menu-item index="/category/result">科研成果</el-menu-item>
          <el-menu-item index="/category/instrument">仪器设备</el-menu-item>
          <el-menu-item index="/category/exchange">开发交流</el-menu-item>
          <el-menu-item><a href="https://www.wtu.edu.cn">学校首页</a></el-menu-item>
        </el-menu>
      </el-header>
      <el-main>
        <router-view/>
      </el-main>
      <el-footer>
        footer
      </el-footer>
    </el-col>
  </el-row>
</template>

<script>
  import { FETCH_DATA } from './store-types'

  export default {
    name: 'app',
    components: {},
    async created() {
      await this.$store.dispatch(FETCH_DATA)
    },
  }
</script>

<style>

</style>
