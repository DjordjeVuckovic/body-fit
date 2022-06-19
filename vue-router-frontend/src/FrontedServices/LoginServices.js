import axios from "axios";



const Login_API_Status_URL="http://localhost:8080/BodyFit/rest/login/logInStatus"

class LoginService{
    tryLogin(username,pasword){
        return axios.post(Login_API_Status_URL);
    }
    
}

export default new LoginService()