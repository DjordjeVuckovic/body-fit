<template>
<div class = "facilitie" >
  <h3 class="name">{{facilitie.name}}</h3>
  <img :src="getImgUrl(facilitie.name)" :alt="facilitie.name" class="ico"/>
  <table>
    <tbody>
    <tr><td>
      <label>Adress:</label>
    </td>

      <td>
        <label>{{facilitie.address}}</label>
      </td>
    </tr>
    <tr>
      <td>
        <label>Latitude,Longitude: </label>
      </td>
      <td>
        <label>{{facilitie.lat}} , {{facilitie.longi}}</label>
      </td>
    </tr><tr>
      <td>
        <label>Type: </label>
      </td>
      <td>
        <label>{{facilitie.type}}</label>
      </td>
    </tr>
    <tr>
      <td>
        <label>Status: </label>
      </td>
      <td>
        <label>{{facilitie.status}}</label>
      </td>
    </tr>
    <tr>
      <td>
        <label>Rating: </label>
      </td>
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
  data() {
      return{
    Synergy: "../assets/Synergy"
    }
  },
  methods:{
    getImgUrl(facility){
      let images = require.context('../assets/', false, /\.png$/);
      return images('./' + facility + ".png")
    }
  }
}
</script>


<style scoped>
.fas {
  color: red;
}
table{
  width: 40%;
  font-size: 20px;
}
.ico{
  display: block;
  width: 120px;
  padding-bottom: 30px;
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
  font-size:40px;
  margin-left: 500px;
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