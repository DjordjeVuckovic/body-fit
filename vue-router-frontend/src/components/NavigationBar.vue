<template>
  <div id="nav">
    <router-link to="/HomeView">Home</router-link>
    <router-link to="/about">About</router-link>
    <router-link to="/facilities">Facilities</router-link>
    <span id="login">
      <router-link v-if="!logedInUser" to="/">Login</router-link>
    </span>
    <h1 class="welcome" v-if="logedInUser" >welcome {{logedInUser.name}} {{logedInUser.surname}}</h1>

    

</div>
</template>

<script>
export default {
    name: 'NavigationBar',
    props:['logedInUser'],
}
</script>

<style>
    #nav{
  padding: 40px;
  text-align: left;
}
#nav a{
  font-weight: bold;
  font-size:30px;
  color: black;
  text-decoration: none;
  padding: 15px;
  border-radius: 4px;

}
#nav a.router-link-exact-active{
  color:white;
  background: #2691d9;
}
#login{
  padding-left: 1300px;
}
.welcome{
    text-align: left;
    position: inherit;
    padding-left: 1800px;
    position:absolute;
}
</style>