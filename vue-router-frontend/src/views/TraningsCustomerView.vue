<template>
  <div style="padding-top: 8em">
  <nav class="navbar navbar-dark bg-dark p-5 text-light">
    <div class="container-fluid mx-5">
      <div class="mx-2 col-2" >
        <div class="textual"><label for="search">Search for trainings:</label></div>
        <div class="textual">
          <input class="form-control me-2" type="search" v-model="searchQuery" placeholder="Search" aria-label="Search..." autofocus required /></div>
      </div>
      <div class="col-1">
        <div class="textual"><label for="search">Start date:</label></div>
        <div class="textual dates">
          <input class="form-control me-2" type="date" v-model="startDate" autofocus required /></div>
      </div>
      <div class="col-1">
        <div class="textual"><label for="search">Finish date:</label></div>
        <div class="textual dates">
          <input class="form-control me-2" type="date" v-model="finishDate" autofocus required /></div>
      </div>
      <div>
        <div class="textual">
          <label  id="sort" for="sort">Sort facilities:</label>
        </div>
        <div class="textual">
          <select id="sort" name="sort" class="form-select" aria-label="Default select example" v-model="selected" style="{width: 200px;}" @change="sortList()">
            <option value="Default">Default sort</option>
            <option value="NameASC">Facility name, ASC</option>
            <option value="NameDES">Facility name, DES</option>
            <option value="PriceASC">Price, ASC</option>
            <option value="PriceDES">Price, DES</option>
            <option value="DateASC">Date, ASC</option>
            <option value="DateDES">Date, DES</option>
          </select>
        </div>
      </div>
      <div class="textual">
        <div>
          <label id="sort" for="sort">Filter training:</label>
        </div>
        <select id="sort" name="sort" v-model="filterType"  @change="filterList()"  style="{width: 200px;}" class="form-select" aria-label="Default select example">
          <option value="ALL">ALL</option>
          <option value="PERSONAL">PERSONAL</option>
          <option value="GROUP">GROUP</option>
          <option value="GYM">GYM</option>
          <option value="YOGA">YOGA</option>
          <option value="PILATES">PILATES</option>
          <option value="FUNCTIONAL">FUNCTIONAL</option>
          <option value="LESSMILLS">LESSMILLS</option>
        </select>
      </div>
      <div class="textual">
        <div>
          <label id="sort" for="sort">Filter facility:</label>
        </div>
        <select id="sort" name="sort" v-model="filterTypeFacility"  @change="filterList()"  style="{width: 200px;}" class="form-select" aria-label="Default select example">
          <option value="ALL">ALL</option>
          <option value="GYM">GYM</option>
          <option value="POOL">POOL</option>
          <option value="SPORTCENTER">SPORTCENTER</option>
          <option value="DANCINGSTUDIO">DANCINGSTUDIO</option>
          <option value="SHOOTINGRANGE">SHOOTINGRANGE</option>
          <option value="BOWLINGCENTER">BOWLINGCENTER</option>
        </select>
      </div>
    </div>
  </nav>
  </div>
  <div class="container-fluid px-5">
    <div class="row">
      <h1 class="headMy">Upcoming trainings</h1>
      <div class="row row-cols-2 g-3">
        <div  v-for="tr in resultQueryUp(this.trainings)" v-bind:key="tr.id" class="container" style="padding-top: 20px">
          <div class="col">
            <ScheduleTraningCustomer :ScheduleTraining = "tr"></ScheduleTraningCustomer>
          </div>
        </div>
      </div>
    </div>
    <div class="row">
      <h1 class="headMy">Passed trainings</h1>
      <div class="row row-cols-2 g-3">
        <div  v-for="tr in resultQueryUp(this.trainingsPassed)" v-bind:key="tr.id" class="container" style="padding-top: 20px">
          <div class="col">
            <ScheduleTraningCustomer @rateFacility="ratefacility"  :passed="true" :ScheduleTraining = "tr"></ScheduleTraningCustomer>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ScheduleTraningService from "@/FrontedServices/ScheduleTraningService";
