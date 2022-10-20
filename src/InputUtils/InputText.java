package InputUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * 텍스트 파일을 입력받고 여러 종류별로 반환하는 메서드
 */
public class InputText {


    /**텍스트 파일을 읽어 한줄로 내보내는 기능
     * @param filePath 파일경로가 저장되있어야 한다.
     * @return 한줄로 정렬된 문자열
     */
    public String inputString(String filePath){
        String line = "";
        StringBuilder sb = new StringBuilder();
        File file = new File(filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.out.println("File Input Fail!!!");
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        InputText in = new InputText();
        String str =  in.inputString("/Users/deadwhale/Downloads/QueryTxt.txt");
        str = str.replace(",","");

        String[] arr = str.split("");
        for (String s : arr){
            System.out.println(s);
        }


    }


}

