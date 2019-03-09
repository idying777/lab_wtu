<template>
  <div>
    <div class="banner">
      <img src="../assets/small.jpg" alt="background">
    </div>
    <category></category>
  </div>
</template>

<script>
  import Category from '../components/Category'

  export default {
    name: 'CategoryView',
    components: {
      Category
    }
  }
</script>

<style scoped lang="scss">
  @import "../assets/layout.scss";

</style>
