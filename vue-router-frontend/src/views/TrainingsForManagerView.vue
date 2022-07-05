<template>
  <div class="container-fluid">
<TrainingsForManager :logedInUser="logedInUser"></TrainingsForManager>
  </div>

</template>

<script>
import TrainingsForManager from "@/components/TrainingsForManager";
export default {
  name: "TrainingsForManagerView",
  props:['logedInUser'],
  components:{TrainingsForManager},

}
</script>

<style scoped>

</style>