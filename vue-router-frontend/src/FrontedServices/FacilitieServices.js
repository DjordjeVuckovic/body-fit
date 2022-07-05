import axios from "axios";


const FACILITIES_API_BASE_URL="http://localhost:8080/BodyFit/rest/facilities/getAll"
const FACILITIES_ID_API_BASE_URL="http://localhost:8080/BodyFit/rest/facilities/getById"

class FacilitieService{
    getFacilities(){
        return axios.get(FACILITIES_API_BASE_URL);
    }
    getById(id){
        return axios.post(FACILITIES_ID_API_BASE_URL,id);
    }
}

export default new FacilitieService()