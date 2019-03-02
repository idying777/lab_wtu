<template>
  <el-main class="home">
    <el-row :span="16" :gutter="10" type="flex" justify="center">
      <el-col :span="6">
        <info-item category="about we"/>
      </el-col>
      <el-col :span="5">
        <info-item category="新闻"/>
      </el-col>
      <el-col :span="5">
        <info-item category="公告"/>
      </el-col>
    </el-row>
    <el-row :span="16" :gutter="10" type="flex" justify="center">
      <el-col :span="6">
        <info-item category="公告"/>
      </el-col>
      <el-col :span="5">
        <info-item category="公告"/>
      </el-col>
      <el-col :span="5">
        <info-item category="公告"/>
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
  import InfoItem from '../components/InfoItem'

  export default {
    name: 'home',
    components: {InfoItem},
  }
</script>
