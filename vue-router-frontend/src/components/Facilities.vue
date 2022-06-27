<template>
  <NavBarFacilites :checked="checked" :filter-me="filterMe" :search-query="searchQuery" :selected="selected"
                :sort-list="sortList()"/>
<section class="p-5 ">
  <div   v-for="facilitie in resultQuery()" v-bind:key="facilitie.sportFacilityId">
      <Facilitie v-if="filterByType(facilitie)"  :facilitie="facilitie"></Facilitie>
  </div>

</section>

    
    
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

</style>