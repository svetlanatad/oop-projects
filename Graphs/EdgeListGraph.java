import java.util.ArrayList;

public class EdgeListGraph<V extends Comparable<V>,E extends Comparable<E>> extends AbstractGraph<V, E> {




    @Override
    public int outDegree(Vertex<V> v) {
        int count = 0;
        for(Edge<E> element: this.edges()){
            if(((GraphEdge<E>) element).getSecond().equals(v) || ((GraphEdge<E>) element).getFirst().equals(v)){
                count++;
            }

        }
        return count;
    }

    @Override
    public int inDegree(Vertex<V> v) {
        int count = 0;
        for(Edge<E> element: this.edges()){
            if(((GraphEdge<E>)element).getSecond().equals(v) || ((GraphEdge<E>)element).getFirst().equals(v) ){
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
        Vertex<V>[] endVertices = (Vertex<V>[]) new Vertex[2];
        endVertices[1] = ((GraphEdge<E>)e).getFirst();
        endVertices[0] = ((GraphEdge<E>)e).getSecond();
        return endVertices;




    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        if(v.equals(((GraphEdge<E>)e).getFirst())){
            return ((GraphEdge<E>)e).getSecond();
        }
        return ((GraphEdge<E>)e).getFirst();
    }

    //insertVertex(V element) that inserts and returns a new vertex with the given element.
    //• insertEdge(Vertex<V> u, Vertex<V> v, E element) that inserts and returns a new edge between vertices u and v, storing the given element. An IllegalArgumentException is thrown in the case if an edge already exists between the given two vertices.
    //• removeVertex(Vertex<V> v) that removes the specified vertex v and all its incident edges from the graph.
    //• removeEdge(Edge<E> e) that removes the specified edge e from the graph.
    @Override
    public Vertex<V> insertVertex(V element) {
        Vertex<V> v = new GraphVertex<>(element);
        vertices().add(v);
        return v;

    }

    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) {

        if (getEdge(u, v) != null) {
            throw new IllegalArgumentException();
        }
        Edge<E> e = new GraphEdge(u, v, element);
        edges().add(e);

        return e;

    }

    @Override
    public void removeVertex(Vertex<V> v) {

        if (!vertices().contains(v)) {
            System.out.print("I'm confused, how do I remove a vertex which doesn't exist? 〣( ºΔº )〣");
        }
        ArrayList<Edge<E>> toRemoveEdges = new ArrayList<>();
        for (Edge<E> e : edges()) {
            if (((GraphEdge<E>)e).getFirst().equals(v) || ((GraphEdge<E>)e).getSecond().equals(v)) {
                toRemoveEdges.add(e);
            }
        }
        vertices().remove(v);
        edges().removeAll(toRemoveEdges);

    }

    @Override
    public void removeEdge(Edge<E> e) {

        if (!edges().contains(e)) {
            System.out.print("I'm confused, how do I remove an edge which doesn't exist? 〣( ºΔº )〣");
        }

        edges().remove(e);

    }
}
