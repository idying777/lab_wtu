<template>
  <div class="main-container">
    <header class="height_auto">
      <nav-main/>
    </header>
    <main>
      <router-view/>
    </main>
    <footer class="height_auto">
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
  .height_auto {
    height: auto !important;
  }

  html, body, main {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  .main-container {
    margin: 0 auto;
    @media only screen and (min-width: 1200px) {
      width: 75%;
    }
    @media only screen and (max-width: 1200px) {
      width: 100%;
    }
  }
</style>
