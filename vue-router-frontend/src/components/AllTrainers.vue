<template>
  <label >Available Managers:</label>
  <select  id="selectNew"   @change="customStuffLoad" v-model="selectedManager" class="selectAcc form-select form-select-lg mb-3" aria-label=".form-select-lg example">
    <option v-for="manager in managers" v-bind:value="manager">
      {{ manager.name}} {{manager.surname}}
    </option>
  </select>
</template>

<script>
export default {
  name: "AllTrainers"
}
</script>

<style scoped>

</style>