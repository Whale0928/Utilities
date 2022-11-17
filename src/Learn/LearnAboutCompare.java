package Learn;

import java.util.*;

public class LearnAboutCompare implements Comparator<Box> {
    public static List<Box> boxes = new LinkedList<Box>();
    public LearnAboutCompare() {
        for(int i=0; i<15; i++){
            int rNumber = new Random().nextInt();
            Box box = new Box(String.valueOf(rNumber));
            boxes.add(box);
        }
    }
    @Override
    public int compare(Box o1, Box o2) {
        return 0;
    }


    //실행 클래스
    public static void main(String[] args) {
        new LearnAboutCompare();
        System.out.println(boxes);
    }
}
class Box{
    private Long boxNumber;
    private String boxName;
    private static Long seq = 0l;
    public Box() {
    }

    public Box(String boxName) {
        this.boxNumber = (++seq);
        this.boxName = boxName;
    }

    public Long getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(Long boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getBoxName() {
        return boxName;
    }

    public void setBoxName(String boxName) {
        this.boxName = boxName;
    }

    @Override
    public String toString() {
        return "Box{" +
                "boxNumber=" + boxNumber +
                ", boxName='" + boxName;
    }
}