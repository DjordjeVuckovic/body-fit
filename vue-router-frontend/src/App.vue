<template>
  <div id="app">

      <NavigationBar  @sign-out="signOut" :logedInUser="logedInUser" :isAdmin="isAdmin" :isTrainer="isTrainer" :isManager="isManager"  :isCustomer ="isCustomer"></NavigationBar>
      <router-view style="padding-top:120px ;" @selectFacilitie="SelectFacilitie" @rateFacility="rateFacility"  @account="account" @loggedIn="logggUser" :logedInUser="logedInUser" :selectedFacilitie="selectedFacilitie"
      :isAdmin="isAdmin" :isManager="isManager" :isCustomer ="isCustomer" :isTrainer="isTrainer"/>
      <vue-basic-alert :duration="200" :closeIn="7000" ref="alert"></vue-basic-alert>
      <vue-basic-alert :duration="200" :closeIn="5000" ref="alert2"></vue-basic-alert>
  </div>
<!--  <MyFooter/>-->
</template>

<script>
import NavigationBar from './components/NavigationBar.vue'
import axios from "axios";
import MyFooter from "@/MyFooter";
import moment from "moment"
import VueBasicAlert from 'vue-basic-alert'

export default{
  name:'App',
  methods:{
    logggUser(user){
      axios.get("http://localhost:8080/BodyFit/rest/login/loggedUser")
            .then((response) => {
              console.log(response.data)
              this.logedInUser = response.data
              console.log(this.logedInUser.userRole)
              if (this.logedInUser.userRole == "CUSTOMER"){
                this.isCustomer = true
                this.findMembership()
              }
              if (this.logedInUser.userRole === "ADMIN"){
                this.isAdmin = true
              }
              if(this.logedInUser.userRole==="MANAGER" && this.logedInUser.sportFacilityId !== ""){
                this.isManager = true
              }
              if(this.logedInUser.userRole==="COACH" && this.logedInUser.sportFacilityId !== ""){
                this.isTrainer = true
              }
              this.$router.push({name : 'Facilities'})
             })
            .catch((error) => console.log(error))
    },
    findMembership(){
      axios.post("http://localhost:8080/BodyFit/rest/memberships/getByCustomer",this.logedInUser.username)
            .then((response) => {
              console.log(response.data)
                this.membership =response.data
                
                this.calculateMembership()
             })
            .catch((error) => console.log(error))
    },
    calculateMembership(){
      var today = new Date();
      if(moment(this.membership.dateAndTimeOfValidity).isBefore(today)){
        console.log("uso if")
        this.membership.isActive= false
        this.logedInUser.colletedPoints = ((this.membership.price/1000)*(this.membership.startSesions-this.membership.numberOfSession))
        if((this.membership.startSesions-this.membership.numberOfSession)<this.membership.startSesions/3){
          this.logedInUser.colletedPoints =  this.logedInUser.colletedPoints -((this.membership.price/1000)*133*4)
        }
        this.scalePoints()
        var customerDto={
          username: this.logedInUser.username,
          colletedPoints: this.logedInUser.colletedPoints,
          userType:this.userTypeName,
          dicount:this.userDisc
          }
        console.log(customerDto)
        axios.put("http://localhost:8080/BodyFit/rest/customers/editCustomerPoints",customerDto)
          .then((response) => {
            
            console.log(response.data)
                 this.$refs.alert 
                        .showAlert('info','Your membership has expired. your new user type is '+ this.userTypeName,'congratulations!')

                
          })
          .catch((error) => console.log(error))
        console.log(this.membership)
        var mem ={
          id: this.membership.id,
          type:this.membership.type,
          paymentDate: this.membership.paymentDate,
          dateAndTimeOfValidity: this.membership.dateAndTimeOfValidity,
          price: this.membership.price,
          customerId:this.membership.customerId,
          active: this.membership.active,
          numberOfSession:this.membership.numberOfSessionid,
          startSesions: this.membership.startSesions
        }
          console.log(mem)
          axios.put("http://localhost:8080/BodyFit/rest/memberships/expired",mem)
          .then((response) => {
            
            console.log(response.data)
                 
          })
          .catch((error) => console.log(error))
        }
        
      
    },
    scalePoints(){
      if(this.logedInUser.colletedPoints < 10){
        this.userTypeName = 'BRONZE'
      }
      else if (this.logedInUser.colletedPoints >= 10 && this.logedInUser.colletedPoints > 20){
        this.userTypeName = 'SILVER'
        this.userDisc = 5
      }
      else if (this.logedInUser.colletedPoints >= 20 && this.logedInUser.colletedPoints > 30){
        this.userTypeName = 'GOLD'
        this.userDisc = 10
      }
      else if (this.logedInUser.colletedPoints >= 30 ){
        this.userTypeName = 'DIMOND'
        this.userDisc = 20
      }
    },
    signOut(){
      this.logedInUser = null
      this.isAdmin = false
      this.isManager = false
      this.isCustomer = false
      this.isTrainer = false
    },
    account(){
      this.$router.push({name : 'AccountView'})
    },
    SelectFacilitie(facilitie){
      this.selectedFacilitie = facilitie
      console.log(this.selectedFacilitie)
      this.$router.push({name : 'facilityView'})
      
    },
    rateFacility(sportFacilityName){

      console.log(sportFacilityName)
      axios.get("http://localhost:8080/BodyFit/rest/facilities/")
       .then((response) => { 
        console.log(response.data)
           for (var facilitiy of response.data){
            
              if(facilitiy.name == sportFacilityName){
                
                this.selectedFacilitie = facilitiy
                console.log(this.selectedFacilitie)
              }
           }
        })
       

      this.$router.push({name : 'CommentView'})
    }
  },
  data(){
    return{
      logedInUser: null,
      isAdmin: null,
      selectedFacilitie: null,
      isManager: false,
      isCustomer: false,
      isTrainer:false,
      membership: null,
      userTypeName: '',
      userDisc: ''
    }
  },
  components:{
    MyFooter,
    NavigationBar,
    VueBasicAlert
  }
 
}
</script>


<style>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
#app{
  font-family: 'Roboto', Tahoma, Geneva, Verdana, sans-serif, 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif, 'Arial Narrow', Arial, sans-serif, Courier, monospace;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: black;
}
#login{
  padding-left: 1600px;
}
body {
  font-family: 'Roboto', sans-serif;
}

.user{
  padding-left: 1300px;
}
.btn {
  display: inline-block;
  background: #000;
  color: #fff;
  border: none;
  padding: 10px 20px;
  margin: 5px;
  border-radius: 5px;
  cursor: pointer;
  text-decoration: none;
  font-size: 15px;
  font-family: inherit;
}
.btn:focus {
  outline: none;
}
.btn:active {
  transform: scale(0.98);
}
.btn-block {
  display: block;
  width: 100%;
}
#mynav{
  text-align: left;
  padding: 20px;
}

.drop{
  text-align: left;
  padding-right: 20px;
}
.drop a{
  font-weight: bold;
  font-size:22px;
  color:white;
  text-decoration: none;
  border-radius: 4px;
}
#drop a.router-link-exact-active{
  color:white;
  background: #2691d9;
}
#mynav a{
  font-weight: bold;
  font-size:22px;
  color:white;
  text-decoration: none;
  border-radius: 4px;
  padding: 20px;

}
#mynav a.router-link-exact-active{
  color:#2691d9;
  background: white;
}
.textual{
  font-size: 20px;
  padding-bottom:10px;
}

.checkbox{
  width: 20px;
  height: 20px;
  
}

</style>
