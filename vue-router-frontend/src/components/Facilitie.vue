<template>
<div class = "facilitie container-fluid" >
  <div class="row">
  <div class="col-8">
  <table class="table">
    <thead class="table-dark">
    <th class="name justify-content-end" scope="col">{{facilitie.name}}</th>
    </thead>
    <tbody>
    <tr><td>
      <label>Adress:</label>
    </td>
      <td>
        <label>{{facilitie.address}}</label>
      </td>
    </tr><tr><td>
      <label>City and postal:</label>
    </td>

      <td>
        <label>{{facilitie.city}} {{facilitie.postal}}</label>
      </td>
    </tr>

    <tr>
      <td>
        <label>Latitude and longitude: </label>
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
    <button class="btn btn-primary mb-3 btn-lg  buttonMy" @click="$emit('selectFacilitie',this.facilitie)">Preview facility</button>
  </div>
  <div class="col-4 ico">
    <img :src="getImgUrl(facilitie.name)" :alt="facilitie.name" class="ico"/>
  </div>
  </div>
</div>
    
</template>

<script>
import Header from "@/components/Header";
export default{
    name:'Facilitie-multi',
    props:{
        facilitie: Object
    },
  components:{ Header},
  methods:{
    getImgUrl(facility){
      let images = require.context('../assets/', false, /\.png$/);
      return images('./' + facility + ".png")
    },
    facilityPreview(){
        // console.log(this.facilitie.name)
        this.$router.push(
            {
              name:'facilityView',
            }
        )
    },
  }
}
</script>


<style scoped>
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
.facilitie {
  background: #f4f4f4;
  margin: 10px;
  padding: 10px 20px;
  cursor: pointer;
}
.facilitie.reminder {
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