import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagBinary {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(10);
		root.right.right = new Node(12);
		root.left.right.right = new Node(100);
		System.out.println(getZigZagTraversalOfTree(root));
	}

	private static List<Long> getZigZagTraversalOfTree(Node root) {
		int height = 0;
		int i = 0;
		List<Node> list = new ArrayList<Node>();
		Stack<Node> stack = new Stack<Node>();
		list.add(root);
		stack.push(root);
		i++;
		while (true) {
			while (!stack.isEmpty()) {
				Node temp = stack.pop();
				if (height % 2 == 0) {
					if (temp.left != null)
						list.add(temp.left);
					if (temp.right != null)
						list.add(temp.right);
				} else {
					if (temp.right != null)
						list.add(temp.right);
					if (temp.left != null)
						list.add(temp.left);
				}
			}
			while (i < list.size()) {
				stack.push(list.get(i));
				i++;
			}
			height++;
			i++;
			if (stack.isEmpty())
				break;
		}
		return convertToLongList(list);
	}

	private static List<Long> convertToLongList(List<Node> list) {
		List<Long> longList = new ArrayList<Long>();
		for (Node node : list) {
			longList.add(node.data);
		}
		return longList;
	}

}
