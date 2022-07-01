<template>
  <div>
    <Facilitie :facilitie="selectedFacilitie"></Facilitie>
  </div>
</template>

<script>
import Facilitie from '../components/Facilitie.vue'
export default {
    name: 'SelectedFacilitieView',
    props:['selectedFacilitie'],
    components:{
            Facilitie
        },
}
</script>

<style>

</style>