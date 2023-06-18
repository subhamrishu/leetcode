class LRUCache {
    class Node{
        int key, value;
        Node next, prev;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node head, tail;
    Map<Integer, Node> map;
    int size;
    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>(size);
        head = new Node(-1, -1); //dummy node
        tail = new Node(-1, -1); //dummy node
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addToLast(node);
        return node.value;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addToLast(node);
        if (map.size() > size){
            Node firstNode = head.next;
            remove(firstNode);
            map.remove(firstNode.key);
        }
    }
    public void addToLast(Node node){
        Node oldEnd = tail.prev;
        oldEnd.next = node;
        node.prev = oldEnd;
        node.next = tail;
        tail.prev = node;
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */