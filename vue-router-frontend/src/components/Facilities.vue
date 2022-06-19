<template>

    <div v-for="facilitie in facilities" v-bind:key="facilitie.sportFacilityId">
        <Facilitie :facilitie="facilitie"></Facilitie>
    </div>
</template>

<script>
import Facilitie from './Facilitie.vue'
    export default{
        name: 'Facilities-multi',
        props: {
            facilities: Array
        },
        components:{
            Facilitie
        }
    }
</script>
