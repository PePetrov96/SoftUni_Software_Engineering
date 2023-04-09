package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class BaseService implements Service{
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;
    private int totalFed;

    public BaseService(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return Collections.unmodifiableCollection(this.robots);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(this.supplements);
    }

    @Override
    public void addRobot(Robot robot) {
        if (this.robots.size() >= this.capacity) {
            throw new IllegalStateException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }

        this.robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void feeding() {
        for (Robot robot: this.robots) {
            robot.eating();
        }
    }

    @Override
    public int sumHardness() {
        return supplements.stream()
                .mapToInt(Supplement::getHardness)
                .sum();
    }

    @Override
    public String getStatistics() {
        String serviceType = this.getClass().getSimpleName();

        StringBuilder out = new StringBuilder(String.format("%s %s:", this.name, serviceType))
                .append(System.lineSeparator());

        if (robots.isEmpty()) {
            out.append("Robots: none")
                    .append(System.lineSeparator());
        } else {
            out.append(String.format("Robots: " + robots.stream().map(Robot::getName).collect(Collectors.joining(" "))))
                    .append(System.lineSeparator());
        }

        out.append(String.format("Supplements: %d Hardness: %d", this.supplements.size(), sumHardness()))
                .append(System.lineSeparator());

        return out.toString().trim();
    }
}
