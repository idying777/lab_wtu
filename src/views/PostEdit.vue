<template>
  <post-form v-model="post" :on-save="onSave"></post-form>
</template>

<script>
  import PostForm from './PostForm'

  export default {
    name: 'PostEdit',
    components: {
      PostForm
    },
    data() {
      return {
        post: {}
      }
    },
    computed: {
      title() {
        return this.$route.params.title
      }
    },
    mounted() {
      this.post = this.$store.state.posts.find(p => p.title === this.title)
    }
  }
</script>

<style scoped>

</style>
