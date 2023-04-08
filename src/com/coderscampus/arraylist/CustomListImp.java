package com.coderscampus.arraylist;

import java.util.Arrays;
import java.lang.IndexOutOfBoundsException;

public class CustomListImp<T> implements CustomList<T> {
    Object[] items = new Object[10];

    int size = 0;

    @Override
    public boolean add(T item) {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        items[size] = item;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T item) throws IndexOutOfBoundsException {
        try {
            if (index >= 0 && index <= size) {
                Object[] itemsAfterNewItem = Arrays.copyOfRange(items, index, size);
                Object[] itemsBeforeNewItem = Arrays.copyOfRange(items, 0, index + 1);
                itemsBeforeNewItem[index] = item;
                items = Arrays.copyOf(itemsBeforeNewItem, itemsBeforeNewItem.length + itemsAfterNewItem.length);
                index = itemsBeforeNewItem.length;
                for (Object itemToAdd : itemsAfterNewItem) {
                    items[index] = itemToAdd;
                    index++;
                }
                size++;
                return true;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e + "-> Index: " + index + " out of list range: " + items.length);
            return false;
        }
    }

    @Override
    public int getSize() {
        items = Arrays.copyOf(items, size);
        return items.length;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        try {
            items = Arrays.copyOf(items, size);
            return (T) items[index];

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        try {
            if (index >= 0 && index < size) {
                Object[] afterIndex = Arrays.copyOfRange(items, index + 1, size);
                Object[] beforeIndex = Arrays.copyOfRange(items, 0, index);
                items = Arrays.copyOf(beforeIndex, beforeIndex.length + afterIndex.length);
//                index = beforeIndex.length;
                for (Object itemToAdd : afterIndex) {
                    items[index] = itemToAdd;
                    index++;
                }
                size--;
                return (T) items;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e + "-> Index: " + index + " out of list range: " + items.length);
            return null;
        }
    }
}
