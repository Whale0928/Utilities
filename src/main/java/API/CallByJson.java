package API;

import org.json.JSONObject;


public class CallByJson {

        public static void main(String[] args) {
                JSONObject param = new JSONObject();
                // POST 방식으로 호출.(GET, POST, PUT, DELETE 다 가능 합니다.)
                HttpUtil.callApi(param, "POST");

        }
}
