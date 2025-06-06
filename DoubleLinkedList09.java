public class DoubleLinkedList09 {
    private Node09 head;
    private Node09 tail;
    private int size;

    public DoubleLinkedList09() {
        this.head = null;
        this.tail = null;
        this.size = 0;
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
        size++;
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
        size++;
    }

    void add(int index, Mahasiswa09 data) {
        if (index < 0 || index > size) {
            System.out.println("Index tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        } else if (index == size) {
            addLast(data);
            return;
        }

        Node09 newNode = new Node09(data);
        Node09 current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
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
        size++;
        System.out.println("Node dengan NIM " + nim + " telah ditambahkan setelah node tersebut.");
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Warning: Linked list kosong!");
        } else {
            Node09 current = head;
            while (current != null) {
                System.out.println("NIM: " + current.data.nim + ", Nama: " + current.data.nama);
                current = current.next;
            }
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked list kosong, tidak ada data yang dihapus.");
        } else {
            Mahasiswa09 deletedData = head.data;
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            size--;
            System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah: NIM = " + deletedData.nim + ", Nama = " + deletedData.nama);
        }
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
        size--;
        System.out.println("Node terakhir telah dihapus.");
    }

    void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index tidak valid.");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size - 1) {
            removeLast();
            return;
        }

        Node09 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        System.out.println("Node dengan NIM " + current.data.nim + " telah dihapus dari indeks ke-" + index);
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
            size--;
            System.out.println("Node dengan NIM " + toDelete.data.nim + " telah dihapus.");
        }
    }

    Mahasiswa09 getFirst() {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return null;
        }
        return head.data;
    }

    Mahasiswa09 getLast() {
        if (isEmpty()) {
            System.out.println("Linked list kosong.");
            return null;
        }
        return tail.data;
    }

    Mahasiswa09 getIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index tidak valid.");
            return null;
        }
        Node09 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    int getSize() {
        return size;
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
