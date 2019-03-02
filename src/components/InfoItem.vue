<template>
  <section>
    <h1 v-if="loading">Loading</h1>

    <div v-else style="width: 100%">
      <el-row>{{category_info[category]}}</el-row>
      <el-row v-bind:key="post.title" v-for="post of  items._embedded.posts">
        <el-col :span="12">{{post.title}}</el-col>
        <el-col :span="10">{{post.createdAt.slice(0,10)}}</el-col>
      </el-row>
    </div>
  </section>
</template>

<script>
  export default {
    name: 'Info',
    props: {
      category: '',
    },
    data() {
      return {
        category_info: {
          'news': '热点新闻',
          'notify': '通知公告',
          'instrument': '仪器设备',
          'result': '科研成果',
          'exchange': '开发交流',
        },
        items: [],
        loading: true,
      }
    },
    async mounted() {
      this.$api.get('http://localhost:8081/api/posts/search/findByCategory?category=' + this.category).then(value => {
        this.items = value.data
        this.loading = false
      })
    },
  }
</script>

<style scoped>
  section {
    height: 300px;
  }
</style>
