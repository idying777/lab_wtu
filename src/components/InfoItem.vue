<template>
  <el-table v-if="!items.length>0"
            :data="items.data._embedded.posts"
            style="width: 100%">
    <el-table-column
      prop="title">
    </el-table-column>
    <el-table-column
      prop="createdAt">
    </el-table-column>
  </el-table>
</template>

<script>
  export default {
    name: 'Info',
    props: {
      category: '',
    },
    data() {
      return {
        items: [],
      }
    },
    async mounted() {
      this.items = await this.$api.get('posts')
    },
  }
</script>

<style scoped>
  section {
    width: 300px;
    height: 400px;
  }
</style>
