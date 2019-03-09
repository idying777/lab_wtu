<template>
  <div class="main-container">
    <header>
      <nav-main/>
    </header>
    <main>
      <router-view/>
    </main>
    <footer>
      <footer-main/>
    </footer>
  </div>
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

<style lang="scss">
  html, body, main {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
  

  header {
    height: 61px;
  }
</style>
