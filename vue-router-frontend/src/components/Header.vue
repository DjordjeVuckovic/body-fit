<template>
    <header>
        <h1>{{title}}</h1>
    </header>
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
    header{
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 70px;
        font-size: 30px;
        text-align: center;
        color: white;
    }
</style>