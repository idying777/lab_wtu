<template>
  <el-main class="home">
    <el-row :span="16" :gutter="10" type="flex" justify="center">
      <el-col :span="6">
        about
      </el-col>
      <el-col :span="5">
        <info-item category="news"/>
      </el-col>
      <el-col :span="5">
        <info-item category="notify"/>
      </el-col>
    </el-row>
    <el-row :span="16" :gutter="10" type="flex" justify="center">
      <el-col :span="6">
        <info-item category="instrument"/>
      </el-col>
      <el-col :span="5">
        <info-item category="result"/>
      </el-col>
      <el-col :span="5">
        <info-item category="exchange"/>
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
