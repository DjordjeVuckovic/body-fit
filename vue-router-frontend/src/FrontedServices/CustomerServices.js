import axios from "axios";

const CUSTOMER_API_BASE_URL="http://localhost:8080/BodyFit/rest/customers"


class CustomerService{
    getCustomers(){
        return axios.get(CUSTOMER_API_BASE_URL);
    }
    createCustomer(){
        return axios.post(CUSTOMER_API_BASE_URL);
    }
    
}

export default new CustomerService()