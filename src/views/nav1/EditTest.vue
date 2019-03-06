<template>
  <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
    <el-form :inline="true" :model="filters">
      <el-form-item>
        <el-input v-model="filters.name" placeholder="姓名"></el-input>
      </el-form-item>

    </el-form>
  </el-col>
</template>

<script>
    export default {
        name: "EditTest"
    }
</script>

<style scoped>

</style>
