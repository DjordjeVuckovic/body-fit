<template >
<div class="mx-5">
    <div style="margin-top: 50px" class="album py-5">
    <div class="row row-cols-3 g-3">
        <div  v-for="user in this.users" v-bind:key="user.username" class="container">
            <div class="col">
                <User :user = "user"></User>
            </div>
    </div>
    </div>
    
</div>
</div>

  
</template>

<script>
import axios from "axios";
import User from '../components/User.vue'
export default {
    name: 'UsersView',
    data(){
        return{
            users: [],
        }
        
    },
    components:{
        User
    },
    methods:{
      getCustomers(){
        axios.get("http://localhost:8080/BodyFit/rest/customers/")
                    .then((response) => { this.users = [...this.users, ...response.data ]; console.log(this.users);})
                    .catch((error) => console.log(error))
      },
      getTrainers(){
        axios.get("http://localhost:8080/BodyFit/rest/trainers/")
                    .then((response) => { this.users = [...this.users, ...response.data ]; console.log(this.users);})
                    .catch((error) => console.log(error))
      },
      getManagers(){
        axios.get("http://localhost:8080/BodyFit/rest/managers/")
                    .then((response) => { this.users = [...this.users, ...response.data ]; console.log(this.users);})
                    .catch((error) => console.log(error))
      },
      getAdmins(){
        axios.get("http://localhost:8080/BodyFit/rest/admins/")
                    .then((response) => { this.users = [...this.users, ...response.data ]; console.log(this.users);})
                    .catch((error) => console.log(error))
      }
      
    },
    created(){
        this.getCustomers()
        this.getTrainers()
        this.getManagers()
        this.getAdmins()
    }
}
</script>

<style>

</style>