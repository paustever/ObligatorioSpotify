package TADS.Tree;

import TADS.LinkedList.src.MyList;

import java.util.List;

    public interface MyTree<K, T>  {
        T find(K key);
        void insert (K key, T data, K parentKey) throws HijosCompletosException;
        void delete (K key);
        int size();
        int countLeaf();
        int countCompleteElements();
        MyList<K> inOrder();
        MyList<K>	preOrder();
        MyList<K>	postOrder();
        MyList<K> pornivel();
    }

