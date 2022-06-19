<template>
  <div id="main">
  <div id="nav">
    <Header title="You have successfully created an account!"></Header>
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