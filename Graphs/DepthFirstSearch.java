import java.util.ArrayList;

public class DepthFirstSearch implements Search {
    @Override
    public <V extends Comparable<V>, E extends Comparable<E>> void traverse(Graph<V, E> graph, Vertex<V> origin, ArrayList<Vertex<V>> visited, boolean toPrint) throws NotTraversableException {

        if (graph.numVertices() == 0 || graph.numEdges() == 0) {

            throw new NotTraversableException();

        } else {

            visited.add(origin);
            if (toPrint) {
                System.out.println(origin.toString());
            }
            for (Edge<E> element : graph.outgoingEdges(origin)) {
                Vertex<V> vertex = graph.opposite(origin, element);
                if (!visited.contains(vertex)) {
                    traverse(graph, vertex, visited, toPrint);
                }

            }

        }


    }

    public <V extends Comparable<V>, E extends Comparable<E>> boolean isConnected(Graph<V, E> graph) {

        Vertex<V> origin = graph.vertices().get(0);
        ArrayList<Vertex<V>> visited = new ArrayList<>();
        boolean toPrint = true;
        if(graph instanceof Directed){
            try{
                traverse(graph, origin, visited, toPrint);
            }catch(NotTraversableException e){
                System.out.println(e.getMessage());
            }

            if (visited.size() == graph.numVertices()) {
                for(Edge<E> element: graph.edges()){
                    element.swapEnds();
                }
                Vertex<V> newOrigin = graph.vertices().get(0);
                ArrayList<Vertex<V>> newVisited = new ArrayList<>();
                try{
                    traverse(graph, newOrigin, newVisited, toPrint);
                }catch(NotTraversableException ex){
                    System.out.println(ex.getMessage());
                }

                return visited.size() == graph.numVertices();
            }

        }else{
            try{
                traverse(graph, origin, visited, toPrint);
            }catch(NotTraversableException exc){
                System.out.println(exc.getMessage());
            }

            return visited.size() == graph.numVertices();

        }


        return false;

    }

    //Congratulations, you made it through checking my homework! ٩(◕‿◕｡)۶

    /*
    Painfully commenting out wrong code be like: (╥﹏╥)

    public <V extends Comparable<V>, E extends Comparable<E>> boolean isStronglyConnected(Graph<V, E> graph) throws NotTraversableException {

        try {
            for (Edge<E> element : graph.edges()) {
                if (element.getElement() == null) {
                    throw new NotTraversableException("so sad");
                }
            }
            for (Vertex<V> element : graph.vertices()) {
                if (element.getElement() == null) {
                    throw new NotTraversableException("so sad");
                }
            }
        } catch (Exception thrownObject) {
            System.out.println(thrownObject.getMessage());
        }
        Vertex<V> origin = graph.vertices().get(0);
        ArrayList<Vertex<V>> visited = new ArrayList<Vertex<V>>();
        boolean toPrint = true;
        traverse(graph, origin, visited, toPrint);
        if (visited.size() == graph.numVertices()) {
            //return true;
            for(Edge<E> element: graph.edges()){
                element.swapEnds();
            }
            Vertex<V> newOrigin = graph.vertices().get(0);
            ArrayList<Vertex<V>> newVisited = new ArrayList<Vertex<V>>();
            traverse(graph, newOrigin, newVisited, toPrint);
            if (visited.size() == graph.numVertices()) {
                return true;
            }
        }
        return false;
    }

     */
}
