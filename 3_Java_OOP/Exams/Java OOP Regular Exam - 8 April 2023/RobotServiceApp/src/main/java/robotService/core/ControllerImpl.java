package robotService.core;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        switch (type) {
            case "MainService":
                    this.services.add(new MainService(name));
                break;
            case "SecondaryService":
                    this.services.add(new SecondaryService(name));
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_SERVICE_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        switch (type) {
            case "PlasticArmor":
                    this.supplements.addSupplement(new PlasticArmor());
                break;
            case "MetalArmor":
                    this.supplements.addSupplement(new MetalArmor());
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement supplement = this.supplements.findFirst(supplementType);

        if (supplement == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }

        this.supplements.removeSupplement(supplement);

        this.services.stream()
                .filter(service1 -> service1.getName().equals(serviceName))
                .findFirst()
                .ifPresent(service -> service.addSupplement(supplement));

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {
        Robot robot;

        switch (robotType) {
            case "MaleRobot": robot = new MaleRobot(robotName, robotKind, price);
                break;
            case "FemaleRobot": robot = new FemaleRobot(robotName, robotKind, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ROBOT_TYPE);
        }

        Service service = this.services.stream()
                .filter(service1 -> service1.getName().equals(serviceName))
                .findFirst()
                .orElse(null);

        assert service != null;

        if ((service.getClass().getSimpleName().equals("MainService") && robotType.equals("FemaleRobot")) ||
                (service.getClass().getSimpleName().equals("SecondaryService") && robotType.equals("MaleRobot"))) {
            return String.format(ConstantMessages.UNSUITABLE_SERVICE);
        }

        this.services.stream()
                .filter(service1 -> service1.getName().equals(serviceName))
                .findFirst()
                .ifPresent(service1 -> service1.addRobot(robot));

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service service = this.services.stream()
                .filter(serviceA -> serviceA.getName().equals(serviceName))
                .findFirst()
                .orElse(null);

        assert service != null;
        int count = service.getRobots().size(); // count the robots

        this.services.stream()
                .filter(service1 -> service1.getName().equals(serviceName))
                .findFirst()
                .ifPresent(Service::feeding); // feed the robots

        return String.format(ConstantMessages.FEEDING_ROBOT, count);
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service service = this.services.stream()
                .filter(service1 -> service1.getName().equals(serviceName))
                .findFirst()
                .orElse(null);

        assert service != null;

        double robotPrice = service.getRobots()
                .stream()
                .mapToDouble(Robot::getPrice)
                .sum();

        double supplementPrice = service.getSupplements()
                .stream()
                .mapToDouble(Supplement::getPrice)
                .sum();

        double totalPrice = robotPrice + supplementPrice;

        return String.format(ConstantMessages.VALUE_SERVICE, serviceName, totalPrice);
    }

    @Override
    public String getStatistics() {
        StringBuilder out = new StringBuilder();

        for (Service service : this.services) {
            out.append(service.getStatistics())
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }
}
