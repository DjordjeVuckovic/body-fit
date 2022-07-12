<template>
</template>

<script>
import 'form-wizard-vue3/dist/form-wizard-vue3.css';
import Wizard from 'form-wizard-vue3';
import CreateManagerForFacilitie from "@/components/createManagerForFacilitie";
import HeaderMulti from "@/components/Header";

export default {
  name: 'App',
  components: {
    HeaderMulti,
    Wizard,CreateManagerForFacilitie
  },
  data() {
    return {
      currentTabIndex: 0,
    };
  },
  methods: {
    onChangeCurrentTab(index) {
      this.currentTabIndex = index;
    },
    onTabBeforeChange() {
      if (this.currentTabIndex === 0) {
        console.log('First Tab');
      }
      console.log('All Tabs');
    },
  },
};
</script>

<style scoped>
.headMy{
  text-align: center;
  padding-top: 0.5em;
  padding-left: 0.5em;
  font-size: 7em;
  color: black;
}
.center {
  display: block;
  margin-top: 100px;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
  text-align: center
}
</style>