package repository;

import entity.Additional;

import java.util.ArrayList;
import java.util.List;

public class AdditionalRepo implements Repo {
    final private static List<Additional> additionalArrayList = new ArrayList<>();
    private static Additional[] additionals;

    public static List<Additional> getAdditionals() {
        return additionalArrayList;
    }

    @Override
    public int size() {
        return additionalArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        if (additionalArrayList == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return additionalArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        additionalArrayList.add((Additional) element);
    }

    @Override
    public void add(int index, Object element) {
        additionalArrayList.set(index, (Additional) element);
    }

    @Override
    public void remove(int index) {
        additionalArrayList.remove(additionalArrayList.get(index));
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(additionalArrayList.toArray());
        Additional additional;
        while (simpleIterator.hasNext()) {
            additional = (Additional) simpleIterator.next();
            System.out.println(additional);
        }
        System.out.println("All additional materials");
        return;
    }
}
