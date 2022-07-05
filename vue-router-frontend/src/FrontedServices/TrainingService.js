import axios from "axios";

const TRAININGS_API_BASE_URL="http://localhost:8080/BodyFit/rest/trainings"
const TRAININGS_MANAGERS_API_BASE_URL="http://localhost:8080/BodyFit/rest/trainings/getAllByManager"
const TRAININGS_TRAINERS_API_BASE_URL="http://localhost:8080/BodyFit/rest/trainings/getAllTrainers"


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
    getTrainersForFacility(id){
        return axios.post(TRAININGS_TRAINERS_API_BASE_URL,id)
    }

}

export default new getTrainings()