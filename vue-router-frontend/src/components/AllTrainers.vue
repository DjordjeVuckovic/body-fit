<template>
  <label >Trainers:</label>
  <select  id="selectNew"   @change="trainerStuffLoad" v-model="selectedTrainer" class="selectAcc form-select form-select-lg mb-3" aria-label=".form-select-lg example">
    <option v-for="trainer in trainers" v-bind:value="trainer">
     {{ trainer.name}} {{trainer.surname}} |<br> username: {{trainer.username}}
    </option>
  </select>
</template>

<script>
import TrainerService from "@/FrontedServices/TrainerService";

export default {
  name: "AllTrainers",
  data(){
    return{
      trainers:[],
      isAny:true
    }
  },
  props :{
    selectedTrainer:Object
  },
  methods: {
    getTrainers() {
      TrainerService.getTrainers().then((response) => {
        this.trainers = response.data
      });
    },
    trainerStuffLoad() {
      this.$emit('selectedTrainer', this.selectedTrainer)
    }
  },
  created() {
    this.getTrainers()
  },
  emits:['selectedTrainer']
}
</script>

<style scoped>
.selectAcc {
  width: 100%;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.6em;
  letter-spacing: 2px;
  font-weight: bolder;
  font-size: 25px;
}
label {
  color: #aaa;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.6em;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-weight: bolder;
  font-size: 20px;
}

</style>