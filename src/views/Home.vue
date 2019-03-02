<template>
  <div class="home">
    <el-row>
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
    <el-row :gutter="10">
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
  </div>
</template>

<script>
  import InfoItem from '../components/InfoItem'

  export default {
    name: 'home',
    components: {InfoItem},
  }
</script>
