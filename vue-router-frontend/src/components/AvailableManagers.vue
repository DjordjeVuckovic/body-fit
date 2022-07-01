<template>
  <label >Available Managers:</label>
  <select  id="selectNew"   @change="customStuffLoad" v-model="selectedManager" class="selectAcc form-select form-select-lg mb-3" aria-label=".form-select-lg example">
    <option v-for="manager in managers" v-bind:value="manager">
    {{ manager.name}} {{manager.surname}}
    </option>
  </select>
</template>

<script>
import ManagerService from "@/FrontedServices/ManagerService";
export default {
  name: "AvailableManagers",
  data(){
    return{
      managers:[],
      selectedManager:null,
      isAny:true
    }
  },
  methods:{
    getManagers(){
      ManagerService.getAvailableManagers().then((response) => {
        this.managers = response.data
        if(this.managers.length===0){
          this.isAny = false
        }
        this.$emit('isAny',this.isAny)
      });
    },
    customStuffLoad(){
      this.$emit('selectedMng',this.selectedManager)
    }
  },
  created() {
    this.getManagers()
  },
  emits:['selectedMng','isAny']
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