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
            Object[] afterIndex = Arrays.copyOfRange(items, index, items.length - 1);
            Object[] beforeIndex = Arrays.copyOfRange(items, 0, index + 1);
            beforeIndex[index] = item;
            items = Arrays.copyOf(beforeIndex, items.length);
            index = beforeIndex.length;
            System.arraycopy(afterIndex, 0, items, index + 0, afterIndex.length);

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
            System.arraycopy(afterIndex, 0, items, index + 0, afterIndex.length);

            size--;
            return (T) items[index];
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }
}
