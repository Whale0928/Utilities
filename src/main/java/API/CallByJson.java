package API;

import org.json.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CallByJson extends HttpServlet{



        public static void main(String[] args) {
                JSONObject param = new JSONObject();
                // POST 방식으로 호출.(GET, POST, PUT, DELETE 다 가능 합니다.)
                HttpUtil.callApi(param, "POST");
        }
}
