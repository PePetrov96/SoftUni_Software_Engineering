package com.plannerapp.init;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.enums.PriorityName;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    private final PriorityRepository priorityRepository;

    @Autowired
    public DatabaseInitializer(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.priorityRepository.count() == 0) {
            initializeSomeEntities();
        }
    }

    private void initializeSomeEntities() {
        for (PriorityName priorityName : PriorityName.values()) {
            Priority priority = new Priority();

            priority.setName(priorityName);
            this.priorityRepository.save(priority);
        }
    }
}
