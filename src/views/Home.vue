<template>
  <div class="home">
    <div>
      <img class="bk" src="../assets/banner.png" alt="background"/>
    </div>
    <div>
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
  img.bk {
    max-width: 100%;
  }

  .card {
    @media only screen and (min-width: 1200px) {
      width: 33.3%;
    }

    @media only screen and (max-width: 1200px) {
      width: 50%;
    }
    @media only screen and (max-width: 500px) {
      width: 100%;
    }
  }
</style>
