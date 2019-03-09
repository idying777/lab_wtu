<template>
  <el-card class="box">
    <div slot="header">
      <span>{{category_info[category]}}</span>
    </div>
    <div class="card-body">
      <el-row v-bind:key="post.title" v-for="post of posts.slice(0,8)" type="flex" justify="space-between">
        <el-col :span="18">{{post.title.slice(0,16)}}</el-col>
        <el-col :span="6" class="hidden-md-and-down" style="text-align: right">
          {{post.createdAt.slice(0,10)}}
        </el-col>
      </el-row>
    </div>
  </el-card>
</template>

<script>
  export default {
    name: 'ItemsCard',
    props: ['category'],
    data() {
      return {
        category_info: {
          'news': '热点新闻',
          'notify': '通知公告',
          'instrument': '仪器设备',
          'result': '科研成果',
          'exchange': '开发交流'
        }
      }
    },
    computed: {
      posts() {
        return this.$store.getters.getPostsByCategory(this.category)
      }
    }
  }
</script>

<style scoped>
  .box {
    height: 300px;
  }

  .card-body {
    font-size: 13px;
  }
</style>
