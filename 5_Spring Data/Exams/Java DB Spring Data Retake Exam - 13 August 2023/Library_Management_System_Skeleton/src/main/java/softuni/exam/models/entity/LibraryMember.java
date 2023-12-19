package softuni.exam.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "library_members")
public class LibraryMember extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;
    //first name - accepts char sequence (between 2 to 30 inclusive).

    @Column(name = "last_name", nullable = false)
    private String lastName;
    //last name - accepts char sequence (between 2 to 30 inclusive).

    @Column(name = "address", nullable = true)
    private String address;
    //accepts char sequence (between 2 to 40 inclusive). Can be nullable.

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;
    //accepts char sequence (between 2 to 20 inclusive). The values are unique in the database.

    @OneToMany(mappedBy = "member")
    private Set<BorrowingRecord> borrowingRecords;
}
