import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Loggin from '../views/LogginView.vue'
import About from '../views/AboutView.vue'
import Facilities from '../views/FacilitiesView.vue'

const routes = [
  {
    path: '/about',
    name: 'about',
    component: About
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
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router