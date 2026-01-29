import java.util.Scanner;


class Book {
    String title;
    String author;
    double price;
    String ISBN;

    Book(String title, String author, double price, String ISBN) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.ISBN = ISBN;
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("ISBN: " + ISBN);
        System.out.println("-------------------------");
    }
}

public class librarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine();
        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.print("ISBN: ");
            String isbn = sc.nextLine();

            books[i] = new Book(title, author, price, isbn);
        }

        System.out.println("\nTitle of first book: " + books[0].title);

        System.out.println("\nAll Book Details:");


        for (int i=0;i<n;i++){
            books[i].displayDetails();
        }
    }
}

