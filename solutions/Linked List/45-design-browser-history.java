class BrowserHistory {



 private Node historyNode;


    public BrowserHistory(String homepage) {
        historyNode = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        historyNode.next = newNode;
        newNode.previous = historyNode;
        historyNode=newNode;
    }

    public String back(int steps) {
        while (historyNode.previous != null && steps > 0) {
            historyNode = historyNode.previous;
            steps--;
        }
        return historyNode.data;
    }

    public String forward(int steps) {
        while (historyNode.next != null && steps > 0) {
            historyNode = historyNode.next;
            steps--;
        }
        return historyNode.data;
    }

    private class Node {
        String data;
        Node next;
        Node previous;

        public Node(String data) {
            this.data = data;
        }
    }
   
}