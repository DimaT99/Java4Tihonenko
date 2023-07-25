package repository;

import org.springframework.stereotype.Component;

@Component
public interface Repo<E> {
    int size();

    boolean isEmpty();

    E get(int index);

    void add(E element);

    void add(int index, E element);

    void remove(int index);

    void findAll();

    boolean save(E element);

    E getById(Integer id);

    boolean update(E element);

    boolean delete(E element);
}
