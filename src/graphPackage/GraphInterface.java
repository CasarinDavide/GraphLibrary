package graphPackage;

import java.util.List;

public interface GraphInterface<U extends Node,E extends Branches<U>> {

    void addNode(U node);
    void addAllNodes(List<U> nodes);
    void deleteNode(U node);
    void addBranch(E branch);
    void addAllBranches(List<E> branches);

    void deleteBranch(E branches);
}
