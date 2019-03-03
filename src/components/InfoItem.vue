<template>
  <section>
    <div style="width: 100%">
      <el-row>{{category_info[category]}}</el-row>
      <items v-bind:items="posts"></items>
    </div>
  </section>
</template>

<script>
  import Items from './Items'

  export default {
    name: 'Info',
    components: {Items},
    props: ['category'],
    data() {
      return {
        category_info: {
          'news': '热点新闻',
          'notify': '通知公告',
          'instrument': '仪器设备',
          'result': '科研成果',
          'exchange': '开发交流',
        },
      }
    },
    computed: {
      posts() {
        return this.$store.getters.getPostsByCategory(this.category)
      },
    },
  }
</script>

<style scoped>
  section {
    height: 300px;
  }
</style>
