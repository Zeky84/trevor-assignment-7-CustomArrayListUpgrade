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
                Object[] itemsAfterNewItem = Arrays.copyOfRange(items, index, items.length);
                Object[] itemsBeforeNewItem = Arrays.copyOfRange(items, 0, index + 1);
                itemsBeforeNewItem[index] = item;
                items = Arrays.copyOf(itemsBeforeNewItem, itemsBeforeNewItem.length + itemsAfterNewItem.length + 1);
                size++;
                index = itemsBeforeNewItem.length;
                for (Object itemToAdd : itemsAfterNewItem) {
                    items[index] = itemToAdd;
                    index++;
                }
                return true;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e + "-> Index " + index + " out of the list range: 0-" + size);
            return false;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        try {
            if (index >= 0 && index <= size) {
                return (T) items[index];
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e + "-> Index " + index + " out of the list range: 0-" + size);
            return null;
        }

    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        try {
            if (index >= 0 && index <= size) {
                Object[] afterIndex = Arrays.copyOfRange(items, index + 1, items.length);
                Object[] beforeIndex = Arrays.copyOfRange(items, 0, index);
                items = Arrays.copyOf(beforeIndex, beforeIndex.length + afterIndex.length);
                size--;
                index = beforeIndex.length;
                for (Object itemToAdd : afterIndex) {
                    items[index] = itemToAdd;
                    index++;
                }
                return (T) items;
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e + "-> Index " + index + " out of the list range: 0-" + size);
            return null;
        }

    }


}
