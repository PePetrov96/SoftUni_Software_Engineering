import java.util.Iterator;

public class Library<Book> implements Iterable<Book>, Iterator<Book> {
    private final Book[] books;

    @SafeVarargs
    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Book next() {
        return null;
    }

    private final class LibraryIterator implements Iterator<Book> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter < books.length;
        }

        @Override
        public Book next() {
            return books[counter++];
        }
    }
}