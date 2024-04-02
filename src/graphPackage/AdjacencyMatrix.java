package graphPackage;

import java.util.List;
import java.util.Map;

public class AdjacencyMatrix<V extends Node, E extends Branches<V>> implements AdjacencyMatrixInterface<V,E>{

    Map<Integer,Node> nodeToIndex;
    List<List<E>> matrix;

    @Override
    public void addNodeToList(V node) {

    }

    @Override
    public void addBranchToAdjMatrix(E branch) {

    }

    @Override
    public Integer getNodeIndex() {

        return 0;
    }

    @Override
    public E getBranch(V node1, V node2) {
        return null;
    }
}
