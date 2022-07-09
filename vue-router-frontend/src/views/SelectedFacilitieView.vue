<template>
  <div class="container-fluid">
    <div class="row">
    <Facilitie :facilitie="selectedFacilitie"></Facilitie>
    </div>
    <div class="row">
      <h1 class="headMy">Available trainings</h1>
      <div  class="py-5 mx-5">
        <div class="row row-cols-2 g-3">
          <div  v-for="tr in trainings" v-bind:key="tr.id" class="container" style="padding-top: 20px">
            <div class="col">
              <TrainingForCustomer :training = "tr" :isCustomer="isCustomer"></TrainingForCustomer>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Facilitie from '../components/Facilitie.vue'
import TrainingForCustomer from "@/components/TrainingForCustomer";
import TrainingService from "@/FrontedServices/TrainingService";
import ModalBuyTraining from "@/components/ModalBuyTraining";
export default {
    name: 'SelectedFacilitieView',
    data(){
        return {
          trainings : []
        }
    },
    props:{
      selectedFacilitie: Object,
      isCustomer:Boolean,
      modalOpen : false
    },
    components:{
      TrainingForCustomer,
            Facilitie,ModalBuyTraining
        },
    created() {
      TrainingService.getByFacility(this.selectedFacilitie.id).
      then((res)=>{this.trainings = res.data})
    }
}
</script>

<style>
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
</style>