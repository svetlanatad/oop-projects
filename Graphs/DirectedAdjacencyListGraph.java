import java.util.ArrayList;

public class DirectedAdjacencyListGraph<V extends Comparable<V>,E extends Comparable<E>> extends AdjacencyListGraph<V, E> implements Directed{
    @Override
    public void reverse() {
        for (Edge<E> e : this.edges()) {
            e.swapEnds();
        }
    }
    public int inDegree(Vertex<V> v) {
        int count = 0;
        for (Edge<E> e : this.edges()) {
            if (((GraphEdge<E>) e).getSecond().equals(v)) {
                count++;
            }
        }
        return count;

    }
    public int outDegree(Vertex<V> v) {
        int count = 0;
        for (Edge<E> e : this.edges()) {
            if (((GraphEdge<E>) e).getFirst().equals(v)) {
                count++;
            }
        }
        return count;
    }
    public ArrayList<Edge<E>> outgoingEdges(Vertex<V> v) {
        ArrayList<Edge<E>> outgoing = new ArrayList<>();
        for (Edge<E> e : this.edges()) {
            if (((GraphEdge<E>) e).getFirst().equals(v)) {
                outgoing.add(e);
            }
        }
        return outgoing;
    }
    public ArrayList<Edge<E>> incomingEdges(Vertex<V> v) {
        ArrayList<Edge<E>> incoming = new ArrayList<>();
        for (Edge<E> e : this.edges()) {
            if (((GraphEdge<E>) e).getSecond().equals(v)) {
                incoming.add(e);
            }
        }
        return incoming;
    }
    public Vertex<V>[] endVertices(Edge<E> e) {

        Vertex<V>[] endVertices = (Vertex<V>[]) new Vertex[2];
        endVertices[0] = ((GraphEdge<E>)e).getFirst();
        endVertices[1] = ((GraphEdge<E>)e).getSecond();
        return endVertices;
    }



}
