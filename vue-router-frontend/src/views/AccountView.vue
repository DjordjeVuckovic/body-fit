<template >
<div style="margin-top: 150px">
    <form v-if="this.changePassword" class="center" @submit.prevent="$emit('account')" >
        <h1>Account information</h1>
        <span>
            <label>Username:</label>
            <div v-if="this.editBool" class="row">
                <div >
                    <p1 class="" v-if="this.editBool">{{this.user.username}}</p1>
                </div>
               
            </div >
            
            
            <div v-if="!this.editBool" class="row">
                
                <div class="col-9">
                    <input  v-model="this.user.username" type="text" required >
                </div>
                <div class="col-sm input">
                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16" @click="edited()">
                        <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                    </svg>
                    <svg xmlns="http://www.w3.org/2000/svg" style="margin-left: 40%;" width="20" height="20" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16" @click="notEdited()">
                        <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
                    </svg>
                </div>
                
            </div>
            
        </span>
         <span>
            <label>Name:</label>
            <div v-if="this.editNameBool" class="row">
                <div  class="col-9">
                    <p1 v-if="this.editNameBool">{{this.user.name}}</p1>
                </div>
                <div class="col-sm input">
                    <svg  v-if="this.editNameBool" xmlns="http://www.w3.org/2000/svg" style="margin-left: 40%;" width="20" height="20" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16" @click="editName()">
                        <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
                    </svg>
                </div>
            </div >
            <div v-if="!this.editNameBool" class="row">
                
                <div class="col-9">
                    <input  v-model="this.user.name" type="text" required >
                </div>
                <div class="col-sm input">
                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16" @click="editedName()">
                        <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                    </svg>
                    <svg xmlns="http://www.w3.org/2000/svg" style="margin-left: 40%;" width="20" height="20" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16" @click="notEditedName()">
                        <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
                    </svg>
                </div>
                
            </div>
        </span>
         <span>
            <label>Surname:</label>
            <div v-if="this.editSurNameBool" class="row">
                <div  class="col-9">
                    <p1 v-if="this.editSurNameBool">{{this.user.surname}}</p1>
                </div>
                <div class="col-sm input">
                    <svg  v-if="this.editSurNameBool" xmlns="http://www.w3.org/2000/svg" style="margin-left: 40%;" width="20" height="20" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16" @click="editSurName()">
                        <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
                    </svg>
                </div>
            </div >
            <div v-if="!this.editSurNameBool" class="row">
                
                <div class="col-9">
                    <input  v-model="this.user.surname" type="text" required >
                </div>
                <div class="col-sm input">
                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16" @click="editedSurName()">
                        <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                    </svg>
                    <svg xmlns="http://www.w3.org/2000/svg" style="margin-left: 40%;" width="20" height="20" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16" @click="notEditedSurName()">
                        <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
                    </svg>
                </div>
                
            </div>
        </span>
        
       
    
        
            <div style="margin-left: 85px;" >
                <button v-if="this.changePassword" type="button" class="submiter d-flex" @click="StartChangePassword()">Change password</button>
            </div>
            
        
    </form>
    <div  v-if="!this.changePassword" class="paswordchanger container">
            <div >
                <label class="paswordchangerText">Insert old password:</label>
                <input v-model="this.oldPassword" class="paswordchangerText" type="password" required >
                <label  class="paswordchangerText">Insert new password:</label>
                <input v-model="this.newPassword" class="paswordchangerText"  type="password" required >
                <label class="paswordchangerText">Confirm new password:</label>
                <input v-model="this.confirmPassword" class="paswordchangerText"  type="password" required >
                <div class="paswordchangerbutton row">
                    <div class="col-sm">
                        <button @click="setNewPassword()">Confirm</button>
                    </div>
                    
                    <div class="col-sm">
                        <button @click="cancelPasswordChange()">Cancel</button>
                       
                    </div>
                     <vue-basic-alert :duration="200" ref="alert"></vue-basic-alert>
                </div>
                
            </div>
             
        </div>
    
</div>
    
</template>

