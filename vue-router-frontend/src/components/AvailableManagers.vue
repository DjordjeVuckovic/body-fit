<template>
  <label >Available Managers:</label>
  <select  id="selectNew"  @change="customStuffLoad" class="selectAcc form-select form-select-lg mb-3" aria-label=".form-select-lg example">
    <option v-for="manager in managers" v-bind:value="manager.username">
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
      managers:[]
    }
  },
  methods:{
    getManagers(){
      ManagerService.getAvailableManagers().then((response) => {
        this.managers = response.data
      });
    },
    customStuffLoad(){
      console.log('1')
    }
  },
  created() {
    this.getManagers()
  }
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