<template >
<div class="b " style="margin-top: 250px;">
    <div >
     
      <div style="margin-left: 30px;">
        <star-rating :rounded-corners="true" text-class="custom-text" :show-rating="false" :border-width="6" :star-size="70"   @update:rating="rating = $event"></star-rating>
      </div>
        
        <label class="labelMy">Leave a comment about your experience </label>
        <div class="comment" style="margin-top: 35px;">
            <textarea v-model="comment.text" class="comment-text"></textarea>
        </div>
        <div>
          <button class="buttonMy" @click="postRating" style="margin-left: 50px;" >Post</button>
          <button class="buttonMy"  @click="exit" style="margin-left: 150px;">Cancel</button>
        </div>
    </div>
</div>

  
</template>

<script>
import axios from "axios";
import StarRating from 'vue-star-rating'
export default {
     name: 'Raiting',
     components:{
        StarRating
     },
     props:{
        logedInUser: Object,
        selectedFacilitie: Object
     },
     data(){
        return{
            rating: null,
            resetableRating: 2,
            currentRating: "No Rating",
            mouseOverRating: null,
            comment:{
              id:'',
              customerId: this.logedInUser.username,

              text: '',
              rating: this.rating,
              state:false
            }
            
        }
     },
      methods: {
    showCurrentRating(rating) {
      this.currentSelectedRating =
        rating === 0
          ? this.currentSelectedRating
          : "Click to select " + rating + " stars";
    },
    setCurrentSelectedRating(rating) {
      this.currentSelectedRating = "You have Selected: " + rating + " stars";
    },
    postRating(){
      var newcomment={
              id:'',
              customerId: this.logedInUser.username,
              sportFacilityId:this.selectedFacilitie.sportFacilityId,
              text: this.comment.text,
              rating: this.rating,
              state:false
            }
      axios.post("http://localhost:8080/BodyFit/rest/comments/",newcomment)
            .then((response) => {console.log(response.data)})
      
      
    },
    exit(){
      this.$router.push({name : 'TraningsCustomerView'})
    }
  },
    computed: {
        currentRatingText() {
          console.log(this.selectedFacilitie)
        return this.rating()
            ? "You have selected " + this.rating + " stars"
            : "No rating selected";
        }
    }
}

</script>

<style scoped>

.buttonMy{
        background: #2691d9;
        color: white;
        border-radius: 15px;
        font-size: 20px;
    }
    .b {
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
  margin-bottom: 25px;
}
.comment{
    background-color: unset;
}
.comment-text{
    width: 450px;
    height: 500px;
}
.custom-text {
  font-weight: bold;
  font-size: 1.9em;
  border: 1px solid #cfcfcf;
  padding-left: 10px;
  padding-right: 10px;
  border-radius: 5px;
  color: #999;
  background: #fff;
}
.labelMy {
        color: #aaa;
        display: inline-block;
        margin: 25px 0 15px;
        font-size: 0.7em;
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: bolder;
        font-size: 20px;
    }
</style>