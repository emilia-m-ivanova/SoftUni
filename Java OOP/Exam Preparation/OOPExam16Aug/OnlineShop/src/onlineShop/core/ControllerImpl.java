package onlineShop.core;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.LinkedHashSet;
import java.util.Set;

public class ControllerImpl implements Controller {

    private Set<Computer> computers;
    private Set<Component> components;
    private Set<Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new LinkedHashSet<>();
        this.components = new LinkedHashSet<>();
        this.peripherals = new LinkedHashSet<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer = this.computers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
        if (computer != null) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
        }
        if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        } else if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }
        this.computers.add(computer);
        return String.format(OutputMessages.ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Computer computer = this.getComputer(computerId);
        Peripheral peripheral = this.peripherals.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
        if (peripheral != null) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
        }
        if (peripheralType.equals("Headset")) {
            peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Keyboard")) {
            peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Monitor")) {
            peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
        } else if (peripheralType.equals("Mouse")) {
            peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
        this.peripherals.add(peripheral);
        computer.addPeripheral(peripheral);
        return String.format(OutputMessages.ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Computer computer = this.getComputer(computerId);
        computer.removePeripheral(peripheralType);
        Peripheral peripheral = this.peripherals.stream()
                .filter(e -> e.getClass().getSimpleName().equals(peripheralType))
                .findFirst()
                .orElse(null);
        this.peripherals.remove(peripheral);
        return String.format(OutputMessages.REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Computer computer = this.getComputer(computerId);
        Component component = this.components.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
        if (component != null) {
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
        }
        if (componentType.equals("CentralProcessingUnit")) {
            component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("Motherboard")) {
            component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("PowerSupply")) {
            component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("RandomAccessMemory")) {
            component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("SolidStateDrive")) {
            component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
        } else if (componentType.equals("VideoCard")) {
            component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
        this.components.add(component);
        computer.addComponent(component);
        return String.format(OutputMessages.ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Computer computer = this.getComputer(computerId);
        computer.removeComponent(componentType);
        Component component = this.components.stream()
                .filter(e -> e.getClass().getSimpleName().equals(componentType))
                .findFirst()
                .orElse(null);
        this.components.remove(component);
        return String.format(OutputMessages.REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer computer = this.getComputer(id);
        this.computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computer = this.computers.stream()
                .filter(c -> c.getPrice() <= budget)
                .sorted((a, b) -> Double.compare(b.getOverallPerformance(), a.getOverallPerformance()))
                .findFirst()
                .orElse(null);
        if(computer==null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER,budget));
        }
        this.computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        Computer computer = this.getComputer(id);
        return computer.toString();
    }

    private Computer getComputer(int id) {
        Computer computer = this.computers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
        if (computer == null) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        return computer;
    }
}
