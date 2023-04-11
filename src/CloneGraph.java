import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Stack<Node> stack = new Stack<Node>();
        HashMap<Node, Node> visited = new HashMap<Node, Node>();
        Node node2 = new Node(node.val);
        stack.push(node);
        visited.put(node, node2);
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            Node currClone = visited.get(curr);
            List<Node> neighbors = curr.neighbors;
            for (Node neighbor : neighbors) {
                if (!visited.containsKey(neighbor)) { // If cloned neighbor is not created already
                    Node newNeighbor = new Node(neighbor.val);
                    stack.push(neighbor);
                    visited.put(neighbor, newNeighbor);
                    currClone.neighbors.add(newNeighbor); // Create edge
                    newNeighbor.neighbors.add(currClone); // Create edge
                } else { // If cloned neighbor already exists
                    Node existingNeighbor = visited.get(neighbor);
                    if (!currClone.neighbors.contains(existingNeighbor)) { // Add edge only if it was not added previously
                        currClone.neighbors.add(existingNeighbor);
                    }
                }
            }
        }
        return node2;
    }
}