
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 텍스트 파일을 입력받고 여러 종류별로 반환하는 메서드
 */
public class getTableNamebyText {
    /**텍스트 파일을 읽어 한줄로 내보내는 기능
     * @param filePath 파일경로가 저장되있어야 한다.
     * @return 한줄로 정렬된 문자열
     */
    public String inputString(String filePath){
        String line;
        StringBuilder sb = new StringBuilder();
        File file = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                sb.append(" ").append(line.replace("[\\n\\r\\t]"," "));
                //체인 append 호출로 변환되었다.
            }
        } catch (IOException e) {
            System.out.println("File Input Fail!!!");
            e.printStackTrace();
        }
        line = sb.toString().replaceAll("[^a-zA-Z]"," ");

        return line;
    }


    public static void main(String[] args) {
        getTableNamebyText in = new getTableNamebyText();
        
        String path ="D:/untitled/queryTxt.txt";
        String str =  in.inputString(path).toUpperCase();
        


        boolean flag = false;

        StringBuilder sb = new StringBuilder();
        String[] arr = str.split("[^\\w]");

        List<String> list = new ArrayList<>();
        for (String s : arr){
            int branch = in.chkValue(s);
            if(branch==0){
                flag = true;  //지금부터 입력받음
                sb.delete(0,sb.length()); //String buffer를 초기화 한다.
                continue;   //시작 문자열("FROM")을 저장하지 않고. 반복
            }else if(branch==1){
                list.add(sb.toString()); //입력이 끝이라는 의미이니깐 지금까지 입력받은 문자열을 list에 저장
                flag = false;  //지금부터는 StringBuffer에 저장하지 않겟다는 의미.
                continue;
            }else if(branch==2){
                flag = false;  // 저장할 필요가 없는 경우 서브쿼리에서 사용된다
                               //  from (SELECT ~
                continue;
            }
            if(flag) sb.append(" ").append(s);
        }

        String[] sArr = list.toString().replaceAll(","," ").split(" ");
        Set<String> collect = Arrays.stream(sArr)
                        .filter(l -> l.length() > 2)
                        .filter(l->!l.equals("CFCODE"))
                        .filter(l-> !l.equals("PLSTYCD"))
                        .filter(l-> !l.equals("SHSHOP"))
                        .collect(Collectors.toSet());

        System.out.println(collect);
    }

    /**입력받은 문자가 어떠한 경우인지 확인하는 함수.
     *
     * @param s 접근한 문자
     * @return 어떤 처리를 할지 결정하는 정수형 분기값
     */
    public int chkValue(String s){
        int result;

        switch (s){
            //입력을 시작하는 경우
            case "FROM":
            case "JOIN": result = 0;
                break;

            //테이블의 이름을 작성하는 영역이 끝나는 부분.
            case "WHERE":
            case "DUAL":
            case "AND":
            case "ON": result = 1;
                break;

            //저장하지 않고 초기화 해야하는 경우
            case "SELECT":
            case "YYMM": result =2;
                break;

           //EXISTS 가 잇는 경우 같이 알림.
            case "EXISTS" :
                System.out.println("EXISTS 구분이 있습니다.");

            default: result = -1;
        }
        return result;
    }
}
