package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Node.Node;

import java.util.Iterator;
import java.util.List;

public abstract class Graph<NODE_VALUE_T,EDGE_VALUE_T,EDGE_TYPE extends Edge<EDGE_VALUE_T,NODE_VALUE_T>> implements GraphInterface<NODE_VALUE_T,EDGE_VALUE_T,EDGE_TYPE> {

    List<Node<NODE_VALUE_T>> nodesList;
    List<EDGE_TYPE> edgesList;

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

    @Override
    public boolean isSubGraph(Graph<NODE_VALUE_T, EDGE_VALUE_T, EDGE_TYPE> g2) {

        for (Node<NODE_VALUE_T> node: g2.nodesList) {
            if (!this.containsNode(node))
                return false;
        }

        for (EDGE_TYPE edge: g2.edgesList) {
            if (!this.containsEdge(edge))
                return false;
        }

        return true;

    }

    @Override
    public boolean isAcyclicGraph() {
        return false;
    }

    @Override
    public Graph<NODE_VALUE_T, EDGE_VALUE_T, EDGE_TYPE> union(Graph<NODE_VALUE_T, EDGE_VALUE_T, EDGE_TYPE> g2) {
        return null;
    }
}
