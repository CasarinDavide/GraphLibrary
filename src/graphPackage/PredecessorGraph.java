package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Node.Node;

import java.util.*;

public class PredecessorGraph<NODE_VALUE,EDGE_TYPE extends Edge> implements Comparator{

    private Map<Node<NODE_VALUE>,PredecessorNode<NODE_VALUE,EDGE_TYPE>> predecessorNodeList;
    private Node<NODE_VALUE> source_index;

    public PredecessorGraph(List<Node<NODE_VALUE>> nodeList, Node<NODE_VALUE> source,Comparator<EDGE_TYPE> comparator)
    {
        Iterator<Node<NODE_VALUE>> it = nodeList.iterator();
        while (it.hasNext())
        {
            Node<NODE_VALUE> node = it.next();
            predecessorNodeList.put(node,new PredecessorNode<NODE_VALUE,EDGE_TYPE>(node,null,comparator));
            if (source.equals(node))
            {
                source_index = node;
            }
        }
    }

    public EDGE_TYPE getNodeKey(Node<NODE_VALUE> node)
    {
        return predecessorNodeList.get(node).getKey();
    }

    public void setNodeKey(Node<NODE_VALUE> node,EDGE_TYPE key)
    {
        predecessorNodeList.get(node).setKey(key);
    }

    public void setNodePredecessor(Node<NODE_VALUE> node,Node<NODE_VALUE> predecessor)
    {
        this.predecessorNodeList.get(node).setPredecessor(predecessor);
    }

    public Node<NODE_VALUE> getNodePredecessor(Node<NODE_VALUE> node)
    {
        return this.predecessorNodeList.get(node).getPredecessor();
    }

    public List<PredecessorNode<NODE_VALUE,EDGE_TYPE>> getNodeList()
    {
        List<PredecessorNode<NODE_VALUE,EDGE_TYPE>> list = new ArrayList<>();
        predecessorNodeList.forEach((k,v) -> list.add(v));
        return list;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof PredecessorNode && o2 instanceof PredecessorNode)
        {
            PredecessorNode<NODE_VALUE, EDGE_TYPE> edge1 = (PredecessorNode<NODE_VALUE, EDGE_TYPE>) o1;
            PredecessorNode<NODE_VALUE, EDGE_TYPE> edge2 = (PredecessorNode<NODE_VALUE, EDGE_TYPE>) o2;
            return edge1.compareTo(edge2);
        }
        else
            throw new RuntimeException("You have to provide two ProdecessorNode");

    }

    public PredecessorNode<NODE_VALUE,EDGE_TYPE> getMappedPredecessorNode(Node<NODE_VALUE> node)
    {
        return this.predecessorNodeList.get(node);
    }
}
