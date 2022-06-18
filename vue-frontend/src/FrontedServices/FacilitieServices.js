import axios from "axios";


const FACILITIES_API_BASE_URL="http://localhost:8080/BodyFit/rest/facilities"

class FacilitieService{
    getFacilities(){
        return axios.get(FACILITIES_API_BASE_URL);
    }
    
}

export default new FacilitieService()