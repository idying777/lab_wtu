<template>
  <info-item v-bind:category="category"/>
</template>

<script>

  import InfoItem from './InfoItem'

  export default {
    name: 'Tab',
    props: {},
    computed: {
      category() {
        return this.$route.params.category
      },
    },
    components: {
      InfoItem,
    },
  }
</script>

<style scoped>

</style>
