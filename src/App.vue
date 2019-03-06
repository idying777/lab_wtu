<template>
  <el-row type="flex" justify="center">
    <el-col :xs="24" :md="20" :xl="16">
      <el-header v-if="flag" class="height_auto">
        <nav-main></nav-main>
      </el-header>
      <el-main style="padding: 0">
        <router-view/>
      </el-main>
      <el-footer v-if="flag" class="height_auto">
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
    data() {
      return {
        flag: true,
      }
    },
    name: 'app',
    components: {
      NavMain,
      FooterMain,
    },
    async created() {
      this.routeUpdate()
      await this.$store.dispatch(FETCH_DATA)
    },
    watch: {
      '$route': 'routeUpdate',
    },
    methods: {
      routeUpdate() {
        this.flag = !this.$route.path.startsWith('/admin')
      },
    },
  }
</script>

<style>
  .height_auto {
    height: auto !important;
  }

</style>
