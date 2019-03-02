<template>
  <section>
    <h1 v-if="loading">Loading</h1>

    <div v-else style="width: 100%">
      <el-row>{{category_info[category]}}</el-row>
      <items v-bind:items="items._embedded.posts"></items>
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
