<template>
</template>

<script>
import 'form-wizard-vue3/dist/form-wizard-vue3.css';
import Wizard from 'form-wizard-vue3';
import CreateManagerForFacilitie from "@/components/createManagerForFacilitie";

export default {
  name: 'App',
  components: {
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
</style>