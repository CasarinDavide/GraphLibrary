package graphPackage;

import java.util.*;

public class DisjointSetTree<ELEMENT_TYPE> implements DisjointSet<ELEMENT_TYPE>{


    private final Map<ELEMENT_TYPE,ELEMENT_TYPE> elements;
    private final Map<ELEMENT_TYPE,Integer> ranks;

    public DisjointSetTree()
    {
        elements = new HashMap<>();
        ranks = new HashMap<>();
    }

    public DisjointSetTree(Collection<ELEMENT_TYPE> collection)
    {
        this();

        Iterator<ELEMENT_TYPE> it = collection.iterator();
        while (it.hasNext())
        {
            ELEMENT_TYPE element = it.next();
            elements.put(element,element);
            ranks.put(element,0);
        }
    }

    @Override
    public ELEMENT_TYPE findSet(ELEMENT_TYPE element) {

        if (elements.get(element).equals(element))
            return element;
        else
        {
            ELEMENT_TYPE parent = findSet(elements.get(element));
            elements.put(element,parent);
            return elements.get(element);
        }
    }

    @Override
    public void unionSet(ELEMENT_TYPE element1,ELEMENT_TYPE element2) {

        ELEMENT_TYPE parent1 = findSet(element1);
        ELEMENT_TYPE parent2 = findSet(element2);

        if (parent1 == parent2)
            return;

        if (ranks.get(parent1) > ranks.get(parent2))
        {
            elements.put(parent1,parent2);
            ranks.put(parent2,ranks.get(parent2) + ranks.get(parent1) + 1);
        }
        else
        {
            elements.put(parent2,parent1);
            ranks.put(parent1,ranks.get(parent1) + ranks.get(parent2) + 1);
        }
    }

    @Override
    public void makeSet(ELEMENT_TYPE element)
    {
        ranks.put(element,0);
        elements.put(element,element);
    }

}
