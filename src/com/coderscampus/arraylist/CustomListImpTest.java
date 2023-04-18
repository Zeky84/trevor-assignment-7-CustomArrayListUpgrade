package com.coderscampus.arraylist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomListImpTest {

    @Test
    void should_add_item() {
        //Arrange
        CustomList<Integer> sutAddingOneItem = new CustomListImp<>();
        //Act
        for (int x = 0; x < 10; x++) {
            sutAddingOneItem.add(x);
        }
        sutAddingOneItem.remove(9);
        sutAddingOneItem.remove(7);
        sutAddingOneItem.add(1000);
        sutAddingOneItem.add(7,1001);
        sutAddingOneItem.add(7,1002);
        sutAddingOneItem.add(1003);
        sutAddingOneItem.add(1004);
        assertEquals(3, sutAddingOneItem.get(3));
        assertEquals(1002, sutAddingOneItem.get(7));
    }

    @Test
    void should_add_item_by_index() {
        //Arrange
        CustomList<Integer> sutAddingItemByIndex = new CustomListImp<>();
        //Act
        for (int x = 0; x < 5; x++) {
            sutAddingItemByIndex.add(x + 1);
        }
        //Checking the added item by index
        sutAddingItemByIndex.add(2, 23);
        assertEquals(sutAddingItemByIndex.get(2), 23);

        //Checking the list size
        assertEquals(sutAddingItemByIndex.getSize(), 6);

        //Checking the added item by index to the end
        sutAddingItemByIndex.add(6, 69);
        assertEquals(sutAddingItemByIndex.get(6), 69);


    }

    @Test
    void should_getSize_of_list() {
        //Arrange
        CustomList<Integer> ust = new CustomListImp<>();
        //Act
        for (int x = 0; x < 8; x++) {
            ust.add(x + 1);
        }
        //Returning the list size
        assertEquals(ust.getSize(), 8);
    }

    @Test
    void should_get_item() {
        //Arrange
        CustomList<Integer> ust = new CustomListImp<>();
        //Act
        for (int x = 0; x < 5; x++) {
            ust.add(x + 1);
        }
        //Getting an item from the list
        assertEquals(ust.get(4),5);
    }

    @Test
    void should_remove_item_by_index() {
        //Arrange
        CustomList<Integer> sutRemovingItem = new CustomListImp<>();
        //Act
        for (int x = 0; x < 13; x++) {
            sutRemovingItem.add(x + 1);
        }
        //Checking the list size after removing item
        sutRemovingItem.remove(2); // Removing item 3
        assertEquals(sutRemovingItem.getSize(), 12);

        //Getting the new item on index 2(4) to check items move to left after removing item
        assertEquals(sutRemovingItem.get(2), 4);

    }
}