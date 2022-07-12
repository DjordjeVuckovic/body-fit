<template>
  <div class="row justify-content-center my-5">
    <form class="center container-fluid" @submit.prevent="$emit('login',this.user)">
      <div class="text-center">
        <h1>Login</h1>
      </div>
      <InputBase
        v-model="user.username"
        label="Username:"
        type="username"
      />
        <label class="form-label labelMy">Pasword:</label>
        <input v-model="user.password" class="form-control inputMy" type="password" placeholder="Password..." id="inputPassword5"  aria-describedby="passwordHelpBlock" required>
        <div class="d-grid gap-2 col-5 mx-auto">
            <input @click="Validate" type="submit" class="btn btn-primary submiter" value="login" />
        </div>
        
        <div class="signup_link">
            Not a member?
            <router-link to="/registration" ><a>Signup</a></router-link>
        </div>
    </form>
    <vue-basic-alert :duration="200" :closeIn="5000" ref="alert"></vue-basic-alert>
  </div>
</template>

<script>
import InputBase from "@/components/InputBase";
import VueBasicAlert from "vue-basic-alert";
export default {
  components: {InputBase,VueBasicAlert},
  data(){
        return{
            user:{
                password: '',
                username: ''
            }
        }
    },
  methods:{
    Validate(){
      if(!this.user.password && !this.user.username)
      this.$refs.alert
          .showAlert('warning','Plese fulfill date of validaty correctly ','warning')
    }
  }
}
</script>

<style scoped>
    .center h1{
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif, 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif, 'Arial Narrow', Arial, sans-serif, Courier, monospace;
        text-align: center;
        padding: 0 0 20px 0;
        color: #2691d9;
    }
    form {
        max-width: 520px;
        margin: 20px auto;
        background: rgb(242, 242, 240);
        text-align: left;
        padding: 40px;
        border-radius: 10px;
        font-size: 20px;
    }
    .labelMy {
        color: #aaa;
        display: inline-block;
        margin: 25px 0 15px;
        font-size: 0.7em;
        text-transform: uppercase;
        letter-spacing: 1px;
        font-weight: bolder;
        font-size: 20px;
    }
    .inputMy {
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
    .submiter{
        text-align: center;
        width: 100px;
        background: #2691d9;
        border: 0;
        padding: 10px 20px;
        margin-top: 40px;
        margin-left: 35px;
        color: white;
        border-radius: 15px;
        font-size: 20px;
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