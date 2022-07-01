<template>
  <div class="container-fluid" style="margin-top: 50px">
    <form class="center" @submit.prevent="createUser">
      <h1>Add new manager for facilitie </h1>
      <label>Username:</label>
      <input type="text" placeholder="Enter username..." v-model="user.username" required>
      <label>Password:</label>
      <input v-model="user.password" type="password" required placeholder="Enter password...">
      <label>Name:</label>
      <input v-model="user.name" type="text" required placeholder="Enter name...">
      <label>Surname:</label>
      <input v-model="user.surname" type="text" required placeholder="Enter surname...">
      <label>Birthdate:</label>
      <input type="date" v-model="user.birthday" required>
      <label>Gender:</label>
      <select id="gender" name="gender" v-model="user.gender">
        <option value="male">Male</option>
        <option value="female">Female</option>
      </select>
      <div class="d-grid gap-2 col-5 mx-auto">
        <input type="submit" class="inputButton btn btn-primary btn-sm" value="Sign up"/>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "createManagerForFacilitie",
  data() {
    return {
      user: {
        username: '',
        password: '',
        name: '',
        surname: '',
        birthday: '',
        gender: ''
      }
    }
  },
  methods: {
    createUser() {
      axios.post("http://localhost:8080/BodyFit/rest/managers/", this.user)
          .then((response) => {
            this.$emit('createdManager',response.data)
            console.log(response.data)
          })
          .catch((error) => console.log(error))
    },
    emits:['createdManager']
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
form {
  max-width: 720px;
  margin: 20px auto;
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