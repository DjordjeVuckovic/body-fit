<template>
  <div class="container-fluid">
    <header>
      <h1 class="headerMy">{{title}}</h1>
    </header>
  </div>
</template>

<script>
    export default{
        name: 'Header-multi',
        props: {
            title: {
               type: String,
               default: 'Header'
            }
        },
    }
    
</script>

<style scoped>
    div.headerMy{
        justify-content: space-between;
        align-items: center;
        font-weight: bolder;
        font-size: 30px;
        text-align: center;
        color: black;
        margin-top: auto;
        margin-bottom: auto;
        min-height: 10em;
        display: table-cell;
        vertical-align: middle
    }
</style>