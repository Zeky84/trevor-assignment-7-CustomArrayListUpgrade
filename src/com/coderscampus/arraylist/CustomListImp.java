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
        if (index >= 0 && index <= size) {
            if (size == items.length) {
                items = Arrays.copyOf(items, items.length * 2);
            }
            Object[] itemsAfterNewItem = Arrays.copyOfRange(items, index, items.length - 1);
            Object[] itemsBeforeNewItem = Arrays.copyOfRange(items, 0, index + 1);
            itemsBeforeNewItem[index] = item;
            items = Arrays.copyOf(itemsBeforeNewItem, items.length);
            index = itemsBeforeNewItem.length;
            for (int x = 0; x < itemsAfterNewItem.length; x++) {
                items[index + x] = itemsAfterNewItem[x];
            }

            size++;
            return true;
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index <= size) {
            return (T) items[index];
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Object[] afterIndex = Arrays.copyOfRange(items, index + 1, items.length);
            Object[] beforeIndex = Arrays.copyOfRange(items, 0, index);
            items = Arrays.copyOf(beforeIndex, items.length);
            for (Object itemToAdd : afterIndex) {
                items[index] = itemToAdd;
                index++;
            }
            size--;
            return (T) items[index];
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }
}
