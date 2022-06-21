import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Loggin from '../views/LogginView.vue'
import About from '../views/AboutView.vue'
import Facilities from '../views/FacilitiesView.vue'
import Registration from '../views/registerUserView.vue'
import createManagerView from '../views/createManagerView'
import MainView from "@/views/MainView"
import AddFacilitiesView from '../views/AddFacilitieView'

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
    path: '/HomeView',
    name:'HomeView',
    component: HomeView
  },
  {
    path: '/MainView',
    name: MainView,
    component: MainView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
