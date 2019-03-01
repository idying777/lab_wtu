<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <el-row :span="16" :gutter="10" type="flex" justify="center">
      <el-col :span="6">
        <info-item/>
      </el-col>
      <el-col :span="4">
        <info-item/>
      </el-col>
      <el-col :span="4">
        <info-item/>
      </el-col>
    </el-row>
    <el-row :span="16" :gutter="10" type="flex" justify="center">
      <el-col :span="6">
        <info-item/>
      </el-col>
      <el-col :span="4">
        <info-item/>
      </el-col>
      <el-col :span="4">
        <info-item/>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import InfoItem from '../components/InfoItem'

  export default {
    name: 'home',
    components: {InfoItem},
  }
</script>
