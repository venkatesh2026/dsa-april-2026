// Welcome to WorkPad
// Start coding here...
package LinkedList;

public class SingleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SingleLinkedList() {
    }


    public void addAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T deleteAtEnd() {
        T data = null;
        if (size == 0) {
            throw new IllegalArgumentException("No nodes to found to delete.");
        } else if (size == 1) {
            data = head.data;
            head = null;
            tail = null;
        } else {
            Node<T> temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            data = tail.data;
            temp.next = null;
            tail = temp;
        }
        size--;
        return data;
    }

    public T deleteAtBeginning() {
        T data = null;
        if (size == 0) {
            throw new IllegalArgumentException("No nodes to found to delete.");
        } else if (size == 1) {
            data = head.data;
            head = null;
            tail = null;
        } else {
            data = head.data;
            head = head.next;
        }
        size--;
        return data;
    }


    public void addAtIndex(int position, T data) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("position is out of existing linked list range.");
        }
        Node<T> newNode = new Node<>(data);
        //if position is x we need to travel till x-1 node and insert
        if (size == 0 && position == 0) {
            head = newNode;
            tail = newNode;
        } else if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else if (position == size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            int count = 0;
            Node<T> previous = head;
            while (count != position - 1) {
                previous = previous.next;
                count++;
            }
            if (count == position - 1) {
                Node<T> nextNode = previous.next;
                previous.next = newNode;
                newNode.next = nextNode;
            } else {
                throw new RuntimeException("List does not have mentioned position");
            }
        }
        size++;
    }


    public T deleteAtIndex(int position) {
        T data = null;
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("position is out of existing linked list range.");
        } else if (size == 1) {
            data = head.data;
            head = null;
            tail = null;
        } else {
            Node<T> temp = head;
            if (position == 0) {
                data = temp.data;
                head = head.next;
                temp.next = null;
            } else {
                int count = 0;
                while (count != position - 1) {
                    temp = temp.next;
                    count++;
                }
                Node<T> toBeDeleted = temp.next;
                data = toBeDeleted.data;
                if (count == position - 1) {
                    temp.next = toBeDeleted.next;
                    toBeDeleted.next = null;
                    if (tail == toBeDeleted) {
                        tail = temp;
                    }
                }
            }
        }
        size--;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Node<T> temp = head;
        while (temp != null) {
            output.append(temp.data);
            output.append("->");
            temp = temp.next;
        }
        output.append("null");
        return output.toString();
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.addAtBeginning("venkatesh");
        list.addAtBeginning("prasanna");
        list.addAtIndex(1,"archana");
        System.out.println(list);
        list.deleteAtIndex(2);
        System.out.println(list);
    }
}
