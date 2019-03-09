<template>
  <div>
    <div class="banner">Banner</div>
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

<style scoped>
  .banner {
    width: 100%;
    height: 200px;
    background-color: red;
  }
</style>
