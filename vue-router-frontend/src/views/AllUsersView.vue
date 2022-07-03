<template >
<div style="padding-top: 20px">
    <nav class="navbar navbar-dark bg-dark p-5 text-light">
    <div class="container-fluid mx-5">
      <div class="mx-2" >
        <div class="textual"><label for="search">Search for users:</label></div>
        <div class="textual">
          <input class="form-control me-2" type="search" v-model="searchQuery" @change="filterList()" @emptied="filterList() " placeholder="Search" aria-label="Search..." autofocus required /></div>
      </div>
      <div >
        <div class="textual">
          <label  id="sort" for="sort">Sort users:</label>
        </div>
        <div class="textual">
          <select id="sort" @change="sortList()" v-model="selected" name="sort" class="form-select" aria-label="Default select example" style="{width: 200px;}" >
            <option value="Default">Default sort</option>
            <option value="NameASC">Name, ASC</option>
            <option value="NameDES">Name, DES</option>
            <option value="SurnameASC">Surname, ASC</option>
            <option value="SurnameDES">Surname, DES</option>
            <option value="UsernameASC">Username, ASC</option>
            <option value="UsernameDES">Username, DES</option>
            <option value="PointsASC">Points, ASC</option>
            <option value="PointsDES">Points, DES</option>
          </select>
        </div>

      </div>

      <div class="textual">
        <div>
          <label id="sort" for="sort">Filter users:</label>
        </div>

        <select id="sort" name="sort" v-model="filterType"  @change="filterList()"  style="{width: 200px;}" class="form-select" aria-label="Default select example">
          <option value="ALL">ALL</option>
          <option value="ADMIN">ADMIN</option>
          <option value="CUSTOMER">CUSTOMER</option>
          <option value="MANAGER">MANAGER</option>
          <option value="COACH">COACH</option>
        </select>
      </div>

      

    </div>

  </nav>
<div class="bla  ">
    <div  class="album py-5 mx-5">
        <div class="row row-cols-3 g-3">
            <div  v-for="user in this.filterList()" v-bind:key="user.username" class="container">
                <div class="col">
                    <User :user = "user"></User>
                </div>
            </div>
        </div>
    </div>
</div>
</div>


  
</template>

<script>
import { jsxClosingElement } from "@babel/types";
import axios from "axios";
import User from '../components/User.vue'
export default {
    name: 'UsersView',
    data(){
        return{
            users: [],
            searchQuery: '',
            selected: 'Default',
            filterType: 'ALL',
            filterUsers : []
        }
        
    },
    components:{
        User
    },
    methods:{
        filterList(){
            if(this.filterType == 'ALL' ){
                this.resultQuery();
                
            }
            else{
                this.resultQuery();
                this.filterUsers =  this.filterUsers.filter((item)=>{
                //return item.userRole.toLowerCase().includes(this.filterType)
                return this.filterType.toLowerCase().split(' ').every(v => item.userRole.toLowerCase().includes(v)) 
                })
            }
            this.sortList();
            return this.filterUsers;
        },
        resultQuery(){
            if(this.searchQuery){
              this.filterUsers = this.filterUsers.filter((item)=>{
                return this.searchQuery.toLowerCase().split(' ').every(v => item.name.toLowerCase().includes(v)) 
                    || this.searchQuery.toLowerCase().split(' ').every(v => item.surname.toLowerCase().includes(v))
                    || this.searchQuery.toLowerCase().split(' ').every(v => item.username.toLowerCase().includes(v))
              })
              this.sortList();
            }else
            {
               this.filterUsers = this.users
            }
          },
          sortList() {
            console.log(this.selected)
            if (this.selected == 'NameASC') {
              this.filterUsers.sort((x, y) => (x.name < y.name ? -1 : 1));
            }
            if(this.selected == 'NameDES') {
              this.filterUsers.sort((x, y) => (x.name > y.name ? -1 : 1));
            }
            if(this.selected == 'SurnameASC') {
              this.filterUsers.sort((x, y) => (x.surname < y.surname ? -1 : 1));
            }
            if(this.selected == 'SurnameDES') {
              this.filterUsers.sort((x, y) => (x.surname > y.surname ? -1 : 1));
            }
            if(this.selected == 'UsernameASC') {
              this.filterUsers.sort((x, y) => (x.username < y.username ? -1 : 1));
            }
            if(this.selected == 'UsernameDES') {
              this.filterUsers.sort((x, y) => (x.username > y.username ? -1 : 1));
            }
            if(this.selected == 'PointsASC') {
              this.filterUsers.sort((x, y) => (x.colletedPoints < y.colletedPoints ? -1 : 1));
            }
            if(this.selected == 'PointsDES') {
              this.filterUsers.sort((x, y) => (x.colletedPoints > y.colletedPoints ? -1 : 1));
            }
        },
      getCustomers(u){
        axios.get("http://localhost:8080/BodyFit/rest/customers/")
                    .then((response) => {   this.filterUsers = [...this.filterUsers, ...response.data ];this.users = this.filterUsers;})
                    .catch((error) => console.log(error))
      },
      getTrainers(){
        axios.get("http://localhost:8080/BodyFit/rest/trainers/")
                    .then((response) => {  this.filterUsers = [...this.filterUsers, ...response.data ];this.users = this.filterUsers;})
                    .catch((error) => console.log(error))
      },
      getManagers(){
        axios.get("http://localhost:8080/BodyFit/rest/managers/")
                    .then((response) => { this.filterUsers = [...this.filterUsers, ...response.data ];this.users = this.filterUsers;})
                    .catch((error) => console.log(error))
      },
      getAdmins(){
        axios.get("http://localhost:8080/BodyFit/rest/admins/")
                    .then((response) => {  this.filterUsers = [...this.filterUsers, ...response.data ];this.users = this.filterUsers; })
                    .catch((error) => console.log(error))
      },
      getAllUsers(){
        this.getCustomers()
        this.getTrainers()
        this.getManagers()
        this.getAdmins()
      }
      
    },
    created(){
        this.getAllUsers()
        this
        console.log("asdadasd")
        console.log(this.users)

    }
}
</script>
    
<style>
    .bla{
        min-width: 350;
        min-height: 300;
        max-width: 350;
        max-height: 300;
    }
</style>