<template>
  <el-card>
    <items-admin v-if="$store.state.logged_in" v-bind:items="posts"/>
    <items class="line-hei" v-else v-bind:items="posts"/>
  </el-card>
</template>

<script>
  import Items from './Items'
  import ItemsAdmin from './ItemsAdmin'

  export default {
    name: 'Tab',
    data() {
      return {
        posts: []
      }
    },
    computed: {
      category() {
        return this.$route.params.category
      }
    },
    created() {
      this.routeUpdate()
    },
    methods: {
      routeUpdate() {
        this.posts = this.$store.getters.getPostsByCategory(this.category)
      }
    },
    watch: {
      '$route': 'routeUpdate'
    },
    components: {
      Items,
      ItemsAdmin
    }
  }
</script>

<style scoped>

</style>
