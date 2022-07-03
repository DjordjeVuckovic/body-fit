<template>
<createTraining :logedInUser="logedInUser"></createTraining>
</template>
<script>
import createTraining from "@/components/createTraining";
export default {
  name: "AddTrainingView",
  props:{
    logedInUser:Object
  },
  components:{createTraining}

}
</script>

<style scoped>
</style>