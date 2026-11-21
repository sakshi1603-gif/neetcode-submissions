class Node {
    int val;
    int key;
    Node prev;
    Node next;
    public Node(int key , int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node desiredNode = map.get(key);
        remove(desiredNode);
        insertAfterdummy(desiredNode);
        return desiredNode.val;
    }
    public void remove(Node newNode) {
        newNode.prev.next = newNode.next;
        newNode.next.prev = newNode.prev;
    }
    public void insertAfterdummy(Node newNode) {
        newNode.next = head.next;
        newNode.prev = head;

        head.next.prev = newNode;
        head.next = newNode;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node getNode = map.get(key);

            getNode.val = value;

            remove(getNode);
            insertAfterdummy(getNode);

        } else {
            Node newNode = new Node(key, value);

            map.put(key, newNode);

            insertAfterdummy(newNode);

            if (map.size() > capacity) {
                Node lru = tail.prev;

                remove(lru);

                map.remove(lru.key);
            }
        }
    }
}
