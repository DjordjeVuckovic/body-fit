<template>
  <div style="padding-top: 50px" class="container-fluid">
    <h1 class="headMy">All trainers</h1>
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
.headMy{
  text-align: center;
  vertical-align: center;
  padding-top: 0.5em;
  padding-left: 0.5em;
  font-size: 7em;
  color: #2691d9;
}
</style>