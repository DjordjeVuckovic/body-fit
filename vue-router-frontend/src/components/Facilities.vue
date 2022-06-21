<template>
    <label for="search">Search for facilities:</label>
    <input id="search" type="search" placeholder="Search..." autofocus required v-model="searchQuery"/>
    <label id="sort" for="sort">Sort facilities:</label>
    <select id="sort" name="sort" v-model="selected" style="width: 200px;" @change="sortList()">
    <option value="Default">Default sort</option>
    <option value="NameASC">Name, ASC</option>
    <option value="NameDES">Name, DES</option>
    <option value="LocationASC">Location, ASC</option>
    <option value="LocationDES">Location, DES</option>
    <option value="GradeASC">Grade, ASC</option>
    <option value="GradeDES">Grade, DES</option>
  </select>
  <label id="sort" for="sort">Filter facilities:</label>
  <select id="sort" name="sort" v-model="filterMe" style="width: 200px;">
    <option value="ALL">ALL</option>
    <option value="GYM">GYM</option>
    <option value="POOL">POOL</option>
    <option value="SHOOTINGRANGE">SHOOTINGRANGE</option>
  </select>
  <label> Only working:</label>
  <input type="checkbox" class="combo" v-model="checked">
    <div v-for="facilitie in resultQuery()" v-bind:key="facilitie.sportFacilityId">
      <Facilitie v-if="filterByType(facilitie)"  :facilitie="facilitie"></Facilitie>
    </div>
</template>

<script>
import Facilitie from './Facilitie.vue'
import FacilitieService from "@/FrontedServices/FacilitieServices";
    export default{
        name: 'Facilities-multi',
        props: {
            facilities: Array
        },
        components:{
            Facilitie
        },
        data() {
        return{
          searchQuery: '',
          selected:'Default',
          filterMe:'ALL',
          checked:false
        }
      },
        methods: {
          resultQuery(){
            if(this.searchQuery){
              return this.facilities.filter((item)=>{
                return this.searchQuery.toLowerCase().split(' ').every(v => item.name.toLowerCase().includes(v)) || this.searchQuery.toLowerCase().split(' ').every(v => item.type.toLowerCase().includes(v))
                    || this.searchQuery.toLowerCase().split(' ').every(v => item.address.toLowerCase().includes(v))
                    || this.searchQuery.toLowerCase().split(' ').every(v => item.rating.toLowerCase().includes(v))
                    || this.searchQuery.toLowerCase().split(' ').every(v => item.city.toLowerCase().includes(v))
              })
            }else{
              return this.facilities;
            }
          },
          sortList() {
            console.log(this.selected)
            if (this.selected == 'NameASC') {
              this.facilities.sort((x, y) => (x.name < y.name ? -1 : 1));
            }
            if(this.selected == 'NameDES') {
              this.facilities.sort((x, y) => (x.name > y.name ? -1 : 1));
            }
            if(this.selected == 'LocationASC') {
              this.facilities.sort((x, y) => (x.address < y.address ? -1 : 1));
            }
            if(this.selected == 'LocationDES') {
              this.facilities.sort((x, y) => (x.address > y.address ? -1 : 1));
            }
            if(this.selected == 'GradeASC') {
              this.facilities.sort((x, y) => (x.rating < y.rating ? -1 : 1));
            }
            if(this.selected == 'GradeDES') {
              this.facilities.sort((x, y) => (x.rating > y.rating ? -1 : 1));
            }
        },
          filterByType(facility){
            let ret = false
            if(facility.type === undefined ||  this.filterMe===undefined) {return}
            if(this.filterMe === facility.type || this.filterMe === 'ALL') {
              ret = true
            }
            if(this.checked && facility.status === 'Closed'){
              ret = false
            }
            return ret
          }

        }
    }
</script>
<style>
#sort{
  margin-left: 10px;
  border-radius: 5px;
  height: 30px;
  width: 350px;
}
.combo{
  margin-left: 5px;
  border-radius: 5px;
}
</style>