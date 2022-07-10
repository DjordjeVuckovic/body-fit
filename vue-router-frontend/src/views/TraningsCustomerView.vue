<template>
  <div class="container-fluid px-5">
    <div class="row">
      <h1 class="headMy">Upcoming trainings</h1>
      <div class="row row-cols-2 g-3">
        <div  v-for="tr in trainings" v-bind:key="tr.id" class="container" style="padding-top: 20px">
          <div class="col">
            <ScheduleTraningCustomer :ScheduleTraining = "tr"></ScheduleTraningCustomer>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <h1 class="headMy">Passed trainings</h1>
      <div class="row row-cols-2 g-3">
        <div  v-for="tr in trainingsPassed" v-bind:key="tr.id" class="container" style="padding-top: 20px">
          <div class="col">
            <ScheduleTraningCustomer @rateFacility="ratefacility"  :passed="true" :ScheduleTraining = "tr"></ScheduleTraningCustomer>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ScheduleTraningService from "@/FrontedServices/ScheduleTraningService";
import ScheduleTraningCustomer from "@/components/ScheduleTraningCustomer";

export default {
  name: "TraningsCustomerView",
  props:{
    logedInUser:Object
  },
  components:{
    ScheduleTraningCustomer
  },
  data(){
    return{
      trainings:[],
      trainingsPassed:[]
    }
  },
  created() {
    this.getAllUp()
    this.getAllPassed()
  },
  methods:{
    getAllUp(){
      ScheduleTraningService.AllUpcomingCustomer(this.logedInUser.username).then(
          (res)=>{
            console.log(res.data)
            this.trainings = res.data
          }
      )
    },
    getAllPassed(){
      ScheduleTraningService.AllPassedCustomer(this.logedInUser.username).then(
          (res)=>{
            this.trainingsPassed = res.data
          }

      )
    },
    ratefacility(sportFacilityName){
      this.$emit('rateFacility',sportFacilityName)
    }

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