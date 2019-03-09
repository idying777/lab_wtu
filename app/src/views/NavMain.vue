<template>
  <div class="header">
    <el-menu class="container menu" default-active="1" mode="horizontal" :router="true"
             background-color="inherit"
             text-color="#fff"
             active-text-color="#A2F8C0">
      <el-menu-item index="/home">首页</el-menu-item>

      <el-submenu index="2">
        <template slot="title">机构职能</template>
        <el-menu-item index="2-1">选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
      </el-submenu>

      <el-menu-item index="/category/team">研究团队</el-menu-item>
      <el-menu-item index="/category/result">科研成果</el-menu-item>
      <el-menu-item index="/category/instrument">仪器设备</el-menu-item>
      <el-menu-item index="/category/exchange">开发交流</el-menu-item>
      <el-menu-item index="/files">下载专区</el-menu-item>
      <el-menu-item><a href="https://www.wtu.edu.cn">学校首页</a></el-menu-item>

      <template v-if="$store.state.logged_in">
        <el-menu-item v-if="category">
          <el-button v-on:click="addPost">添加</el-button>
        </el-menu-item>
        <el-menu-item>
          <el-button v-on:click="logout">退出登录</el-button>
        </el-menu-item>
      </template>
    </el-menu>
  </div>
</template>

<script>
  import { SET_LOGGED_IN } from '../store-types'

  export default {
    name: 'Nav',
    data() {
      return {}
    },
    components: {},
    computed: {
      category() {
        return this.$route.params.category
      }
    },
    methods: {
      logout() {
        this.$confirm('确认退出吗?', '提示', {}).then(() => {
          this.$store.commit(SET_LOGGED_IN, false)
          this.$router.push('/')
        }).catch(() => {
        })
      },
      addPost() {
        this.$router.push(this.category + '/new')
      }

    }
  }
</script>

<style scoped lang="scss">
  a {
    display: block;
    text-decoration: none;
  }

  .header {
    background-color: #0d295d;

    .menu {
      border-bottom: inherit;
    }
  }
</style>
