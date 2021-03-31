package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private GunRepository<Gun> guns;
    private PlayerRepository<Player> players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository<>();
        this.players = new PlayerRepository<>();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun;
        if (type.equals("Pistol")) {
            gun = new Pistol(name, bulletsCount);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name, bulletsCount);
        } else {
            throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }
        this.guns.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = this.guns.findByName(gunName);
        if (gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        Player player;
        if (type.equals("Terrorist")) {
            player = new Terrorist(username, health, armor, gun);
        } else if (type.equals("CounterTerrorist")) {
            player = new CounterTerrorist(username, health, armor, gun);
        } else {
            throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        this.players.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return this.field.start(this.players.getModels());
    }

    @Override
    public String report() {
        Collection<Player> models = this.players.getModels();
        models = models.stream()
                .sorted(Comparator.comparing(Player::getUsername))
                .sorted((a, b) -> Integer.compare(b.getHealth(), a.getHealth()))
                .sorted(Comparator.comparing(a -> a.getClass().getSimpleName()))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Player player : models) {
            sb.append(player.getClass().getSimpleName()).append(": ").append(player.getUsername()).append(System.lineSeparator())
                    .append("--Health: ").append(player.getHealth()).append(System.lineSeparator())
                    .append("--Armor: ").append(player.getArmor()).append(System.lineSeparator())
                    .append("--Gun: ").append(player.getGun().getName()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
