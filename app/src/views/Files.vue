<template>
  <div>
    <ul>
      <li :key="file.filename" v-for="file of $store.state.files">
        <a v-bind:href="file.url">
          <i class="el-icon-download"></i>
          <span>{{file.filename}}</span>
        </a>
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
  ul {
    list-style: none;
    margin: 0;
    padding: 0;
  }

</style>
