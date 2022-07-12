<template>
  <nav class="navbar navbar-dark bg-dark p-5 text-light" style="margin-top: 110px">
    <div class="container-fluid mx-5">
      <div class="col-1 textual">
        <div class="textual"><label for="search">Start date:</label></div>
        <div class="textual dates">
          <input class="form-control me-2" type="date" v-model="startDate" autofocus required /></div>
      </div>
      <div class="col-1 textual">
        <div class="textual"><label for="search">Finish date:</label></div>
        <div class="textual dates">
          <input class="form-control me-2" type="date" v-model="finishDate" autofocus required /></div>
      </div>
        <div class="col-1 textual">
          <div class="textual"><label for="search">First price:</label></div>
          <div class="textual dates">
            <input class="form-control me-2" type="number" v-model="price1" autofocus required /></div>
        </div>
        <div class="col-1 textual">
          <div class="textual"><label for="search">Second price:</label></div>
          <div class="textual dates">
            <input class="form-control me-2" type="number" v-model="price2" autofocus required /></div>
        </div>
      <div class="col-1 textual">
        <div class="textual">
          <label for="search">Sort trainings:</label>
        </div>
        <div class="textual">
          <select id="sort" name="sort" class="form-select" aria-label="Default select example" v-model="selected" style="{width: 200px;}" @change="sortList()">
            <option value="Default">Default sort</option>
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
      <div class="mx-2 textual">
        <div>
          <label> Without price:</label>
        </div>
        <div class="text-center" >
          <input  type="checkbox" class="combo checkbox" id="flexCheckChecked" v-model="checked">
        </div>
      </div>
    </div>
  </nav>
  <div class="container-fluid">
    <div class="row">
      <h1 class="headMy">All trainings</h1>
      <div class="row row-cols-3 g-3">
        <div  v-for="tr in resultQueryUp(this.trainings)" v-bind:key="tr.id" class="container" style="padding-top: 20px">
          <div class="col">
            <SchedulePassedManager :ScheduleTraining = "tr" v-if="CheckMe(tr)"></SchedulePassedManager>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SchedulePassedManager from "@/components/SchedulePassedManager";
import UpcomingTrainingManager from "@/components/UpcomingTrainingManager";
import ScheduleTraningCustomer from "@/components/ScheduleTraningCustomer";
import ScheduleTraningService from "@/FrontedServices/ScheduleTraningService";
import moment from "moment";
export default {
  name: "FacilityScheduleTraningsView",
  components: {ScheduleTraningCustomer, SchedulePassedManager},
  props:{
    logedInUser:Object
  },
  data(){
    return{
      trainings:[],
      selected: 'Default',
      filterType: 'ALL',
      filterUp:[],
      startDate:'',
      finishDate:'',
      checked:false,
      price1:0,
      price2:0,
    }
  },
  created() {
    this.getAll()
  },
  methods: {
    getAll() {
      ScheduleTraningService.AllByFacility(this.logedInUser.sportFacilityId).then(
          (res) => {
            this.trainings = res.data
            this.sortList()
          }
      )
    },
    filterList() {
      this.resultQueryUp(this.trainings)
    },
    CheckMe(tr) {
      if (this.checked) {
        return tr.traning.additionalPrice === 0
      }
      else {
        return true
      }
    },
    resultQueryUp(trainings) {
      if(this.startDate && this.finishDate && this.filterType === 'ALL'  && this.price2 ===0){
        console.log('0')
        return trainings.filter((item) => {
          const DateS = moment(this.startDate)
          const DateF = moment(this.finishDate)
          const itemDate = moment(item.dateTraining)
          if(itemDate.isAfter(DateS) && itemDate.isBefore(DateF) ){
            return  true
          }
          else{
            return false
          }
        })
      }
      else if(this.startDate && this.finishDate && this.filterType !== 'ALL'&& this.price2 ===0){
        console.log('1')
        return trainings.filter((item) => {
          const DateS = moment(this.startDate)
          const DateF = moment(this.finishDate)
          const itemDate = moment(item.dateTraining)
          if(itemDate.isAfter(DateS) && itemDate.isBefore(DateF)){
            return this.filterType.toLowerCase().split(' ').every(v => item.traning.type.toLowerCase().includes(v))
          }
          else{
            return false
          }
        })
      }
      else if(this.startDate && this.finishDate && this.filterType === 'ALL' && this.price2 !==0){
        console.log('1')
        return trainings.filter((item) => {
          const DateS = moment(this.startDate)
          const DateF = moment(this.finishDate)
          const itemDate = moment(item.dateTraining)
          if(itemDate.isAfter(DateS) && itemDate.isBefore(DateF)){
            if(  this.price1 <= item.traning.additionalPrice && item.traning.additionalPrice <= this.price2)
              return true
          }
          else{
            return false
          }
        })
      }
      else if(this.startDate && this.finishDate && this.filterType !== 'ALL'  && this.price2 !==0){
        console.log('1')
        return trainings.filter((item) => {
          const DateS = moment(this.startDate)
          const DateF = moment(this.finishDate)
          const itemDate = moment(item.dateTraining)
          if(itemDate.isAfter(DateS) && itemDate.isBefore(DateF)){
            if( this.price1 <= item.traning.additionalPrice && item.traning.additionalPrice <= this.price2)
            return (this.filterType.toLowerCase().split(' ').every(v => item.traning.type.toLowerCase().includes(v)))
          }
          else{
            return false
          }
        })
      }
      else if(!this.startDate && !this.finishDate && this.filterType === 'ALL'  && this.price2 !==0){
        console.log('1111')
        return trainings.filter((item) => {
            if( this.price1 <= item.traning.additionalPrice && item.traning.additionalPrice <= this.price2) {
              console.log(item.traning.additionalPrice)
              console.log(this.price1)
              console.log(this.price2)
              return true
            }
          else{
            return false
          }
        })
      }
      else if(!this.startDate && !this.finishDate && this.filterType !== 'ALL'  && this.price2 !==0){
        return trainings.filter((item) => {
            if( this.price1 <= item.traning.additionalPrice && item.traning.additionalPrice <= this.price2)
              return (this.filterType.toLowerCase().split(' ').every(v => item.traning.type.toLowerCase().includes(v)))
          else{
            return false
          }
        })
      }
      else if(!this.startDate && !this.finishDate && this.price2 ===0 && this.filterType !== 'ALL'){
        return  trainings.filter((item) => {
          return (this.filterType.toLowerCase().split(' ').every(v => item.traning.type.toLowerCase().includes(v)))
        })
      }
      else {
        return trainings
      }
    },
    sortList() {
      if(this.selected =='Default'){
        this.trainings.sort((x, y) => (x.traning.additionalPrice < y.traning.additionalPrice ? -1 : 1));
      }
      if (this.selected === 'PriceASC') {
        this.trainings.sort((x, y) => (x.traning.additionalPrice < y.traning.additionalPrice ? -1 : 1));
      }
      if (this.selected === 'PriceDES') {
        this.trainings.sort((x, y) => (x.traning.additionalPrice > y.traning.additionalPrice  ? -1 : 1));
      }
      if (this.selected === 'DateASC') {
        this.trainings.sort((x, y) => (x.dateTraining < y.dateTraining ? -1 : 1));
      }
      if (this.selected === 'DateDES') {
        this.trainings.sort((x, y) => (x.dateTraining > y.dateTraining ? -1 : 1));
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
.pad{

}
</style>