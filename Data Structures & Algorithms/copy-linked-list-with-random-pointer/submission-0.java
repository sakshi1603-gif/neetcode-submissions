/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/


class Solution {
    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        Node copy = new Node(head.val);

        Node curr1 = copy;
        Node curr2 = head.next;

        map.put(head, copy);

        while (curr2 != null) {
            Node node = new Node(curr2.val);
            curr1.next = node;
            map.put(curr2, node);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        Node pointer = head;

        while (pointer != null) {
            Node copiedNode = map.get(pointer);
            copiedNode.random = map.get(pointer.random);
            pointer = pointer.next;
        }

        return copy;
    }
}
