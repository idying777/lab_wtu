<template>
  <div>
    <el-row v-bind:key="post.title" v-for="post of items.slice(0,size|8)" type="flex" justify="space-between">
      <el-col class="col">{{post.title.slice(0,limit)}}</el-col>
      <el-col class="hidden-md-and-down col" style="text-align: right">
        {{post.createdAt.slice(0,10)}}
      </el-col>
      <template>
        <el-col class="col">
          <el-button @click="editPost(post)">编辑</el-button>
        </el-col>
        <el-col class="col">
          <el-button @click="deletePost(post)">删除</el-button>
        </el-col>
      </template>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: 'Items',
    props: {
      items: {type: Array},
      size: {
        type: Number,
        default: 0
      }
    },
    computed: {
      limit() {
        return this.size === 0 ? Infinity : this.size
      }
    },
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
    },
    watch: {
      '$route': () => {
        if (this.route.path === '/') {
          for (let e of document.getElementsByClassName('col')) {
            e.classList.remove('col')
          }
        }
      }
    }
  }
</script>

<style scoped lang="scss">
  .col {
    line-height: 40px;
  }
</style>
