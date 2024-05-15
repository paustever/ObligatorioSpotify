package TADS.Tree;
import TADS.LinkedList.src.MyList;

    public interface MyBinarySearchTree <K extends Comparable<K>, T>{
        T findbus(K key);
        void insert (K key, T data);
        void delete (K key);
        MyList<K> inOrder();
        MyList<K>	preOrder();
        MyList<K>	postOrder();
    }

