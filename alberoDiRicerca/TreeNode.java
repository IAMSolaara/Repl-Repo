/**
 * @author Ricco Davide
 * @version 0.1
 */

/* Progetto della classe TreeNode
 *
 * Attributi:
 * - val: int (svincolato)
 * - left: TreeNode
 * - right: TreeNode
 *
 * Metodi:
 * Costruttori:
 * + TreeNode (in val: int)
 * 
 * Accessori:
 * + getVal(): int
 * + getLeft(): TreeNode 
 * + getRight(): TreeNode
 *
 * Modificatori:
 * + setLeft(in tn: TreeNode): void
 * + setRight(in tn: TreeNode): void
 * + setVal(in val: int): void
 *
 * Altri metodi:
 * + toString(): String
 */

public class TreeNode {

	//Attributi
	private int val;
	private TreeNode left, right;

	//Costruttori
	/**
	 * Crea un' istanza di TreeNode
	 */
	public TreeNode(int val) {

		this.val = val;
		left = null;
		right = null;
	}

	//Accessori
	/**
	 * Restituisce il valore del TreeNode
	 * @return Valore del nodo
	 */
	public int getVal() {
		
		return val;
	}

	/**
	 * Restituisce il nodo sinistro
	 * @return Nodo sinistro
	 */
	public TreeNode getLeft() {
		
		return left;
	}

	/**
	 * Restituisce il nodo destro
	 * @return Nodo destro
	 */
	public TreeNode getRight() {
		
		return right;
	}

	/**
	 * Imposta il nodo sinistro
	 * @param tn Nodo sinistro da impostare
	 */
	public void setLeft(TreeNode tn) {

		left = tn;
	}

	/**
	 * Imposta il nodo destro
	 * @param tn Nodo destro da impostare
	 */
	public void setRight(TreeNode tn) {

		right = tn;
	}

	//Altri metodi
	/**
	 * Restituisce una stringa con lo stato dell'oggetto
	 * @return Stringa con lo stato dell'oggetto
	 */
	public String toString() {
		return ""+val;
	}
}