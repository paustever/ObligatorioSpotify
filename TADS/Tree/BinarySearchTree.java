package TADS.Tree;

import java.util.ArrayList;
import java.util.List;

    public class BinarySearchTree <K extends Comparable<K>, T> implements MyBinarySearchTree {
        private TreeNode<K, T> root;

        public BinarySearchTree(TreeNode<K, T> root) {
            this.root = root;
        }
        public TreeNode<K, T> getRoot() {
            return root;
        }

        public void setRoot(TreeNode<K, T> root) {
            this.root = root;
        }

        @Override
        public Object findbus(Comparable key) {
            if (root == null) {
                return null;
            } else {
                if (root.findNodeBus((K) key)!=null) {
                    return root.findNodeBus((K) key).getData();
                }else{
                    return null;
                }
            }
        }

        public Object findNodo(Comparable key) {
            if (root == null) {
                return null;
            } else {
                if (root.findNodeBus((K) key)!=null) {
                    return root.findNodeBus((K) key);
                }else{
                    return null;
                }
            }
        }

        @Override
        public void insert(Comparable key, Object data) {
            TreeNode<K, T> nuevonodo = new TreeNode<K, T>((K) key, (T) data, null, null);
            if(root==null){
                root=nuevonodo;
                return;
            }
            if(this.findbus(key)==null) {
                root.agregar(nuevonodo);
            }
        }

        @Override
        public void delete(Comparable key) {
            TreeNode<K,T> nodoBorrar= (TreeNode<K, T>) this.findNodo(key);
            if(nodoBorrar!=null) {
                TreeNode<K,T> padre=nodoBorrar.buscarpadre(root);
                if(nodoBorrar.getLeftChild()==null && nodoBorrar.getRightChild()==null) {
                    if (padre == null) {
                        root = null;
                    } else {
                        if (key.compareTo(padre.getKey()) < 0) {
                            padre.setLeftChild(null);
                        } else padre.setRightChild(null);
                    }

                }else{if (nodoBorrar.getLeftChild()==null && nodoBorrar.getRightChild()!=null){
                    if (padre==null) {
                        root = nodoBorrar.getRightChild();
                    }else{
                        if(key.compareTo(padre.getKey())<0) {
                            padre.setLeftChild(nodoBorrar.getRightChild());
                        }else{
                            padre.setRightChild(nodoBorrar.getRightChild());
                        }
                    }
                }else{
                    if(nodoBorrar.getRightChild()==null && nodoBorrar.getLeftChild()!=null) {
                        if (padre == null) {
                            root = nodoBorrar.getLeftChild();
                        } else {
                            if (key.compareTo(padre.getKey()) < 0) {
                                padre.setLeftChild(nodoBorrar.getLeftChild());
                            } else {
                                padre.setRightChild(nodoBorrar.getLeftChild());
                            }
                        }
                    } else{
                        TreeNode<K,T> chico=nodoBorrar.buscarChico();
                        TreeNode<K,T> padreChico=chico.buscarpadre(root);
                        if(chico.getRightChild()==null){
                            if(padreChico.getRightChild()!=null){
                                padreChico.setLeftChild(padreChico.rightChild);
                                padreChico.setRightChild(null);
                            }else {
                                padreChico.setLeftChild(null);
                            }
                        }else{
                            padreChico.setLeftChild(chico.getRightChild());
                        }
                        nodoBorrar.setKey(chico.getKey());
                        nodoBorrar.setData(chico.getData());

                    }
                }
                }

            }else{
                System.out.println("El nodo a eliminar no existe");
            }
        }

        @Override
        public List inOrder() {
            List<K> milista = new ArrayList<>();
            if (root != null) {
                return root.inorder(milista);
            }
            return null;
        }

        @Override
        public List preOrder() {
            List<K> milista = new ArrayList<>();
            if (root != null) {
                return root.preorder(milista);
            }
            return null;
        }

        @Override
        public List postOrder() {
            List<K> milista = new ArrayList<>();
            if (root != null) {
                return root.postorder(milista);
            }
            return null;
        }
    }



