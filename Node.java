/**
 * Class to implement a node which can be used in linked list, doubly linked
 * list and trees.
 * 
 * @author Saurabh
 *
 */
public class Node {
	long data;
	Node next;
	Node prev;
	Node left;
	Node right;
	Node random;
	Node[] children;

	/**
	 * @param data
	 */
	public Node(long data) {
		super();
		this.data = data;
		this.next = null;
		this.prev = null;
		this.left = null;
		this.right = null;
		this.random = null;
		this.children = null;
	}

	/*
	 * java.lang.Object#toString() method overridden. This display the linked
	 * list and doubly linked list elements. Does not work with trees.
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(data);
		if (random != null)
			buffer.append("(" + random.data + ")");
		Node head = next;
		while (head != null) {
			buffer.append(" -> " + head.data);
			if (head.random != null)
				buffer.append("(" + head.random.data + ")");
			head = head.next;
		}
		return buffer + "";
	}
}
