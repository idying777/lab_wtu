<template>
  <div>
    <h3>{{post.title}}</h3>
    <h6><span>{{post.createdAt}}</span></h6>
    <p>{{post.content}}</p>
  </div>
</template>

<script>
  export default {
    name: 'PostView',
    computed: {
      title() {
        return this.$route.params.title
      },
      post() {
        return this.$store.state.posts.find(p => p.title === this.title)
      }
    }
  }
</script>

<style scoped>

</style>
