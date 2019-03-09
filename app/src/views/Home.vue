<template>
  <div class="home">
    <div class="banner banner-home">
      <img src="../assets/small.jpg" alt="background"/>
    </div>
    <div class="container">
      <el-row :gutter="10">
        <el-col class="card">
          <el-card class="box">
            about
          </el-card>
        </el-col>
        <el-col class="card">
          <items-card category="news"/>
        </el-col>
        <el-col class="card">
          <items-card category="notify"/>
        </el-col>
        <el-col class="card">
          <items-card category="instrument"/>
        </el-col>
        <el-col class="card">
          <items-card category="result"/>
        </el-col>
        <el-col class="card">
          <items-card category="exchange"/>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
  import ItemsCard from '../components/ItemsCard'

  export default {
    name: 'home',
    components: {ItemsCard}
  }
</script>

<style scoped lang="scss">
  @import "../assets/layout.scss";

  .card {
    min-width: 270px;
    max-width: 360px;
  }

  .banner-home {
    height: 360px;
  }
</style>
