<template>
  <div class = "container">
    <Header title = "Facilities" hidden="hidden"></Header>
    <Facilities :facilities="facilities" v-if="shower"></Facilities>
    <Customer hidden="hidden"/>
    <LoginForm></LoginForm>
  </div>
</template>

<script>
import FacilitieService from './FrontedServices/FacilitieServices'
import Customer from './components/Customer.vue'
import Header from './components/Header.vue'
import Facilities from './components/Facilities.vue'
import LoginForm from './components/SignupForm.vue'

export default{
  name: 'App',
  components: {
    Customer,
    Header,
    Facilities,
    LoginForm
  },
  data() {
    return{
      facilities: [],
      shower : false
    }
  },
  methods:{
    getFacilities(){
      FacilitieService.getFacilities().then((response) => {
        this.facilities = response.data
        });
     }
  },
  created(){
    this.getFacilities()
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400&display=swap');
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
body {
  font-family: 'Poppins', sans-serif;
}
.container {
  max-width: 1280px;
  margin: 30px auto;
  overflow: auto;
  min-height: 720px;
  border: 1px solid steelblue;
  padding: 30px;
  border-radius: 5px;
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
</style>
