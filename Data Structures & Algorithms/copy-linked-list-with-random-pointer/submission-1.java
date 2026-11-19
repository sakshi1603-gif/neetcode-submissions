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

        // Step 1: Insert copied nodes
        Node curr = head;

        while (curr != null) {
            Node newNode = new Node(curr.val);

            newNode.next = curr.next;
            curr.next = newNode;

            curr = newNode.next;
        }

        // Step 2: Connect random pointers
        Node curr1 = head;

        while (curr1 != null) {
            Node copiedNode = curr1.next;

            if (curr1.random != null) {
                copiedNode.random = curr1.random.next;
            }

            curr1 = curr1.next.next;
        }

        // Step 3: Separate both lists
        Node dummy = new Node(-1);
        Node copyTail = dummy;
        Node curr3 = head;

        while (curr3 != null) {
            Node copiedNode = curr3.next;
            curr3.next = copiedNode.next;
            copyTail.next = copiedNode;

            copyTail = copiedNode;
            curr3 = curr3.next;
        }

        return dummy.next;
    }

}
    // public Node copyRandomList(Node head) {

    //     if (head == null) {
    //         return null;
    //     }

    //     HashMap<Node, Node> map = new HashMap<>();

    //     Node copy = new Node(head.val);

    //     Node curr1 = copy;
    //     Node curr2 = head.next;

    //     map.put(head, copy);

    //     while (curr2 != null) {
    //         Node node = new Node(curr2.val);
    //         curr1.next = node;
    //         map.put(curr2, node);
    //         curr1 = curr1.next;
    //         curr2 = curr2.next;
    //     }
    //     Node pointer = head;

    //     while (pointer != null) {
    //         Node copiedNode = map.get(pointer);
    //         copiedNode.random = map.get(pointer.random);
    //         pointer = pointer.next;
    //     }

    //     return copy;
    // }