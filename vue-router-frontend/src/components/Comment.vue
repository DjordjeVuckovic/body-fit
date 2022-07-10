<template>
  <div class="comment col"> 
    <div class="row"> 
        <div style="padding: 10px;"><h1>{{Comment.customerId}}</h1></div>      
        <div style="padding: 10px; margin-left: 160px;" class="row"><star-rating :rating="Comment.rating" :read-only="true" :increment="0.01"></star-rating></div>
        <div style="padding: 10px;" class="row"><h1>{{Comment.text}}</h1></div>
        <div v-if="!Comment.state">
            <button @click="aprove" class="buttonMy">Aprove</button>
        </div>
        <div v-if="Comment.state">
            <button @click="reject" class="buttonMyRed">Reject</button>
        </div>
    </div >
    
    
  </div>
</template>

<script>
import CommentService from "../FrontedServices/CommentServices";
import StarRating from 'vue-star-rating'
export default {
    name:'Comment',
    props:{
        Comment: Object
    },
    data(){
        return{

        }
    },
    components:{
        StarRating,CommentService
     },
     methods:{
        aprove(){
            var newComment={
                id: this.Comment.id,
                customerId:  this.Comment.id,
                sportFacilityId: this.Comment.sportFacilityId,
                text:  this.Comment.text,
                rating: this.Comment.rating,
                state:  true
            }
            CommentService.aproveComment(newComment).
            then((response)=>{this.$emit('refreshComments')})
        },
        reject(){
            var newComment={
                id: this.Comment.id,
                customerId:  this.Comment.id,
                sportFacilityId: this.Comment.sportFacilityId,
                text:  this.Comment.text,
                rating: this.Comment.rating,
                state:  false
            }
            CommentService.aproveComment(newComment).
            then((response)=>{this.$emit('refreshComments')})
        }
     },
     emits:['refreshComments']
}
</script>

<style scoped>
    .comment{
        padding: 15px;
        border-top: 2px black;
        font-family: 'Raleway', sans-serif;
        align-items: center;
        justify-content: center;
        display: flex;

    max-width: 650px;
    
    margin: 20px auto;
    background: rgb(242, 242, 240);
        
        
    border-radius: 10px;
    font-size: 20px;
    }
    h1{
        text-align: center;
    }
    .buttonMy{
  background: #2691d9;
  color: white;
  border-radius: 15px;
  font-size: 20px;
  padding: 20px;
  margin-left: 250px;
  margin-right: auto;
}
.buttonMyRed{
    background: #d6491e;
  color: white;
  border-radius: 15px;
  font-size: 20px;
  padding: 20px;
  margin-left: 250px;
  margin-right: auto;
}
</style>