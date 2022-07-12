<template>
  <div class="container-fluid" style="margin-top: 10em">
    <form class="center">
      <h1>Schedule training</h1>
      <div>
        <label  class="baseLabel">Choose date:</label>
        <input class="inputBase form-control" v-model="date" type="date"/>
      </div>
      <div>
        <label  class="baseLabel">Choose start time:</label>
        <input class="inputBase form-control" v-model="startTime" type="time"/>
      </div>
      <div>
        <label  class="baseLabel">Choose finish time:</label>
        <input class="inputBase form-control" v-model="finishTime" type="time"/>
      </div>
      <div class="d-grid gap-2 col-5 mx-auto">
        <input @click.prevent="getMemebership"  class="submiter btn btn-primary btn-lg" value="Finish"/>
      </div>
      <vue-basic-alert :duration="200" :closeIn="5000" ref="alert"></vue-basic-alert>
    </form>
  </div>
</template>

<script>
import VueBasicAlert from "vue-basic-alert";
import axios from "axios";
import moment from "moment"
import TrainerService from "@/FrontedServices/TrainerService";
import InputBase from "@/components/InputBase";
import ScheduleTraningService from "@/FrontedServices/ScheduleTraningService";

export default {
  name: "BuyTrainingView",
  components:{VueBasicAlert},
  data(){
    return{
      id: this.$route.params.id,
      date:'',
      startTime:'',
      finishTime:'',
      name:'',
      type: '',
      description:'',
      duration:'',
      additionalPrice:'',
      selectedFile:null,
      isDisabled:false,
      trainer:{},
      trainerId:'',
      membership:null,
      noMembership:false
    }
  }
  ,created() {
    axios.post("http://localhost:8080/BodyFit/rest/trainings/getById",this.id).then(
        (res)=>{
          this.startName =res.data.name
          this.name= res.data.name
          this.type = res.data.type
          this.description = res.data.description
          this.duration = res.data.duration
          this.additionalPrice = res.data.additionalPrice
          this.trainerId = res.data.trainerId;
          console.log(res.data)
        }
    )
    this.findTrainer()
  },
  methods: {
    findTrainer() {
      TrainerService.getTrainers().then(
          (res) => {
            for (let tr of res.data) {
              if (tr.username === this.trainerId) {
                this.trainer = tr
              }
            }
          }
      )
    },
    getMemebership(){
      axios.post("http://localhost:8080/BodyFit/rest/memberships/getByCustomer",this.logedInUser.username)
            .then((response) => {
              console.log(response.data)
                this.membership =response.data;
                if(this.membership.numberOfSession<=0 ){
                  console.log("usoo1")
                  this.$refs.alert
                  .showAlert('error','Your membership has expired ','warning')
                }
                else{
                  this.BuyTraining();
                }
             })
            .catch((error) => this.$refs.alert
                  .showAlert('error','Your membership has expired ','warning'))

            
    },
    BuyTraining() {
      
      
      
        let today = new Date();
      if(moment(this.date).isBefore(today)){
        this.$refs.alert
            .showAlert('error','Plese fulfill date of validaty correctly ','warning')
      }
      else {
        let scheduleTraining = {
          dateAssign : today,
          dateTraining: this.date,
          traningId: this.id,
          customerId : this.logedInUser.username,
          startTime : this.startTime,
          finishTime : this.finishTime
        }
        ScheduleTraningService.createScheduleTraining(scheduleTraining)
        this.$refs.alert.showAlert('success', 'You have successfully schedule training ', 'Congratulations!')
        // for (let i = 0; i < 2; i++) {
        //   console.log(`Waiting ${i} seconds...`);
        //   new Promise(resolve => setTimeout(resolve, i * 1000))
        // }
        // this.$router.push({name: 'Facilities'})
      
      }
      
    }
  },
    props:{
      logedInUser:Object
    },
}
</script>

<style scoped>
.center h1{
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif, 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif, 'Arial Narrow', Arial, sans-serif, Courier, monospace;
  text-align: center;
  padding: 0 0 20px 0;
  color: #2691d9;
}
form {
  max-width: 720px;
  margin: 30px auto;
  background: rgb(242, 242, 240);
  text-align: left;
  padding: 40px;
  border-radius: 10px;
  font-size: 15px;
}
label {
  color: #aaa;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.6em;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-weight: bolder;
  font-size: 20px;
}
.selectMy {
  width: 100%;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.6em;
  text-transform: uppercase;
  letter-spacing: 2px;
  font-weight: bolder;
  font-size: 15px;
}
.inputMy {
  padding: 10px 6px;
  width: 75%;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid #ddd;
  color: #555;
  font-size: 20px;
}
.buttonMy{
  background: #2691d9;
  color: white;
  border-radius: 15px;
  font-size: 20px;
}
.submiter{
  text-align: center;
  background: #2691d9;
  border-radius: 15px;
  font-size: 20px;
  margin-top: 50px;
  padding: 20px;
  cursor: auto;
}
.baseLabel {
  color: #aaa;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.6em;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-weight: bolder;
  font-size: 20px;
}
.inputBase {
  display: block;
  padding: 10px 6px;
  width: 100%;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid #ddd;
  color: #555;
  font-size: 20px;
}
</style>