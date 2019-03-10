<template>
  <post-form v-model="post" :on-save="handleSave"></post-form>
</template>

<script>
  import PostForm from '../components/PostForm'
  import { SET_POSTS } from '../store-types'

  export default {
    name: 'PostNew',
    components: {PostForm},
    data() {
      return {
        post: {
          title: '',
          content: '',
          fileList: []
        }
      }
    },
    computed: {
      category() {
        return this.$route.params.category
      }
    },
    methods: {
      handleSave(post) {
        post = {
          ...post,
          fileList: this.post.fileList.map(f => f.name),
          category: this.category
        }
        this.$api.post('posts', post).then(r => {
          this.$store.commit(SET_POSTS, this.$store.state.posts.concat(r.data))
          this.$message({
            message: 'save success',
            type: 'success',
            duration: 1500
          })
          this.$router.push(`/category/${post.category}`)
        }).catch((err) => {
          this.$message('save failed', err)
        })
      }
    }
  }
</script>

<style scoped>
</style>
