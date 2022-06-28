<template>
    <form class="center" @submit.prevent="$emit('account')">
        <h1>Account information</h1>
        <span>
            <label>Username:</label>
            <label>{{logedInUser.name}}</label>
        </span>
    
        <input  type="submit" class="submiter" value="Edit information"/>
        <div class="signup_link">
            Not a member?
            <router-link to="/registration" ><a>Signup</a></router-link>
        </div>
    </form>
</template>

<script>
export default {
    name: 'AccountView',
    props:['logedInUser']
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
    input {
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
        margin-left: 120px;
        color: white;
        border-radius: 15px;
        font-size: 20px;
    }
    .submiter{
        text-align: center;
        width: 100px;
        background: #2691d9;
        border: 0;
        padding: 10px 20px;
        margin-top: 40px;
        margin-left: 120px;
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