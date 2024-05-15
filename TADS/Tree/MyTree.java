package TADS.Tree;

import java.util.List;

    public interface MyTree<K, T>  {
        T find(K key);
        void insert (K key, T data, K parentKey) throws HijosCompletosException;
        void delete (K key);
        int size();
        int countLeaf();
        int countCompleteElements();
        List<K> inOrder();
        List<K>	preOrder();
        List<K>	postOrder();
        List<K> pornivel();
    }

