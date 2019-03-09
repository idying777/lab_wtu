<template>
  <el-card cl>
    {{category}}
  </el-card>
</template>

<script>
  export default {
    name: 'Tab',
    components: {},
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
