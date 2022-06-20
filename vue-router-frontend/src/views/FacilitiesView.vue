<template>
<div>
    <Header title = "Facilities" ></Header>
    <Facilities :facilities="facilities"></Facilities>  
</div>
    
</template>

<script>
import FacilitieService from '../FrontedServices/FacilitieServices'
import Facilities from '../components/Facilities.vue'
import Header from '../components/Header.vue'
export default {
    name: 'FacilitiesView',
    components: {
    Facilities,
    Header
    },
    data() {
        return{
          facilities: [],
          shower : false,
          searchQuery: null
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
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
.myform{
  padding-bottom: 30px;
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
  background: #2691d9;
  color: white;
  border: none;
  margin: 5px;
  border-radius: 5px;
  cursor: pointer;
  text-decoration: none;
  font-size: 15px;
  font-family: inherit;
}
#search{
  padding: 15px 20px;
  margin-left: 10px;
  border-radius: 5px;
  height: 30px;
  width: 250px;
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