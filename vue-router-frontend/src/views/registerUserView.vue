<template>
  <div class="container-fluid" style="margin-top: 150px">
  <form class="center" @submit.prevent="createUser">
  <h1>Create new Account </h1>
  <label>Username:</label>
  <input type="username" placeholder="Enter username..." v-model="user.username" required>
  <label>Password:</label>
  <input v-model="user.password" type="password"  placeholder="Enter password..." required>
  <label>Name:</label>
  <input v-model="user.name" type="text"  placeholder="Enter name..." required>
  <label>Surname:</label>
  <input v-model="user.surname" type="text"  placeholder="Enter surname..." required>
  <label>Birthdate:</label>
  <input type="date" v-model="user.birthday" required>
    <label>Gender:</label>
  <select id="gender" name="gender" v-model="user.gender" required>
    <option value="male">Male</option>
    <option value="female">Female</option>
  </select>
  <input type="submit" class="inputButton" value="Sign up"/>
  </form>
  <div class="centerp">
  <p >{{error}}</p>
  </div>
  </div>


</template>

<script>
import axios from "axios";
import Facilities from "@/components/Facilities";
export default {
  name: "registerUser",
  data(){
    return{
      user:{
        username:'',
        password:'',
        name:'',
        surname:'',
        birthday:'',
        gender:''
      },
      error:'',
      props: {
        users: Array
      }
    }
  },
  methods:{
    createUser(){
      console.log(this.users)
      if (this.users.some(code=> code.username.toLowerCase() === this.user.username.toLowerCase()))
      {
        this.error = "Wrong credential.Please choose another username!";
        alert(this.error);
        return;
      }
      axios.post("http://localhost:8080/BodyFit/rest/customers",this.user)
          .then((response) => console.log(response))
          .catch((error) => console.log(error))
      this.$router.push("MainView");
    },
    goToLogin(){
      this.$router.push("About");
    }
  },
  created() {
    axios.get("http://localhost:8080/BodyFit/rest/customers")
        .then(response => (this.users = response.data))
  }
}
</script>

<style scoped>
.center h1{
  font-family: 'Roboto', Tahoma, Geneva, Verdana, sans-serif, 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif, 'Arial Narrow', Arial, sans-serif, Courier, monospace;
  text-align: center;
  padding: 0 0 20px 0;
  color: #2691d9;
}
.centerp{
  font-family: 'Roboto', Tahoma, Geneva, Verdana, sans-serif, 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif, 'Arial Narrow', Arial, sans-serif, Courier, monospace;
  text-align: center;
  padding: 0 0 20px 0;
  color: red;

}
form {
  max-width: 420px;
  margin: 30px auto;
  background: rgb(242, 242, 240);
  text-align: left;
  padding: 40px;
  border-radius: 10px;
  font-size: 15px;
}
label {
  color: #aaa;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.6em;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-weight: bolder;
  font-size: 15px;
}
input,select {
  display: block;
  padding: 10px 6px;
  width: 100%;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid #ddd;
  color: #555;
  font-size: 20px;
}
.pill{
  display: inline-block;
  margin: 20px 10px 0 0;
  padding: 6px 12px;
  background: #eee;
  border-radius: 20px;
  font-size: 12px;
  letter-spacing: 1px;
  font-weight: bold;
  color: #777;
  cursor: pointer;
}
button{
  width: 100px;
  background: #2691d9;
  border: 0;
  padding: 10px 20px;
  margin-top: 40px;
  margin-left: 140px;
  color: white;
  border-radius: 15px;
  font-size: 20px;
}
.inputButton{
  width: 150px;
  background: #2691d9;
  border: 0;
  padding: 10px 20px;
  margin-top: 40px;
  margin-left: 120px;
  color: white;
  border-radius: 15px;
  font-size: 20px;

}
.submiter{
  text-align: center;
}
.signup_link{
  margin: 30px 0;
  text-align: center;
  font-size: 16px;
  color: #666666;
}
.signup_link a{
  color: #2691d9;
  text-decoration: none;
}

</style>