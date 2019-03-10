<template>
  <div>
    <div class="row">
      <div class="card">
        <el-card class="box">
          about
        </el-card>
      </div>
      <div class="card">
        <items-card category="news"/>
      </div>
      <div class="card">
        <items-card category="notify"/>
      </div>
    </div>
    <div class="row">
      <div class="card">
        <items-card category="instrument"/>
      </div>
      <div class="card">
        <items-card category="result"/>
      </div>
      <div class="card">
        <items-card category="exchange"/>
      </div>
    </div>
  </div>
</template>

<script>
  import ItemsCard from '../../components/ItemsCard'

  export default {
    name: 'HomeView',
    components: {
      ItemsCard
    }
  }
</script>

<style scoped lang="scss">
  .row {
    display: flex;
  }

  .card {
    flex: 1 0 300px;
    flex-wrap: wrap;
    margin: 5px;
  }
</style>
