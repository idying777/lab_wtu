<template>
  <div class="home">
    <el-row :gutter="10">
      <el-col :span="6">
        about
      </el-col>
      <el-col :span="6">
        <items-card category="news"/>
      </el-col>
      <el-col :span="6">
        <items-card category="notify"/>
      </el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="6">
        <items-card category="instrument"/>
      </el-col>
      <el-col :span="6">
        <items-card category="result"/>
      </el-col>
      <el-col :span="6">
        <items-card category="exchange"/>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import ItemsCard from '../components/ItemsCard'

  export default {
    name: 'home',
    components: {ItemsCard},
  }
</script>
