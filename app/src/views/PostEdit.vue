<template>
  <post-form :post="post" :on-save="handleSave"></post-form>
</template>

<script>
  import PostForm from '../components/PostForm'
  import { SET_POSTS } from '../store-types'
  import { parsePostUrl } from '../util.js'

  export default {
    name: 'PostEdit',
    components: {
      PostForm
    },
    computed: {
      title() {
        return this.$route.params.title
      },
      post() {
        return this.$store.state.posts.find(p => p.title === this.title)
      }
    },

    methods: {
      handleSave(post) {
        this.$api.patch(parsePostUrl(post), post).then(r => {
          this.$store.commit(SET_POSTS, this.$store.state.posts.filter(p => parsePostUrl(p) !== parsePostUrl(post)))
          this.addPost(r.data)
          this.$router.push(`/category/${post.category}`)
          this.$message({
            message: 'save success',
            type: 'success',
            duration: 1500
          })
        }).catch(e => {
          this.addPost(post)
          this.$message('save failed', e)
        })
      },
      addPost(post) {
        this.$store.commit(SET_POSTS, this.$store.state.posts.concat(post))
      }
    }
  }
</script>

<style scoped>

</style>
