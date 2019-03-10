<template>
  <div>
    <ul>
      <li :key="post.key" v-for="post of posts">
        <span>{{post.title}}</span>
        <span :class="{mr:logged_in}" style="float: right">{{post.createdAt.slice(0,10)}}</span>
        <div v-if="logged_in" style="position: relative;right: 0">
          <el-button @click="handleEdit(post)">编辑</el-button>
          <el-button @click="handleDelete(post)">删除</el-button>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
  import { SET_POSTS } from '../../store-types'
  import { parsePostUrl } from '../../util'
  import { mapState } from 'vuex'

  export default {
    name: 'Tab',
    components: {},
    computed: {
      category() {
        return this.$route.params.category
      },
      posts() {
        return this.$store.getters.getPostsByCategory(this.category)
      },
      ...mapState(['logged_in'])
    },
    methods: {
      handleEdit(post) {
        this.$router.push(`/post/${post.title}/edit`)
      },
      handleDelete(post) {
        this.$store.commit(SET_POSTS, this.$store.state.posts.filter(p => p.title !== post.title))
        this.$api.delete(parsePostUrl(post)).
          then(() => this.$message('delete success')).
          catch(() => this.$message('delete failed'))
      }
    }
  }
</script>

<style scoped>
</style>
