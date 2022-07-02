<template>
<div class = "user container" >
    <div class="container">
        <p>{{user.username}}</p>
        <p>{{user.name}}</p>
        <p>{{user.surname}}</p>
    </div>
    
</div>
</template>

<script>
export default {
    name:'User',
    props:{
        user: Object
    },
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
  display: block;
  padding-bottom: 10px;
  margin-left: auto;
}
.user {
  background: #f4f4f4;
  margin: 10px;
  padding: 10px 20px;
  cursor: pointer;
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
  align-items: end;
  text-align: end;
  color: #2691d9;
  font-size:50px;
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