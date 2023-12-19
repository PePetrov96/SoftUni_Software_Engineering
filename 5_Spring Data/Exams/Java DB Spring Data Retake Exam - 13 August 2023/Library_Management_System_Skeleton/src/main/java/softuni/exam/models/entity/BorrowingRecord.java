package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "borrowing_records")
public class BorrowingRecord extends BaseEntity {
    @Column(name = "borrow_date", nullable = false)
    private LocalDate borrowDate;
    //a date in the "yyyy-MM-dd" format.

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;
    //a date in the "yyyy-MM-dd" format.

    @Column(name = "remarks", nullable = true)
    private String remarks;
    //can be used to store any relevant information and might be helpful for tracking and managing the borrowing records. Accepts char sequence (between 3 to 100 inclusive). Can be nullable.

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private LibraryMember member;
}
