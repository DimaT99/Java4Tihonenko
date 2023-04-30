package repository;

public interface Repo<E> {
    int size();

    boolean isEmpty();

    E get(int index);

    void add(E element);

    void add(int index, E element);

    void remove(int index);
    void findAll();
}
