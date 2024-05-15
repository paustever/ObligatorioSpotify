package TADS.Tree;

import TADS.LinkedList.src.MyList;
import TADS.LinkedList.src.LinkedList;


import java.util.*;

    public class Tree<K extends Comparable<K>, T> implements MyTree {
        private TreeNode<K, T> root;

        public Tree(TreeNode<K, T> root) {
            this.root = root;
        }

        public TreeNode<K, T> getRoot() {
            return root;
        }

        public void setRoot(TreeNode<K, T> root) {
            this.root = root;
        }

        @Override
        public Object find(Object key) {
            if (root == null) {
                return null;
            } else {
                if (root.findNode((K) key) != null) {
                    return root.findNode((K) key).getData();
                } else {
                    return null;
                }
            }
        }

        @Override
        public void insert(Object key, Object data, Object parentKey) throws HijosCompletosException {
            TreeNode<K, T> nuevonodo = new TreeNode<K, T>((K) key, (T) data, null, null);
            if (root == null) {
                setRoot(nuevonodo);
            } else {
                TreeNode<K, T> padre = root.findNode((K) key);
                if (padre.leftChild == null) {
                    padre.setLeftChild(nuevonodo);
                    return;
                } else {
                    if (padre.rightChild == null) {
                        padre.setRightChild(nuevonodo);
                        return;
                    }
                }
                throw new HijosCompletosException();
            }
        }

        @Override
        public void delete(Object key) {
            TreeNode<K, T> borrar = root.findNode((K) key);
            if (borrar != null) {
                TreeNode<K, T> ultimo = borrar.intercambiar();
                TreeNode<K, T> padre = borrar.buscarpadre(root);
                if (padre == null) {
                    root= null;
                } else {
                    if (padre.rightChild != null) {
                        padre.setLeftChild(padre.rightChild);
                        padre.setRightChild(null);
                    } else {
                        padre.setLeftChild(null);
                    }
                }
            }
        }

        @Override
        public int size() {
            int tam = 0;
            if (this.root == null) {
                return tam;
            } else {
                tam += this.root.suma(tam);
                tam++;

            }
            return tam;
        }

        @Override
        public int countLeaf() {
            int tam = 0;
            if (this.root == null) {
                return tam;
            } else {
                tam += 1;
                tam += root.contarhojas(tam);
            }
            return tam;
        }

        @Override
        public int countCompleteElements() {
            int cant = 0;
            if (root == null) {
                return cant;
            } else {
                return root.contarcompleto(cant);
            }
        }

        @Override
        public MyList inOrder() {
            List<K> milista = new ArrayList<>();
            if (root != null) {
                return root.inorder(milista);
            }
            return null;
        }

        @Override
        public MyList<K> preOrder() {
            MyList<K> milista = new LinkedList<>();
            if (root != null) {
                return root.preorder(milista);
            }
            return null;
        }


        @Override
        public MyList<K> postOrder() {
            MyList<K> milista = new LinkedList<>();
            if (root != null) {
                return root.postorder(milista);
            }
            return null;
        }

        @Override
        public MyList<K> pornivel() {
            MyList<K> milista = new LinkedList<>() ;
            if (root != null) {
                Queue<TreeNode<K, T>> cola = new LinkedList<>();
                TreeNode<K, T> temp;
                cola.offer(this.root);
                while (!cola.isEmpty()) {
                    temp = cola.poll();
                    milista.add(temp.getKey());
                    if (temp.getLeftChild() != null) {
                        cola.offer(temp.getLeftChild());
                        if (temp.getRightChild() != null) {
                            cola.offer(temp.getRightChild());
                        }
                    }
                }
            }return milista;
        }


    }



