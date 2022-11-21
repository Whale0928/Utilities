package Learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyStack {
    List<Integer> stack = new ArrayList<>();

    /**스택에 삽입
     * Push.
     *
     * @param i the
     */
    public void push(Integer i) {
        stack.add(i);
    }

    /**스택이 비어있지 않은 경우 값을 추출
     * Pop integer.
     *
     * @return the integer
     */
    public Integer pop() {
        if (isEmpty()) return null;
        Integer result = stack.get(stack.size() - 1);
        stack.remove(stack.size()-1);
        return result;
    }

    /**스택의 값이 비어있는지 확인
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }


    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println(myStack); //null
        myStack.push(1);        //1,
        myStack.push(2);        //1,2
        myStack.push(3);        //1,2,3
        System.out.println(myStack);//1,2,3
        System.out.println(myStack.pop());//3
        System.out.println(myStack.pop());//2
        System.out.println(myStack.isEmpty());//false
        System.out.println(myStack.pop());//1
        System.out.println(myStack.isEmpty());//true

    }
}
