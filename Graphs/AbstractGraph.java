import java.util.ArrayList;

public abstract class AbstractGraph<V extends Comparable<V>,E extends Comparable<E>> implements Graph<V,E> {

    private ArrayList<Vertex<V>> vertices;
    private ArrayList<Edge<E>> edges;

    public int numVertices(){
        return vertices.size();

    }
    public int numEdges(){
        return edges.size();
    }
    public ArrayList<Vertex<V>> vertices(){
        return vertices;
    }

    public ArrayList<Edge<E>> edges(){
        return edges;
    }


    protected class GraphVertex<V extends Comparable<V>> implements Vertex<V>{

        private V element;
        public GraphVertex(V element){

            this.element = element;
        }

        @Override
        public V getElement() {
            return element;
        }
        public String toString(){
            return element.toString();
        }

        @Override
        public int compareTo(Vertex<V> o) {
            return this.element.compareTo(((GraphVertex<V>)o).element);
        }
    }

    protected class GraphEdge<E extends Comparable<E>> implements Edge<E>{

        private E element;

        private Vertex<V> first;
        private Vertex<V> second;

        public GraphEdge(Vertex<V> first, Vertex<V> second, E element){
            this.element = element;
            this.first = first;
            this.second = second;


        }
        public Vertex<V> getFirst(){ return first;}
        public Vertex<V> getSecond(){ return second;}

        @Override
        public E getElement() {
            return element;
        }

        @Override
        public void swapEnds() {

            Vertex<V> someV =  second;
            second = first;
            first = someV;


        }
        public String toString(){
            return element.toString();
        }

        @Override
        public int compareTo(Edge<E> o) {
            return  this.element.compareTo(((GraphEdge<E>)o).element);
        }
    }
}
