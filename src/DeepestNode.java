public class DeepestNode {
int deepestlevel;
int value;
public int Deep(NodeDeep root) {
		find(root, 0);
return value;
	}
public void find(NodeDeep root, int level) {
if (root != null) {
			find(root.left, ++level);
if (level > deepestlevel) {
				value = root.data;
				deepestlevel = level;
			}
			find(root.right, level);
		}
	}
public static void main(String args[]) {
NodeDeep root = new NodeDeep(1);
		root.left = new NodeDeep(2);
		root.right = new NodeDeep(3);
		root.left.left = new NodeDeep(4);
		root.left.right = new NodeDeep(5);
		root.right.left = new NodeDeep(6);
		root.right.right = new NodeDeep(7);
		root.left.left.left = new NodeDeep(9);
		root.left.left.right = new NodeDeep(8);
		root.right.right.right = new NodeDeep(10);
DeepestNode dp = new DeepestNode();
System.out.println("Deepest child is: " + dp.Deep(root));
	}
}
class NodeDeep {
int data;
NodeDeep left;
NodeDeep right;
public NodeDeep(int data) {
this.data = data;
this.left = null;
this.right = null;
	}
}