import ScheduleTraningCustomer from "@/components/ScheduleTraningCustomer";
import moment from "moment";
export default {
  name: "TraningsCustomerView",
  props:{
    logedInUser:Object
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
      filterTypeFacility:'ALL',
      filterUp:[],
      startDate:'',
      finishDate:''
    }
  },
  created() {
    this.getAllUp()
    this.getAllPassed()
  },
  methods: {
    getAllUp() {
      ScheduleTraningService.AllUpcomingCustomer(this.logedInUser.username).then(
          (res) => {
            console.log(res.data)
            this.trainings = res.data
          }
      )
    },
    getAllPassed() {
      ScheduleTraningService.AllPassedCustomer(this.logedInUser.username).then(
          (res) => {
            this.trainingsPassed = res.data
          }
      )
    },
    ratefacility(sportFacilityName) {
      this.$emit('rateFacility', sportFacilityName)
    },
    filterList() {
      this.resultQueryUp(this.trainings)
      this.resultQueryUp(this.trainingsPassed)
    },
    resultQueryUp(trainings) {
      if ((this.searchQuery && this.filterType === 'ALL') || (this.searchQuery && this.filterTypeFacility === 'ALL')) {
        return trainings.filter((item) => {
          return this.searchQuery.toLowerCase().split(' ').every(v => item.sportFacility.name.toLowerCase().includes(v))
        })
      }
      else if(this.startDate && this.finishDate && this.filterType === 'ALL' && this.filterTypeFacility === 'ALL'){
        return trainings.filter((item) => {
          const DateS = moment(this.startDate)
          const DateF = moment(this.finishDate)
          const itemDate = moment(item.dateTraining)
          if(itemDate.isAfter(DateS) && itemDate.isBefore(DateF)){
            return true
          }
          else{
            return false
          }
        })
      }
      else if(this.startDate && this.finishDate && this.filterType !== 'ALL' && this.filterTypeFacility === 'ALL' ){
        return trainings.filter((item) => {
          const DateS = moment(this.startDate)
          const DateF = moment(this.finishDate)
          const itemDate = moment(item.dateTraining)
          if(itemDate.isAfter(DateS) && itemDate.isBefore(DateF)){
            return (this.filterType.toLowerCase().split(' ').every(v => item.traning.type.toLowerCase().includes(v)))
          }
          else{
            return false
          }
        })
      }
      else if(this.startDate && this.finishDate && this.filterType === 'ALL' && this.filterTypeFacility !== 'ALL' ){
        return trainings.filter((item) => {
          const DateS = moment(this.startDate)
          const DateF = moment(this.finishDate)
          const itemDate = moment(item.dateTraining)
          if(itemDate.isAfter(DateS) && itemDate.isBefore(DateF)){
            return (this.filterType.toLowerCase().split(' ').every(v => item.sportFacility.type.toLowerCase().includes(v)))
          }
          else{
            return false
          }
        })
      }
      else if(this.startDate && this.finishDate && this.filterType !== 'ALL' && this.filterTypeFacility !== 'ALL' ){
        return trainings.filter((item) => {
          const DateS = moment(this.startDate)
          const DateF = moment(this.finishDate)
          const itemDate = moment(item.dateTraining)
          if(itemDate.isAfter(DateS) && itemDate.isBefore(DateF)){
            return (this.filterType.toLowerCase().split(' ').every(v => item.sportFacility.type.toLowerCase().includes(v)) && this.filterType.toLowerCase().split(' ').every(v => item.sportFacility.type.toLowerCase().includes(v)))
          }
          else{
            return false
          }
        })
      }
      else if (this.filterType !== 'ALL' && this.filterTypeFacility === 'ALL' && this.searchQuery) {
        return  trainings.filter((item) => {
          return (this.filterType.toLowerCase().split(' ').every(v => item.traning.type.toLowerCase().includes(v)) && this.searchQuery.toLowerCase().split(' ').every(v => item.sportFacility.name.toLowerCase().includes(v)))
        })
      }
      else if (this.filterType !== 'ALL' && this.filterTypeFacility === 'ALL' && !this.searchQuery) {
        return  trainings.filter((item) => {
          return this.filterType.toLowerCase().split(' ').every(v => item.traning.type.toLowerCase().includes(v))
        })
      }
      else if (this.filterType !== 'ALL' && this.filterTypeFacility !== 'ALL' && this.searchQuery) {
        return  trainings.filter((item) => {
          return (this.filterType.toLowerCase().split(' ').every(v => item.traning.type.toLowerCase().includes(v) && (this.filterTypeFacility.toLowerCase().split(' ').every(v => item.sportFacility.type.toLowerCase().includes(v)) && this.searchQuery.toLowerCase().split(' ').every(v => item.sportFacility.name.toLowerCase().includes(v)))))
        })
      }
      else if (this.filterType === 'ALL' && this.filterTypeFacility !== 'ALL' && this.searchQuery) {
        return  trainings.filter((item) => {
          return ((this.filterTypeFacility.toLowerCase().split(' ').every(v => item.sportFacility.type.toLowerCase().includes(v) && this.searchQuery.toLowerCase().split(' ').every(v => item.sportFacility.name.toLowerCase().includes(v)))))
        })
      }
      else if (this.filterType === 'ALL' && this.filterTypeFacility !== 'ALL' && !this.searchQuery) {
        return  trainings.filter((item) => {
          return this.filterTypeFacility.toLowerCase().split(' ').every(v => item.sportFacility.type.toLowerCase().includes(v))
        })
      }
      else if (this.filterType !== 'ALL' && this.filterTypeFacility !== 'ALL' && !this.searchQuery) {
        return  trainings.filter((item) => {
          return (this.filterType.toLowerCase().split(' ').every(v => item.traning.type.toLowerCase().includes(v) && this.filterTypeFacility.toLowerCase().split(' ').every(v => item.sportFacility.type.toLowerCase().includes(v))))
        })
      }
      else {
        return trainings
      }
    },
    sortList() {
      console.log(this.selected)
      if (this.selected === 'NameASC') {
        this.trainings.sort((x, y) => (x.sportFacility.name < y.sportFacility.name ? -1 : 1));
        this.trainingsPassed.sort((x, y) => (x.sportFacility.name < y.sportFacility.name ? -1 : 1));
      }
      if (this.selected === 'NameDES') {
        this.trainings.sort((x, y) => (x.sportFacility.name > y.sportFacility.name ? -1 : 1));
        this.trainingsPassed.sort((x, y) => (x.sportFacility.name > y.sportFacility.name ? -1 : 1));
      }
      if (this.selected === 'PriceASC') {
        this.trainings.sort((x, y) => (x.traning.additionalPrice < y.traning.additionalPrice ? -1 : 1));
        this.trainingsPassed.sort((x, y) => (x.traning.additionalPrice < y.traning.additionalPrice ? -1 : 1));
      }
      if (this.selected === 'PriceDES') {
        this.trainings.sort((x, y) => (x.traning.additionalPrice > y.traning.additionalPrice  ? -1 : 1));
        this.trainingsPassed.sort((x, y) => (x.traning.additionalPrice > y.traning.additionalPrice  ? -1 : 1));
      }
      if (this.selected === 'DateASC') {
        this.trainings.sort((x, y) => (x.dateTraining < y.dateTraining ? -1 : 1));
        this.trainingsPassed.sort((x, y) => (x.dateTraining < y.dateTraining ? -1 : 1));
      }
      if (this.selected === 'DateDES') {
        this.trainings.sort((x, y) => (x.dateTraining > y.dateTraining ? -1 : 1));
        this.trainingsPassed.sort((x, y) => (x.dateTraining > y.dateTraining ? -1 : 1));
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
.dates{
  width: 150px;
}
</style>