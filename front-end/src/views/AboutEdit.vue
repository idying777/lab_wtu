<template>
  <post-form :post="about" :on-save="handleSave"></post-form>
</template>

<script>
  import PostForm from '../components/PostForm'
  import { mapState } from 'vuex'
  import { parsePostUrl } from '../util'
  import { SET_POSTS } from '../store-types'

  export default {
    name: 'AboutEdit',
    components: {PostForm},
    computed: {
      ...mapState(['posts']),
      exist() {
        return this.posts.find(p => p.title === 'about')
      },
      about() {
        let about = this.posts.find(p => p.title === 'about')
        if (about) return about
        else {
          return {
            title: 'about',
            content: '关于我们',
            category: 'about',
            fileList: []
          }
        }
      }
    },
    methods: {
      handleSave() {
        if (this.exist) {
          const url = parsePostUrl(this.about)
          this.$api.patch(url, this.about).then((r) => {
              this.$message({
                message: 'save success',
                type: 'success',
                duration: 1000
              })
              let _posts = this.posts.filter(p => p.title !== 'about').concat(r.data)
              this.$store.commit(SET_POSTS, _posts)
              this.$router.push('/')
            }
          ).catch(() => this.$message('save failed'))
        } else {
          this.$api.post('/posts', this.about).then((r) => {
              this.$message({
                message: 'save success',
                type: 'success',
                duration: 1000
              })
              let _posts = this.posts.filter(p => p.title !== 'about').concat(r.data)
              this.$store.commit(SET_POSTS, _posts)
              this.$router.push('/')
            }
          ).catch(() => this.$message('save failed'))
        }
      }
    }
  }
</script>

<style scoped>

</style>
