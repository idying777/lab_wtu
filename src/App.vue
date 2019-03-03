<template>
  <el-row id="app" type="flex" justify="center">
    <el-col :xs="24" :sm="22" :md="20" :lg="18" :xl="16">
      <el-header>
        <nav-main></nav-main>
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
  import NavMain from './views/NavMain'

  export default {
    name: 'app',
    components: {
      NavMain,
    },
    async created() {
      await this.$store.dispatch(FETCH_DATA)
    },
  }
</script>

<style>

</style>
