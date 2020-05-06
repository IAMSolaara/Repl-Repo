/**
    @author Lorenzo Cauli
    @version 0.1
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
    - root: TreeNode

    + Albero()
    + caricaAlbero(in f: File): void
    - caricaAlbero(in sc: Scanner): void
    - insert(in node: TreeNode, v: int): void

    + toString(): String
    - toString(in node: TreeNode): String

    + visitaAnticipata(): String
    - visitaAnticipata(in node: TreeNode): String

    + visitaPosticipata(): String
    - visitaPosticipata(in node: TreeNode): String

    + contaFoglie(): int
    - contaFoglie(): int

    + contaFoglie(in node: TreeNode): int
    - contaFoglie(in node: TreeNode): int

    - ricerca(in node: TreeNode, query: int): TreeNode
*/
public class Albero {
    private TreeNode root;

    /**
        Costruttore
    */
    public Albero() {
        root = null;
    }

    /**
        Metodo pubblico che carica l'albero da un file
        @param f File input
    */
    public void caricaAlbero(File f) throws FileNotFoundException {
        try {
            Scanner sc = new Scanner(f);
            root = caricaAlbero(sc);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File non trovato.");
        } catch (NullPointerException e) {
            throw new NullPointerException("Errore lettura file.");
        }
    }

    /**
        Controparte privata caricaAlbero
        @param sc Scanner che itera sul file
    */
    private TreeNode caricaAlbero(Scanner sc) {
        TreeNode out = null;
        int next;
        boolean start = true;
        while (sc.hasNext()) {
            next = sc.nextInt();
            if (ricerca(out, next) == null) { //se il valore non esiste
                if (start) { // root
                    out = new TreeNode(next);
                    out.setLeft(null);
                    out.setRight(null);
                    start = false;
                } else {
                    insert(out, next);
                }
            }
        }
        return out;
    }

    /**
        Metodo che inserisce un nodo nell'albero col numero fornito
        @param node Radice sottoalbero dove inserire il numero
        @param v Numero da inserire
    */
    private void insert(TreeNode node, int v) {
        if (node !=  null) {
            if (v < node.getVal()) {        //se v minore allora sinistro
                if (node.getLeft() == null) {
                    node.setLeft(new TreeNode(v));
                    node.getLeft().setLeft(null);
                    node.getLeft().setRight(null);
                }
                else insert(node.getLeft(), v);
            }
            else {
                if (node.getRight() == null) {
                    node.setRight(new TreeNode(v));
                    node.getRight().setLeft(null);
                    node.getRight().setRight(null);
                }
                else insert(node.getRight(), v);
            }
        }
    }

    /**
        Metodo che fa visita anticipata
        @return stringa che raffigura l'albero con visita anticipata
    */  
    public String visitaAnticipata() {
        String out = "";
        out += visitaAnticipata(root);
        return out;
    }

    /**
        Controparte privata visitaAnticipata
    */
    private String visitaAnticipata(TreeNode node) {
        String out = "";
        if (node != null) {
            out += " " + node.toString() + " ";
            out += visitaAnticipata(node.getLeft());
            out += visitaAnticipata(node.getRight());
        }
        return out;
    }

    /**
        Metodo che fa visita simmetrica
        @return stringa che raffigura l'albero con visita simmetrica
    */  
    public String toString() {
        String out = "";
        out += toString(root);
        return out;
    }

    /**
        Controparte privata toString
    */
    private String toString(TreeNode node) {
        String out = "";
        if (node != null) {
            out += toString(node.getLeft());
            out += " " + node.toString() + " ";
            out += toString(node.getRight());
        }
        return out;
    }

    /**
        Metodo che fa visita posticipata
        @return stringa che raffigura l'albero con visita posticipata
    */  
    public String visitaPosticipata() {
        String out = "";
        out += visitaPosticipata(root);
        return out;
    }

    /**
        Controparte privata visitaPosticipata
    */
    private String visitaPosticipata(TreeNode node) {
        String out = "";
        if (node != null) {
            out += visitaPosticipata(node.getLeft());
            out += visitaPosticipata(node.getRight());
            out += " " + node.toString() + " ";
        }
        return out;
    }
    /**
        Metodo che conta le foglie
        @return numero delle foglie
    */
    public int contaFoglie() {
        int out = 0;
        out = contaFoglie(root);
        return out;
    }

    /**
        Controparte privata contaFoglie
    */
    private int contaFoglie(TreeNode node) {
        int out = 0;
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null)
                out = 1;
            else {
                out += contaFoglie(node.getLeft());
                out += contaFoglie(node.getRight());
            }
        }
        return out;
    }

    /**
        Metodo che conta i nodi
        @return numero dei nodi
    */
    public int contaNodi() {
        return contaNodi(root);
    }

    /**
        Controparte privata contaNodi
    */
    private int contaNodi(TreeNode node) {
        int out = 0;
        if (node != null) {
            out++;
            out += contaNodi(node.getLeft());
            out += contaNodi(node.getRight());
        }
        return out;
    }

    /**
        Metodo che cerca un valore nell'albero
        @param node Radice sottoalbero dove cercare il numero
        @param v Numero da cercare
    */
    private TreeNode ricerca(TreeNode node, int query) {
        TreeNode out = null;
        if (node != null) {
            if (node.getVal() == query) out = node;
            else if (query < node.getVal()) {
                out = ricerca(node.getLeft(), query);
            }
            else {
                out = ricerca(node.getRight(), query);
            }
        }
        return out;
    }
}