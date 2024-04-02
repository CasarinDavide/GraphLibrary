package graphPackage;
import java.util.List;

public abstract class Graph<U extends Node,E extends Branches<U>> implements GraphInterface<U,E>{

    // TODO togliamo le due liste e gestiamo tutto con la matrice di adiacenza?
    protected List<U> _nodes;
    protected List<E> _branches;
    protected AdjacencyMatrix<U,E> _adjacencyMatrix;

    // farei matrice di adiancenza posizionale non per indice ma per reference dell istanza.
    // ad esempio:
    // A[nodeI][nodeJ] nove nodeI e nodeJ sono instanze della classe graph.
    // questo per accedere comunque in O(1)
    // se facciamo matrice di adiacenza a questo punto non so quanto senso abbia avere all'interno della classe anche gli archi.

    @Override
    public void addNode(U node) {
        _nodes.add(node);
    }

    @Override
    public void addAllNodes(List<U> nodes) {
        for (U node: nodes)
        {
            this.addNode(node);
        }
    }

    @Override
    public void addBranch(E branch) {
        this._branches.add(branch);
    }


    @Override
    public void addAllBranches(List<E> branches) {
        for (E branch: branches)
        {
            this.addBranch(branch);
        }
    }

    @Override
    public void deleteNode(U node) {
        // TODO
    }

}
