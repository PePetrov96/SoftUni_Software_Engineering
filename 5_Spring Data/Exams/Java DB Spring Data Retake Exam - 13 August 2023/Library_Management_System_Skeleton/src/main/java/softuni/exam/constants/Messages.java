package softuni.exam.constants;

public enum Messages {
    ;
    public static final String INVALID_BOOK = "Invalid book";
    public static final String INVALID_LIBRARY_MEMBER = "Invalid library member";
    public static final String INVALID_BORROWING_RECORD = "Invalid borrowing record";
    public static final String BOOK_IMPORTED = "Successfully imported book %s - %s"; //author – title
    public static final String LIBRARY_MEMBER_IMPORTED = "Successfully imported library member %s - %s"; //first name – last name
    public static final String BORROWING_RECORD_IMPORTED = "Successfully imported borrowing record %s - %s"; //title – borrow date
    public static final String RECORDS_EXPORT =
            "Book title: %s\n" + // title
            "*Book author: %s\n" + // author
            "**Date borrowed: %s\n" + // borrowDate
            "***Borrowed by: %s %s\n"; // firstName, lastName

}
