package TADS.Tree;
import TADS.LinkedList.src.MyList;

import java.util.Objects;


public class TreeNode<K extends Comparable <K>,T> {
        K key;
        T data;
        TreeNode<K, T> leftChild;
        TreeNode<K, T> rightChild;

        public TreeNode(K key, T data, TreeNode<K, T> leftChild, TreeNode<K, T> rightChild) {
            this.key = key;
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }


        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public TreeNode<K, T> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode<K, T> leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode<K, T> getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode<K, T> rightChild) {
            this.rightChild = rightChild;
        }

        public TreeNode<K, T> findNode(K key) {
            if (this.getKey().equals(key)) {
                return this;
            } else {
                if (this.leftChild != null) {
                    TreeNode<K, T> hijoizq = this.leftChild;
                    if (hijoizq.findNode(key) != null) {
                        return hijoizq;
                    }
                }
                if (this.rightChild != null) {
                    TreeNode<K, T> hijoder = this.rightChild;
                    if (hijoder.findNode(key) != null) {
                        return hijoder;
                    }
                }
                ;
            }
            return null;
        }

        public TreeNode<K, T> buscarpadre(TreeNode<K, T> raiz) {
            TreeNode<K, T> padre = null;
            if (this.equals(raiz)) {
                return null;
            } else {
                if (raiz.leftChild != null) {
                    if (raiz.leftChild.equals(this)) {
                        return raiz;
                    }}
                if (raiz.rightChild != null) {
                    if (raiz.rightChild.equals(this)) {
                        return raiz;
                    }}
                if (raiz.leftChild != null) {
                    padre=this.buscarpadre(raiz.leftChild);}
                if (raiz.rightChild != null && padre==null) {
                    padre =this.buscarpadre(raiz.rightChild);}
            }
            return padre;
        }




        public TreeNode<K, T> intercambiar () {
            if (this.leftChild != null) {
                K llave = this.getKey();
                T valor = this.getData();
                this.setData(this.leftChild.getData());
                this.setKey(this.getLeftChild().getKey());
                this.leftChild.setData(valor);
                this.leftChild.setKey(llave);
                this.leftChild.intercambiar();
            }
            return this;
        }


        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode<?, ?> node = (TreeNode<?, ?>) o;
            return Objects.equals(key, node.key);
        }

        public int suma ( int tam){
            if (this.leftChild != null) {
                tam++;
                this.leftChild.suma(tam);
                if (this.rightChild != null) {
                    this.rightChild.suma(tam);
                }
            }
            return tam;
        }

        public int contarhojas ( int tam){
            if (this.leftChild != null) {
                tam += this.leftChild.contarhojas(tam);
                if (this.rightChild != null)
                    tam += this.rightChild.contarhojas(tam);
            } else {
                tam++;
            }
            return tam;
        }

        public int contarcompleto ( int tam){
            if (this.leftChild != null) {
                tam += this.leftChild.contarcompleto(tam);
                if (this.rightChild != null) {
                    tam += this.getRightChild().contarcompleto(tam);
                    tam++;
                }
            }
            return tam;
        }

        public MyList<K> inorder (MyList < K > milista) {
            if (this.leftChild != null) {
                this.leftChild.inorder(milista);
            }
            milista.add(this.getKey());
            if (this.rightChild != null) {
                this.rightChild.inorder(milista);
            }
            return milista;
        }

        public MyList<K> postorder (MyList < K > milista) {
            if (this.leftChild != null) {
                this.leftChild.postorder(milista);
            }
            if (this.rightChild != null) {
                this.rightChild.postorder(milista);
            }
            milista.add(this.getKey());
            return milista;
        }

        public MyList<K> preorder (MyList < K > milista) {
            milista.add(this.getKey());
            if (this.leftChild != null) {
                this.leftChild.preorder(milista);
            }
            if (this.rightChild != null) {
                this.rightChild.preorder(milista);
            }
            return milista;
        }

        public TreeNode<K, T> findNodeBus (K mikey){
            if (this.getKey().equals(mikey)) {
                return this;
            } else {
                TreeNode<K, T> minodo = null;
                if (mikey.compareTo(this.getKey()) < 0) {
                    if (this.getLeftChild() != null) {
                        minodo = this.getLeftChild().findNodeBus(mikey);
                    }
                }
                if (mikey.compareTo(this.getKey()) > 0) {
                    if (this.getRightChild() != null) {
                        minodo = this.getRightChild().findNodeBus(mikey);
                    }
                }
                return minodo;
            }
        }

        public void agregar (TreeNode< K, T > nuevonodo){
            if (nuevonodo.getKey().compareTo(this.getKey()) < 0) {
                if (this.getLeftChild() != null) {
                    this.getLeftChild().agregar(nuevonodo);
                } else {
                    this.setLeftChild(nuevonodo);
                    return;
                }
            }
            if (nuevonodo.getKey().compareTo(this.getKey()) > 0) {
                if (this.getRightChild() != null) {
                    this.getRightChild().agregar(nuevonodo);
                } else {
                    this.setRightChild(nuevonodo);
                }
            }
        }
        public TreeNode<K, T> buscarChico () {
            if (this.getLeftChild() != null) {
                return this.getLeftChild().buscarChico();
            }
            return this;
        }

    public MyList<K> porNivel(MyList<K> milista){
        if (this.leftChild!=null){
            milista.add(this.leftChild.getKey());
            if (this.rightChild!=null){
                milista.add(this.rightChild.getKey());
                this.leftChild.porNivel(milista);
                this.rightChild.porNivel(milista);
            }
        }
        return milista;
}
    }



