package kg.itacademy.securitylesson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskModel {
    private String title;
    private String text;
    private Boolean isDone;
}
