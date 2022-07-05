<template>
<div class="container my-margin">
  <div class="row-cols-sm-2 d-flex my-cart">
  <div class="col-lg-6 my-border">
    <h1  class="headMy">{{nameFacility}}</h1>
  </div>
  <div class="col-lg-6 ico pt-3 pb-3 justify-content-center">
    <span class="d-block">
    <img :src="getImgUrl(nameFacility)"  class="ico"/>
      </span>
  </div>
  </div>
</div>
  <div style="padding-top: 30px" class="container-fluid">
    <h1 class="headMy">Available trainings</h1>
  <div  class="py-5 mx-5">
    <div class="row row-cols-2 g-3">
      <div  v-for="tr in trainingsForManager" v-bind:key="tr.id" class="container" style="padding-top: 20px">
        <div class="col">
          <Training :training = "tr" ></Training>
        </div>
    </div>
  </div>
  </div>
  </div>
</template>

<script>
import TrainingService from "@/FrontedServices/TrainingService";
import Training from "@/components/Training";
import Facilitie from "@/components/Facilitie";
import FacilitieServices from "@/FrontedServices/FacilitieServices";
import HeaderMulti from "@/components/Header";
export default {
  name: "TrainingsForManager",
  components: {HeaderMulti, Training,Facilitie},
  data(){
    return{
      trainingsForManager:[],
      nameFacility : ''
    }
  },
  props:['logedInUser'],
  created() {
    TrainingService.getByManager(this.logedInUser.sportFacilityId).
    then((res)=>{this.trainingsForManager = res.data})
    FacilitieServices.getById(this.logedInUser.sportFacilityId).
    then((res)=> {this.nameFacility = res.data.name;})
  },
  methods:{
    getImgUrl(name){
      if(name == ''){
        return
      }
      let images = require.context('../assets/', false, /\.png$/);
      return images('./' + name + ".png")
    }
  }

}
</script>

<style scoped>
.my-margin{
  padding-top: 100px;
}
.headMy{
  text-align: center;
  vertical-align: center;
  padding-top: 0.5em;
  padding-left: 0.5em;
  font-size: 7em;
  color: #2691d9;
}
.my-cart {
  background: #f4f4f4;
  padding: 10px 20px;
  cursor: pointer;
}
.my-border{
  border-right: 5px solid #2691d9;
}

</style>