<template>
  <div class="container-fluid" style="margin-top: 120px;">
    <div class="row">
    <Facilitie @viewComments="viewComments"  @hideTrenings="hideTrenings" :viewTreningsBoole="viewTreningsBoole" :viewComentsBoole="viewComentsBoole" @viewTrenings="viewTrenings" @hideComments="hideComments" :selectedFacilitie="selectedFacilitie" :facilitie="selectedFacilitie"></Facilitie>
    </div>
    <div  v-if="viewComentsBoole"> 
        <div  v-if="isAdmin || isManager" class="row bg-dark"> 
          <div class="col">
            <div style="border-bottom: 5px white;">
              <h1 class="comments">Aproved:</h1>
            </div>
        
        <div  v-for="com in commentsAproved" v-bind:key="com.id"  style="padding-top: 20px"> 
          <Comment :isManager="isManager" :isCustomer="isCustomer" :isTrainer="isTrainer" :isAdmin="isAdmin" @refreshComments="refreshComments" :Comment="com"></Comment>
        </div>
      </div>
      
      <div class="col">
        <h1 class="comments">Not aproved:</h1>
        <div  v-for="com in commentsNotAproved" v-bind:key="com.id"  style="padding-top: 20px"> 
          <Comment :isManager="isManager" :isAdmin="isAdmin" @refreshComments="refreshComments" :isCustomer="isCustomer" :isTrainer="isTrainer" :Comment="com"></Comment>
        </div>
      </div>
    </div>

      <div  v-if="isCustomer || isTrainer" class="row bg-dark"> 
        <div class="col">
          <div  v-for="com in commentsAproved" v-bind:key="com.id"  style="padding-top: 20px"> 
            <Comment :isManager="isManager" :isAdmin="isAdmin" @refreshComments="refreshComments" :isCustomer="isCustomer" :isTrainer="isTrainer" :Comment="com"></Comment>
          </div>
        </div>
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
      <h1 class="headMy"> Other content</h1>
      <div   class="py-5 mx-5">
        <div class="row row-cols-2 g-3">
          <div  v-for="tr in contents" v-bind:key="tr.id" class="container" style="padding-top: 20px">
            <div class="col">
              <OtherContent :training = "tr"></OtherContent>
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
import OtherContent from "@/components/OtherContent";
export default {
    name: 'SelectedFacilitieView',
    data(){
        return {
          trainings : [],
          viewTreningsBoole:true,
          viewComentsBoole:false,
          commentsAproved:[],
          commentsNotAproved:[],
          contents:[]
        }
    },
    props:['selectedFacilitie', 'isCustomer','isManager','isAdmin','isTrainer',],
    
    components:{
      OtherContent,
      TrainingForCustomer,Facilitie,ModalBuyTraining,CommentService,Comment
        },
    created() {
      TrainingService.getByFacility(this.selectedFacilitie.id).
      then((res)=>{this.trainings = res.data})
      CommentService.getByFacilityAproved(this.selectedFacilitie.id).
      then((response)=>{this.commentsAproved = response.data})
      CommentService.getByFacilityNotAproved(this.selectedFacilitie.id).
      then((response)=>{this.commentsNotAproved = response.data; console.log("sadgfasgfadgdfag")})
      .catch((error) => console.log(error))
      console.log(this.selectedFacilitie)
      TrainingService.getContent(this.selectedFacilitie.id).then(
          (res)=>{
            this.contents = res.data
          }
      )
    },
    methods:{
      viewTrenings(){
        this.viewTreningsBoole = true
      },
      refreshComments(){
        CommentService.getByFacilityAproved(this.selectedFacilitie.id).
        then((response)=>{this.commentsAproved = response.data})
        CommentService.getByFacilityNotAproved(this.selectedFacilitie.id).
        then((response)=>{this.commentsNotAproved = response.data})
      },
      viewComments(){
        console.log(this.isCustomer)
        this.viewComentsBoole = true
      },
      hideComments(){
         this.viewComentsBoole = false
      },
      hideTrenings(){
         this.viewTreningsBoole = false
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