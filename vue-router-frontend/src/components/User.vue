<template>
<div class = "user container-fluid p-5" >
    <div class="row">
      <div class="col-lg-8  pb-1">
        <table class="table">
          <thead class="table-dark">
            <th class="name justify-content-end" scope="col">{{user.username}}</th>
          </thead>
          <tbody>
            <tr>
              <td>
                <label>Name:</label>
              </td>
              <td>
                <label>{{user.name}}</label>
              </td>
            </tr>
            <tr>
              <td>
                <label>Surname:</label>
              </td>
              <td>
                <label>{{user.surname}}</label>
              </td>
            </tr>
            <tr>
              <td>
                <label>Gender:</label>
              </td>
              <td>
                <label>{{user.gender}}</label>
              </td>
            </tr>
            <tr>
              <td>
                <label>Role:</label>
              </td>
              <td>
                <label>{{user.userRole}}</label>
              </td>
            </tr>
            <tr v-if="this.user.userRole=='CUSTOMER'">
              <td>
                <label>Points:</label>
              </td>
              <td>
                <label>{{user.colletedPoints}}</label>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div  style="margin-top: 20px" class="col-lg-4 ico pt-5 pb-3 justify-content-center">
       <span class="d-block">
          <img v-if="this.user.userRole=='ADMIN'" src="@/assets/admin.png" height="200" width="200" class="ico"/>
          <img v-if="this.user.userRole=='MANAGER'" src="@/assets/manager.png" height="200" width="200" class="ico"/>
          <img v-if="this.user.userRole=='CUSTOMER'" src="@/assets/customer.png" height="200" width="200" class="ico"/>
          <img v-if="this.user.userRole=='COACH'" src="@/assets/trainer.png" height="200" width="200" class="ico"/>

        </span>
  </div>
        
    </div>
    
</div>
</template>

<script>
export default {
    name:'User',
    props:{
        user: Object
    },
    data(){
      return{
        isAdmin: this.user.userRole
      }
    },
    methods:{
      checkAdmin(){
        if(user.userRole =="CUSTOMER"){
          return true
        }
        return false
          
      }
    }
}
</script>

<style>
   .fas {
  color: red;
}
table{
  width: 90%;
  font-size: 24px;
}
.ico{
  display: flex;
  padding-bottom: 10px;
  margin-left: auto;
  margin-right: auto;
  max-width: 20em;
}
.user {
  background: #f4f4f4;
  margin: 10px;
  padding: 10px 20px;
  cursor: pointer;
  min-height: 430px;
  max-height: 430px;
}
.user.reminder {
  border-left: 5px solid green;
}
.buttonMy{
  background: #2691d9;
  color: white;
  border-radius: 15px;
  font-size: 20px;
  padding: 20px;
  margin-left: auto;
  margin-right: auto;
}
.name {
  align-items: flex-start;
  text-align: end;
  color: #2691d9;
  font-size:40px;
  margin-top: auto;
  margin-bottom: auto;
  min-height: 10em;
  display: table-cell;
  vertical-align: middle;
  padding-bottom:10px;
}
.myth {
  color: blue;
  text-align: center;
  font-size: 30px;
  margin-bottom: 20px;
}
table, tbody, td {
  padding-bottom:5px;
}
</style>