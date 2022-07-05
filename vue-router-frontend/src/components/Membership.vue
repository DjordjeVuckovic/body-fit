<template>
    <div class = "membership ">
        <form @submit.prevent="$emit('buyMembership',this.user)">
            <div class="big pb-1">
            <h1 style="padding-top:10px ;">{{numberOfSession}}</h1>
            <p1>trenings per month</p1>
        </div>
        <div class="big pb-1">
            <h1>{{type}}</h1>
            <p1>membership</p1>
        </div>
        <div>
            <h1>{{price}}</h1>
            <p>RSD</p>
            <button class="buttonMy" @click="buyMembership">Buy</button>
        </div>
        </form>
    </div>
</template>

<script>
import axios from "axios";
export default {
    name:'Membership',
    props:['numberOfSession','type','price','logedInUser'],
    data(){
        return{
            membership:{
                numberOfSession: this.numberOfSession,
                type: this.type,
                price: this.price,
            }
        }
    },
    methods:{
        buyMembership(){

            var today = new Date();
            var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            var endDate = this.calculateEndDate()
            let newmembership={
                type: this.type,
                paymentDate : date,
                dateAndTimeOfValidity: endDate,
                price: this.price,
                customerId:this.logedInUser.username,
                isActive: true,
                numberOfSession: this.numberOfSession
            }

             axios.post("http://localhost:8080/BodyFit/rest/memberships/",newmembership)
            .then((response) => {
                console.log(response.data)})
            .catch((error) => console.log(error))
            
        },
        calculateEndDate(){
            if(this.type=="MONTH"){
                var today = new Date();
                today.setMonth(today.getMonth()+1);
               
                return today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            }
            else if(this.type=="THREE_MONTHS"){
                var today = new Date();
                today.setMonth(today.getMonth()+3);
               
                return today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            }
            else if(this.type=="SIX_MONTHS"){
                var today = new Date();
                today.setMonth(today.getMonth()+6);
               
                return today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            }
            else if(this.type=="YEAR"){
                var today = new Date();
                today.setFullYear(today.getFullYear()+1);
               
                return today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            }
        }
    }
    
}
</script>

<style>
    
   .fas {
  color: red;
}
table{
  width: 90%;
  font-size: 24px;
}
.ico{
  display: flex;
  padding-bottom: 10px;
  margin-left: auto;
  margin-right: auto;
  max-width: 20em;
}
.membership {
  border-bottom:2px solid  #2691d9; 
  
  background: #f4f4f4;
  border-radius: 15px;
  cursor: pointer;
  min-height: 500px;
  max-height: 500px;
  min-width: 350px;
  max-width: 350px;
}
.buttonMy{
  background: #2691d9;
  color: white;
  border-radius: 15px;
  font-size: 20px;

  margin-top: 15px;
  margin-left: 140px;
  margin-right: auto;
}
.name {
  align-items: flex-start;
  text-align: end;
  color: #2691d9;
  font-size:40px;
  margin-top: auto;
  margin-bottom: auto;
  min-height: 10em;
  display: table-cell;
  vertical-align: middle;
  padding-bottom:10px;
}
.myth {
  color: blue;
  text-align: center;
  font-size: 30px;
  margin-bottom: 20px;
}
table, tbody, td {
  padding-bottom:5px;
}
.big{
    border-bottom:2px solid  #2691d9; ;
    text-align: center;
    color: #2691d9;
}
h1{
    padding-bottom: 10px;
}
</style>