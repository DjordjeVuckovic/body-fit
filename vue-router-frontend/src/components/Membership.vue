<template>
    <div class = "membership">
        <form @submit.prevent="$emit('buyMembership',this.user)">
            <div class="big pb-1">
            <h1 style="padding-top:10px ;">{{numberOfSession}}</h1>
            <p1>trenings per month</p1>
        </div>
        <div class="big pb-1">
            <h1>{{type}}</h1>
            <p1>membership</p1>
        </div>
        
        <div class="big pb-1" >
            <h1>{{membership.price}}</h1>
            <p>RSD</p>
            
        </div>
        <div class="d-grid gap-2 col-5 mx-auto" v-if="!isCode">
            <button  class="buttonMy" @click="chooseMembership">Choose</button>
        </div>
        
        <div class="big p-3" v-if="isCode">
            <p1 >have a promo code?</p1>
            <input v-model="code" type="text"/>
            <button class="buttonMy" @click="applyCode">Apply</button>
        </div>
        <div class="d-grid gap-2 col-5 mx-auto" v-if="isCode">
            <button class="buttonMy" @click="buyMembership">Buy</button>
        </div>
        <vue-basic-alert :duration="200" :closeIn="5000" ref="alert"></vue-basic-alert>
        </form>
    </div>
</template>

<script>
import moment from "moment"
import VueBasicAlert from 'vue-basic-alert'
import axios from "axios";
import PromoCodeService from '../FrontedServices/PromoCodeServices'
export default {
    name:'Membership',
    props:['numberOfSession','type','price','logedInUser','isCode'],
    components:{PromoCodeService,VueBasicAlert},
    data(){
        return{
            membership:{
                numberOfSession: this.numberOfSession,
                type: this.type,
                price: this.price,
                promoCodes:[]
            },
            code:''
        }
    },
    emits:['chooseMembership'],
    methods:{
        chooseMembership(){
            this.$emit('chooseMembership',this.membership)
        },
        buyMembership(){
            var today = new Date();
            var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            var endDate = this.calculateEndDate()
            let newmembership={
                type: this.membership.type,
                paymentDate : date,
                dateAndTimeOfValidity: endDate,
                price: this.membership.price,
                customerId:this.logedInUser.username,
                isActive: true,
                numberOfSession: this.membership.numberOfSession
            }

             axios.post("http://localhost:8080/BodyFit/rest/memberships/",newmembership)
            .then((response) => {
                console.log(response.data)})
            .catch((error) => console.log(error))
            
        },
        calculateEndDate(){
            let today;
          if(this.type=="MONTH"){
                today = new Date();
                today.setMonth(today.getMonth()+1);
               
                return today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            }
            else if(this.type=="THREE_MONTHS"){
            today = new Date();
            today.setMonth(today.getMonth()+3);
               
                return today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            }
            else if(this.type=="SIX_MONTHS"){
                today = new Date();
                today.setMonth(today.getMonth()+6);
               
                return today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            }
            else if(this.type=="YEAR"){
                today = new Date();
                today.setFullYear(today.getFullYear()+1);
               
                return today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            }
        },
        getAll(){
            PromoCodeService.getPromoCodes().
            then((res)=>
                {
                    console.log(res.data)
                    this.promoCodes = res.data
                })
        },
        applyCode(){
          let find = false;
          for (var existingCode of this.promoCodes){
                
                var today = new Date();
                console.log(this.code)
                console.log(existingCode.code)
                if (existingCode.code == this.code && existingCode.quantity > 0 && moment(today).isBefore(existingCode.dateOfValidity)){
                    
                    this.$refs.alert 
                    .showAlert('success','Yuu have successfully apllied promo code','congratulations!')
                    this.membership.price = this.membership.price - this.membership.price * existingCode.discount/100
                    find = true
                }
    
                
            }
            if(find==false)
                {
                    this.$refs.alert 
                    .showAlert('error','Incorrect promo code ','warning')
                    this.code=''
                }
        }

    },
    created() {
        this.getAll()
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
input {
        margin-top: 15px;
        
        display: block;
        padding: 10px 6px;
        width: 100%;
        box-sizing: border-box;
        border: none;
        border-bottom: 1px solid #ddd;
        color: #555;
        font-size: 20px;
    }
.membership {
  
  
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

  margin-top: 25px;
  margin-bottom: 25px;
  
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