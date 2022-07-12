
<template>
  <div  style="margin-top: 150px">
  <LoginForm @login="login"></LoginForm>
    </div>
  <vue-basic-alert :duration="200" :closeIn="5000" ref="alert"></vue-basic-alert>
</template>

<script>
import LoginForm from '../components/SignupForm.vue'
import LoginService from '../FrontedServices/LoginServices'
import axios from "axios";
import VueBasicAlert from "vue-basic-alert";

export default {
    name: 'Loggin',
    components:{
        LoginForm,
        logedIn : Boolean,
        VueBasicAlert
    }, 
    
    methods:{
        login(user){
            axios.post("http://localhost:8080/BodyFit/rest/login/logInStatus",user)
            .then((response) => {
                if(response.data){
                    this.$emit('loggedIn',user)
                    }
                else {
                  this.$refs.alert.showAlert('error','Wrong credential','Error')
                }

            })
            .catch((error) => console.log(error))
        },
    },
    emits:['loggedIn'],
    
        
    
    
}
</script>

<style>

</style>