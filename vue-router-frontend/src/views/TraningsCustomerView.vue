<template>
<!--  <div style="padding-top: 7em">-->
<!--  <nav class="navbar navbar-dark bg-dark p-5 text-light">-->
<!--    <div class="container-fluid mx-5">-->
<!--      <div class="mx-2" >-->
<!--        <div class="textual"><label for="search">Search for trainings:</label></div>-->
<!--        <div class="textual">-->
<!--          <input class="form-control me-2" type="search" v-model="searchQuery" @change="filterList()" @emptied="filterList() " placeholder="Search" aria-label="Search..." autofocus required /></div>-->
<!--      </div>-->
<!--      <div >-->
<!--        <div class="textual">-->
<!--          <label  id="sort" for="sort">Sort users:</label>-->
<!--        </div>-->
<!--        <div class="textual">-->
<!--          <select id="sort" @change="sortList()" v-model="selected" name="sort" class="form-select" aria-label="Default select example" style="{width: 200px;}" >-->
<!--            <option value="Default">Default sort</option>-->
<!--            <option value="NameASC">Name, ASC</option>-->
<!--            <option value="NameDES">Name, DES</option>-->
<!--            <option value="SurnameASC">Surname, ASC</option>-->
<!--            <option value="SurnameDES">Surname, DES</option>-->
<!--            <option value="UsernameASC">Username, ASC</option>-->
<!--            <option value="UsernameDES">Username, DES</option>-->
<!--            <option value="PointsASC">Points, ASC</option>-->
<!--            <option value="PointsDES">Points, DES</option>-->
<!--          </select>-->
<!--        </div>-->

<!--      </div>-->

<!--      <div class="textual">-->
<!--        <div>-->
<!--          <label id="sort" for="sort">Filter users:</label>-->
<!--        </div>-->

<!--        <select id="sort" name="sort" v-model="filterType"  @change="filterList()"  style="{width: 200px;}" class="form-select" aria-label="Default select example">-->
<!--          <option value="ALL">ALL</option>-->
<!--          <option value="ADMIN">ADMIN</option>-->
<!--          <option value="CUSTOMER">CUSTOMER</option>-->
<!--          <option value="MANAGER">MANAGER</option>-->
<!--          <option value="COACH">COACH</option>-->
<!--        </select>-->
<!--      </div>-->
<!--    </div>-->
<!--  </nav>-->
<!--  </div>-->
  <div class="container-fluid px-5">
    <div class="row">
      <h1 class="headMy">Upcoming trainings</h1>
      <div class="row row-cols-2 g-3">
        <div  v-for="tr in trainings" v-bind:key="tr.id" class="container" style="padding-top: 20px">
          <div class="col">
            <ScheduleTraningCustomer :ScheduleTraining = "tr"></ScheduleTraningCustomer>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <h1 class="headMy">Passed trainings</h1>
      <div class="row row-cols-2 g-3">
        <div  v-for="tr in trainingsPassed" v-bind:key="tr.id" class="container" style="padding-top: 20px">
          <div class="col">
            <ScheduleTraningCustomer @rateFacility="ratefacility" :selectedFacilitie="selectedFacilitie" :passed="true" :ScheduleTraining = "tr"></ScheduleTraningCustomer>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ScheduleTraningService from "@/FrontedServices/ScheduleTraningService";
import ScheduleTraningCustomer from "@/components/ScheduleTraningCustomer";

export default {
  name: "TraningsCustomerView",
  props:{
    logedInUser:Object,
    selectedFacilitie: Object
  },
  components:{
    ScheduleTraningCustomer
  },
  data(){
    return{
      trainings:[],
      trainingsPassed:[],
      searchQuery: '',
      selected: 'Default',
      filterType: 'ALL',
    }
  },
  created() {
    this.getAllUp()
    this.getAllPassed()
  },
  methods:{
    getAllUp(){
      ScheduleTraningService.AllUpcomingCustomer(this.logedInUser.username).then(
          (res)=>{
            console.log(res.data)
            this.trainings = res.data
          }
      )
    },
    getAllPassed(){
      ScheduleTraningService.AllPassedCustomer(this.logedInUser.username).then(
          (res)=>{
            this.trainingsPassed = res.data
          }

      )
    },
    ratefacility(sportFacilityName){
      this.$emit('rateFacility',sportFacilityName)
    },
    resultQuery(){
      if(this.searchQuery){
        this.trainings = this.trainings.filter((item)=>{
          return this.searchQuery.toLowerCase().split(' ').every(v => item.name.toLowerCase().includes(v))
              || this.searchQuery.toLowerCase().split(' ').every(v => item.surname.toLowerCase().includes(v))
              || this.searchQuery.toLowerCase().split(' ').every(v => item.username.toLowerCase().includes(v))
        })
        this.sortList();
      }else
      {
        this.filterUsers = this.users
      }
    }

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