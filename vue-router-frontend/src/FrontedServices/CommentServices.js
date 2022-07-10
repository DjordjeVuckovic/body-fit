import axios from "axios";

const COMMENT_API_BASE_URL="http://localhost:8080/BodyFit/rest/comments/"


class CommentService{
    getComments(){
        return axios.get(COMMENT_API_BASE_URL);
    }
    
}

export default new CommentService()