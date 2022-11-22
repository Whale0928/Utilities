package Learn;

import ValueObjects.Box;

import java.util.*;

public class LearnAboutCompare{
    public static List<Box> boxes = new LinkedList<Box>();
    public LearnAboutCompare() {
        for(int i=0; i<5; i++){
            int rNumber = new Random().nextInt(50);
            Box box = new Box(rNumber+"번 박스");
            boxes.add(box);
        }
    }


    //실행 클래스
    public static void main(String[] args) {
        LearnAboutCompare learnAboutCompare = new LearnAboutCompare();
        System.out.println(boxes);

        boxes.sort((o1, o2) -> {
            return o1.getBoxName().compareTo(o2.getBoxName());
        });
        System.out.println(boxes);
    }
}
