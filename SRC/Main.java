import org.w3c.dom.Node;

import java.util.LinkedList;


public class Main {

    public static void main(String[] args) {

        LinkedList<String> stringLinked = new LinkedList<>();
        stringLinked.addFirst("a");
        stringLinked.addLast("b");
        System.out.println("Начальный LinkedList " + stringLinked);
        stringLinked.addFirst("z");
        System.out.println("LinkedList после добавления элемента вначало " + stringLinked);
        System.out.println("Размер LinkedList: " + stringLinked.size());
        //System.out.println(stringLinked.getElementByIndex(2));




    }

}