package softuni.exam.models.dto.wrappers;

import softuni.exam.models.dto.TaskCreateDTO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskWrapper {
    @XmlElement(name = "task")
    private List<TaskCreateDTO> tasks;

    public TaskWrapper(List<TaskCreateDTO> tasks) {
        this.tasks = tasks;
    }

    public TaskWrapper() {
    }

    public List<TaskCreateDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskCreateDTO> tasks) {
        this.tasks = tasks;
    }
}
