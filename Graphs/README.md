**Term/Year:** Fall 2022

**Subject Code and Course Number**: CS120 Intro to OOP, Sections B & D

**University and Faculty:** American University of Armenia, CSE

**Instructor name**  Monika Stepanyan

**Edge List and Adjacency List Graphs** Find how each representation of a graph looks like in graphs.png :)




**Vertex**:  This is a generic interface Vertex<V> that represents a vertex in a graph. Classes plugged in instead of V during instantiation are necessarily comparable. Any object of type Vertex is also comparable.
The interface includes:
• a method getElement() that returns the element associated with the vertex


**Edge**:  This is an interface Edge<E> that represents an edge in a graph. Classes plugged in instead of E during instantiation are necessarily comparable. Any object of type Edge is also comparable.
The interface includes:
• a method getElement() that returns the element associated with the edge
• a method swapEnds() that swaps the direction of the edge

**NotTraversableException** This class represents an exception to be thrown when a graph cannot be traversed. The class inherits from the Exception class. The class should include two constructors.


**Directed**:  This interface represents a property of being directed. The interface includes a method reverse() that reverses the direction of all edges in the graph.

**Graph**:  This generic interface Graph<V, E> represents a graph consisting of vertices and edges. The interface should includes the following methods:
• numVertices() that returns the number of vertices in the graph.
• numEdges() that returns the number of edges in the graph.
• vertices() that returns an ArrayList of vertices in the graph.
• edges() that returns an ArrayList of edges in the graph.
• outDegree(Vertex<V> v) that returns the number of edges leaving the specified vertex v.
• inDegree(Vertex<V> v) that returns the number of edges arriving at the specified vertex v.
• outgoingEdges(Vertex<V> v) that returns an ArrayList of edges for which vertex v is the origin.
• incomingEdges(Vertex<V> v) that returns an ArrayList of edges for which vertex v is the destination.
• getEdge(Vertex<V> u, Vertex<V> v) that returns the edge from vertex u to vertex v, or null if they are not adjacent.
• endVertices(Edge<E> e) that returns the vertices of edge e as an array of length two. If the graph is directed, the first vertex is the origin, and the second is the destination. If the graph is undirected, the order is not important.
• opposite(Vertex<V> v, Edge<E> e) that returns the vertex that is opposite of vertex v on edge e.
• insertVertex(V element) that inserts and returns a new vertex with the given element.
• insertEdge(Vertex<V> u, Vertex<V> v, E element) that inserts and returns a new edge between vertices u and v, storing the given element. An IllegalArgumentException is thrown in the case if an edge already exists between the given two vertices.
• removeVertex(Vertex<V> v) that removes the specified vertex v and all its incident edges from the graph.
• removeEdge(Edge<E> e) that removes the specified edge e from the graph.

**AbstractGraph**:  This generic abstract class AbstractGraph<V, E> implements the Graph<V, E> interface and includes attributes and functionality common far all graphs. The class has the following instance variables and methods:
• private ArrayList<Vertex<V>> vertices: an ArrayList of vertices in the graph • private ArrayList<Edge<E>> edges: an ArrayList of edges in the graph
• overridden numVertices()
• overridden numEdges()
• overridden vertices() • overridden edges()
The class also includes these inner classes:
• protected GraphVertex<V>: An inner class that implements the Vertex<V> interface. Each instance of this class represents a vertex in the graph and stores the vertex’s element of type V in the element instance variable. This class should include the following methods:
– A one-argument constructor
– getElement(): Returns the element stored in the vertex.
– toString(): Returns a string representation of the vertex’s element.
– compareTo(...): Compares this vertex’s element to another vertex’s element of the same
type V.
• protected GraphEdge<E>: An inner class that implements the Edge<E> interface. Each instance of this class represents an edge in the graph and stores element of type E in the instance variable element and two vertices first and second representing the endpoints of the edge. This class includes the following methods:
– A three-argument constructor
– getElement(): Returns the element stored in the edge.
– swapEnds(): Swaps the direction of the edge.
– getFirst(): Returns the first vertex of the edge.
– getSecond(): Returns the second vertex of the edge.
– String toString(): Returns a string representation of the edge’s element.
– compareTo(): Compares this edge’s element to another edge’s element of the same type E.

**EdgeListGraph**: This generic class EdgeListGraph<V, E>  represents a graph using an edge list structure. The class  extends the AbstractGraph<V, E>. The class also implements all the Graph methods not implemented in AbstractGraph.


**DirectedEdgeListGraph**: This class DirectedEdgeListGraph<V, E> extends EdgeListGraph<V, E> and implements the Directed interface. This class represents a directed graph, where each edge has a direction. The class  has the following methods:
• reverse(): Reverses the direction of all the edges in the graph. • overridden outDegree()
• overridden inDegree()
• overridden outgoingEdges()
• overridden incomingEdges()
• overridden endVertices() (if necessary)

**AdjacencyListGraph**: This generic class AdjacencyListGraph<V, E> represents a graph using an adjacency list structure. The class also extends the AbstractGraph<V, E>.
The class includes the following inner class:
• protected AdjacencyListVertex<V>: An inner class that extends GraphVertex<V>. Each instance of this class also keeps all the incident edges in an ArrayList<Edge<E>> called incidentCollection. This class should include the following methods:
– A one-argument constructor matching the super constructor
– getIncidentCollection(): Returns an ArrayList of edges incident to the vertex.
The class also implements all the Graph methods not implemented in AbstractGraph.

**DirectedAdjacencyListGraph**: This class DirectedAdjacencyListGraph<V, E> extends AdjacencyListGraph<V, E> and implements the Directed interface. The class has the following methods:
• reverse(): Reverses the direction of all the edges in the graph. • overridden outDegree()
• overridden inDegree()
• overridden outgoingEdges()
• overridden incomingEdges()
• overridden endVertices() (if necessary)
**Search**:  This interface Search that represents a traversal algorithm for a generic Graph. The interface
has one generic method:
• traverse(Graph<V, E> graph, Vertex<V> origin, ArrayList<Vertex<V>> visited, boolean toPrint): This method traverses the given graph starting from the origin vertex and puts
all visited vertices in the visited list. If toPrint is true, it prints out each visited vertex during traversal. If the graph is not traversable (there are no elements in it), it throws a NotTraversableException.
A traversal is a systematic procedure of examining (visiting) all the vertices of a graph.
**DepthFirstSearch**: This class implements the Search interface. This class performs a depth-first search traversal of a graph, starting at a given vertex. DFS works as follows:
• Begins at a specific starting vertex s in G, and “visits” it,
• the vertex s becomes the “current” vertex,
• traverses G by considering an arbitrary outgoing edge (u, v) incident to the current vertex u, • if the edge leads us to a vertex v that is already visited, we ignore that edge,
• else, we go to v and visit it (and continue this process until there are no more edges to visit).
The class should have the following methods:
• overridden traverse(...): that recursively traverses the graph in DFS manner.
• isConnected(Graph<V, E> graph) that returns true if the graph is connected, i.e., there is a path between every pair of vertices in the graph. The method should handle any NotTraversableException thrown by the traverse method.
To check if an undirected graph is connected, start DFS from any vertex, and if it visits all the vertices in the graph, then the graph is connected.
To check if a directed graph is strongly connected, start DFS from any vertex, and if it visits all the vertices in the graph, reverse the direction of all edges and rerun DFS from the same vertex. If DFS again manages to reach all vertices in the graph, then it is strongly connected.
