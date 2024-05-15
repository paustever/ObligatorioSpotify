package TADS.Tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import TADS.LinkedList.src.LinkedList;
import TADS.LinkedList.src.MyList;
import org.junit.jupiter.api.Test;


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
            MyList<Integer> resultado = miarbolbi.inOrder();
            MyList<Integer> expected = new LinkedList<>();
            expected.add(1);
            expected.add(2);
            expected.add(5);
            expected.add(7);
            expected.add(8);
            expected.add(9);
            assertEquals(expected.size(), resultado.size());
            for(int i=0;i<=expected.size();i++){
                assertEquals(expected.get(i), resultado.get(i));
            }
        }
        @Test
        public void findbinary() {
            TreeNode<Integer, String> raiz = new TreeNode<>(5, "A", null, null);
            MyBinarySearchTree miarbolbi = new BinarySearchTree(raiz);
            miarbolbi.insert(2, "B");
            miarbolbi.insert(8, "C");
            miarbolbi.insert(9, "D");
            miarbolbi.insert(5, "E");
            miarbolbi.insert(1, "F");
            miarbolbi.insert(7, "G");
            String resultado= (String) miarbolbi.findbus(2);
            String expected="B";
            assertEquals(expected, resultado);
        }

        @Test
        public void deleteraizbinary(){
            TreeNode<Integer, String> raiz = new TreeNode<>(5, "A", null, null);
            MyBinarySearchTree miarbolbi = new BinarySearchTree(raiz);
            miarbolbi.insert(2, "B");
            miarbolbi.insert(8, "C");
            miarbolbi.insert(9, "D");
            miarbolbi.insert(5, "E");
            miarbolbi.insert(1, "F");
            miarbolbi.insert(7, "G");
            miarbolbi.delete(5);
            MyList<Integer> resultado = miarbolbi.inOrder();
            MyList<Integer> expected = new LinkedList<>();
            expected.add(2);
            expected.add(1);
            expected.add(7);
            expected.add(8);
            expected.add(9);
            assertEquals(expected.size(), resultado.size());
            for(int i=0;i<=expected.size();i++){
                assertEquals(expected.get(i), resultado.get(i));
            }


        }

        @Test
        public void deleteUnHijobinary(){
            TreeNode<Integer, String> raiz = new TreeNode<>(5, "A", null, null);
            MyBinarySearchTree miarbolbi = new BinarySearchTree(raiz);
            miarbolbi.insert(2, "B");
            miarbolbi.insert(8, "C");
            miarbolbi.insert(9, "D");
            miarbolbi.insert(5, "E");
            miarbolbi.insert(1, "F");
            miarbolbi.insert(7, "G");
            miarbolbi.delete(2);
            MyList<Integer> resultado = miarbolbi.inOrder();
            MyList<Integer> expected = new LinkedList<>();
            expected.add(1);
            expected.add(5);
            expected.add(7);
            expected.add(8);
            expected.add(9);
            assertEquals(expected.size(), resultado.size());
            for(int i=0;i<=expected.size();i++){
                assertEquals(expected.get(i), resultado.get(i));
            }
        }

        @Test
        public void deleteDosHijosbinary(){
            TreeNode<Integer, String> raiz = new TreeNode<>(5, "A", null, null);
            MyBinarySearchTree miarbolbi = new BinarySearchTree(raiz);
            miarbolbi.insert(2, "B");
            miarbolbi.insert(8, "C");
            miarbolbi.insert(9, "D");
            miarbolbi.insert(5, "E");
            miarbolbi.insert(1, "F");
            miarbolbi.insert(7, "G");
            miarbolbi.delete(8);
            MyList<Integer> resultado = miarbolbi.inOrder();
            MyList<Integer> expected = new LinkedList<>();
            expected.add(1);
            expected.add(2);
            expected.add(5);
            expected.add(9);
            expected.add(7);
            assertEquals(expected.size(), resultado.size());
            for(int i=0;i<=expected.size();i++){
                assertEquals(expected.get(i), resultado.get(i));
            }
        }

        @Test
        public void deleteNoExistebinary(){
            TreeNode<Integer, String> raiz = new TreeNode<>(5, "A", null, null);
            MyBinarySearchTree miarbolbi = new BinarySearchTree(raiz);
            miarbolbi.insert(2, "B");
            miarbolbi.insert(8, "C");
            miarbolbi.insert(9, "D");
            miarbolbi.insert(5, "E");
            miarbolbi.insert(1, "F");
            miarbolbi.insert(7, "G");
            miarbolbi.delete(4);
            MyList<Integer> resultado = miarbolbi.inOrder();
            MyList<Integer> expected = new LinkedList<>();
            expected.add(1);
            expected.add(2);
            expected.add(5);
            expected.add(7);
            expected.add(8);
            expected.add(9);
            assertEquals(expected.size(), resultado.size());
            for(int i=0;i<=expected.size();i++){
                assertEquals(expected.get(i), resultado.get(i));
            }
        }

        @Test
        public void InsertTree() throws HijosCompletosException {
            TreeNode<Integer, String> raiz = new TreeNode<>(1, "A", null, null);
            Tree<Integer,String> miarbol=new Tree<>(raiz);
            miarbol.insert(2,"B",1);
            miarbol.insert(3,"C",1);
            miarbol.insert(3,"Z",2);
            miarbol.insert(8,"Z",1);
            MyList<Integer> resultado =  miarbol.inOrder();
            MyList<Integer> expected= new LinkedList<>();
            expected.add(2);
            expected.add(1);
            expected.add(3);
            assertEquals(expected.size(), resultado.size());
            for(int i=0;i<=expected.size();i++){
                assertEquals(expected.get(i), resultado.get(i));
            }
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
            MyList<Integer> result =  miarbol.inOrder();
            MyList<Integer> expected= new LinkedList<>();
            expected.add(6);
            expected.add(4);
            expected.add(2);
            expected.add(5);
            expected.add(1);
            assertEquals(expected, result);
            miarbol.delete(2);
            expected.remove(2);
            result=miarbol.inOrder();
            assertEquals(expected, result);
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
