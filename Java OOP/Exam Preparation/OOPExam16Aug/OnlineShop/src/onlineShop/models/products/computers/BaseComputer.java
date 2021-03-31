package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getOverallPerformance() {
        double performance = this.components.isEmpty()
                ? 0
                : this.components.stream()
                .mapToDouble(Product::getOverallPerformance)
                .average().getAsDouble();
        return super.getOverallPerformance() + performance;
    }

    @Override
    public double getPrice() {
        double sumPeripherals = this.peripherals.stream().mapToDouble(Product::getPrice).sum();
        double sumComponents = this.components.stream().mapToDouble(Product::getPrice).sum();
        return super.getPrice() + sumPeripherals + sumComponents;
    }

    @Override
    public List<Component> getComponents() {
        return Collections.unmodifiableList(this.components);
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return Collections.unmodifiableList(this.peripherals);
    }

    @Override
    public void addComponent(Component component) {
        Component componentExists = this.components.stream()
                .filter(c -> c.getClass().getSimpleName().equals(component.getClass().getSimpleName()))
                .findFirst()
                .orElse(null);
        if (componentExists != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,
                    component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        Component component = this.components.stream()
                .filter(c -> c.getClass().getSimpleName().equals(componentType))
                .findFirst()
                .orElse(null);
        if (component == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
                    componentType, this.getClass().getSimpleName(), this.getId()));
        }
        this.components.remove(component);
        return component;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        Peripheral peripheralExists = this.peripherals.stream()
                .filter(c -> c.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName()))
                .findFirst()
                .orElse(null);
        if (peripheralExists != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL,
                    peripheralExists.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral peripheral = this.peripherals.stream()
                .filter(c -> c.getClass().getSimpleName().equals(peripheralType))
                .findFirst()
                .orElse(null);
        if (peripheral == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                    peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.remove(peripheral);
        return peripheral;
    }

    @Override
    public String toString() {
        return (super.toString() + System.lineSeparator() +
                String.format(OutputMessages.COMPUTER_COMPONENTS_TO_STRING, this.components.size()) +
                (this.components.size() > 0 ? System.lineSeparator() : "") +
                this.components.stream().map(e -> "  " + e.toString()).collect(Collectors.joining(System.lineSeparator())) +
                System.lineSeparator() +
                String.format(OutputMessages.COMPUTER_PERIPHERALS_TO_STRING,
                        this.peripherals.size(),
                        this.peripherals.stream()
                                .mapToDouble(Product::getOverallPerformance)
                                .average().orElse(0)) +
                System.lineSeparator() +
                this.peripherals.stream().map(e -> "  " + e.toString()).collect(Collectors.joining(System.lineSeparator()))).trim();
    }
}
