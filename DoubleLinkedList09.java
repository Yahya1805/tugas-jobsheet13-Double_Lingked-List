public class DoubleLinkedList09 {
    private Node09 head;
    private Node09 tail;

    public DoubleLinkedList09() {
        this.head = null;
        this.tail = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(Mahasiswa09 data) {
        Node09 newNode = new Node09(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void addLast(Mahasiswa09 data) {
        Node09 newNode = new Node09(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void insertAfter(Mahasiswa09 data, String nim) {
        Node09 current = head;
        while (current != null && !current.data.nim.equals(nim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + nim + " tidak ditemukan.");
            return;
        }

        Node09 newNode = new Node09(data);
        if (current == tail) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node dengan NIM " + nim + " telah ditambahkan setelah node tersebut.");
    }

    void print() {
        if (isEmpty()) {
            System.out.println("List kosong.");
            return;
        }

        Node09 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang dihapus.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        System.out.println("Node pertama telah dihapus.");
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak ada yang dihapus.");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        System.out.println("Node terakhir telah dihapus.");
    }

    void removeAfter(String nim) {
        Node09 current = head;
        while (current != null && !current.data.nim.equals(nim)) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Node dengan NIM " + nim + " tidak ditemukan atau tidak ada node setelahnya.");
        } else {
            Node09 toDelete = current.next;
            current.next = toDelete.next;
            if (toDelete.next != null) {
                toDelete.next.prev = current;
            } else {
                tail = current;
            }

            System.out.println("Node dengan NIM " + toDelete.data.nim + " telah dihapus.");
        }
    }

    Node09 search(String nim) {
        Node09 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
