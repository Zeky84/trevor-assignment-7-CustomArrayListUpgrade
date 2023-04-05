package com.coderscampus.arraylist;

public class CustomListApp {
    public static void main(String[] args) throws Exception {
        CustomList<String> myStringListTest = new CustomListImp<>();

        myStringListTest.add("zero");
        myStringListTest.add("one");
        myStringListTest.add("two");
        myStringListTest.add("three");
        myStringListTest.add("four");
        myStringListTest.add("five");
        myStringListTest.add("six");
        myStringListTest.add("seven");
        myStringListTest.add("eight");
        myStringListTest.add("nine");
        myStringListTest.add("ten");
        myStringListTest.add(2, "Pete Carapetyan 2"); // adding item by index
        myStringListTest.add(3, "MANOLO MANOLO 3"); // adding item by index
        myStringListTest.add(0, "Roche :)");
        myStringListTest.remove(0); // removing item by index
        myStringListTest.remove(2); // removing item by index
        myStringListTest.get(25);// retrieving item from index 25. Does not exist. Throw IndexOutOfBound...
        myStringListTest.add(21, "Test to fail");//Adding item to index out of list range. Throw IndexOutOfBound...
        myStringListTest.remove(34);//Removing item out of range.Throw IndexOutOfBound...

        for (int x = 0; x < myStringListTest.getSize(); x++) {
            System.out.println(myStringListTest.get(x));
        }
        System.out.println();
        System.out.println("List length: " + myStringListTest.getSize());
    }
}