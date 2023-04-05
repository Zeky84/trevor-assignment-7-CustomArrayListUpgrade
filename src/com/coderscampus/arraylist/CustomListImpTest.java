package com.coderscampus.arraylist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomListImpTest {

    @Test
    void should_add_item() {
        //Arrange
        CustomList<Integer> testOneItem = new CustomListImp<>();
        //Act
        for (int x = 1; x < 12; x++) {
            testOneItem.add(x);
        }
        //Assert
        assertEquals(testOneItem.getSize(), 11);
        assertEquals(3, testOneItem.get(2));
    }

    @Test
    void should_add_item_by_index() {
        //Arrange
        CustomList<Integer> addingItemByIndex = new CustomListImp<>();
        //Act
        for (int x = 0; x < 5; x++) {
            addingItemByIndex.add(x + 1);
        }
        //Checking the added item by index
        addingItemByIndex.add(2, 23);
        assertEquals(addingItemByIndex.get(2), 23);

        //Checking the list size
        assertEquals(addingItemByIndex.getSize(), 6);

        //Checking the added item by index to the end
        addingItemByIndex.add(6, 69);
        assertEquals(addingItemByIndex.get(6), 69);

        //Adding item by index out of range (throws exception(returning false))
        assertFalse(addingItemByIndex.add(8, 23));
    }

    @Test
    void should_getSize_of_list() {
        //Arrange
        CustomList<Integer> myListToCheck = new CustomListImp<>();
        //Act
        for (int x = 0; x < 10; x++) {
            myListToCheck.add(x + 1);
        }
        //Returning the list size
        assertEquals(myListToCheck.getSize(), 10);
    }

    @Test
    void should_get_item() {
        //Arrange
        CustomList<Integer> myListToCheck = new CustomListImp<>();
        //Act
        for (int x = 0; x < 5; x++) {
            myListToCheck.add(x + 1);
        }
        //Getting item out of index.Catching the exception and returning null
        assertNull(myListToCheck.get(34));
    }

    @Test
    void should_remove_item_by_index() {
        //Arrange
        CustomList<Integer> removingItem = new CustomListImp<>();
        //Act
        for (int x = 0; x < 20; x++) {
            removingItem.add(x + 1);
        }
        //Checking the list size after removing item
        removingItem.remove(2); // Removing item 3
        assertEquals(removingItem.getSize(), 19);

        //Getting the new item on index 2(4) to check items move to left after removing item
        assertEquals(removingItem.get(2), 4);

        //Removing item out of the list range.Catching the exception and returning null.
        assertNull(removingItem.remove(24));


    }
}