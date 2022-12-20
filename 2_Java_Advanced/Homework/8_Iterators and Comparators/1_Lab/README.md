## Task 1. Book

Create a class Book from the UML diagram below:
 -title: String
 -year: int
 -authors: List<String>
 -setTitle(String)
 -setYear(String)
 -setAuthors(String…)
 -getTitle(): String
 -getYear(): int
 -getAuthors(): List<String
 
 You can use only one constructor. There can be no authors, one author, or many authors.
 
 
 
 ## Task 2. Library

Create a class Library from the UML diagram below:
Iterable<Book> Library
- books: Book[]
- iterator(): Iterator<Book>
 
 Create a nested class LibIterator from the UML diagram below:
- counter: int
- hasNext(): boolean
- next(): Book
 
 
 
 ## Task 3. Comparable Book

Expand Book by implementing Comparable<Book>.

The book has to be compared by title. When the title is equal, compare them by year.

Expand Book from UML diagram below:
Comparable<Book> Book
- title: String
- year: int
- authors: List<String>
- setTitle(String)
- setYear(String)
- setAuthors(String…)
- getTitle(): String
- getYear(): int
- getAuthors(): List<String>
- compareTo(Book): int
 
You can use only one constructor. There can be no authors, one author, or many authors.
 
 
 
 ## Task 4. Book Comparator

Create a class BookComparator from the UML diagram below:

Comparator<Book> BookComparator
- compare(Book, Book): int

BookComparator has to compare two books by:
1. Book title.
2. Year of publishing a book.