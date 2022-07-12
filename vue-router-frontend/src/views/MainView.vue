<template>
  <div class="container-fluid" style="margin-top: 50px">
    <div id="main" class="container-fluid">
      <h1 class="headMy" >You have successfully submitted form!</h1>
      <div class="center">
        <img src="../../success.png">
      </div>
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header";
export default {
  name: "MainView",
  components:{
    Header
  }
}
</script>

<style scoped>
.center {
  display: block;
  margin-top: 100px;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
  text-align: center
}
#main{
  font-family: Roboto;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2691d9;
}
.headMy{
  text-align: center;
  vertical-align: center;
  padding-top: 0.5em;
  padding-left: 0.5em;
  font-size: 5em;
  color: #2691d9;
}
.container {
  max-width: 1280px;
  margin: 30px auto;
  overflow: auto;
  min-height: 720px;
  border: 1px solid steelblue;
  padding: 30px;
  border-radius: 5px;
}
#nav{
  padding: 30px;
}
#nav a{
  font-weight: bold;
  color: #2691d9;
  text-decoration: none;
  padding: 10px;
  border-radius: 4px;

}
</style>