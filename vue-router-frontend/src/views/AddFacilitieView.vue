<template>
  <form class="center" @submit.prevent="$emit('login',this.NewFacilitie)">
        <h1>Add a facilitie?</h1>
        <label>Name</label>
        <input type="name" v-model="name"/>
        <label>Type</label>
        <select v-model="type" >
            <option value="GYM">Gym</option>
            <option value="POOL">Pool</option>
            <option value="SPORTCENTER">Sport center</option>
            <option value="DANCINGSRUDIO">Dancing studio</option>
            <option value="BOWLINGCENTER">Bowling center</option>
            <option value="SHOOTINGRANGE">Shooting range</option>
        </select>
        <label>Content</label>
        <select v-model="facilityContent" multiple>
            <option value="grupni">Gym</option>
            <option value="personalni">Pool</option>
            <option value="sauna">Sport center</option>
            <option value="kardio">Dancing studio</option>
        </select>

        <label>Location:</label>
        <input type="location" v-model="location"/>
        <input  type="submit" class="submiter" value="Add Facilitie"/>
  

  </form>
  <p>{{name}}</p>
  <p>{{type}}</p>
  <p>{{facilityContent}}</p>
  <p>{{location}}</p>
</template>

<script>
import MultiDropDown from '../components/MultiDropDown.vue'
export default {
    name: 'addFaciliteView', 
    data(){
        return{
            NewFacilitie:{
                name: '',
                type: '',
                facilityContent: '',
                location: '',
            }
            
        }
    },
    components:{
        MultiDropDown
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
    select {
        width: 100%;
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
        padding: 10px 6px;
        width: 100%;
        box-sizing: border-box;
        border: none;
        border-bottom: 1px solid #ddd;
        color: #555;
        font-size: 20px;
    }
    .input-selector{
        outline: none;
       padding: 10px 6px;
        width: 90%;
        box-sizing: border-box;
        border: none;
        background-color: rgb(242, 242, 240);
        color: #555;
        font-size: 20px; 
    }
    .select-field{
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