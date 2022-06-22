<template>
<!--  <div id="nav">
    <router-link to="/HomeView">Home</router-link>
    <router-link to="/about">About</router-link>
    <router-link to="/facilities">Facilities</router-link>

    <router-link v-if="isAdmin"  to='/addFacilitie'>Add facilitie</router-link>
    <router-link v-if="isAdmin"  to="/newManger">Add trainer</router-link>

    <span class="login">
    <router-link v-if="!logedInUser" to="/">Login</router-link>
    <router-link v-if="!logedInUser" to="/registration">Signup</router-link>
    <router-link v-if="logedInUser" @click="signOut()" to="/">Sign out</router-link>
    </span>
</div>-->
  <nav class="navbar navbar-dark bg-primary navbar-expand-lg nav fixed-top">
    <div class="container-fluid">
      <img src="@/assets/fitness.png" height="60" width="70">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-collapse me-auto mb-0 mb-lg-0">
          <li class="nav-item" id="mynav">
            <router-link class="nav-link active" aria-current="page" to="/HomeView" >Home</router-link>
          </li>
          <li class="nav-item" id="mynav">
            <router-link class="nav-link active" aria-current="page" to="/about">About</router-link>
          </li>
          <li class="nav-item" id="mynav">
            <router-link class="nav-link active" aria-current="page" to="/facilities">Facilities</router-link>
          </li>
          <li class="nav-item" id="mynav">
            <router-link class="nav-link active" aria-current="page" v-if="isAdmin"  to='/addFacilitie'>Add facilitie</router-link>
          </li>
          <li class="nav-item dropdown bg-black drop"  v-if="isAdmin">
            <a class="nav-link dropdown-toggle bg-black drop nav-link active"  aria-current="page" style="::selection{background-color:#2691d9}" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Add accounts
            </a>
            <ul class="dropdown-menu bg-black drop" aria-labelledby="navbarDropdown">
              <li  class="dropdown-item"><router-link v-if="isAdmin" to="/newManger">Add trainer</router-link></li>
              <li ><router-link v-if="isAdmin" class="dropdown-item" to="/newManger">Add manager</router-link></li>
            </ul>
          </li>
        </ul>
        <div class="d-flex">
          <ul class="navbar-collapse me-auto mb-0 mb-lg-0">
            <li class="nav-justified" id="mynav">
              <router-link v-if="!logedInUser" to="/">Login</router-link>
            </li>
            <li class="nav-justified" id="mynav">
              <router-link v-if="!logedInUser" to="/registration">Signup</router-link>
            </li>
            <li class="nav-justified" id="mynav">
              <router-link v-if="logedInUser" @click="signOut()" to="/">Sign out</router-link>
            </li>
            </ul>
        </div>
      </div>
    </div>
  </nav>
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

</style>