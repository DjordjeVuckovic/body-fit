<template>
  <div class="home">
    <img alt="Gym" src="@/assets/gym.png" >
    <HelloWorld msg="Welcome to back user"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  }
}
</script>
<style>

</style>
