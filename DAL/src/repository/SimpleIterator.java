package repository;

import java.util.Iterator;

public class SimpleIterator<E> implements Iterator {
    private E[] array;
    private int currentSize;
    private int currentIndex;

    public SimpleIterator(E[] newArray) {
        this.array = newArray;
        this.currentSize = array.length;
    }
    @Override
    public boolean hasNext() {
        if(currentIndex < currentSize && array[currentIndex] != null){
            return true;
        }
        if(currentIndex < currentSize && array[currentIndex] == null){
            currentIndex++;
            return hasNext();
        }
        return false;
    }

    @Override
    public Object next() {
        return array[currentIndex++];
    }

    @Override
    public void remove() {
        Iterator.super.remove();
        //array[currentIndex] = null;
    }
}
