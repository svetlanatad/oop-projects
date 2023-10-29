import java.util.ArrayList;

interface Graph<V extends Comparable<V>, E extends Comparable<E>> {


    // Make sure to impose appropriate bounds on V and E in this and subsequent classes. ?

     int numVertices();
     int numEdges();

    ArrayList<Vertex<V>> vertices();
    ArrayList<Edge<E>> edges();

    int outDegree(Vertex<V> v);
    int inDegree(Vertex<V> v);
    ArrayList<Edge<E>> outgoingEdges(Vertex<V> v);

    ArrayList<Edge<E>> incomingEdges(Vertex<V> v);
    Edge<E> getEdge(Vertex<V> u, Vertex<V> v);

    Vertex<V>[] endVertices(Edge<E> e);


    Vertex<V> opposite(Vertex<V> v, Edge<E> e);
    Vertex<V> insertVertex(V element);
    Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element);

    void removeVertex(Vertex<V> v);
    void removeEdge(Edge<E> e);





}
