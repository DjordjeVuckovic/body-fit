<template>
  <div class="container-fluid" style="margin-top: 150px">
  <div class="home">
    <img class="picture" alt="Gym" src="@/assets/gym.png" >
    <h1 v-if="logedInUser">Welcome back {{logedInUser.name}} {{logedInUser.surname}}</h1>
    <p v-if="logedInUser">
      Train and stay helty!
    </p>
  </div>
    </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  },
  props:['logedInUser'],
}
</script>
<style>
h1{
  text-align: center;
  margin: 40px 0 0;
}
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
p{
  text-align: center;
  color: #2691d9;
  font-size: 20px;
}
.picture{
  margin-left: 345px;
}

</style>