<script>
import VueBasicAlert from 'vue-basic-alert'
import axios from "axios";
export default {
    name: 'AccountView',
    props:['logedInUser'],
    data(){
        return{
            editBool: true,
            editNameBool: true,
            editSurNameBool: true,
            user:{
                name: this.logedInUser.name,
                surname: this.logedInUser.surname,
                username: this.logedInUser.username,
                password : this.logedInUser.password
            },
            
            changePassword: true,
            newPassword: '',
            confirmPassword: '',
            oldPassword: ''
        }
    },
    components:{
        VueBasicAlert
    },
    methods:{
        updateUser(){
             if(this.logedInUser.userRole == "ADMIN"){
                    axios.put("http://localhost:8080/BodyFit/rest/admins/editAdmin",this.user)
                    .then((response) => {console.log(response.data); console.log(this.user)})
                    .catch((error) => console.log(error))
                }
                else if(this.logedInUser.userRole == "MANAGER"){
                    axios.put("http://localhost:8080/BodyFit/rest/managers/editManager",this.user)
                    .then((response) => {console.log(response.data)})
                    .catch((error) => console.log(error))
                }
                else if(this.logedInUser.userRole == "CUSTOMER"){
                    axios.put("http://localhost:8080/BodyFit/rest/customers/editCustomer",this.user)
                    .then((response) => {console.log(response.data)})
                    .catch((error) => console.log(error))
                }
                else if(this.logedInUser.userRole == "COACH"){
                    axios.put("http://localhost:8080/BodyFit/rest/trainers/editTrainer",this.user)
                    .then((response) => {console.log(response.data)})
                    .catch((error) => console.log(error))
                }
        },
        edit(){
            this.editBool = false;
        },
        edited(){
            this.editBool = true;
            this.logedInUser.username = this.user.username;
        },
        notEdited(){
            this.editBool = true;
             this.user.username = this.logedInUser.username;
        },
        editName(){
            this.editNameBool = false;
        },
        editedName(){
            this.editNameBool = true;
            this.logedInUser.name = this.user.name;
            console.log(this.logedInUser.userRole)
            this.updateUser();
            
        },
        notEditedName(){
            this.editNameBool = true;
            this.user.name = this.logedInUser.name;
        },
        editSurName(){
            this.editSurNameBool = false;
        },
        editedSurName(){
            this.editSurNameBool = true;
            this.logedInUser.surname = this.user.surname;
           this.updateUser();
        },
        notEditedSurName(){
            this.editSurNameBool = true;
            this.surname = this.logedInUser.surname;
        },
        setNewPassword(){
            if(this.user.password == this.oldPassword && this.newPassword == this.confirmPassword){
                this.user.password = this.newPassword;
                this.logedInUser.password = this.newPassword;
                this.changePassword = true;
                this.newPassword= '';
                this.confirmPassword= '';
                this.oldPassword= '';
                this.updateUser();
            }
            else{
                this.$refs.alert 
                .showAlert('error','Plese fulfill required fields correctly ','warning')
            }
            
        },
        StartChangePassword(){
            this.changePassword = false
        },
        cancelPasswordChange(){
             this.changePassword = true
             this.newPassword= '';
            this.confirmPassword= '';
            this.oldPassword= '';
        },
        
        
       
    },
    
}
</script>

<style scoped>
    .center h1{
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif, 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif, 'Arial Narrow', Arial, sans-serif, Courier, monospace;
        text-align: center;
        padding: 0 0 20px 0;
        color: #2691d9;
        align-items: center;
    }
    form {
        max-width: 600px;
        margin: 30px auto;
        background: rgb(242, 242, 240);
        text-align: left;
        padding: 40px;
        border-radius: 10px;
        font-size: 15px;
        
        
        
    }
    .paswordchanger{
        border-radius: 10px;
        width: 500px;
        margin-top: 60px;
        padding-bottom: 30px;
        background: rgb(170, 179, 208);
        color: black;
    }
    .paswordchangerText{
        
        background: rgb(170, 179, 208);
        color: black;
    }
    .paswordchangerbutton{
        align-items: flex-start;
        justify-items: center;
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
    p1 {
        display: block;
        padding: 10px 6px;
        width: 100%;
        box-sizing: border-box;
        border: none;
        border-bottom: 1px solid #ddd;
        color: #555;
        font-size: 20px;
    }
     input {
        display: block;
        padding: 10px 6px;
        width: 100%;
        box-sizing: border-box;
        border: none;
        border-bottom: 1px solid #ddd;
        color: #555;
        font-size: 20px;
        background: rgb(242, 242, 240);
    }
    .input {
        display: block;
        padding: 10px 6px;
        width: 100%;
        box-sizing: border-box;
        border: none;
        border-bottom: 1px solid #ddd;
        color: #555;
        font-size: 20px;
        background: rgb(242, 242, 240);
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
       
        width: px;
        background: #2691d9;
        border: 0;
        padding: 10px 20px;
        margin-top: 40px;
        margin-left: 75px;
        color: white;
        border-radius: 15px;
        font-size: 20px;
    }
    .submiter{
        text-align: center;
        background: #2691d9;
        border: 0;
        align-self: center;
        margin-top: 40px;
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