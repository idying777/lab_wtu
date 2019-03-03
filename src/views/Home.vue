<template>
  <div class="home">
    <div>
      <img class="bk" src="../assets/banner.png" alt="background"/>
    </div>
    <el-row :gutter="10">
      <el-col :lg="6" :md="8" :sm="12">
        about
      </el-col>
      <el-col :lg="6" :md="8" :sm="12">
        <items-card category="news"/>
      </el-col>
      <el-col :lg="6" :md="8" :sm="12">
        <items-card category="notify"/>
      </el-col>
      <el-col :lg="6" :md="8" :sm="12">
        <items-card category="instrument"/>
      </el-col>
      <el-col :lg="6" :md="8" :sm="12">
        <items-card category="result"/>
      </el-col>
      <el-col :lg="6" :md="8" :sm="12">
        <items-card category="exchange"/>
      </el-col>
    </el-row>
    <el-aside :width="300">
      aside
    </el-aside>
  </div>
</template>

<script>
  import ItemsCard from '../components/ItemsCard'

  export default {
    name: 'home',
    components: {ItemsCard},
  }
</script>
