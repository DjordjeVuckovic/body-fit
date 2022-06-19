
<template>
  <LoginForm @login="login"></LoginForm>
</template>

<script>
import LoginForm from '../components/SignupForm.vue'
import LoginService from '../FrontedServices/LoginServices'
import axios from "axios";

export default {
    name: 'Loggin',
    components:{
        LoginForm,
        logedIn : Boolean
        
    }, 
    
    methods:{
        login(user){   
            console.log(user)
            axios.post("http://localhost:8080/BodyFit/rest/login/logInStatus",user)
            .then((response) => {if(response.data){this.$router.push({name : 'Facilities'})}})
            .catch((error) => console.log(error))
                      
        },   
    },
    
}
</script>

<style>

</style>