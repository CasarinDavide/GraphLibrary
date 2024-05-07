package graphPackage;

import graphPackage.Edge.Edge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Functions {


    public static<VALUE_TYPE extends Comparable<VALUE_TYPE>,T extends List<VALUE_TYPE>> void merge(T list,int start,int q, int end)
    {
        List<VALUE_TYPE> l = new ArrayList<>();
        List<VALUE_TYPE> r = new ArrayList<>();

        for (int i = start; i < q; i++) {
            l.add(list.get(i));
        }

        for (int i = q; i < end; i++) {
            r.add(list.get(i));
        }

        int inserted_l = 0;
        int inserted_r = 0;
        int inserted = 0;

        while (inserted_l < l.size() && inserted_r < r.size()) {
            if (l.get(inserted_l).compareTo(r.get(inserted_r)) <= 0) {
                inserted_r++;
                list.set(inserted,r.get(inserted_r));
            } else {
                inserted_l++;
                list.set(inserted,l.get(inserted_l));
            }
            inserted++;
        }

        while (inserted_l < l.size())
        {
            list.set(inserted,l.get(inserted_l));
            inserted++;
            inserted_l++;
        }

        while (inserted_r < r.size())
        {
            list.set(inserted,r.get(inserted_r));
            inserted++;
            inserted_r++;
        }
    }
    public static<VALUE_TYPE extends Comparable<VALUE_TYPE>,T extends List<VALUE_TYPE>> void mergeSort(T list,int start, int end)
    {
        if (start >= end)
        {
            return;
        }
        else
        {
            int q = (start + end) / 2;
            mergeSort(list,start,q);
            mergeSort(list,q,end);
            merge(list,start,q,end);
        }
    }

    public static<VALUE_TYPE,T extends List<VALUE_TYPE>> void mergeSort(T list, int start, int end, Comparator<VALUE_TYPE> comparator)
    {
        if (start >= end)
        {
            return;
        }
        else
        {
            int q = (start + end) / 2;
            mergeSort(list,start,q,comparator);
            mergeSort(list,q,end,comparator);
            merge(list,start,q,end,comparator);
        }
    }


    public static<VALUE_TYPE,T extends List<VALUE_TYPE>> void merge(T list,int start,int q, int end,Comparator<VALUE_TYPE> comparator)
    {
        List<VALUE_TYPE> l = new ArrayList<>();
        List<VALUE_TYPE> r = new ArrayList<>();

        for (int i = start; i < q; i++) {
            l.add(list.get(i));
        }

        for (int i = q; i < end; i++) {
            r.add(list.get(i));
        }

        int inserted_l = 0;
        int inserted_r = 0;
        int inserted = 0;


        while (inserted_l < l.size() && inserted_r < r.size()) {
            if (comparator.compare(l.get(inserted_l),r.get(inserted_r)) <= 0) {
                inserted_r++;
                list.set(inserted,r.get(inserted_r));
            } else {
                inserted_l++;
                list.set(inserted,l.get(inserted_l));
            }
            inserted++;
        }

        while (inserted_l < l.size())
        {
            list.set(inserted,l.get(inserted_l));
            inserted++;
            inserted_l++;
        }

        while (inserted_r < r.size())
        {
            list.set(inserted,r.get(inserted_r));
            inserted++;
            inserted_r++;
        }
    }



}
