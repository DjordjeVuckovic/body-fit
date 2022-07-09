<template>  
    <div class="container-fluid" style="margin-top: 50px">
        <form class="center">
            <InputBase
            v-model="NewPromoCode.code"
            label="Code:"
            type="text"
            @change="checkCode"
            />
        
            <label>Date of validity:</label>
            <input type="date" v-model="NewPromoCode.dateOfValidity" required>
        
        

            <label>Promo code quantity:</label>
            <input type="number" v-model="NewPromoCode.quantity" required>
        
            <label>Discount in percentages:</label>
            <input type="number" v-model="NewPromoCode.discount" required>
            
            <div class="d-grid gap-2 col-5 mx-auto">
            <button @click.prevent="addCode"  class="submiter btn btn-primary btn-lg" value="Add" :disabled="isDisabled">Add</button>
    </div>
            <vue-basic-alert :duration="200" :closeIn="5000" ref="alert"></vue-basic-alert>
        </form>
        <p>{{NewPromoCode.code}}</p>
        <p>{{NewPromoCode.dateOfValidity}}</p>
        <p>{{NewPromoCode.quantity}}</p>
        <p>{{NewPromoCode.discount}}</p>
    </div>
</template>

<script>
import VueBasicAlert from 'vue-basic-alert'
import moment from "moment"
import InputBase from "@/components/InputBase"
import PromoCodeService from '../FrontedServices/PromoCodeServices'
export default {
    name: 'addPromoCodeView',
    data(){
        return{
            NewPromoCode:{
                code:'',
                dateOfValidity:'',
                quantity:'',
                discount:'',
            },
            isDisabled:false,
            promoCodes:[]
        }
    },
    components:{
        InputBase,
        PromoCodeService,
        VueBasicAlert
    },
    methods:{
        getAll(){
        PromoCodeService.getPromoCodes().then((response) => {
          this.promoCodes = response.data
        });
      },
      checkCode(){
        if (this.promoCodes.some(code=> code.code.toLowerCase() === this.NewPromoCode.code.toLowerCase()))
        {
          this.error = "Wrong code.Please choose another code!";
          alert(this.error);
          this.isDisabled = true
        }
        else{
          this.isDisabled = false
        }
      },
      addCode(){
        let today = new Date();
        if(moment(this.NewPromoCode.dateOfValidity).isBefore(today)){
            this.$refs.alert 
                .showAlert('error','Plese fulfill date of validaty correctly ','warning')
        }
        else if(this.NewPromoCode.quantity<1){
             this.$refs.alert 
                .showAlert('error','Plese fulfill promo code quantity correctly ','warning')
        }
        else if(this.NewPromoCode.discount<1 || this.NewPromoCode.discount>99){
             this.$refs.alert 
                .showAlert('error','Plese fulfill promo code discount correctly ','warning')
        }
        else{
            PromoCodeService.postPromoCode(this.NewPromoCode).
            then((res)=>
                {
                    // console.log(res);
                    this.$refs.alert 
                        .showAlert('success','Yuu have successfully added new promo code','congratulations!')
                })

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
        font-size: 20px;
    }
    .selectMy {
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
        border-radius: 15px;
        font-size: 20px;
        margin-top: 50px;
        padding: 20px;
    }
    input,select {
  display: block;
  padding: 10px 6px;
  width: 100%;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid #ddd;
  color: #555;
  font-size: 20px;
}
</style>