<template>
  <div class="container-fluid">
    <div class="row">
      <h1 class="headMy">Upcoming trainings</h1>
      <div class="row row-cols-2 g-3">
        <div  v-for="tr in trainings" v-bind:key="tr.id" class="container" style="padding-top: 20px">
          <div class="col">
            <UpcomingTrainingManager :ScheduleTraining = "tr"></UpcomingTrainingManager>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <h1 class="headMy">Passed trainings</h1>
      <div class="row row-cols-2 g-3">
        <div  v-for="tr in trainingsPassed" v-bind:key="tr.id" class="container" style="padding-top: 20px">
          <div class="col">
            <SchedulePassedManager :ScheduleTraining = "tr"></SchedulePassedManager>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ScheduleTraningCustomer from "@/components/ScheduleTraningCustomer";
import ScheduleTraningService from "@/FrontedServices/ScheduleTraningService";
import SchedulePassedManager from "@/components/SchedulePassedManager";
import UpcomingTrainingManager from "@/components/UpcomingTrainingManager";

export default {
  name: "TrainingTrainerView",
  props:{
    logedInUser:Object
  },
  components:{
    UpcomingTrainingManager,
    SchedulePassedManager,
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
      ScheduleTraningService.AllUpcomingTrainer(this.logedInUser.username).then(
          (res)=>{
            console.log(res.data)
            this.trainings = res.data
          }
      )
    },
    getAllPassed(){
      ScheduleTraningService.AllPassedTrainer(this.logedInUser.username).then(
          (res)=>{
            this.trainingsPassed = res.data
          }
      )
    },

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