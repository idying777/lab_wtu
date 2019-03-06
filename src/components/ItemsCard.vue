<template>
  <el-card class="box">
    <div slot="header">
      <span>{{category_info[category]}}</span>
    </div>
    <items v-bind:items="posts"/>
  </el-card>
</template>

<script>
  import Items from './Items'

  export default {
    name: 'ItemsCard',
    components: {Items},
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
</style>
