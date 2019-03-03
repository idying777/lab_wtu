<template>
  <div>
    <items v-bind:items="posts"/>
  </div>
</template>

<script>
  import Items from './Items'

  export default {
    name: 'Tab',
    data() {
      return {
        posts: [],
      }
    },
    computed: {
      category() {
        return this.$route.params.category
      },
    },
    created() {
      this.routeUpdate()
    },
    methods: {
      routeUpdate() {
        this.posts = this.$store.getters.getPostsByCategory(this.category)
      },
    },
    watch: {
      '$route': 'routeUpdate',
    },
    components: {
      Items,
    },
  }
</script>

<style scoped>

</style>
