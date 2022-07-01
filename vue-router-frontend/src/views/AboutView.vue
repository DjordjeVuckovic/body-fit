<template>
  <div id="app">
    <div>
      <h1>Customize with Props</h1>
      <Wizard
          squared-tabs
          card-background
          navigable-tabs
          :custom-tabs="[
          {
            title: 'Step 1',
          },
          {
            title: 'Step 2',
          },
        ]"
          :beforeChange="onTabBeforeChange"
          @change="onChangeCurrentTab"
      >
        <CreateManagerForFacilitie v-if="currentTabIndex === 0"/>
        <h5 v-if="currentTabIndex === 1">Tab 1</h5>
      </Wizard>
    </div>
  </div>
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

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>