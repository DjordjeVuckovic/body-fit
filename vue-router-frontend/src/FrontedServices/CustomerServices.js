import axios from "axios";

const CUSTOMER_API_BASE_URL="http://localhost:8080/BodyFit/rest/customers"
const CUSTOMER_M_API_BASE_URL="http://localhost:8080/BodyFit/rest/scheduleTrainings/getAllCustomers"


class CustomerService{
    getCustomers(){
        return axios.get(CUSTOMER_API_BASE_URL);
    }
    getCustomersForManager(id){
        return axios.post(CUSTOMER_M_API_BASE_URL,id)
    }
    
}

export default new CustomerService()