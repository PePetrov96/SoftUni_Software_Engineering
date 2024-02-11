package bg.softuni.pathfinder.model.dto.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentViewModel {

    private long id;
    private String content;
    private String authorName;
    private Boolean approved;

}
