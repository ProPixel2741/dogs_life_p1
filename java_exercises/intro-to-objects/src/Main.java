import com.qa.Book;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"Mike", "Martina", "Peter"};
        Book b1 = new Book("title", arr, 10.99);

        Book b2 = new Book("title2", arr, 7.99);

        Book b3 = new Book("title3", arr, 5.99);

        Book[] bookArr = new Book[3];

        bookArr[0] = b1;
        bookArr[1] = b2;
        bookArr[2] = b3;

        for (int i = 0; i < bookArr.length; i++) {
            System.out.println(bookArr[i]);
        }
    }
}