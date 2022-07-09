<template>
  <div class="container-fluid" style="margin-top: 15em">
  </div>
  <form class="center">
    <h1>Edit  training</h1>
    <InputBase
        v-model="name"
        label="Name:"
        type="text"
        @change="checkName"
    />
    <label>Type:</label>
    <select v-model="type"  class="form-select form-select-lg mb-3 selectMy" aria-label=".form-select-lg example" >
      <option value="GROUP">Group</option>
      <option value="PERSONAL">Personal</option>
      <option value="GYM">Gym</option>
      <option value="YOGA">Yoga</option>
      <option value="PILATES">Pilates</option>
      <option value="LESSMILLS">Less mills</option>
    </select>
    <InputBase class="description"
               v-model="description"
               label="Description:"
               type="text"
    />
    <label class="baseLabel">Duration(minutes):</label>
    <input class="inputBase form-control" v-model="duration" type="number" min="1" max="1000"/>
    <label class="baseLabel">Additional price:</label>
    <input class="inputBase form-control" v-model="additionalPrice" type="number" min="1" max="1000"/>
    <AllTrainers :selectedTrainer="trainer" @selectedTrainer="OnSelection"/>
    <div class="col-form-label-lg">
      Current trainer: {{trainerId}}
    </div>
    <div class="col-auto">
      <label  class="col-form-label">Upload image:</label>
    </div>
    <div class="row g-2">
      <div class="col-auto">
        <input class="form-control inputMy" :disabled="isDisabled" type="file" id="formFile">
      </div>
      <div class="col-auto">
        <button @click.prevent="OnFileUpload"  :disabled="isDisabled" class="btn btn-primary mb-3 btn-lg  buttonMy">Add photo</button>
      </div>
    </div>
    <div>
    </div>
    <div class="d-grid gap-2 col-5 mx-auto">
      <input @click.prevent="EditTraining"  class="submiter btn btn-primary btn-lg" value="Finish" :disabled="isDisabled"/>
    </div>
  </form>
</template>

<script>
import axios from "axios";
import InputBase from "@/components/InputBase";
import AllTrainers from "@/components/AllTrainers";
import TrainingService from "@/FrontedServices/TrainingService";
import TrainerService from "@/FrontedServices/TrainerService";

export default {
  name: "EditTrainingView",
  data(){
    return{
      startName:'',
      id:this.$route.params.id,
      name:'',
      type: '',
      description:'',
      duration:'',
      additionalPrice:'',
      trainings:[],
      selectedFile:null,
      isDisabled:false,
      trainer:{},
      trainerId:'',
      pic: null
    }
  },
  components:{InputBase,AllTrainers,TrainingService},
  methods: {
    OnFileUpload(){
      axios.post("http://localhost:8080/BodyFit/rest/files/uploadFile/",this.name)
          .then((response)=>{console.log("Success set up name" + response)})
          .catch((error) => console.log(error))
      let base64String = "";
      const file = document.querySelector('input[type=file]')['files'][0];
      const reader = new FileReader();
      reader.onload = function () {
        base64String = reader.result.replace("data:", "").replace(/^.+,/, "");
        console.log(this.name);
        axios.post("http://localhost:8080/BodyFit/rest/files/editTrainingPhoto/",base64String)
            .then((response)=>{console.log("Success uploading")})
            .catch((error) => console.log(error))
      }
      reader.readAsDataURL(file);
    },
    checkName() {
      if (this.trainings.some(code => code.name.toLowerCase() === this.name.toLowerCase())) {
        if(this.startName !== this.name) {
          this.error = "Wrong name.Please choose another name!";
          alert(this.error);
          this.isDisabled = true
        }
      } else if (!this.name) {
        this.isDisabled = true
      } else {
        this.isDisabled = false
      }
    },
    EditTraining() {
      //console.log(this.logedInUser)
      if(!document.getElementById('formFile').value){
        console.log('vv')
      }
      let trainerIdd = ""
      if(this.trainer != null){
        trainerIdd = this.trainer.username
      }
      const training = {
        id: this.id,
        name: this.name,
        type: this.type,
        description: this.description,
        duration:this.duration,
        additionalPrice: this.additionalPrice,
        sportFacilityId : this.logedInUser.sportFacilityId,
        trainerId : trainerIdd
      }
      console.log(training)
      TrainingService.updateTraining(training)
          .then((response)=>{console.log(response.data)})
          .catch((error) => console.log(error))
      this.$router.push({name : 'trainingsForManagerView'})
    },
    getAll() {
      TrainingService.getByManager(this.logedInUser.sportFacilityId).then((response) => {
        this.trainings = response.data
      });
    },
    OnSelection(selectedTrainer){
      this.trainer = selectedTrainer;
      this.trainerId = selectedTrainer.username
      console.log(this.trainer)
    },
    findTrainer(){
      TrainerService.getTrainers().then(
          (res)=>{
            for(let tr of res.data){
              if(tr.username === this.trainerId){
                this.trainer =tr
              }
            }
          }
      )
    },
    getImgUrl(name){
      let images = require.context('../assets/trainings', false, /\.png$/);
      return images('./' + name + ".png")
    }
  },
  created() {
    axios.post("http://localhost:8080/BodyFit/rest/trainings/getById",this.id).then(
        (res)=>{
          this.startName =res.data.name
          this.name= res.data.name
          this.type = res.data.type
          this.description = res.data.description
          this.duration = res.data.duration
          this.additionalPrice = res.data.additionalPrice
          this.trainerId = res.data.trainerId
          this.pic = this.getImgUrl(res.data.name)
          console.log(res.data)
        }
    )
    this.getAll()
    this.findTrainer()
  },
  props:{
    logedInUser:Object
  }
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