public interface Edge<E extends Comparable<E>> extends Comparable<Edge<E>>{


    E getElement();
    void swapEnds();

}
