<template>
  <div class="multi-selector">
            <div class="select-field">
                <input  type="text" name="" placeholder="Choose Tasks" id="" class="input-selector">
                <span class="down-arrow">&blacktriangledown;</span>  
            </div>
            <div class="list">
                 <label for="task1" class="task">
            <input type="checkbox" name="" id="task1">
            Task 1
            <span>10 mins</span>
     </label>
       <label for="task2" class="task">
            <input type="checkbox" name="" id="task2">
            Task 2
            <span>20 mins</span>
     </label>
       <label for="task3" class="task">
            <input type="checkbox" name="" id="task3">
            Task 3
            <span>30 mins</span>
     </label>
       <label for="task4" class="task">
            <input type="checkbox" name="" id="task4">
            Task 4
            <span>40 mins</span>
     </label>
            </div>
        </div>
</template>

<script>
export default {
   
}
</script>
    
<style>
  *{
    font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

input{
    outline: none;
    border: none;
}
.multi-selector{
    width: max-content;
}
.select-field{
    border: 1px solid rgb(187, 187, 187);
}
.select-field,.task,.list{
    width: 100%;
    background-color: white;
    padding: 0.3rem;
}
.list{
    box-shadow: 0 30px 60px rgb(0,0,0,0.2);
    
}
.down-arrow{
    font-size: 1.2rem;
    display: inline-block;
    cursor: pointer;
    transition: 0.2s linear;
}
.task{
    display: block;
    padding-left: 0;
}
.task span{
    float: right;
    font-size: 0.6rem;
    padding-top: 6px;
}
.task:hover{
    background-color: aliceblue;
}
.show{
    display: block;
}
.rotate180{
    transform: rotate(-60deg);
}

</style>