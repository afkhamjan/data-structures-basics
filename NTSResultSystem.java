import java.util.Scanner;

class Nodee {
    int std_id;
    String std_name;
    int marks_obt;
    String address;

    Node next, prev;

    Nodee(int id, String name, int marks, String addr) {
        std_id = id;
        std_name = name;
        marks_obt = marks;
        address = addr;
        next = prev = null;
    }
}

// Doubly Linked
class NTSListt {
    Node first, last;

    NTSListt() {
        first = last = null;
    }

    // Insert at end
    void insert(int id, String name, int marks, String addr) {
        Node temp = new Node(id, name, marks, addr);
        if (first == null) {
            first = last = temp;
        } else {
            last.next = temp;
            temp.prev = last;
            last = temp;
        }
    }

    // Display all records
    void display() {
        Node cur = first;
        while (cur != null) {
            System.out.println(cur.std_id + " | " + cur.std_name + " | " + cur.marks_obt + " | " + cur.address);
            cur = cur.next;
        }
    }

    // (a) Size of List
    int size() {
        int count = 0;
        Node cur = first;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // (b) Count pass & fail
    void count_pass_fail() {
        int pass = 0, fail = 0;
        Node cur = first;
        while (cur != null) {
            if (cur.marks_obt >= 50) {
                pass++;
            } else {
                fail++;
            }
            System.out.println(cur.std_id + " | " + cur.std_name + " | " + cur.marks_obt + " | " + cur.address);
            cur = cur.next;
        }
        System.out.println("Total Passed: " + pass);
        System.out.println("Total Failed: " + fail);
    }

    // (c) Delete Fail Students (<50 marks)
    void deleteFailStudents() {
        Node cur = first;
        while (cur != null) {
            if (cur.marks_obt < 50) {
                if (cur == first) {
                    first = first.next;
                    if (first != null) first.prev = null;
                } else if (cur == last) {
                    last = last.prev;
                    if (last != null) last.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }

    // Q2-1: Delete node with smallest marks
    void deleteSmallest() {
        if (first == null) return;
        Node cur = first, smallest = first;
        while (cur != null) {
            if (cur.marks_obt < smallest.marks_obt) {
                smallest = cur;
            }
            cur = cur.next;
        }
        deleteNode(smallest);
    }

    // Helper delete node
    void deleteNode(Node node) {
        if (node == null) return;
        if (node == first) {
            first = first.next;
            if (first != null) first.prev = null;
        } else if (node == last) {
            last = last.prev;
            if (last != null) last.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    // Q2-2: Delete all occurrences of given marks
    void deleteAllOccurrences(int marks) {
        Node cur = first;
        while (cur != null) {
            Node nextNode = cur.next;
            if (cur.marks_obt == marks) {
                deleteNode(cur);
            }
            cur = nextNode;
        }
    }

    // Q2-3: kth element info
    void kthElement(int k) {
        Node cur = first;
        int index = 1;
        while (cur != null) {
            if (index == k) {
                System.out.println("Kth Element: " + cur.std_id + " | " + cur.std_name + " | " + cur.marks_obt + " | " + cur.address);
                return;
            }
            cur = cur.next;
            index++;
        }
        System.out.println("No such element exists!");
    }

    // Q2-4: Delete kth element
    void deleteKth(int k) {
        Node cur = first;
        int index = 1;
        while (cur != null) {
            if (index == k) {
                deleteNode(cur);
                System.out.println("Deleted element at position " + k);
                return;
            }
            cur = cur.next;
            index++;
        }
        System.out.println("No such element exists!");
    }

    // Q2-5: Divide into two sublists
    void divideList() {
        int n = size();
        int mid = n / 2;
        int count = 0;

        Node cur = first;
        System.out.print("Sublist 1: ");
        while (cur != null && count < mid) {
            System.out.print(cur.marks_obt + " ");
            cur = cur.next;
            count++;
        }

        System.out.print("\nSublist 2: ");
        while (cur != null) {
            System.out.print(cur.marks_obt + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    // Q2-6: Merge Lists
    void mergeLists(NTSList list2) {
        if (list2.first == null) return;
        if (this.first == null) {
            this.first = list2.first;
            this.last = list2.last;
        } else {
            this.last.next = list2.first;
            list2.first.prev = this.last;
            this.last = list2.last;
        }
    }

    // Q2-7: Insert with duplicate check
    void insertUnique(int id, String name, int marks, String addr) {
        Node cur = first;
        while (cur != null) {
            if (cur.std_id == id) {
                System.out.println("Error: Student with ID " + id + " already exists!");
                return;
            }
            cur = cur.next;
        }
        insert(id, name, marks, addr);
    }
}

public class NTSResultSystem {
    public static void main(String[] args) {
        NTSList list = new NTSList();

        // Sample data
        list.insert(1, "Ali", 45, "Lahore");
        list.insert(2, "Sara", 85, "Karachi");
        list.insert(3, "Usman", 72, "Islamabad");
        list.insert(4, "Ayesha", 33, "Multan");
        list.insert(5, "Hina", 90, "Quetta");

        System.out.println("\nAll Records:");
        list.display();

        System.out.println("\nSize of List: " + list.size());

        System.out.println("\nPass/Fail Count:");
        list.count_pass_fail();

        System.out.println("\nDeleting Fail Students (<50):");
        list.deleteFailStudents();
        list.display();

        System.out.println("\nDeleting Smallest Marks Student:");
        list.deleteSmallest();
        list.display();

        System.out.println("\nDeleting all occurrences of 72:");
        list.deleteAllOccurrences(72);
        list.display();

        System.out.println("\nFind 2nd Element:");
        list.kthElement(2);

        System.out.println("\nDelete 2nd Element:");
        list.deleteKth(2);
        list.display();

        System.out.println("\nDivide List:");
        list.divideList();

        NTSList list2 = new NTSList();
        list2.insert(6, "Zara", 55, "Peshawar");
        list2.insert(7, "Hamza", 60, "Hyderabad");
        list.mergeLists(list2);

        System.out.println("\nAfter Merging Two Lists:");
        list.display();

        System.out.println("\nInsert Unique Check:");
        list.insertUnique(2, "Sara", 85, "Karachi"); // Duplicate ID
        list.insertUnique(8, "Bilal", 77, "Faisalabad"); // New record
        list.display();
    }
}
