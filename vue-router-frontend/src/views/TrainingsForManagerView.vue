<template>
<TrainingsForManager :logedInUser="logedInUser"></TrainingsForManager>
</template>

<script>
import TrainingsForManager from "@/components/TrainingsForManager";
export default {
  name: "TrainingsForManagerView",
  props:{
    logedInUser:Object
  },
  components:{TrainingsForManager}
}
</script>

<style scoped>

</style>