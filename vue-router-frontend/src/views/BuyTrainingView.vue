<template>
  <div class="container-fluid">
    <h1>{{id}}</h1>
  </div>
</template>

<script>
export default {
  name: "BuyTrainingView",
  data(){
    return{
      id: this.$route.params.id
    }
  }
}
</script>

<style scoped>

</style>