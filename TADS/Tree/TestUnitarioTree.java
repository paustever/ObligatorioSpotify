package TADS.Tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

    public class TestUnitarioTree <K extends Comparable<K>,T>{
        @Test
        public void insertbinary() {
            TreeNode<Integer, String> raiz = new TreeNode<>(5, "A", null, null);
            MyBinarySearchTree miarbolbi = new BinarySearchTree(raiz);
            miarbolbi.insert(2, "B");
            miarbolbi.insert(8, "C");
            miarbolbi.insert(9, "D");
            miarbolbi.insert(5, "E");
            miarbolbi.insert(1, "F");
            miarbolbi.insert(7, "G");
            List<Integer> resultado1 = miarbolbi.inOrder();
            List<Integer> expected1 = Arrays.asList(1, 2, 5, 7, 8, 9);
            assertEquals(expected1.size(), resultado1.size());
            assertEquals(expected1, resultado1);
        }
        @Test
        public void findbinary() {
            TreeNode<Integer, String> raiz = new TreeNode<>(5, "A", null, null);
            MyBinarySearchTree miarbolbi2 = new BinarySearchTree(raiz);
            miarbolbi2.insert(2, "B");
            miarbolbi2.insert(8, "C");
            miarbolbi2.insert(9, "D");
            miarbolbi2.insert(5, "E");
            miarbolbi2.insert(1, "F");
            miarbolbi2.insert(7, "G");
            String resultado= (String) miarbolbi2.findbus(2);
            String expected="B";
            assertEquals(expected, resultado);
        }

        @Test
        public void deleteraizbinary(){
            TreeNode<Integer, String> raiz = new TreeNode<>(5, "A", null, null);
            MyBinarySearchTree miarbolbi3 = new BinarySearchTree(raiz);
            miarbolbi3.insert(2, "B");
            miarbolbi3.insert(8, "C");
            miarbolbi3.insert(9, "D");
            miarbolbi3.insert(5, "E");
            miarbolbi3.insert(1, "F");
            miarbolbi3.insert(7, "G");
            miarbolbi3.delete(5);
            List<Integer> resultado3 = miarbolbi3.inOrder();
            List<Integer> expected3 = Arrays.asList(2,1,7,8,9);
            assertEquals(expected3.size(), resultado3.size());
            assertEquals(expected3, resultado3);

        }

        @Test
        public void deleteUnHijobinary(){
            TreeNode<Integer, String> raiz = new TreeNode<>(5, "A", null, null);
            MyBinarySearchTree miarbolbi3 = new BinarySearchTree(raiz);
            miarbolbi3.insert(2, "B");
            miarbolbi3.insert(8, "C");
            miarbolbi3.insert(9, "D");
            miarbolbi3.insert(5, "E");
            miarbolbi3.insert(1, "F");
            miarbolbi3.insert(7, "G");
            miarbolbi3.delete(2);
            List<Integer> resultado3 = miarbolbi3.inOrder();
            List<Integer> expected3 = Arrays.asList(1,5,7,8,9);
            assertEquals(expected3, resultado3);
        }

        @Test
        public void deleteDosHijosbinary(){
            TreeNode<Integer, String> raiz = new TreeNode<>(5, "A", null, null);
            MyBinarySearchTree miarbolbi3 = new BinarySearchTree(raiz);
            miarbolbi3.insert(2, "B");
            miarbolbi3.insert(8, "C");
            miarbolbi3.insert(9, "D");
            miarbolbi3.insert(5, "E");
            miarbolbi3.insert(1, "F");
            miarbolbi3.insert(7, "G");
            miarbolbi3.delete(8);
            List<Integer> resultado3 = miarbolbi3.inOrder();
            List<Integer> expected3 = Arrays.asList(1,2,5,9,7);
            assertEquals(expected3, resultado3);
        }

        @Test
        public void deleteNoExistebinary(){
            TreeNode<Integer, String> raiz = new TreeNode<>(5, "A", null, null);
            MyBinarySearchTree miarbolbi3 = new BinarySearchTree(raiz);
            miarbolbi3.insert(2, "B");
            miarbolbi3.insert(8, "C");
            miarbolbi3.insert(9, "D");
            miarbolbi3.insert(5, "E");
            miarbolbi3.insert(1, "F");
            miarbolbi3.insert(7, "G");
            miarbolbi3.delete(4);
            List<Integer> resultado3 = miarbolbi3.inOrder();
            List<Integer> expected3 = Arrays.asList(1,2,5,7,8,9);
            assertEquals(expected3, resultado3);
        }

        @Test
        public void InsertTree() throws HijosCompletosException {
            TreeNode<Integer, String> raiz = new TreeNode<>(1, "A", null, null);
            Tree<Integer,String> miarbol=new Tree<>(raiz);
            miarbol.insert(2,"B",1);
            miarbol.insert(3,"C",1);
            miarbol.insert(3,"Z",2);
            miarbol.insert(8,"Z",1);
            List<Integer> result =miarbol.inOrder();
            List<Integer> expected=Arrays.asList(2,1,3);
            assertEquals(expected, result);
        }

        @Test
        public void FindTree() throws HijosCompletosException {
            TreeNode<Integer, String> raiz = new TreeNode<>(1, "A", null, null);
            Tree<Integer,String> miarbol=new Tree<>(raiz);
            miarbol.insert(2,"B",1);
            miarbol.insert(3,"C",1);
            String result= (String) miarbol.find(2);
            String expected="B";
            assertEquals(expected,result);
            String result1= (String) miarbol.find(5);
            String expected1=null;
            assertEquals(expected1,result1);
        }

        @Test
        public void DeleteTree() throws HijosCompletosException {
            TreeNode<Integer, String> raiz = new TreeNode<>(1, "A", null, null);
            Tree<Integer,String> miarbol=new Tree<>(raiz);
            miarbol.insert(2,"B",1);
            miarbol.insert(3,"C",1);
            miarbol.insert(4,"D",2);
            miarbol.insert(5,"E",2);
            miarbol.insert(6,"F",4);
            miarbol.delete(3);
            List<Integer> result =miarbol.inOrder();
            List<Integer> expected=Arrays.asList(6,4,2,5,1);
            assertEquals(expected, result);
            miarbol.delete(2);
            List<Integer> result1 =miarbol.inOrder();
            List<Integer> expected1=Arrays.asList(6,4,5,1);
            assertEquals(expected1, result1);
        }

        @Test
        public void SizeTree() throws HijosCompletosException {
            TreeNode<Integer, String> raiz = new TreeNode<>(1, "A", null, null);
            Tree<Integer,String> miarbol=new Tree<>(raiz);
            miarbol.insert(2,"B",1);
            miarbol.insert(3,"C",1);
            Integer resultado= miarbol.size();
            Integer expected=3;
            assertEquals(resultado,expected);
        }







    }
