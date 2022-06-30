<template>
  <div class="container-fluid" style="margin-top: 150px">
  <form class="center" @submit.prevent="$emit('addFacilitie',this.NewFacilitie)">
        <h1>Add  facilitie</h1>
        <InputBase
            v-model="NewFacilitie.name"
            label="Name:"
            type="text"
            @change="checkName"
        />
        <label>Type</label>
        <select v-model="NewFacilitie.type" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" >
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
        <div class="col-auto">
        <label  class="col-form-label">Upload image:</label>
         </div>
    <div class="row g-2">
         <div class="col-auto">
           <input class="form-control inputMy" type="file" id="formFile">
         </div>
        <div class="col-auto">
          <button @click.prevent="OnFileUpload(this.NewFacilitie.name)" :disabled="isDisabled" class="btn btn-primary mb-3 btn-lg  buttonMy">Add logo</button>
        </div>
      </div>
    <div class="d-grid gap-2 col-5 mx-auto">
      <input  type="submit" class="submiter btn btn-primary btn-lg" value="Add Facilitie" :disabled="isDisabled"/>
    </div>

  </form>
  <p>{{NewFacilitie.name}}</p>
  <p>{{NewFacilitie.type}}</p>
  <p>{{NewFacilitie.city}}</p>
  <p>{{NewFacilitie.address}}</p>
  <p>{{NewFacilitie.postal}}</p>
    </div>
</template>

<script>
import MultiDropDown from '../components/MultiDropDown.vue'
import InputBase from "@/components/InputBase"
import FacilitieService from '../FrontedServices/FacilitieServices'
import axios from "axios";
export default {
    name: 'addFaciliteView',
    data(){
        return{
            NewFacilitie:{
                name: '',
                type: '',
                city: '',
                postal: '',
                address: ''
            },
          selectedFile:null,
          isDisabled:true,
          facilities:[]
        }
    },
    components:{
        MultiDropDown,InputBase,FacilitieService
    },
    methods:{
      OnFileUpload(name){
        let base64String = "";

        const file = document.querySelector('input[type=file]')['files'][0];

        const reader = new FileReader();
        reader.onload = function () {
          base64String = reader.result.replace("data:", "").replace(/^.+,/, "");
          console.log(name);
          axios.post("http://localhost:8080/BodyFit/rest/files/uploadFile/",name)
              .then((response)=>{console.log("Success set up name" + response)})
              .catch((error) => console.log(error))
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
          this.error = "Wrong credentials.Please choose another name!";
          alert(this.error);
          this.isDisabled = true
        }
        else if(!this.NewFacilitie.name){
          this.isDisabled = true
        }
        else{
          this.isDisabled = false
        }
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
        font-size: 15px;
    }
    select {
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
        color: white;
        border-radius: 15px;
        font-size: 20px;
        margin-top: 50px;
        padding: 20px;
    }
</style>