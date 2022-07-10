<template>
  <div class="container-fluid">
    <div class="row">
      <h1 class="headMy">All trainings</h1>
      <div class="row row-cols-3 g-3">
        <div  v-for="tr in trainings" v-bind:key="tr.id" class="container" style="padding-top: 20px">
          <div class="col">
            <SchedulePassedManager :ScheduleTraining = "tr"></SchedulePassedManager>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SchedulePassedManager from "@/components/SchedulePassedManager";
import UpcomingTrainingManager from "@/components/UpcomingTrainingManager";
import ScheduleTraningCustomer from "@/components/ScheduleTraningCustomer";
import ScheduleTraningService from "@/FrontedServices/ScheduleTraningService";
export default {
  name: "FacilityScheduleTraningsView",
  components: {ScheduleTraningCustomer, SchedulePassedManager},
  props:{
    logedInUser:Object
  },
  data(){
    return{
      trainings:[]
    }
  },
  created() {
    this.getAll()
  },
  methods: {
    getAll() {
      ScheduleTraningService.AllByFacility(this.logedInUser.sportFacilityId).then(
          (res) => {
            this.trainings = res.data
          }
      )
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