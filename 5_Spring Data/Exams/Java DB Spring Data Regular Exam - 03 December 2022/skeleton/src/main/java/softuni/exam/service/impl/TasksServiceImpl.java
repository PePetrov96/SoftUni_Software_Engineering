package softuni.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TaskCreateDTO;
import softuni.exam.models.dto.wrappers.TaskWrapper;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.models.entity.Task;
import softuni.exam.models.entity.enums.CarType;
import softuni.exam.repository.CarsRepository;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.repository.PartsRepository;
import softuni.exam.repository.TasksRepository;
import softuni.exam.service.TasksService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class TasksServiceImpl implements TasksService {
    private final TasksRepository tasksRepository;
    private final CarsRepository carsRepository;
    private final MechanicsRepository mechanicsRepository;
    private final PartsRepository partsRepository;
    private final ValidationUtils validator;
    private final XmlParser xmlParser;

    @Autowired
    public TasksServiceImpl(TasksRepository tasksRepository, CarsRepository carsRepository, MechanicsRepository mechanicsRepository,
                            PartsRepository partsRepository, ValidationUtils validator, XmlParser xmlParser) {
        this.tasksRepository = tasksRepository;
        this.carsRepository = carsRepository;
        this.mechanicsRepository = mechanicsRepository;
        this.partsRepository = partsRepository;
        this.validator = validator;
        this.xmlParser = xmlParser;
    }

    private static String TASKS_FILE_PATH = "src/main/resources/files/xml/tasks.xml";

    @Override
    public boolean areImported() {
        return this.tasksRepository.count() >= 1;
    }

    @Override
    public String readTasksFileContent() throws IOException {
        return Files.readString(Path.of(TASKS_FILE_PATH));
    }

    @Override
    public String importTasks() throws IOException, JAXBException {
        StringBuilder out = new StringBuilder();

        List<TaskCreateDTO> taskDTOs = this.xmlParser
                .fromFile(Path.of(TASKS_FILE_PATH).toFile(), TaskWrapper.class)
                .getTasks();

        for (TaskCreateDTO taskDTO : taskDTOs) {

            if (this.validator.isValid(taskDTO)) {
                Optional<Car> car = this.carsRepository.findCarById(taskDTO.getCar().getId());
                Optional<Mechanic> mechanic = this.mechanicsRepository.findMechanicByFirstName(taskDTO.getMechanic().getFirstName());
                Optional<Part> part = this.partsRepository.findPartById(taskDTO.getPart().getId());

                if (car.isEmpty() || mechanic.isEmpty() || part.isEmpty()) {
                    out.append(String.format("Invalid task%n"));

                    continue;
                }

                Task task = new Task(); //create empty task

                String dateStr = taskDTO.getDate(); //get date as string
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //parse
                LocalDateTime dateTime = LocalDateTime.parse(dateStr, formatter); //convert

                task.setDate(dateTime); //set LocalDateTime to Task
                task.setPrice(taskDTO.getPrice()); //set Price to Task
                task.setCar(car.get()); //set Car to Task
                task.setMechanic(mechanic.get()); //set Mechanic to Task
                task.setPart(part.get()); //set Part to Task

                this.tasksRepository.saveAndFlush(task); //save Task

                out.append(String.format("Successfully imported task %.2f%n",
                        taskDTO.getPrice()));
            } else {
                out.append(String.format("Invalid task%n"));
            }


        }

        return out.toString().trim();
    }

    @Override
    public String getCoupeCarTasksOrderByPrice() {
        StringBuilder out = new StringBuilder();

        final String EXPORT_TASK =
                "Car %s %s with %dkm\n" + //make, mode, kilometers
                        "-Mechanic: %s %s - task №%d:\n" + //first name, last name, task id
                        " --Engine: %s\n" + //engine
                        "---Price: %.2f$\n"; //task price

        List<Task> taskList = this.tasksRepository
                .findAllByCar_CarTypeOrderByPriceDesc(CarType.coupe);

        DecimalFormat df = new DecimalFormat("0.0#");


        for (Task task : taskList) {
            out.append(String.format(EXPORT_TASK,
                    task.getCar().getCarMake(), task.getCar().getCarModel(), task.getCar().getKilometers(), //make, mode, kilometers
                    task.getMechanic().getFirstName(), task.getMechanic().getLastName(), task.getId(), //first name, last name, task id
                    df.format(task.getCar().getEngine()), //engine
                    task.getPrice())); //task price
        }

        return out.toString().trim();
    }
}
