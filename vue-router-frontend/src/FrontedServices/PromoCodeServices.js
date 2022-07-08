import axios from "axios";


const PROMOCODES_BASE_URL="http://localhost:8080/BodyFit/rest/promoCodes/"


class PromoCodeService{
    getPromoCodes(){
        return axios.get(PROMOCODES_BASE_URL);
    }
    postPromoCode(code){
        return axios.post(PROMOCODES_BASE_URL,code);
    }
}

export default new PromoCodeService()
