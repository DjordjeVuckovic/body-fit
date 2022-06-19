<template>
    <div class="conteiner">
        <h1 class="text-center">Customers</h1>
        <table>
            <thead>
                <th>Name</th>
                <th>Surname</th>
            </thead>
            <tbody>
                <tr v-for="customer in customers" v-bind:key ="customer.username">
                    <td>{{customer.name}}</td>
                    <td>{{customer.surname}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import CustomerService from '../FrontedServices/CustomerServices'

    export default{
        name:'Customers-bla',
        data(){
            return{
                customers : []
            }
        },
        methods:{
            getCustomers(){
                CustomerService.getCustomers().then((response) => {
                    this.customers = response.data
                });
            }
        },
        created(){
            this.getCustomers()
        }

    }
</script>
