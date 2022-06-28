<template>
  <nav class="navbar navbar-dark bg-primary navbar-expand-lg nav fixed-top">
    <div class="container-fluid">
      <img src="@/assets/fitness.png" height="60" width="70">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-collapse me-auto mb-0 mb-lg-0">
          <li class="nav-item" id="mynav">
            <router-link   aria-current="page" to="/HomeView" >Home</router-link>
          </li>
          <li class="nav-item" id="mynav">
            <router-link class="nav-link active" aria-current="page" to="/about">About</router-link>
          </li>
          <li class="nav-item " id="mynav">
            <router-link class="nav-link active" aria-current="page" to="/facilities">
              <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-building align-top mx-2" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M14.763.075A.5.5 0 0 1 15 .5v15a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V14h-1v1.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V10a.5.5 0 0 1 .342-.474L6 7.64V4.5a.5.5 0 0 1 .276-.447l8-4a.5.5 0 0 1 .487.022zM6 8.694 1 10.36V15h5V8.694zM7 15h2v-1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5V15h2V1.309l-7 3.5V15z"></path>
                <path d="M2 11h1v1H2v-1zm2 0h1v1H4v-1zm-2 2h1v1H2v-1zm2 0h1v1H4v-1zm4-4h1v1H8V9zm2 0h1v1h-1V9zm-2 2h1v1H8v-1zm2 0h1v1h-1v-1zm2-2h1v1h-1V9zm0 2h1v1h-1v-1zM8 7h1v1H8V7zm2 0h1v1h-1V7zm2 0h1v1h-1V7zM8 5h1v1H8V5zm2 0h1v1h-1V5zm2 0h1v1h-1V5zm0-2h1v1h-1V3z"></path>
              </svg>
              <span class="align-bottom">Facilities</span> 
              </router-link>
          </li>
          <li class="nav-item" id="mynav">
            <router-link class="nav-link active" aria-current="page" v-if="isAdmin"  to='/addFacilitie'>
              <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-plus" viewBox="0 0 16 16">
                <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"></path>
              </svg>
              <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-building align-top" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M14.763.075A.5.5 0 0 1 15 .5v15a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V14h-1v1.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V10a.5.5 0 0 1 .342-.474L6 7.64V4.5a.5.5 0 0 1 .276-.447l8-4a.5.5 0 0 1 .487.022zM6 8.694 1 10.36V15h5V8.694zM7 15h2v-1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5V15h2V1.309l-7 3.5V15z"></path>
                <path d="M2 11h1v1H2v-1zm2 0h1v1H4v-1zm-2 2h1v1H2v-1zm2 0h1v1H4v-1zm4-4h1v1H8V9zm2 0h1v1h-1V9zm-2 2h1v1H8v-1zm2 0h1v1h-1v-1zm2-2h1v1h-1V9zm0 2h1v1h-1v-1zM8 7h1v1H8V7zm2 0h1v1h-1V7zm2 0h1v1h-1V7zM8 5h1v1H8V5zm2 0h1v1h-1V5zm2 0h1v1h-1V5zm0-2h1v1h-1V3z"></path>
              </svg>
              <span class="align-middle"> Add facilitie</span> 
            </router-link>
          </li>
          <li class="nav-item dropdown  drop"  v-if="isAdmin">
            <a class="nav-link dropdown-toggle  drop nav-link active"  aria-current="page" style="::selection{background-color:#2691d9}" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
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
              <router-link v-if="logedInUser" @click="signOut()" to="/">
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-door-open align-top" viewBox="0 0 16 16">
                  <path d="M8.5 10c-.276 0-.5-.448-.5-1s.224-1 .5-1 .5.448.5 1-.224 1-.5 1z"></path>
                  <path d="M10.828.122A.5.5 0 0 1 11 .5V1h.5A1.5 1.5 0 0 1 13 2.5V15h1.5a.5.5 0 0 1 0 1h-13a.5.5 0 0 1 0-1H3V1.5a.5.5 0 0 1 .43-.495l7-1a.5.5 0 0 1 .398.117zM11.5 2H11v13h1V2.5a.5.5 0 0 0-.5-.5zM4 1.934V15h6V1.077l-6 .857z"></path>
                </svg>
                <span class="align-middle mx-2">Sign out</span> 
              </router-link>
            </li>
            <li class="nav-justified" id="mynav">
              <router-link v-if="logedInUser"  to="/account">
              <span class="mx-3">{{logedInUser.name}}</span>{{logedInUser.surname}}
              <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-person-circle mx-3" viewBox="0 0 16 16">
                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"></path>
                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"></path>
              </svg>
              </router-link>
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
    #nav{
  padding: 40px;
  text-align: left;
}
#nav a{
  font-weight: bold;
  font-size:30px;
  color: white;
  text-decoration: none;
  padding: 15px;
  border-radius: 4px;

}
#nav a.router-link-exact-active{
  color:black;
  background: black;
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