import axios from "axios";

const COMMENT_API_BASE_URL="http://localhost:8080/BodyFit/rest/comments/"
const COMMENT_GET_BY_FACILITY="http://localhost:8080/BodyFit/rest/comments/getAllByFacility"


class CommentService{
    getComments(){
        return axios.get(COMMENT_API_BASE_URL);
    }
    getByFacility(sportFacilityId){
        return axios.post(COMMENT_GET_BY_FACILITY,sportFacilityId)
    }
}

export default new CommentService()