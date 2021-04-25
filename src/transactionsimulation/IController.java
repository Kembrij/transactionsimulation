package transactionsimulation;

public interface IController<T> {
    T getRandom();

    T getById(String st);

    void add(T accountable);
}
