import java.util.Scanner;

// Doubly Linked List
class Node {
    int std_id;
    String std_name;
    int marks_obt;
    String address;
    Node next, prev;

    Node(int id, String name, int marks, String addr) {
        std_id = id;
        std_name = name;
        marks_obt = marks;
        address = addr;
        next = prev = null;
    }
}

// class
class NTSList {
    Node first, last;

    NTSList() {
        first = last = null;
    }

    // end
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

    // records
    void display() {
        if (first == null) {
            System.out.println("List is empty!");
            return;
        }
        Node cur = first;
        while (cur != null) {
            System.out.println(cur.std_id + " | " + cur.std_name + " | " + cur.marks_obt + " | " + cur.address);
            cur = cur.next;
        }
    }

    // size
    int size() {
        int count = 0;
        Node cur = first;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // pass/fail
    void count_pass_fail() {
        int pass = 0, fail = 0;
        Node cur = first;
        while (cur != null) {
            if (cur.marks_obt >= 50) pass++;
            else fail++;
            cur = cur.next;
        }
        System.out.println("Passed: " + pass + " | Failed: " + fail);
    }

    // Del f students
    void deleteFailStudents() {
        Node cur = first;
        while (cur != null) {
            Node nextNode = cur.next;
            if (cur.marks_obt < 50) deleteNode(cur);
            cur = nextNode;
        }
    }

    // Delete small
    void deleteSmallest() {
        if (first == null) return;
        Node cur = first, smallest = first;
        while (cur != null) {
            if (cur.marks_obt < smallest.marks_obt) smallest = cur;
            cur = cur.next;
        }
        deleteNode(smallest);
    }

    // Delete all occurrence
    void deleteAllOccurrences(int marks) {
        Node cur = first;
        while (cur != null) {
            Node nextNode = cur.next;
            if (cur.marks_obt == marks) deleteNode(cur);
            cur = nextNode;
        }
    }

    // kth
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

    // Del kth element
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

    // Divide into two lists
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

    // Merge two lists
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

    //  duplicate check
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

    //  delete node
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
}

public class NtsMenuDriven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NTSList list = new NTSList();

        while (true) {
            System.out.println("\n===== NTS Result Card Menu =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Display All Records");
            System.out.println("3. Show Size of List");
            System.out.println("4. Count Pass & Fail");
            System.out.println("5. Delete Fail Students (<50)");
            System.out.println("6. Delete Smallest Marks Student");
            System.out.println("7. Delete All Occurrences of Marks");
            System.out.println("8. Show Kth Element");
            System.out.println("9. Delete Kth Element");
            System.out.println("10. Divide List into Two");
            System.out.println("11. Merge with Another List");
            System.out.println("12. Insert Unique Student");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Address: ");
                    String addr = sc.nextLine();
                    list.insert(id, name, marks, addr);
                    break;

                case 2:
                    list.display();
                    break;

                case 3:
                    System.out.println("Size = " + list.size());
                    break;

                case 4:
                    list.count_pass_fail();
                    break;

                case 5:
                    list.deleteFailStudents();
                    System.out.println("Fail students deleted.");
                    break;

                case 6:
                    list.deleteSmallest();
                    System.out.println("Deleted student with smallest marks.");
                    break;

                case 7:
                    System.out.print("Enter Marks to delete: ");
                    int m = sc.nextInt();
                    list.deleteAllOccurrences(m);
                    break;

                case 8:
                    System.out.print("Enter K: ");
                    int k1 = sc.nextInt();
                    list.kthElement(k1);
                    break;

                case 9:
                    System.out.print("Enter K: ");
                    int k2 = sc.nextInt();
                    list.deleteKth(k2);
                    break;

                case 10:
                    list.divideList();
                    break;

                case 11:
                    NTSList list2 = new NTSList();
                    System.out.print("Enter number of students in 2nd list: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        System.out.print("Enter ID: ");
                        int id2 = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name2 = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        int marks2 = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Address: ");
                        String addr2 = sc.nextLine();
                        list2.insert(id2, name2, marks2, addr2);
                    }
                    list.mergeLists(list2);
                    System.out.println("Lists merged.");
                    break;

                case 12:
                    System.out.print("Enter ID: ");
                    int id3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name3 = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Address: ");
                    String addr3 = sc.nextLine();
                    list.insertUnique(id3, name3, marks3, addr3);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
