<template>
  <div class = "user container-fluid p-5" >
    <div class="row">
      <div class="col-lg-8  pb-1">
        <table class="table">
          <thead class="table-dark">
          <th class="name justify-content-end" scope="col">{{training.name}}</th>
          </thead>
          <tbody>
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
              <label>Description:</label>
            </td>
            <td>
              <label>{{training.description}}</label>
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
              <label>Trainer name and surname: </label>
            </td>
            <td>
              <!--            <label>{{getFacility(training.sportFacilityId)}}</label>-->
              <label>{{trainerName}} {{trainerSurname}}</label>
            </td>
          </tr>
          </tbody>
        </table>
        <router-link v-if="isCustomer" class="btn btn-primary mb-3   buttonMy" :to="{name: 'BuyTrainingView',params:{id:trainingId}}">Buy training</router-link>
<!--        <button v-if="isCustomer" class="btn btn-primary mb-3   buttonMy" @click="Modal">Buy training</button>-->
      </div>
      <div  style="margin-top: 5px" class="col-lg-4 ico pt-5 pb-3 justify-content-center">
       <span class="d-block">
         <img :src="getImgUrl(training.name)" :alt="training.name" class="ico"/>
        </span>
      </div>
    </div>
  </div>
</template>
<script>
import FacilitieServices from "@/FrontedServices/FacilitieServices";
import ModalBuyTraining from "@/components/ModalBuyTraining";
import TrainerService from "@/FrontedServices/TrainerService";
export default {
  name: "TrainingForCustomer",
  components:[FacilitieServices,ModalBuyTraining],
  props:{
    training: Object,
    logedInUser:Object,
    isCustomer:Boolean
  },
  data(){
    return{
      sportFacilityName:"",
      trainingId:this.training.id,
      trainerName:'',
      trainerSurname:'',
      modalOpen: false
    }
  },
  methods:{
    getImgUrl(facility){
      let images = require.context('../assets/trainings', false, /\.png$/);
      return images('./' + facility + ".png")
    },
    getFacility(){
      FacilitieServices.getById(this.training.sportFacilityId).
      then((res)=> {this.sportFacilityName = res.data.name;})
    },
    getTrainer(){
      TrainerService.getById(this.training.trainerId).then(
          (res) =>{
            this.trainerName = res.data.name
            this.trainerSurname = res.data.surname
          }
      )
    },
    Modal(){
      this.modalOpen = !this.modalOpen
    }
  },
  created() {
    this.getFacility()
    this.getTrainer()
  }
}
</script>

<style scoped>
table{
  width: 90%;
  font-size: 24px;
}
.ico{
  display: flex;
  padding-bottom: 10px;
  margin-left: auto;
  margin-right: auto;
  max-width: 20em;
}
.user {
  background: #f4f4f4;
  margin: 10px;
  padding: 10px 20px;
  cursor: pointer;
  min-height: 45em;
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