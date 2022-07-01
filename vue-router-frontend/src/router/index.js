import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Loggin from '../views/LogginView.vue'
import About from '../views/AboutView.vue'
import Facilities from '../views/FacilitiesView.vue'
import Registration from '../views/registerUserView.vue'
import createManagerView from '../views/createManagerView'
import MainView from "@/views/MainView"
import AddFacilitiesView from '../views/AddFacilitieView'
import AccountView from '../views/AccountView'
import createTrainerView from "@/views/createTrainerView";
import facilityView from "@/components/facilityView";
import SelectedFacilitieView from '../views/SelectedFacilitieView'

const routes = [
  {
    path: '/about',
    name: 'about',
    component: About
  },
  {
    path: '/addFacilitie',
    name: 'abaddFacilitie',
    component: AddFacilitiesView
  },
  {
    path: '/',
    name: 'Loggin',
    component: Loggin
  },
  {
    path: '/facilities',
    name: 'Facilities',
    component: Facilities
  },
  {
    path: '/registration',
    name: 'Registration',
    component: Registration
  },
  {
    path: '/newManger',
    name: 'newManger',
    component: createManagerView
  },
  {
    path: '/newTrainer',
    name: 'newTrainer',
    component: createTrainerView
  },
  {
    path: '/HomeView',
    name:'HomeView',
    component: HomeView
  },
  {
    path: '/MainView',
    name: 'MainView',
    component: MainView
  },
  {
    path: '/account',
    name: 'AccountView',
    component: AccountView
  },
  {
    path: '/facilityView',
    name: 'facilityView',
    component: SelectedFacilitieView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
