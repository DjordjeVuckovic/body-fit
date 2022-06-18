<template>
<div class = "facilitie">
    <h3>{{facilitie.name}}</h3>
    <p>{{facilitie.location}}</p>
    <p>{{facilitie.type}}</p>
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
.facilitie h3 {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

</style>