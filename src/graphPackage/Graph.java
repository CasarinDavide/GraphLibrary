package graphPackage;

import java.util.ArrayList;
import java.util.List;

public abstract class Graph<U extends Node,E extends Branches<U>> implements GraphInterface<U,E>{

    protected List<U> _nodes;
    protected List<E> _branches;

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
