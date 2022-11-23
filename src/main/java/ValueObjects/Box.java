package ValueObjects;

import java.util.Comparator;

public class Box  implements Comparator<Box>{
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
        return "boxNumber=" + boxNumber +
                ", boxName='" + boxName + "\n";
    }

    @Override
    public int compare(Box o1, Box o2) {
        return o1.getBoxName().compareTo(o2.getBoxName());
    }
}
