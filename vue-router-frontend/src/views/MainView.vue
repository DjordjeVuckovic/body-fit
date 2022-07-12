<template>
  <div class="container-fluid" style="margin-top: 150px">
  <div id="main" class="container-fluid">
    <Header class="headMy" title="You have successfully submitted form!"></Header>
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
  font-size: 7em;
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