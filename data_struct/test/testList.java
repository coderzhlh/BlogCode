package data_struct.test;

import data_struct.common.MyList;
import data_struct.list.MyArrayList;
import data_struct.list.MySingleLinkedList;

public class testList {
    public static void main(String[] args) {
        //testMyArrayList();
        testMySingleLinkedList();
    }

    public static void testMyList(MyList<Integer> list) {
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(0, 55);
        // [55, 11, 22, 33, 44]
        list.add(2, 66);
        // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77);
        // [55, 11, 66, 22, 33, 44, 77]
        list.remove(0);
        // [11, 66, 22, 33, 44, 77]
        list.remove(2);
        // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1);
        // [11, 66, 33, 44]
        System.out.println(list.indexOf(44) == 3);
        System.out.println(list.indexOf(22) == MyList.ELEMENT_NOT_FOUND_INDEX_RESULT);
        System.out.println(list.contains(33));
        System.out.println(list.get(0) == 11);
        System.out.println(list.get(1) == 66);
        System.out.println(list.get(list.size() - 1) == 44);
    }

    public static void testMyArrayList(){
        MyList<Integer> list = new MyArrayList<>();
        testMyList(list);
    }

    public static void testMySingleLinkedList(){
        MyList<Integer> list = new MySingleLinkedList<>();
        testMyList(list);
    }
}
