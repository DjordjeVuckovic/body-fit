<template>
  <div style="padding-top: 50px" class="container-fluid">
    <Header title="Trainers in my facility"></Header>
    <div  class="py-5 mx-5">
      <div class="row row-cols-2 g-3">
        <div  v-for="tr in trainersForManager" v-bind:key="tr.username" class="container" style="padding-top: 20px">
          <div class="col">
            <User :user = "tr" ></User>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TrainingService from "@/FrontedServices/TrainingService";
import User from "@/components/User";
import Header from "@/components/Header";

export default {
  name: "TrainersForManagerView",
  components: {User,Header},
  data(){
    return{
      trainersForManager:[]
    }
  },
  props:['logedInUser'],
  created() {
    TrainingService.getTrainersForFacility(this.logedInUser.sportFacilityId).
    then((res)=>
    {this.trainersForManager = res.data;
      // console.log(res.data)
    })
  }
}
</script>

<style scoped>

</style>