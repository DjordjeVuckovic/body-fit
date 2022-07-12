<template>
  <div class="container-fluid" style="margin-top: 150px">
  </div>
  <form class="center">
    <h1>Add  other content</h1>
    <InputBase
        v-model="name"
        label="Name:"
        type="text"
        @change="checkName"
    />
    <InputBase class="description"
               v-model="description"
               label="Description:"
               style="max-height: 300px"
               type="text"
    />
    <label class="baseLabel">Duration(minutes):</label>
    <input class="inputBase form-control" v-model="duration" type="number" min="1" max="1000"/>
    <label class="baseLabel">Additional price:</label>
    <input class="inputBase form-control" v-model="additionalPrice" type="number" min="1" max="1000"/>
    <div class="col-auto">
      <label  class="col-form-label">Upload image:</label>
    </div>
    <div class="row g-2">
      <div class="col-auto">
        <input class="form-control inputMy" :disabled="isDisabled" type="file" id="formFile">
      </div>
      <div class="col-auto">
        <button @click.prevent="OnFileUpload" :disabled="isDisabled" class="btn btn-primary mb-3 btn-lg  buttonMy">Add photo</button>
      </div>
    </div>
    <div>
    </div>
    <div class="d-grid gap-2 col-5 mx-auto">
      <input @click.prevent="CreateTraining"  class="submiter btn btn-primary btn-lg" value="Finish" :disabled="isDisabled"/>
    </div>
  </form>
</template>

<script>
import InputBase from "@/components/InputBase";
import AllTrainers from "@/components/AllTrainers";
import TrainingService from "@/FrontedServices/TrainingService";
import axios from "axios";
export default {
  name: "AddContentView",
  components:{InputBase,AllTrainers,TrainingService},
  data() {
    return {
      name:'',
      type: '',
      description:'',
      duration:'',
      additionalPrice:'',
      trainings:[],
      selectedFile:null,
      isDisabled:true,
      trainer:{}
    }
  },
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
        axios.post("http://localhost:8080/BodyFit/rest/files/uploadTrainingPhoto/",base64String)
            .then((response)=>{console.log("Success uploading")})
            .catch((error) => console.log(error))
      }
      reader.readAsDataURL(file);
    },
    checkName() {
      if (this.trainings.some(code => code.name.toLowerCase() === this.name.toLowerCase())) {
        this.error = "Wrong name.Please choose another name!"
        alert(this.error);
        this.isDisabled = true
      } else if (!this.name) {
        this.isDisabled = true
      } else {
        this.isDisabled = false
      }
    },
    CreateTraining() {
      //console.log(this.logedInUser)
      let trainerIdd = ""
      if(this.trainer != null){
        trainerIdd = this.trainer.username
      }
      const training = {
        id : new Date(),
        name: this.name,
        description: this.description,
        duration:this.duration,
        additionalPrice: this.additionalPrice,
        sportFacilityId : this.logedInUser.sportFacilityId,
      }
      axios.post("http://localhost:8080/BodyFit/rest/contents",training).then(
          (res)=>{
            console.log("Success")
          }
      )
      this.$router.push({name : 'MainView'})
    },
    getAll() {
      axios.get("http://localhost:8080/BodyFit/rest/contents").then(
          (res)=>{
            this.trainings = res.data
          }
      )
    }
    },
  created() {
    this.getAll()
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