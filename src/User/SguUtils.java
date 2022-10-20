package User;

import InputUtils.InputText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SguUtils {
    public static void main(String[] args) {
        InputText in = new InputText();
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
