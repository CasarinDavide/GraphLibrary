package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Node.Node;

import java.util.*;

public abstract class Graph<NODE_VALUE_T,EDGE_VALUE_T,EDGE_TYPE extends Edge<EDGE_VALUE_T,NODE_VALUE_T>> implements GraphInterface<NODE_VALUE_T,EDGE_VALUE_T,EDGE_TYPE> {

    List<Node<NODE_VALUE_T>> nodesList = new ArrayList<>();
    List<EDGE_TYPE> edgesList = new ArrayList<>();

    public Graph()
    {

    }

    public Graph(List<Node<NODE_VALUE_T>> nodes, List<EDGE_TYPE> edges)
    {
        this(nodes);
        this.edgesList.addAll(edges);
    }


    public Graph(List<Node<NODE_VALUE_T>> nodes)
    {
        this.nodesList.addAll(nodes);
    }


    @Override
    public void addNodes(Node<NODE_VALUE_T> node) {
        this.nodesList.add(node);
    }

    @Override
    public Node<NODE_VALUE_T> removeNodes(Node<NODE_VALUE_T> node) {

        Iterator<Node<NODE_VALUE_T>> it = this.nodesList.iterator();
        while(it.hasNext())
        {
            Node<NODE_VALUE_T> tmp = it.next();
            if (tmp.equals(node))
            {
                it.remove();
                return tmp;
            }
        }

        return null;
    }

    @Override
    public boolean containsNode(Node<NODE_VALUE_T> node) {

        for (Node<NODE_VALUE_T> tmp : this.nodesList) {
            if (tmp.equals(node)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void addEdge(EDGE_TYPE edge) {
        this.edgesList.add(edge);
    }

    @Override
    public EDGE_TYPE removeEdge(EDGE_TYPE edge) {

        Iterator<EDGE_TYPE> edgeTypeIterator = this.edgesList.iterator();
        while (edgeTypeIterator.hasNext())
        {
            var tmp = edgeTypeIterator.next();
            if (tmp.equals(edge))
            {
                edgeTypeIterator.remove();
                return tmp;
            }
        }

        return null;
    }

    @Override
    public void setEdgeWeight(EDGE_TYPE edge, EDGE_VALUE_T value) {
        for (EDGE_TYPE tmp : this.edgesList) {
            if (tmp.equals(edge)) {
                tmp.setValue(value);
            }
        }

    }

    @Override
    public boolean containsEdge(EDGE_TYPE edge) {

        for (Edge<?,?> edgeInList : this.edgesList)
        {
            if (edgeInList.equals(edge))
                return true;
        }

        return false;

    }


    /**
     * subgraph given G(V,E) G'(V',E') is subgraph iff V' ⊆ V and E' ⊆ V' x V'
     * @param g2 graph(V,E)
     * @return
     */
    @Override
    public boolean isSubGraph(Graph<NODE_VALUE_T, EDGE_VALUE_T, EDGE_TYPE> g2) {

        for (Node<NODE_VALUE_T> node: g2.nodesList) {
            if (!this.containsNode(node))
                return false;
        }

        for(EDGE_TYPE edge : g2.edgesList)
        {
            if(!g2.nodesList.contains(edge.getNode1()) || !g2.nodesList.contains(edge.getNode2()))
                return false;
        }

        return true;

    }

    @Override
    public boolean isAcyclicGraph() {

        Map<Node<NODE_VALUE_T>,Boolean> visitedMap = new HashMap<>();

        for (Node<NODE_VALUE_T> node: this.nodesList) {
            visitedMap.put(node,false);
        }

        Queue<Node<NODE_VALUE_T>> nodeQueue = new LinkedList<>();


        for (Node<NODE_VALUE_T> node: this.nodesList) {
            nodeQueue.add(node);
            visitedMap.put(node,true);

            for (EDGE_TYPE edge : this.edgesList) {
                if (edge.isStartNode(node)) {
                    Node<NODE_VALUE_T> neighbor = edge.getToDestination(node);
                    if (!visitedMap.get(neighbor)) {
                        visitedMap.put(neighbor, true);
                        nodeQueue.add(neighbor);
                    }
                    else
                        return false;
                }
            }
        }

        return true;
    }

    public int getConnectedComponentCount()
    {
        Map<Node<NODE_VALUE_T>,Boolean> visitedMap = new HashMap<>();
        int connectedComponent = 0;
        for (Node<NODE_VALUE_T> node: this.nodesList)
        {
            visitedMap.put(node,false);
        }

        for (Node<NODE_VALUE_T> node: this.nodesList) {
            if (!visitedMap.get(node))
            {
                breadthFirstSearch(node,visitedMap);
                connectedComponent++;
            }
        }

        return connectedComponent;
    }

    @Override
    public void breadthFirstSearch(Node<NODE_VALUE_T> node, Map<Node<NODE_VALUE_T>, Boolean> visitedMap)
    {
        Queue<Node<NODE_VALUE_T>> queue = new LinkedList<>();
        queue.add(node);
        visitedMap.put(node, true);

        while (!queue.isEmpty()) {
            Node<NODE_VALUE_T> currentNode = queue.poll();
            // Traverse all edges of the current node
            for (EDGE_TYPE edge : this.edgesList) {
                if (edge.isStartNode(currentNode)) {
                    Node<NODE_VALUE_T> neighbor = edge.getToDestination(currentNode);
                    if (!visitedMap.get(neighbor)) {
                        visitedMap.put(neighbor, true);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }


    @Override
    public int getNodeDegree(Node<NODE_VALUE_T> node) {

        int degree = 0;
        for (EDGE_TYPE edge: this.edgesList) {
            if (edge.isStartNode(node))
                degree++;
        }

        return degree;
    }


    /**
     * @return -1 if the graph is not a regular graph otherwise returns the k-value that makes the graph regular
     */
    @Override
    public int isRegularGraph() {

        int n = -1, m = -1;
        for (int i = 0; i < this.nodesList.size()-1;i++)
        {
            n = getNodeDegree(nodesList.get(i));
            m = getNodeDegree(nodesList.get(i + 1));

            if (n != m)
                return -1;
        }
        return n;
    }

    @Override
    public List<Node<NODE_VALUE_T>> getAllIsolatedVertex() {

        List<Node<NODE_VALUE_T>> isolated_vertex = new ArrayList<>();

        for (Node<NODE_VALUE_T> node: nodesList) {

            if (getNodeDegree(node) == 0)
                isolated_vertex.add(node);
        }

        return isolated_vertex;
    }


    public List<Node<NODE_VALUE_T>> getAllAdjacentNode(Node<NODE_VALUE_T> node)
    {
        List<Node<NODE_VALUE_T>> adjList = new ArrayList<>();
        for (EDGE_TYPE edge: this.edgesList) {
            if (edge.isStartNode(node))
                adjList.add(edge.getToDestination(node));
        }

        return adjList;
    }


    public List<EDGE_TYPE> getAllAdjacentEdge(Node<NODE_VALUE_T> node)
    {
        List<EDGE_TYPE> adjList = new ArrayList<>();
        for (EDGE_TYPE edge: this.edgesList) {
            if (edge.isStartNode(node))
                adjList.add(edge);
        }
        return adjList;
    }

    @Override
    public List<Node<NODE_VALUE_T>> getAllNodes() {
        return this.nodesList;
    }

    @Override
    public List<EDGE_TYPE> getAllEdges() {
        return this.edgesList;
    }
}
