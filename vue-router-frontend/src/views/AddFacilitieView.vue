<template>
  <div class="container-fluid" style="margin-top: 50px">
    <Header title="Step 1" v-if="step1"/>
  <form class="center" v-if="step1">
        <h1>Add  facilitie</h1>
        <InputBase
            v-model="NewFacilitie.name"
            label="Name:"
            type="text"
            @change="checkName"
        />
        <label>Type:</label>
        <select v-model="NewFacilitie.type" class="form-select form-select-lg mb-3 selectMy" aria-label=".form-select-lg example" >
            <option value="GYM">Gym</option>
            <option value="POOL">Pool</option>
            <option value="SPORTCENTER">Sport center</option>
            <option value="DANCINGSTUDIO">Dancing studio</option>
            <option value="BOWLINGCENTER">Bowling center</option>
            <option value="SHOOTINGRANGE">Shooting range</option>
        </select>
        <InputBase
            v-model="NewFacilitie.city"
            label="City:"
            type="text"
        />
      <InputBase
          v-model="NewFacilitie.address"
          label="Street and number:"
          type="text"
      />
    <InputBase
        v-model="NewFacilitie.postal"
        label="PostalCode:"
        type="text"
    />
    <InputBase
        v-model="NewFacilitie.longi"
        label="Longitude:"
        type="text"
    />
    <InputBase
        v-model="NewFacilitie.lat"
        label="Latitude:"
        type="text"
    />
        <div class="col-auto">
        <label  class="col-form-label">Upload image:</label>
         </div>
    <div class="row g-2">
         <div class="col-auto">
           <input :disabled="isDisabled" class="form-control inputMy" type="file" id="formFile">
         </div>
        <div class="col-auto">
          <button @click.prevent="OnFileUpload(this.NewFacilitie.name)" :disabled="isDisabled" class="btn btn-primary mb-3 btn-lg  buttonMy">Add logo</button>
        </div>
      </div>
    <div>
    </div>
    <div class="d-grid gap-2 col-5 mx-auto">
      <input @click.prevent="ChangeView"  class="submiter btn btn-primary btn-lg" value="Next" :disabled="isDisabled"/>
    </div>
  </form>
    <div v-if="!step1">
      <div class="container-fluid">
        <Header title="Step 2"/>
        <form  class="center" @submit.prevent="addFacilitie">
          <AvailableManagers @selectedMng="OnSelection" @isAny="CheckAvailability" v-if="isAvailable"/>
          <CreateManagerForFacilitie v-if="!isAvailable" @createdManager="SendManager"/>
          <div class="d-grid gap-2 col-5 mx-auto">
            <input type="submit" class="submiter btn btn-primary btn-lg" value="Finish"/>
          </div>
        </form>
      </div>
    </div>

    </div>
</template>

<script>
import CreateManagerForFacilitie from "@/components/createManagerForFacilitie";
import MultiDropDown from '../components/MultiDropDown.vue'
import InputBase from "@/components/InputBase"
import FacilitieService from '../FrontedServices/FacilitieServices'
import axios from "axios";
import AvailableManagers from "@/components/AvailableManagers";
import Header from "@/components/Header";
export default {
    name: 'addFaciliteView',
    data(){
        return{
            NewFacilitie:{
                name: '',
                type: '',
                city: '',
                postal: '',
                address: '',
                lat:'',
                longi:''
            },
          selectedFile:null,
          isDisabled:true,
          facilities:[],
          availableManager:null,
          isAvailable : true,
          step1:true
        }
    },
    components:{
      AvailableManagers, MultiDropDown,InputBase,FacilitieService,CreateManagerForFacilitie,Header
    },
    methods:{
      OnFileUpload(name){
        axios.post("http://localhost:8080/BodyFit/rest/files/uploadFile/",name)
            .then((response)=>{console.log("Success set up name" + response)})
            .catch((error) => console.log(error))
        let base64String = "";
        const file = document.querySelector('input[type=file]')['files'][0];
        const reader = new FileReader();
        reader.onload = function () {
          base64String = reader.result.replace("data:", "").replace(/^.+,/, "");
          console.log(name);
          axios.post("http://localhost:8080/BodyFit/rest/files/uploadLogo/",base64String)
              .then((response)=>{console.log("Success uploading")})
              .catch((error) => console.log(error))
        }
        reader.readAsDataURL(file);
      },
      getAll(){
        FacilitieService.getFacilities().then((response) => {
          this.facilities = response.data
        });
      },
      checkName(){
        if (this.facilities.some(code=> code.name.toLowerCase() === this.NewFacilitie.name.toLowerCase()))
        {
          this.error = "Wrong name.Please choose another name!";
          alert(this.error);
          this.isDisabled = true
        }
        else if(!this.NewFacilitie.name){
          this.isDisabled = true
        }
        else{
          this.isDisabled = false
        }
      },
      OnSelection(selectedManager){
        this.availableManager= selectedManager
        console.log(this.availableManager)
      },
      CheckAvailability(isAny){
        this.isAvailable = isAny
      },
      SendManager(user){
        this.availableManager = user
        console.log(user)
      },
      addFacilitie(){
        axios.post("http://localhost:8080/BodyFit/rest/newFacilitie/",this.NewFacilitie)
            .then((response)=>{console.log(this.NewFacilitie)})
            .catch((error) => console.log(error))
        axios.post("http://localhost:8080/BodyFit/rest/newFacilitie/setManager/",this.availableManager)
            .then((response)=>{console.log(this.availableManager)})
            .catch((error) => console.log(error))
        this.$router.push('Facilities')
      },
      ChangeView(){
        this.step1 = false
      }
    },
  created() {
    this.getAll()
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
</style>