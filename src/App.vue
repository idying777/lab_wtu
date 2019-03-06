<template>
  <el-row type="flex" justify="center">
    <el-col :xs="24" :md="20" :xl="16">
      <el-header class="height_auto">
        <nav-main/>
      </el-header>
      <el-main>
        <router-view/>
      </el-main>
      <el-footer v-show="is_display" class="height_auto">
        <footer-main/>
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
        loginVisible: false
      }
    },
    name: 'app',
    components: {
      NavMain,
      FooterMain
    },
    async created() {
      this.routeUpdate()
      await this.$store.dispatch(FETCH_DATA)
    },
    watch: {
      '$route': 'routeUpdate'
    },
    methods: {
      routeUpdate() {
        this.is_display = !this.$route.path.startsWith('/admin')
      }
    }
  }
</script>

<style>
  .height_auto {
    height: auto !important;
  }
</style>
