<template>
  <div id="app">
  <NavigationBar @sign-out="signOut" :logedInUser="logedInUser" :isAdmin="isAdmin"></NavigationBar>
  <router-view @addFacilitie="addFacilitie" @loggedIn="logggUser" :logedInUser="logedInUser" :isAdmin="isAdmin"  class="container"/>
  </div>

</template>

<script>
import NavigationBar from'./components/NavigationBar.vue'
import axios from "axios";
export default{
  name:'App',
  methods:{
    logggUser(user){
      
      axios.get("http://localhost:8080/BodyFit/rest/login/loggedUser")
            .then((response) => {
              this.logedInUser = response.data
              console.log(this.logedInUser.userRole)
              if (this.logedInUser.userRole === "ADMIN"){
              this.isAdmin = true
            }
              this.$router.push({name : 'Facilities'})
             })
            .catch((error) => console.log(error))
    },
    signOut(){
      this.logedInUser = null
      this.isAdmin = false
    },
    addFacilitie(NewFacilitie){
      console.log(NewFacilitie)
    }
  },
  data(){
    return{
      logedInUser: null,
      isAdmin: null
    }
  },
  components:{
    NavigationBar
  }
 
}
</script>


<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400&display=swap');
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}
#app{
  font-family: 'Roboto', Tahoma, Geneva, Verdana, sans-serif, 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif, 'Arial Narrow', Arial, sans-serif, Courier, monospace;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: black;
}
#login{
  padding-left: 1600px;
}
body {
  font-family: 'Roboto', sans-serif;
}
.container {
  max-width: 1280px;
  margin: 30px auto;
  overflow: auto;
  min-height: 720px;
  border: 1px solid steelblue;
  padding: 30px;
  border-radius: 5px;
}
.user{
  padding-left: 1300px;
}
.btn {
  display: inline-block;
  background: #000;
  color: #fff;
  border: none;
  padding: 10px 20px;
  margin: 5px;
  border-radius: 5px;
  cursor: pointer;
  text-decoration: none;
  font-size: 15px;
  font-family: inherit;
}
.btn:focus {
  outline: none;
}
.btn:active {
  transform: scale(0.98);
}
.btn-block {
  display: block;
  width: 100%;
}
#mynav{
  text-align: left;
  padding: 20px;
}

.drop{
  text-align: left;
  padding-right: 20px;
}
.drop a{
  font-weight: bold;
  font-size:22px;
  color:white;
  text-decoration: none;
  border-radius: 4px;
}
#drop a.router-link-exact-active{
  color:white;
  background: #2691d9;
}
#mynav a{
  font-weight: bold;
  font-size:22px;
  color:white;
  text-decoration: none;
  border-radius: 4px;
  padding: 20px;

}
#mynav a.router-link-exact-active{
  color:white;
  background: #2691d9;
}

</style>
