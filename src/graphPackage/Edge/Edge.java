package graphPackage.Edge;

import graphPackage.Functions;
import graphPackage.Node.Node;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

public abstract class Edge<EDGE_VALUE_T,NODE_TYPE> extends AbstractEdge{

    protected EDGE_VALUE_T value;
    protected final Node<NODE_TYPE> node1;
    protected final Node<NODE_TYPE> node2;



    /**
     * Sorting the list in ascending order
     * @param edgeList
     * @return
     * @param <EDGE_VALUE_T>
     */

    public static<EDGE_VALUE_T> List<EDGE_VALUE_T> sortEdge(List<EDGE_VALUE_T> edgeList, Comparator<EDGE_VALUE_T> comparator)
    {
        List<EDGE_VALUE_T> edgeList1 = new ArrayList<>(edgeList);
        Functions.mergeSort(edgeList1,0,edgeList1.size()-1,comparator);
        return edgeList1;
    }
    public Edge(EDGE_VALUE_T value,Node<NODE_TYPE> node1, Node<NODE_TYPE> node2)
    {
        this.value = value;
        this.node1 = node1;
        this.node2 = node2;
    }

    public EDGE_VALUE_T getValue() {
        return value;
    }

    public void setValue(EDGE_VALUE_T value) {
        this.value = value;
    }


    public Node<NODE_TYPE> getNode1()
    {
        return this.node1;
    }

    public Node<NODE_TYPE> getNode2()
    {
        return this.node2;
    }


    abstract public boolean isStartNode(Node<NODE_TYPE> node);

    abstract public boolean isToNode(Node<NODE_TYPE> node);

    abstract public Node<NODE_TYPE> getToDestination(Node<NODE_TYPE> node);
}
