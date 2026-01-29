import java.util.Scanner;

class Deque {
    int[] q;
    int size, front, rear;

    Deque(int size) {
        this.size = size;
        q = new int[size];
        front = rear = -1;
    }

    boolean isFull() {
        return (front == (rear + 1) % size);
    }

    boolean isEmpty() {
        return (front == -1);
    }

    // 1: Insert at rear
    void insertAtRear(int x) {
        if (isFull()) {
            System.out.println("Deque is full.");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % size;
        }
        q[rear] = x;
    }

    // 2: Delete from front
    int delAtFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        int x = q[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return x;
    }

    // 3: Delete from rear
    int delFromRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        int x = q[rear];

        if (front == rear) {
            front = rear = -1;
        } else {
            rear = (rear - 1 + size) % size;
        }
        return x;
    }

    // 4: Insert at front
    void insertFromFront(int x) {
        if (isFull()) {
            System.out.println("Deque is full.");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + size) % size;
        }
        q[front] = x;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.print("Deque elements: ");

        int i = front;
        while (true) {
            System.out.print(q[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }
}
public class doublyqueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of deque: ");
        int n = sc.nextInt();
        Deque dq = new Deque(n);

        int choice, val;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert at Rear");
            System.out.println("2. Delete from Front");
            System.out.println("3. Insert at Front");
            System.out.println("4. Delete from Rear");
            System.out.println("5. Display");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    dq.insertAtRear(val);
                    break;

                case 2:
                    System.out.println("Deleted: " + dq.delAtFront());
                    break;

                case 3:
                    System.out.print("Enter value: ");
                    val = sc.nextInt();
                    dq.insertFromFront(val);
                    break;

                case 4:
                    System.out.println("Deleted: " + dq.delFromRear());
                    break;

                case 5:
                    dq.display();
                    break;

                case 0:
                    System.out.println("EXITING...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }
}
