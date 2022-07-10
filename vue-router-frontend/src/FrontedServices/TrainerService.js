import axios from "axios";

const TRAINERS_API_BASE_URL="http://localhost:8080/BodyFit/rest/trainers"
const TRAINERS_ID_API_BASE_URL="http://localhost:8080/BodyFit/rest/trainers/getById"


class TrainerService{
    getTrainers(){
        return axios.get(TRAINERS_API_BASE_URL);
    }
    getById(id){
        return axios.post(TRAINERS_ID_API_BASE_URL,id)
    }

}

export default new TrainerService()