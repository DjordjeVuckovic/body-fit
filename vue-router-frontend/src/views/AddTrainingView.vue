<template>
<CreateTraining :logedInUser="logedInUser"></CreateTraining>
</template>
<script>
import CreateTraining from "@/components/CreateTraining";
export default {
  name: "AddTrainingView",
  props:{
    logedInUser:Object
  },
  components:{CreateTraining}

}
</script>

<style scoped>
</style>