package TADS.Tree;
import java.util.List;
    public interface MyBinarySearchTree <K extends Comparable<K>, T>{
        T findbus(K key);
        void insert (K key, T data);
        void delete (K key);
        List<K> inOrder();
        List<K>	preOrder();
        List<K>	postOrder();
    }

