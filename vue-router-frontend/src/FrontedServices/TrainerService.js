import axios from "axios";

const TRAINERS_API_BASE_URL="http://localhost:8080/BodyFit/rest/trainers"


class TrainerService{
    getTrainers(){
        return axios.get(TRAINERS_API_BASE_URL);
    }

}

export default new TrainerService()