<template>
  <div>
    <ul>
      <li :key="file.name" v-for="file of $store.state.files">

      </li>
    </ul>
  </div>
</template>

<script>
  export default {
    name: 'Files'
  }
</script>

<style scoped>

</style>
