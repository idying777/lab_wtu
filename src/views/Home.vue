<template>
  <div class="home">
    <div>
      <ul>
        <img class="bk" src="../assets/banner.png"></img>
      </ul>
    </div>
    <el-row :span="16" :gutter="10" type="flex" justify="center">
      <el-col :span="6">
        <info-item/>
      </el-col>
      <el-col :span="5">
        <info-item/>
      </el-col>
      <el-col :span="5">
        <info-item/>
      </el-col>
    </el-row>
    <el-row :span="16" :gutter="10" type="flex" justify="center">
      <el-col :span="6">
        <info-item/>
      </el-col>
      <el-col :span="5">
        <info-item/>
      </el-col>
      <el-col :span="5">
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
