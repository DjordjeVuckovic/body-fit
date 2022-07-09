import axios from "axios";

const TRAININGS_API_BASE_URL="http://localhost:8080/BodyFit/rest/scheduleTrainings"



class getScheduleTrainings{
    getScheduleTrainings(){
        return axios.get(TRAININGS_API_BASE_URL);
    }
    createScheduleTraining(training){
        return axios.post(TRAININGS_API_BASE_URL,training)
    }

}

export default new getScheduleTrainings()