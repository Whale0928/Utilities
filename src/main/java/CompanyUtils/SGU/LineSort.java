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

        StringBuilder sb = insertLineSorting(reader);

        System.out.println(sb);
    }

    private static StringBuilder insertLineSorting(BufferedReader reader) throws IOException {
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = reader.readLine()) != null) {
            List<String> arr = Arrays.stream(str.split(",")).toList();
            for (String oneLine : arr) {
                if (oneLine.contains("(")) {
                    int wordIndex = oneLine.indexOf("(");
                    sb.append(oneLine.substring(0, wordIndex).trim());
                    sb.append("\n").append(oneLine.substring(wordIndex));
                } else {
                    if (!oneLine.trim().equals("")) {
                        sb.append("\n").append(",").append(oneLine);
                    }
                }
            }
        }
        return sb;
    }
}
