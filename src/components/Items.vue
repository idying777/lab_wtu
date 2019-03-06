<template>
  <div>
    <el-row v-bind:key="post.title" v-for="post of items.slice(0,size|8)" type="flex" justify="space-between">
      <el-col :md="16" :sm="20" :xs="24">{{post.title.slice(0,10)}}</el-col>
      <el-col :md="8" class="hidden-md-and-down" style="text-align: right">{{post.createdAt.slice(0,10)}}
      </el-col>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: 'Items',
    props: ['items', 'size']
  }
</script>

<style scoped>
  div {
    font-size: 13px;
  }
</style>
