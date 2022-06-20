<template>
  <div id="nav">
    <router-link to="/HomeView">Home</router-link>
    <router-link to="/about">About</router-link>
    <router-link to="/facilities">Facilities</router-link>
    <router-link v-if="isAdmin"  to="/add-facilities">Add facilitie</router-link>
    <span class="login">
    <router-link v-if="!logedInUser" to="/">Login</router-link>
    <router-link v-if="!logedInUser" to="/registration">Signup</router-link>
    <router-link v-if="logedInUser" @click="signOut()" to="/">Sign out</router-link>
    
    
    </span>
</div>
</template>

<script>
export default {
    name: 'NavigationBar',
    props:['logedInUser', 'isAdmin'],
    methods:{
      signOut(){
        this.$emit('sign-out')
      }
    }
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

.login{
  padding-left: 1000px;
}.sign{
   text-align: center;
 }
.welcome{
    text-align: left;
    position: inherit;
    position:absolute;
}
</style>