package Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {

    private Book[] books;

    public Library(Book...books) {
        this.books = books;
    }

    private class LibIterator implements Iterator<Book>{

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
}
