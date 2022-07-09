import axios from "axios";

const TRAININGS_API_BASE_URL="http://localhost:8080/BodyFit/rest/scheduleTrainings"
const TRAININGS1_API_BASE_URL="http://localhost:8080/BodyFit/rest/scheduleTrainings/getAllPassedTrainer"
const TRAININGS2_API_BASE_URL="http://localhost:8080/BodyFit/rest/scheduleTrainings/getAllUpcomingCustomer"
const TRAININGS3_API_BASE_URL="http://localhost:8080/BodyFit/rest/scheduleTrainings/getAllUpcomingTrainer"
const TRAININGS4_API_BASE_URL="http://localhost:8080/BodyFit/rest/scheduleTrainings/getAllPassedCustomer"



class ScheduleTrainings{
    getScheduleTrainings(){
        return axios.get(TRAININGS_API_BASE_URL);
    }
    createScheduleTraining(training){
        return axios.post(TRAININGS_API_BASE_URL,training)
    }
    AllPassedCustomer(id){
        return axios.post(TRAININGS4_API_BASE_URL,id);
    }
    AllPassedTrainer(id){
        return axios.post(TRAININGS1_API_BASE_URL,id);
    }
    AllUpcomingCustomer(id){
        return axios.post(TRAININGS2_API_BASE_URL,id);
    }
    AllUpcomingTrainer(id){
        return axios.post(TRAININGS3_API_BASE_URL,id);
    }

}
export default new ScheduleTrainings()