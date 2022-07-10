<template>
  <div class="container-fluid ">
    <div class="row">
    <Facilitie @viewComments="viewComments" @viewTrenings="viewTrenings" :selectedFacilitie="selectedFacilitie" :facilitie="selectedFacilitie"></Facilitie>
    </div>
    <div class="row bg-dark"> 
      <div class="col">
        <div style="border-bottom: 5px white;">
          <h1 class="comments">Aproved:</h1>
        </div>
        
        <div  v-for="com in comments" v-bind:key="com.id"  style="padding-top: 20px"> 
          <Comment :Comment="com"></Comment>
        </div>
      </div>
      
      <div class="col">
        <h1 class="comments">Not aproved:</h1>
        <div  v-for="com in comments" v-bind:key="com.id"  style="padding-top: 20px"> 
          <Comment :Comment="com"></Comment>
        </div>
      </div>
    </div>
    <div v-if="viewTreningsBoole" class="row">
      <h1 class="headMy">Available trainings</h1>
      <div   class="py-5 mx-5">
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
import CommentService from "../FrontedServices/CommentServices";
import ModalBuyTraining from "@/components/ModalBuyTraining";
import Comment from "../components/Comment.vue";
export default {
    name: 'SelectedFacilitieView',
    data(){
        return {
          trainings : [],
          viewTreningsBoole:false,
          comments:[]
        }
    },
    props:{
      selectedFacilitie: Object,
      isCustomer:Boolean,
      modalOpen : false
    },
    components:{
      TrainingForCustomer,Facilitie,ModalBuyTraining,CommentService,Comment
        },
    created() {
      TrainingService.getByFacility(this.selectedFacilitie.id).
      then((res)=>{this.trainings = res.data})
      CommentService.getByFacility(this.selectedFacilitie.id).
      then((response)=>{this.comments = response.data})
    },
    methods:{
      viewTrenings(){
        this.viewTreningsBoole = true
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
.comments{
  color: white;
  text-align: center;
  padding-top: 35px;
  border-bottom: 2px white;
}
</style>