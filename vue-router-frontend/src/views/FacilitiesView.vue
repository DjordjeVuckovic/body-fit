<template>
<div>
    <Facilities :facilities="facilities" @selectFacilitie="Selectfacilitie"></Facilities>
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
        },
        Selectfacilitie(facilitie){
            this.$emit('selectFacilitie',facilitie)
        }
    },
    created(facilitie){
    this.getFacilities('selectFacilitie',this.facilitie)
    },
    emits:['selectFacilitie']
}
</script>

<style>
</style>