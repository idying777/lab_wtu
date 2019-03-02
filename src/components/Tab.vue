<template>
  <div>
    <h1 v-if="loading">loading</h1>
    <items v-else v-bind:items="items._embedded.posts"/>
  </div>
</template>

<script>
  import Items from './Items'

  export default {
    name: 'Tab',
    data() {
      return {
        items: [],
        loading: true,
      }
    },
    created() {
      this.fetchData()
    },
    methods: {
      fetchData() {
        this.loading = true
        this.$api.get('http://localhost:8081/api/posts/search/findByCategory?category=' + this.$route.params.category).
          then(value => {
            this.items = value.data
            this.loading = false
          })
      },
    },
    watch: {
      '$route': 'fetchData',
    },
    components: {
      Items,
    },
  }
</script>

<style scoped>

</style>
