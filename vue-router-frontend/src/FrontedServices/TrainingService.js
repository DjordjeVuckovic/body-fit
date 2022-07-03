import axios from "axios";

const TRAININGS_API_BASE_URL="http://localhost:8080/BodyFit/rest/trainings"
const TRAININGS_MANAGERS_API_BASE_URL="http://localhost:8080/BodyFit/rest/trainings/getAllByManager"


class getTrainings{
    getTrainings(){
        return axios.get(TRAININGS_API_BASE_URL);
    }
    createTraining(training){
        return axios.post(TRAININGS_API_BASE_URL,training)
    }
    getByManager(sportFacilityId){
        return axios.post(TRAININGS_MANAGERS_API_BASE_URL,sportFacilityId)
    }

}

export default new getTrainings()