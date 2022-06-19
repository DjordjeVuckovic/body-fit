<template>
    <label for="search">Search for facilities:</label>
    <input id="search" type="search" placeholder="Search..." autofocus required v-model="searchQuery"/>
    <label for="sort">Sort :</label>
    <div v-for="facilitie in resultQuery()" v-bind:key="facilitie.sportFacilityId">
      <Facilitie :facilitie="facilitie"></Facilitie>
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
          sortedbyASC: false
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
          sortList(sortBy) {
            if (this.sortedbyASC) {
              this.facilities.sort((x, y) => (x[sortBy] > y[sortBy] ? -1 : 1));
              this.sortedbyASC = false;
            } else {
              this.facilities.sort((x, y) => (x[sortBy] < y[sortBy] ? -1 : 1));
              this.sortedbyASC = true;
            }
        }
        }
    }
</script>