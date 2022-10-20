package InputUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 텍스트 파일을 입력받고 여러 종류별로 반환하는 메서드
 */
public class InputText {


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
                line=  line.replace("\n","").replace("\r","").replace("\t","");
                sb.append(" ").append(line);
                //체인 append 호출로 변환되었다.
            }
        } catch (IOException e) {
            System.out.println("File Input Fail!!!");
            e.printStackTrace();
        }
        line = sb.toString().replace("[^a-zA-Z]"," ");
        return line;
    }


}

