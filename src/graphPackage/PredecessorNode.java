package graphPackage;

import graphPackage.Edge.Edge;
import graphPackage.Node.Node;

import java.util.Comparator;

public class PredecessorNode<NODE_VALUE,EDGE_VALUE extends Edge> implements Comparable<Object>{

    private Node<NODE_VALUE> predecessor;
    final public Node<NODE_VALUE> node;
    private final Comparator<EDGE_VALUE> comparator;

    private EDGE_VALUE key;

    public PredecessorNode(Node<NODE_VALUE> node,EDGE_VALUE key,Comparator<EDGE_VALUE> comparator)
    {
        this.node = node;
        predecessor = null;
        this.key = key;
        this.comparator = comparator;
    }


    public PredecessorNode(Node<NODE_VALUE> node,EDGE_VALUE key)
    {
        this.node = node;
        predecessor = null;
        this.key = key;
        comparator = null;
    }


    public void setPredecessor(Node<NODE_VALUE> predecessor) {
        this.predecessor = predecessor;
    }

    public void setKey(EDGE_VALUE key) {
        this.key = key;
    }

    public Node<NODE_VALUE> getPredecessor() {
        return predecessor;
    }

    public EDGE_VALUE getKey() {
        return key;
    }

    public Node<NODE_VALUE> getNode() {
        return node;
    }


    /**
     * PredecessorNode is initalized with a dummy value indicated with null
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Object o)
    {
        if(o instanceof PredecessorNode<?,?>)
        {
            PredecessorNode<NODE_VALUE, EDGE_VALUE> o1 = (PredecessorNode<NODE_VALUE, EDGE_VALUE>) o;

            if (this.getKey() == null && o1.getKey() == null)
                return 0;
            else if (this.getKey() == null)
                return 1;
            else if (o1.getKey() == null)
                return -1;

            Object key1 = this.getKey().getValue();
            Object key2 = o1.getKey().getValue();
            if (key1 instanceof Comparable<?> && key2 instanceof Comparable<?> && comparator == null)
            {
                return ((Comparable<Object>) key1).compareTo(key2);
            }
            else if (comparator != null)
            {
                return this.comparator.compare(this.getKey(),o1.getKey());
            }
            else
                throw new Error("Not comparable Object");

        }

        if (o instanceof Edge<?,?>)
        {

            EDGE_VALUE edge = (EDGE_VALUE) o;

            if (this.getKey() == null && edge.getValue() == null)
                return 0;
            else if (this.getKey() == null)
                return 1;
            else if (edge.getValue() == null)
                return -1;


            Object key1 = this.getKey().getValue();
            Object key2 = edge.getValue();
            if (key1 instanceof Comparable<?> && key2 instanceof Comparable<?> && comparator == null)
            {
                return ((Comparable<Object>) key1).compareTo(key2);
            }
            else if (comparator != null)
            {
                EDGE_VALUE edgeValue1 = this.getKey();
                return this.comparator.compare(edgeValue1,edge);
            }
            else
                throw new Error("Not comparable Object");

        }

        return 0;
    }


}
