<template>
  <div id="app">
  <NavigationBar :logedInUser="logedInUser"></NavigationBar>
  <router-view @loggedIn="logggUser" :logedInUser="logedInUser" class="container"/>
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
              console.log(this.logedInUser)
              this.$router.push({name : 'Facilities'})
             })
            .catch((error) => console.log(error))
    }
  },
  data(){
    return{
      logedInUser: null
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
  font-family: 'Poppins', sans-serif;
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

</style>
