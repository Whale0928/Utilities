package API;


import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class HttpUtil {

    public static void callApi(JSONObject params, String type) {
        String key = "9Z%2FRt7EJguG7M5cGcaNE9kHzRxe1fS1%2FcgOWNQn3AyXg4a19A3almi%2FStT0WKlKYgikjqLNn5Wepnw9Hlup2DA%3D%3D";
        String path = "http://apis.data.go.kr/1543061/abandonmentPublicSrvc/sido?numOfRows=30&pageNo=1&serviceKey="+key+"&_type=json";



        try {
            URL url = new URL(path);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setRequestMethod("GET");


            int responseCode = con.getResponseCode();

            InputStream inputStream = (InputStream) con.getContent();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,StandardCharsets.UTF_8);
            System.out.println(inputStreamReader.getEncoding());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = bufferedReader;
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
