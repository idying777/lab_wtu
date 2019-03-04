<template>
  <el-row type="flex" justify="center">
    <el-col :xs="24" :md="20" :xl="16">
      <el-header class="height_auto">
        <nav-main></nav-main>
      </el-header>
      <el-main>
        <router-view/>
      </el-main>
      <el-footer class="height_auto">
        <footer-main></footer-main>
      </el-footer>
    </el-col>
  </el-row>
</template>

<script>
  import { FETCH_DATA } from './store-types'
  import NavMain from './views/NavMain'
  import FooterMain from './views/FooterMain'

  export default {
    name: 'app',
    components: {
      NavMain,
      FooterMain,
    },
    async created() {
      await this.$store.dispatch(FETCH_DATA)
    },
  }
</script>

<style>
  .height_auto {
    height: auto !important;
  }

</style>
