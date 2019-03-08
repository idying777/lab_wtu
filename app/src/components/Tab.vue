<template>
  <el-card>
    <items v-bind:items="posts"/>
  </el-card>
</template>

<script>
  import Items from './Items'

  export default {
    name: 'Tab',
    components: {
      Items
    },
    computed: {
      category() {
        return this.$route.params.category
      },
      posts() {
        return this.$store.getters.getPostsByCategory(this.category)
      }
    }

  }
</script>

<style scoped>

</style>
