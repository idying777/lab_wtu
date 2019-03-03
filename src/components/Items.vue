<template>
  <div>
    <el-row v-bind:key="post.title" v-for="post of items.slice(0,size|8)" type="flex" justify="space-between">
      <el-col :lg="12" :md="12" :sm="20" :xs="24">{{post.title.slice(0,10)}}</el-col>
      <el-col :lg="10" :md="12" class="hidden-md-and-down">{{post.createdAt.slice(0,10)}}</el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: 'Items',
    props: ['items', 'size'],
  }
</script>

<style scoped>
  div {
    font-size: 13px;
  }
</style>
