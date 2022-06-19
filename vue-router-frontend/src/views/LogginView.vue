<template>
  <LoginForm @login="loggin"></LoginForm>
</template>

<script>
import LoginForm from '../components/SignupForm.vue'

export default {
    name: 'Loggin',
    components:{
        LoginForm
    }, 
    methods:{
        loggin(){
            this.$router.push({name : 'Facilities'})
        }    
    }
}
</script>

<style>

</style>