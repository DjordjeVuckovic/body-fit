<template>
<div class = "facilitie">
  <h3 class="name">{{facilitie.name}}</h3>
  <table>
    <tbody>
    <tr>
      <td>
        <label>{{facilitie.address}}</label>
      </td>
    </tr>
    <tr>
      <td>
        <label>{{facilitie.lat}} , {{facilitie.longi}}</label>
      </td>
    </tr><tr>
      <td>
        <label>{{facilitie.type}}</label>
      </td>
    </tr>
    <tr>
      <td>
        <label>{{facilitie.status}}</label>
      </td>
    </tr>
    <tr>
      <td>
        <label>{{facilitie.rating}}</label>
      </td>
    </tr>

    </tbody>
  </table>
</div>
    
</template>

<script>
export default{
    name:'Facilitie-multi',
    props:{
        facilitie: Object
    },
}
</script>


<style scoped>
.fas {
  color: red;
}

.facilitie {
  background: #f4f4f4;
  margin: 5px;
  padding: 10px 20px;
  cursor: pointer;
}
.facilitie.reminder {
  border-left: 5px solid green;
}
.name {
  display: flex;
  align-items: center;
  text-align: center;
  justify-content: space-between;
  color: #2691d9;
  font-size:26px;
  padding-bottom:10px;
}
td{
  padding-bottom:5px;
}
thead {
  color: blue;
  text-align: center;
}
table, tbody, td {
  padding-bottom:5px;
}

</style>