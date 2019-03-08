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

<style scoped>
  a {
    display: block;
    text-decoration: none;
  }
</style>
