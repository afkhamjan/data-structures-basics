import java.util.Scanner;

class ApplicantNode {
    int id,score;
    String name,program;

    ApplicantNode left, right;

    public ApplicantNode(int id, String name, int score, String program) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.program = program;

        left = right = null;
    }
}

class AdmissionTree {

    ApplicantNode root = null;
    ApplicantNode addStudent(ApplicantNode node, ApplicantNode newNode) {

        if (node == null) return newNode;

        if (newNode.id < node.id)
            node.left = addStudent(node.left, newNode);
        else
            node.right = addStudent(node.right, newNode);

        return node;
    }


    ApplicantNode findStudent(ApplicantNode node, int id) {

        if (node == null || node.id == id)
            return node;

        if (id < node.id)
            return findStudent(node.left, id);
        else
            return findStudent(node.right, id);
    }


    ApplicantNode removeStudent(ApplicantNode node, int id) {

        if (node == null) return null;

        if (id < node.id)
            node.left = removeStudent(node.left, id);

        else if (id > node.id)
            node.right = removeStudent(node.right, id);

        else {

            if (node.left == null && node.right == null)
                return null;

            else if (node.left == null)
                return node.right;

            else if (node.right == null)
                return node.left;

            ApplicantNode smallest = smallestNode(node.right);

            node.id = smallest.id;
            node.name = smallest.name;
            node.score = smallest.score;
            node.program = smallest.program;

            node.right = removeStudent(node.right, smallest.id);
        }
        return node;
    }


    ApplicantNode smallestNode(ApplicantNode node) {
        while (node.left != null)
            node = node.left;
        return node;
    }


    void showSorted(ApplicantNode node) {
        if (node == null) return;

        showSorted(node.left);

        System.out.println(node.id + " | " + node.name + " | " +
                node.score + " | " + node.program);

        showSorted(node.right);
    }

    void topThree(ApplicantNode node, int[] counter) {
        if (node == null || counter[0] >= 3) return;

        topThree(node.right, counter);

        if (counter[0] < 3) {
            System.out.println(node.name + " - Score: " + node.score);
            counter[0]++;
        }

        topThree(node.left, counter);
    }


    int countByProgram(ApplicantNode node, String prog) {
        if (node == null) return 0;

        int c = (node.program.equalsIgnoreCase(prog)) ? 1 : 0;

        return c + countByProgram(node.left, prog)
                + countByProgram(node.right, prog);
    }

    int totalStudents(ApplicantNode node) {
        if (node == null) return 0;
        return 1 + totalStudents(node.left) + totalStudents(node.right);
    }

    void showAbove80(ApplicantNode node) {
        if (node == null) return;

        showAbove80(node.left);

        if (node.score > 80)
            System.out.println(node.id + " | " + node.name + " | "
                    + node.score + " | " + node.program);

        showAbove80(node.right);
    }

}

public class COMSATSAdmissionApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AdmissionTree tree = new AdmissionTree();
        int choice;

        do {
            System.out.println("\n---- COMSATS Admission System (BST) ----");
            System.out.println("1. Insert applicant");
            System.out.println("2. Display sorted merit list");
            System.out.println("3. Search applicant by ID");
            System.out.println("4. Delete applicant");
            System.out.println("5. Show Top 3 Students");
            System.out.println("6. Count students in program");
            System.out.println("7. Count all students");
            System.out.println("8. Students scoring above 80");
            System.out.println("9. Exit");
            System.out.print("Enr choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Score: ");
                    int score = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Program: ");
                    String prog = sc.nextLine();

                    tree.root = tree.addStudent(tree.root,
                            new ApplicantNode(id, name, score, prog));

                    System.out.println("Applicant added.");
                    break;

                case 2:
                    System.out.println("\n--- SORTED LIST ---");
                    tree.showSorted(tree.root);
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int sid = sc.nextInt();
                    ApplicantNode found = tree.findStudent(tree.root, sid);

                    if (found != null)
                        System.out.println("FOUND: " + found.name +
                                " | Score: " + found.score);
                    else
                        System.out.println("No such student.");
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    tree.root = tree.removeStudent(tree.root, did);
                    System.out.println("Deleted if existed.");
                    break;

                case 5:
                    System.out.println("\n--- TOP 3 STUDENTS ---");
                    tree.topThree(tree.root, new int[]{0});
                    break;

                case 6:
                    sc.nextLine();
                    System.out.print("Enter program: ");
                    String p = sc.nextLine();
                    System.out.println("Count = " + tree.countByProgram(tree.root, p));
                    break;

                case 7:
                    System.out.println("Total Students = " + tree.totalStudents(tree.root));
                    break;

                case 8:
                    System.out.println("\n--- Score > 80 ---");
                    tree.showAbove80(tree.root);
                    break;

                case 9:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);
    }
}
