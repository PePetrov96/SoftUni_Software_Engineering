package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.exam.models.entity.enums.Genre;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class BookCreateDTO implements Serializable {
    @Expose
    @NotNull
    @Size(min = 3, max = 40)
    private String author;
    //accepts char sequence (between 3 to 40 inclusive).

    @Expose
    @NotNull
    private boolean available;
    //accepts a true or false, representing the availability status of the book.

    @Expose
    @NotNull
    @Size(min = 5)
    private String description;
    //a long and detailed description of the book with a character length value higher than or equal to 5.

    @Expose
    @NotNull
    private Genre genre;
    //enumeration one of the following – CLASSIC_LITERATURE, SCIENCE_FICTION, FANTASY

    @Expose
    @NotNull
    @Size(min = 3, max = 40)
    private String title;
    //accepts char sequence (between 3 to 40 inclusive). The values are unique in the database

    @Expose
    @NotNull
    @Min(value = 1)
    private Double rating;
    //accepts number values that are positive.
}
