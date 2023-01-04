package CompanyUtils.SGU;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LineSort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("D:\\BABAPRJ\\workspace\\Utilities\\src\\main\\java\\CompanyUtils\\SGU\\textFile.txt")
        );
        StringBuilder sb = lineSorting(reader);
        System.out.println(sb);
    }


    private static StringBuilder lineSorting(BufferedReader reader) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder();
        String tempStr;
        int rowCount =0;
        while (!(str = reader.readLine()).contains("SELECT")) {
            List<String> arr = Arrays.stream(str.split(",")).toList();
            for (String oneLine : arr) {
                if (oneLine.contains("(")) {
                    int wordIndex = oneLine.indexOf("(");
                    sb.append("         ").append(oneLine.substring(0, wordIndex).trim());
                    sb.append("\n").append("            ").append(oneLine.substring(wordIndex));
                } else {
                    if (!oneLine.trim().equals("")) {
                        sb.append("\n").append("             ,").append(oneLine);
                    }
                }
            }
        }
        boolean flag = false;
        tempStr = str;
        while ((str = reader.readLine()) != null) {
            if(rowCount == 0){
                str = tempStr+str;
                rowCount++;
            }

            List<String> arr = Arrays.stream(str.trim().split(",")).toList();

            for (String oneLine : arr) {
                if (oneLine.trim().equals("")) continue;
                if (oneLine.contains("DECODE")) {
                    int wordIndex = oneLine.indexOf("DECODE");
                    sb.append("         ").append(oneLine.substring(0, wordIndex).trim());
                    String decodeWord = oneLine.substring(wordIndex);
                    sb.append("\n           ").append(decodeWord);
                    flag = true;
                    continue;
                }

                if (flag) {
                    sb.append(",").append(oneLine);
                } else {
                    if (oneLine.contains("FROM") || oneLine.contains("WHERE") || oneLine.contains("ORDER")) {
                        sb.append("\n").append("           ").append(oneLine);
                    } else {
                        sb.append("\n").append("            ,").append(oneLine);
                    }
                }

                if (flag && oneLine.contains(")")) flag = false;
            }
        }
        return sb;
    }

}
