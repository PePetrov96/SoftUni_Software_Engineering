package manager;

public interface DbContext<E> {
    boolean persist(E entity);
    Iterable<E> find(Class<E> table);
    Iterable<E> find(Class<E> table, String where);
    E findFirst(Class<E> table);
    E findFirst(Class<E> table, String where);
    void doCreate(Class<E> entityClass);
    void doAlter(E entity);
}