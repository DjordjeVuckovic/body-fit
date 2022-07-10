import axios from "axios";

const COMMENT_API_BASE_URL="http://localhost:8080/BodyFit/rest/comments/"
const COMMENT_GET_BY_FACILITY_APROVED="http://localhost:8080/BodyFit/rest/comments/getAprovedByFacility"
const COMMENT_GET_BY_FACILITY_NOT_APROVED="http://localhost:8080/BodyFit/rest/comments/getNotAprovedByFacility"

class CommentService{
    getComments(){
        return axios.get(COMMENT_API_BASE_URL);
    }
    getByFacilityAproved(sportFacilityId){
        return axios.post(COMMENT_GET_BY_FACILITY_APROVED,sportFacilityId)
    }
    getByFacilityNotAproved(sportFacilityId){
        return axios.post(COMMENT_GET_BY_FACILITY_NOT_APROVED,sportFacilityId)
    }
    aproveComment(comment){
        return axios.put(COMMENT_API_BASE_URL,comment)
    }
}

export default new CommentService()