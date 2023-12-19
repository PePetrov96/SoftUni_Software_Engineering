package softuni.exam.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@XmlRootElement(name = "borrowing_record")
@XmlAccessorType(XmlAccessType.FIELD)
public class BorrowingRecordCreateDTO {
    @NotNull
    @XmlElement(name = "borrow_date")
    private String borrowDate;
    //a date in the "yyyy-MM-dd" format.

    @NotNull
    @XmlElement(name = "return_date")
    private String returnDate;
    //a date in the "yyyy-MM-dd" format.

    @NotNull
    @XmlElement(name = "book")
    private BookWrapperCreateDTO book;

    @NotNull
    @XmlElement(name = "member")
    private LibraryMemberWrapperCreateDTO member;

    @XmlElement(name = "remarks")
    @Size(min = 3, max = 100)
    private String remarks;
    //can be used to store any relevant information and might be helpful for tracking and managing the borrowing records. Accepts char sequence (between 3 to 100 inclusive). Can be nullable.
}
