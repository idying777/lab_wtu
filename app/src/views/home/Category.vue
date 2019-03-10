<template>
  <el-card class="container wrapper">
    <ul v-if="posts.length>0">
      <li style="display: flex"
          :key="post.key" v-for="post of posts">
        <a :href="'/#/post/'+post.title" style="flex-grow: 3;margin-right: 100px;line-height: 40px">
          <span>{{post.title}}</span>
          <span style="float: right;">{{post.createdAt.slice(0,10)}}</span>
        </a>
        <el-button-group v-if="logged_in" style="flex-grow: 1">
          <el-button @click="handleEdit(post)">编辑</el-button>
          <el-button @click="handleDelete(post)">删除</el-button>
        </el-button-group>
      </li>
    </ul>
    <div v-else>empty</div>
  </el-card>
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

<style scoped lang="scss">
  .wrapper {
    height: 360px;
    margin: 0 80px;

    ul {
      li {
        border: black 1px;
      }

    }
  }
</style>
