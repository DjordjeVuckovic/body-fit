<template>
  <div class="comment col"> 
    <div class="row"> 
        <div style="padding: 10px;"><h1>{{Comment.customerId}}</h1></div>      
        <div style="padding: 10px;" class="row"><star-rating :rating="Comment.rating" :read-only="true" :increment="0.01"></star-rating></div>
        <div style="padding: 10px;" class="row"><h1>{{Comment.text}}</h1></div>
    </div >
    
    
  </div>
</template>

<script>
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
        StarRating
     },
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
</style>