<template  >
<div class="bg-dark b">
    <div class="center" style="padding-top: 20px">
    <div>
        <div v-if="!isCode"  class="album py-5 mt-5">
            <div class="row row-cols-4 g-3">
                <div class="col">
                    <Membership :isCode="isCode" @chooseMembership="chooseMembership"  :logedInUser="this.logedInUser" :numberOfSession = "16" :type = "month" :price = "2000"></Membership>
                </div>
                <div class="col">
                    <Membership :isCode="isCode" @chooseMembership="chooseMembership" :logedInUser="logedInUser" :numberOfSession = "16" :type = "threeMonths" :price = "5500"></Membership>
                </div>
                <div class="col">
                    <Membership :isCode="isCode" @chooseMembership="chooseMembership" :logedInUser="logedInUser" :numberOfSession = "16" :type = "sixMonths" :price = "11000"></Membership>
                </div>
                <div class="col">
                    <Membership :isCode="isCode" @chooseMembership="chooseMembership" :logedInUser="logedInUser" :numberOfSession = "16" :type = "year" :price = "20000"></Membership>
                </div>
                <div class="col">
                    <Membership :isCode="isCode" @chooseMembership="chooseMembership" :logedInUser="logedInUser" :numberOfSession = "22" :type = "month" :price = "2500"></Membership>
                </div>
                <div class="col">
                    <Membership :isCode="isCode" @chooseMembership="chooseMembership" :logedInUser="logedInUser" :numberOfSession = "22" :type = "threeMonths" :price = "6500"></Membership>
                </div>
                <div class="col">
                    <Membership @chooseMembership="chooseMembership" :logedInUser="logedInUser" :numberOfSession = "22" :type = "sixMonths" :price = "12000"></Membership>
                </div>
                <div class="col">
                    <Membership :isCode="isCode" @chooseMembership="chooseMembership" :logedInUser="logedInUser" :numberOfSession = "22" :type = "year" :price = "21000"></Membership>
                </div>
            </div>
        </div>
        <div v-if="isCode">
            <Membership class="container choosen" @chooseMembership="chooseMembership" :logedInUser="logedInUser" :numberOfSession = "this.selectedMembership.numberOfSession" :isCode="true" :type = "this.selectedMembership.type" :price = "this.selectedMembership.price"></Membership>
        </div>
    </div>
  </div>
</div>
  
</template>

<script>
import Membership from '../components/Membership.vue'
export default {
    name: 'ChooseMembershipView',
    components:{
        Membership
    },
    props:['logedInUser'],
    data(){
        return{
            month: 'MONTH',
            threeMonths:'THREE_MONTHS',
            sixMonths:'SIX_MONTHS',
            year: 'YEAR',
            isCode : false,
            selectedMembership: Object
        }
    },
    methods:{
        chooseMembership(membership){
            this.isCode = true
            this.selectedMembership = membership
        },
        buyMembership(membership){
            var today = new Date();
            var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
            
           
            console.log(membership)
            
        }
    }
}
</script>

<style scoped>
    .center{
        margin-left: 150px;
        margin-right: 150px;
        margin-top: 100px;
    }
    .b{
     
         padding-bottom: 30%;

    }
    .choosen{
        min-height: 750px;
        max-height: 750px;
        min-width: 550px;
        max-width: 550px;
        
    }
</style>