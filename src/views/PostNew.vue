<template>
  <post-form v-model="post" :on-save="onSave"></post-form>
</template>

<script>
  import PostForm from './PostForm'
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
      onSave() {
        post = {
          ...this.post,
          fileList: this.post.fileList.map(f => f.name),
          category: this.category
        }
        this.$api.post('posts', post).then(r => {
          this.$store.commit(SET_POSTS, _.concat(this.$store.state.posts, r.data))
          this.$message('postSave successful')
        }).catch(() => {
          this.$message('save failed')
        })
      }
    }
  }
</script>

<style scoped>
</style>
