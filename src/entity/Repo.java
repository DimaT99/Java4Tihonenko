package entity;

import java.util.Arrays;

public class Repo<E> {
    private E[] entityArray;

    public E[] getEntityArray() {
        return entityArray;
    }

    public int size() {
        return entityArray.length;
    }

    public boolean isEmpty() {
        if (entityArray == null) {
            return true;
        }
        return false;
    }

    public E get(int index) {
        return entityArray[index];
    }

    public void addAll(E[] element) {
        entityArray = element;
    }

    public void add(E element) {
        if (isEmpty()) {
            return;
        } else {
            E[] entityArray1 = Arrays.copyOf(entityArray, (size() * 3) / 2 + 1);
            entityArray1[size()] = element;
            entityArray = entityArray1;
        }
    }

    public void add(int index, E element) {
        entityArray[index] = element;
    }

    public void remove(int index) {
        if (index < entityArray.length) {
            entityArray[index] = null;
        }
    }
}
