<template>
  <h1>{{facility.name}}</h1>
</template>

<script>
export default {
  name: "facilityView",
  data(){
    return{
      facility:null
    }
  },
  mounted() {
    console.log(this.facility)
  }
}
</script>

<style scoped>

</style>