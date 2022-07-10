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
import SelectedFacilitieView from '../views/SelectedFacilitieView'
import AllUsersView from '../views/AllUsersView'
import AddContentView from "@/views/AddContentView";
import AddTrainingView from "@/views/AddTrainingView";
import TrainingsForManagerView from "@/views/TrainingsForManagerView";
import ChooseMembershipView from "@/views/ChooseMembershipView";
import TrainersForManagerView from "../views/TrainersForManagerView";
import EditTrainingView from "../views/EditTrainingView";
import BuyTrainingView from "../views/BuyTrainingView";
import PromoCodeView from "@/views/PromoCodeView";
import TraningsCustomerView from "@/views/TraningsCustomerView";
import TrainingTrainerView from "@/views/TrainingTrainerView";
import FacilityScheduleTraningsView from "@/views/FacilityScheduleTraningsView";
import AllCustomersManagerView from "@/views/AllCustomersManagerView";

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
  },
  {
    path: '/usersView',
    name: 'usersView',
    component: AllUsersView
  },
  {
    path: '/AddContentView',
    name: 'AddContentView',
    component: AddContentView
  },
  {
    path: '/addTrainingView',
    name: 'addTrainingView',
    component: AddTrainingView
  },
  {
    path: '/trainingsForManagerView',
    name: 'trainingsForManagerView',
    component: TrainingsForManagerView
  },
  {
    path: '/trainersForManagerView',
    name: 'trainersForManagerView',
    component: TrainersForManagerView
  },
  {
    path: '/EditTrainingView/:id',
    name: 'EditTrainingView',
    component: EditTrainingView
  }
  ,
  {
    path: '/chooseMembership',
    name: 'chooseMembership',
    component: ChooseMembershipView
  },
  {
    path: '/buyTrainingView/:id',
    name: 'BuyTrainingView',
    component: BuyTrainingView
  },
  {
    path: '/addPromoCode',
    name: 'PromoCodeView',
    component: PromoCodeView
  },
  {
    path: '/trainingsCustomer',
    name: 'TraningsCustomerView',
    component: TraningsCustomerView
  },
  {
    path: '/trainingsTrainer',
    name: 'trainingsTrainer',
    component: TrainingTrainerView
  },
  {
    path: '/facilitySchedule',
    name: 'facilitySchedule',
    component: FacilityScheduleTraningsView
  },
  {
    path: '/allCustomersManager',
    name: 'allCustomersManager',
    component: AllCustomersManagerView
  }


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
