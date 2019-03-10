<template>
  <div class="main-container">
    <router-view></router-view>
  </div>
</template>


<script>
  import { FETCH_DATA } from './store-types'

  export default {
    data() {
      return {
        loginVisible: false
      }
    },
    name: 'app',
    components: {},
    async created() {
      await this.$store.dispatch(FETCH_DATA)
    },
    watch: {},
    methods: {}
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
