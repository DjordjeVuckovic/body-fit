<template>
  <div style="padding-top: 50px" class="container-fluid">
    <h1 class="headMy">All customers</h1>
    <div  class="py-5 mx-5">
      <div class="row row-cols-2 g-3">
        <div  v-for="tr in customers" v-bind:key="tr.username" class="container" style="padding-top: 20px">
          <div class="col">
            <User :user = "tr" ></User>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TrainingService from "@/FrontedServices/TrainingService";
import CustomerServices from "@/FrontedServices/CustomerServices";
import User from "@/components/User";
import Header from "@/components/Header";

export default {
  name: "AllCustomersManagerView",
  data(){
    return{
      customers:[]
    }
  },
  components: {User,Header},
  props:['logedInUser'],
  created() {
    CustomerServices.getCustomersForManager(this.logedInUser.sportFacilityId).then
    ((res)=> {
      this.customers = res.data;
    })
  }
}
</script>

<style scoped>
.headMy{
  text-align: center;
  vertical-align: center;
  padding-top: 0.5em;
  padding-left: 0.5em;
  font-size: 7em;
  color: #2691d9;
}
</style>