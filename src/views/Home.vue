<template>
  <div class="home">
    <div>
      <img class="bk" src="../assets/banner.png" alt="background"/>
    </div>
    <div>
      <main>
        <el-row :gutter="10">
          <el-col :md="8" :sm="12">
            about
          </el-col>
          <el-col :md="8" :sm="12">
            <items-card category="news"/>
          </el-col>
          <el-col :md="8" :sm="12">
            <items-card category="notify"/>
          </el-col>
          <el-col :md="8" :sm="12">
            <items-card category="instrument"/>
          </el-col>
          <el-col :md="8" :sm="12">
            <items-card category="result"/>
          </el-col>
          <el-col :md="8" :sm="12">
            <items-card category="exchange"/>
          </el-col>
        </el-row>
        <el-container></el-container>
      </main>
      <aside>
        aside
      </aside>
    </div>
  </div>
</template>

<script>
  import ItemsCard from '../components/ItemsCard'

  export default {
    name: 'home',
    components: {ItemsCard},
  }
</script>

<style scoped>
  main {
    margin-right: 300px;
  }

  aside {
    width: 290px;
    float: right;
  }
</style>
