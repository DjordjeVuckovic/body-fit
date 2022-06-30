import axios from "axios";

const AVAILABLE_API_BASE_URL="http://localhost:8080/BodyFit/rest/managers/getAvailable"

class ManagerService{
    getAvailableManagers(){
        return axios.get(AVAILABLE_API_BASE_URL);
    }

}
export default new ManagerService()