package graphPackage.Node;

public class Node<T>  extends AbstractNode{

    private final T identifier;

    public Node(T identifier)
    {
        this.identifier = identifier;
    }

    @Override
    public int hashCode() {

        /* TODO IMPLEMENT HASHCODE */
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Node<?>)
        {
            return ((Node<?>) obj).identifier.equals(this.identifier);
        }

        return false;
    }

}
