import java.util.ArrayList;

public class AdjacencyListGraph<V extends Comparable<V>, E extends Comparable<E>> extends AbstractGraph<V, E> {

    protected class AdjacencyListVertex<V extends Comparable<V>> extends GraphVertex<V> {
        private ArrayList<Edge<E>> incidentCollection;

        //introduce  the or in the if
        public AdjacencyListVertex(V element) {

            super(element);
            incidentCollection = new ArrayList<>();
        }

        public ArrayList<Edge<E>> getIncidentCollection() {
            return incidentCollection;
        }
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        Vertex<V> v = new AdjacencyListVertex<>(element);
        vertices().add(v);
        return v;
    }


    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) {
        if (getEdge(u, v) != null) {
            throw new IllegalArgumentException();
        }
        Edge<E> e = new GraphEdge<E>(u, v, element);
        edges().add(e);
        ((AdjacencyListVertex<V>) u).incidentCollection.add(e);
        ((AdjacencyListVertex<V>) v).incidentCollection.add(e);
        return e;
    }

    @Override
    public void removeVertex(Vertex<V> v) {
        for (Edge<E> e : ((AdjacencyListVertex<V>) v).incidentCollection) {
            removeEdge(e);
        }
        vertices().remove(v);
    }

    @Override
    public void removeEdge(Edge<E> e) {
        Vertex<V>[] endpoints = endVertices(e);
        ((AdjacencyListVertex<V>) endpoints[0]).incidentCollection.remove(e);
        ((AdjacencyListVertex<V>) endpoints[1]).incidentCollection.remove(e);
        edges().remove(e);
    }

    @Override
    public int outDegree(Vertex<V> v) {
        int count = 0;
        for(Edge<E> element: ((AdjacencyListVertex<V>)v).incidentCollection ){
            if(((GraphEdge<E>) element).getSecond().equals(v) || ((GraphEdge<E>) element).getFirst().equals(v)){
                count++;
            }

        }
        return count;
    }

    @Override
    public int inDegree(Vertex<V> v) {
        int count = 0;
        for(Edge<E> element: ((AdjacencyListVertex<V>)v).incidentCollection ){
            if(((GraphEdge<E>) element).getSecond().equals(v) || ((GraphEdge<E>) element).getFirst().equals(v)){
                count++;
            }

        }
        return count;
    }

    @Override
    public ArrayList<Edge<E>> outgoingEdges(Vertex<V> v) {
        ArrayList<Edge<E>> outgoingEdges = new ArrayList<>();
        for (Edge<E> element : this.edges()) {
            if (((GraphEdge<E>) element).getSecond().equals(v) || ((GraphEdge<E>) element).getFirst().equals(v)) {
                outgoingEdges.add(element);
            }
        }
        return outgoingEdges;
    }

    @Override
    public ArrayList<Edge<E>> incomingEdges(Vertex<V> v) {
        ArrayList<Edge<E>> incomingEdges = new ArrayList<>();
        for (Edge<E> element : this.edges()) {
            if (((GraphEdge<E>) element).getSecond().equals(v) || ((GraphEdge<E>) element).getFirst().equals(v)) {
                incomingEdges.add(element);
            }
        }
        return incomingEdges;
    }

    @Override
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        for (Edge<E> element : this.edges()) {
            if (((GraphEdge<E>) element).getFirst().equals(u) && ((GraphEdge<E>) element).getSecond().equals(v)) {
                return element;
            }

        }
        return null;
    }

    @Override
    public Vertex<V>[] endVertices(Edge<E> e) {
        return new Vertex[]{

                ((GraphEdge<E>) e).getFirst(), ((GraphEdge<E>) e).getSecond()
        };
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        if(v.equals(((GraphEdge<E>)e).getFirst())){
            return ((GraphEdge<E>)e).getSecond();
        }
        return ((GraphEdge<E>)e).getFirst();
    }
}
