<template>
  <div class="mb-3">
<label class="baseLabel">{{label}}</label>
  <input class="inputBase form-control" :placeholder="createPlaceholder()"  :value="modelValue" @input="$emit('update:modelValue',$event.target.value)" required>
  </div>
</template>

<script>
export default {
  name: "InputBase",
  props:{
    label:{
      type:String,
      default:''
    },
    modelValue:{
      type:[String,Number],
      default: ''
    }
  },
  methods:{
    createPlaceholder(){
      const myArray = this.label .split(":");
      return myArray[0] + "..."
    }
  }
}
</script>

<style scoped>
.baseLabel {
  color: #aaa;
  display: inline-block;
  margin: 25px 0 15px;
  font-size: 0.6em;
  text-transform: uppercase;
  letter-spacing: 1px;
  font-weight: bolder;
  font-size: 15px;
}
.inputBase {
  display: block;
  padding: 10px 6px;
  width: 100%;
  box-sizing: border-box;
  border: none;
  border-bottom: 1px solid #ddd;
  color: #555;
  font-size: 20px;
}

</style>