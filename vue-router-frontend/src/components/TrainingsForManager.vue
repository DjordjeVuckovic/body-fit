<template>
<!--  <h1>{{logedInUser.sportFacilityId}}</h1>-->
  <div  v-for="tr in trainingsForManager" v-bind:key="tr.id" class="container" style="padding-top: 150px">
    <div class="col">
      <Training :training = "tr"></Training>
    </div>
  </div>
</template>

<script>
import TrainingService from "@/FrontedServices/TrainingService";
import Training from "@/components/Training";
export default {
  name: "TrainingsForManager",
  components: {Training},
  data(){
    return{
      trainingsForManager:[]
    }
  },
  props:{
    logedInUser:Object
  },
  created() {
    TrainingService.getByManager(this.logedInUser.sportFacilityId).
    then((res)=>{this.trainingsForManager = res.data})
  }
}
</script>

<style scoped>

</style>