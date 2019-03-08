<template>
  <div>
    <el-row class="line-height" v-bind:key="post.title" v-for="post of mutableItems.slice(0,size|8)" type="flex"
            justify="space-between">
      <el-col :md="16" :sm="20" :xs="24">{{post.title.slice(0,10)}}</el-col>
      <el-col :md="4">{{post.createdAt.slice(0,10)}}</el-col>
      <el-col :md="1">
        <el-button @click="editPost(post)">编辑</el-button>
      </el-col>
      <el-col :md="1">
        <el-button @click="deletePost(post)">删除</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import { SET_POSTS } from '../store-types'

  export default {
    name: 'ItemsAdmin',
    props: ['items', 'size'],
    data() {
      return {mutableItems: [...this.items]}
    },
    methods: {
      editPost(post) {
        this.$router.push('/post/' + post.title)
      },
      deletePost(post) {
        const f = i => i.title !== post.title
        this.mutableItems = this.mutableItems.filter(f)
        this.$store.commit(SET_POSTS, this.$store.state.posts.filter(f))
        this.$api.delete(post._links.self.href)
      }
    }
  }
</script>

<style scoped>
  .line-height div {
    line-height: 40px;
  }
</style>
