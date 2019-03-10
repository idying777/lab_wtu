<template>
  <el-card class="post-container">
    <div slot="header">
      <h2>{{post.title}}</h2>
      <h4><span>{{post.createdAt}}</span></h4>
    </div>
    <p class="post-content" v-html="content"></p>
  </el-card>
</template>

<script>
  import { markdown } from 'markdown'

  export default {
    name: 'PostView',
    computed: {
      title() {
        return this.$route.params.title
      },
      post() {
        return this.$store.state.posts.find(p => p.title === this.title)
      },
      content() {
        return markdown.toHTML(this.post.content)
      }
    }
  }
</script>

<style scoped lang="scss">
  h2, h4 {
    text-align: center;
  }

  .post-container {
    width: 80%;
    margin: 80px auto;

    .post-content {
      margin: 0;
    }
  }
</style>
