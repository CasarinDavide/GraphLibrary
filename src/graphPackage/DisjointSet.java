package graphPackage;

import java.util.Collection;

public interface DisjointSet<ELEMENT_TYPE> {

    public ELEMENT_TYPE findSet(ELEMENT_TYPE element);
    public void unionSet(ELEMENT_TYPE element1,ELEMENT_TYPE element2);

    public void makeSet(ELEMENT_TYPE element);





}
