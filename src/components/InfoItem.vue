<template>
  <section>
    {{category}}
  </section>
</template>

<script>
  export default {
    name: 'Info',
    props: {
      category: '',
    },
    data() {
      return {
        items: [],
      }
    },
  }
</script>

<style scoped>
  section {
    width: 300px;
    height: 400px;
  }
</style>
