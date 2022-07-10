<template>
  <div class = "user container-fluid p-5" >
    <div class="row">
      <div class="col-lg-8 col-md-6  pb-1">
        <table class="table">
          <thead class="table-dark">
          <th class="name justify-content-end" scope="col">{{training.name}}</th>
          </thead>
          <tbody>
          <tr>
            <td>
              <label>Date:</label>
            </td>
            <td>
              <label>{{parseDate(ScheduleTraining.dateTraining)}}</label>
            </td>
          </tr>
          <tr>
            <td>
              <label>Start Time:</label>
            </td>
            <td>
              <label>{{ScheduleTraining.startTime}}</label>
            </td>
          </tr>
          <tr>
            <td>
              <label>Finish time:</label>
            </td>
            <td>
              <label>{{ScheduleTraining.finishTime}}</label>
            </td>
          </tr>
          <tr>
            <td>
              <label>Type:</label>
            </td>
            <td>
              <label>{{training.type}}</label>
            </td>
          </tr>
          <tr>
            <td>
              <label>Duration:</label>
            </td>
            <td>
              <label>{{training.duration}}</label>
            </td>
          </tr>
          <tr>
            <td>
              <label>Additional price:</label>
            </td>
            <td>
              <label>{{training.additionalPrice}}</label>
            </td>
          </tr>
          <tr>
            <td>
              <label>Facility name: </label>
            </td>
            <td>
              <!--            <label>{{getFacility(training.sportFacilityId)}}</label>-->
              <label>{{sportFacilityName}}</label>
            </td>
          </tr>
          <tr>
            <td>
              <label>Facility type: </label>
            </td>
            <td><label>{{sportType}}</label>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
      <div  style="margin-top: 1px" class="col-lg-4 col-md-6 ico pt-5 pb-3 justify-content-center">
       <span class="d-">
         <img :src="getImgUrl(training.name)" :alt="training.name" class="ico"/>
        </span>
      </div>
    </div>
  </div>
</template>

<script>
import TrainingService from "@/FrontedServices/TrainingService";
import FacilitieServices from "@/FrontedServices/FacilitieServices";
export default {
  name: "SchedulePassedManager",
  props:{
    ScheduleTraining: Object
  },
  data(){
    return{
      sportFacilityName:"",
      training:{},
      dateAssign:'',
      dateTraining:'',
      traningId:'',
      sportType:''
    }
  },
  created() {
    this.getByTrainingId()
  },
  methods:{
    getByTrainingId(){
      TrainingService.getById(this.ScheduleTraining.traningId).then(
          (res)=>{
            //console.log(res.data)
            this.training = res.data
            FacilitieServices.getById(this.training.sportFacilityId).
            then((res)=> {this.sportFacilityName = res.data.name;
              this.sportType = res.data.type})
          }
      )
    },
    parseDate(dateStr){
      // let date_month = new Date(dateStr).getMonth()
      // let date_year = new Date(dateStr).getFullYear()
      // let date_day = new Date(dateStr).getDay()
      // let date  = new Date(date_year,date_month,date_day)
      return new Date(dateStr).toDateString()
    },
    getImgUrl(facility){
      let images = require.context('../assets/trainings', false, /\.png$/);
      return images('./' + facility + ".png")
    }
  }
}
</script>

<style scoped>
table{
  width: 90%;
  font-size: 24px;
}
.ico{
  padding-bottom: 10px;
  margin-left: auto;
  margin-right: auto;
  max-width: 15em;
}
.user {
  background: #f4f4f4;
  margin: 10px;
  padding: 10px 20px;
  cursor: pointer;
  min-height: 430px;
  max-height: 45em;
}
.buttonMy{
  background: #2691d9;
  color: white;
  border-radius: 15px;
  font-size: 20px;
  padding: 20px;
  margin-left: auto;
  margin-right: auto;
}
.name {
  align-items: flex-start;
  text-align: end;
  color: #2691d9;
  font-size:40px;
  margin-top: auto;
  margin-bottom: auto;
  min-height: 10em;
  display: table-cell;
  vertical-align: middle;
  padding-bottom:10px;
}
.myth {
  color: blue;
  text-align: center;
  font-size: 30px;
  margin-bottom: 20px;
}
table, tbody, td {
  padding-bottom:5px;
}
.buttonMy{
  background: #2691d9;
  color: white;
  border-radius: 15px;
  font-size: 20px;
  padding: 20px;
  margin-left: auto;
  margin-right: auto;
}
</style>