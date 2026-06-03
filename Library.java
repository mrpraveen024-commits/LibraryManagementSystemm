import java.util.ArrayList;

public class Library {

    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book Added Successfully");
    }

    public void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available");
            return;
        }

        for (Book b : books) {
            System.out.println(
                b.id + " | " +
                b.title + " | " +
                b.author
            );
        }
    }
}
