<template>
  <div>
    <el-row class="line-height" v-bind:key="post.title" v-for="post of items.slice(0,size|8)" type="flex"
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
  import { EDIT_POST, SET_POSTS } from '../store-types'

  export default {
    name: 'ItemsAdmin',
    props: ['items', 'size'],
    methods: {
      editPost(post) {
        this.$store.commit(EDIT_POST, post)
      },
      deletePost(post) {
        this.$store.commit(SET_POSTS, this.$store.state.posts.filter(p => p.title !== post.title))
        this.$api.delete(post.self.href)
      }
    }
  }
</script>

<style scoped>
  .line-height div {
    line-height: 40px;
  }
</style>
