import java.util.HashMap;
class NodeDeepLL {
    int data;
    NodeDeepLL right;
	NodeDeepLL random;
 
    public NodeDeepLL(int item) {
        data = item;
        right = null;
        random =null;
    }
}
public class DeepCopyOfALinkedList 
{
	public NodeDeepLL copyRandomList(NodeDeepLL head) {
		  if (head == null) return null;
		  
		  HashMap<NodeDeepLL, NodeDeepLL> map = new HashMap<NodeDeepLL, NodeDeepLL>();
		  
		  // loop 1. copy all the nodes
		  NodeDeepLL node = head;
		  while (node != null) {
		    map.put(node, new NodeDeepLL(node.data));
		    node = node.right;
		  }
		  
		  // loop 2. assign right and random pointers
		  node = head;
		  while (node != null) {
		    map.get(node).right = map.get(node.right);
		    map.get(node).random = map.get(node.random);
		    node = node.right;
		  }
		  
		  return map.get(head);
		}
	
	public NodeDeepLL copyRandomList2(NodeDeepLL head) {
		 
		if (head == null)
			return null;
	 
		NodeDeepLL p = head;
	 
		while (p != null) {
			NodeDeepLL copy = new NodeDeepLL(p.data);
			copy.right = p.right;
			p.right = copy;
			p = copy.right;
		}
	 
		// copy random pointer for each new node
		p = head;
		while (p != null) {
			if (p.random != null)
				p.right.random = p.random.right;
			p = p.right.right;
		}
	 
		// break list to two
		p = head;
		NodeDeepLL newHead = head.right;
		while(p != null && p.right != null){
		    NodeDeepLL temp = p.right;
		    p.right = temp.right;
		    p = temp;
		}
		return newHead;
	}
}