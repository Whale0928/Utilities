package User;

import InputUtils.InputText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * SGU에서 사용하기 위한 기능 모음
 */
public class SguApplication {
    static InputText in = new InputText();
    static SguApplication app = new SguApplication();

    public static void main(String[] args) {
        app.getTableNames();
    }

    /**
     * 텍스트 파일로 저장된 쿼리에서 . 테이블 이름만 추출하는 메서드
     */
    void getTableNames(){
        String str =  in.inputString("/Users/deadwhale/Downloads/QueryTxt.txt").toUpperCase();
        boolean flag = false;

        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" ");

        List<String> list = new ArrayList<>();
        for (String s : arr){
            if(s.equals("FROM")){
                flag = true;
                sb.delete(0,sb.length());
                continue;
            } else if(s.equals("WHERE")){
                list.add(sb.toString());
                flag = false;
                continue;
            }
            if(flag) sb.append(" ").append(s);
        }

        String[] sArr = list.toString().replaceAll(","," ").split(" ");
        Set<String> collect = Arrays.stream(sArr).filter(l -> l.length() > 2).collect(Collectors.toSet());

        System.out.println(collect);
    }
}
