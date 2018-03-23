package map.level;

import entity.Player;
import main.GameManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Passageway {
    /*
    * Passageway class creates the passages between the rooms, and also the doors in the rooms.
    * It will need to add the door coordinates to the rooms as it creates them.
     */

    private Room roomFrom;
    private Room roomTo;

    public Passageway(Room roomFrom, Room roomTo) {
        this.roomFrom = roomFrom;
        this.roomTo = roomTo;

        createDoorway(roomFrom);
        createDoorway(roomTo);
    }
    private void createDoorway(Room room) {
        ArrayList<Integer> directions = getDirections(room.getZone());

        int doorFrom = directions.get(new Random().nextInt(directions.size()));

        if (doorFrom == Player.DOWN) {
            Point door = new Point(new Random().nextInt(
                    (int) (room.getCenter().getX() + Math.floor(room.getSize().getWidth() / 2)) -
                            (int) (room.getCenter().getX() - Math.floor(room.getSize().getWidth() / 2) + 1)
                    ) + (int) (room.getCenter().getX() - Math.floor(room.getSize().getWidth() / 2)),
                    (int) (room.getCenter().getY() - Math.floor(room.getSize().getHeight() / 2)));
            // room.getCenter().getY() - Math.floor(room.getHeight() / 2)
            GameManager.getTable().getModel().setValueAt("+", door.y, door.x);
        } else if (doorFrom == Player.UP) {

        } else if (doorFrom == Player.RIGHT) {

        } else if (doorFrom == Player.LEFT) {

        }
    }
    private ArrayList<Integer> getDirections(int zone) {
        ArrayList<Integer> directions = new ArrayList<>();
        if (zone == 0) {
            // Doors can be down or right
            directions.add(Player.DOWN);
            directions.add(Player.RIGHT);
        } else if (zone == 1) {
            // Doors can be down right or left
            directions.add(Player.DOWN);
            directions.add(Player.RIGHT);
            directions.add(Player.LEFT);
        } else if (zone == 2) {
            // Doors can be down or left
            directions.add(Player.DOWN);
            directions.add(Player.LEFT);
        } else if (zone == 3) {
            // Doors can be up down or right
            directions.add(Player.DOWN);
            directions.add(Player.RIGHT);
        } else if (zone == 4) {
            // Doors can be any direction
            directions.add(Player.DOWN);
            directions.add(Player.UP);
            directions.add(Player.RIGHT);
            directions.add(Player.LEFT);
        } else if (zone == 5) {
            // Doors can be up down or left
            directions.add(Player.DOWN);
            directions.add(Player.UP);
            directions.add(Player.LEFT);
        } else if (zone == 6) {
            // Doors can be up or right
            directions.add(Player.UP);
            directions.add(Player.RIGHT);
        } else if (zone == 7) {
            // Doors can be up right or left
            directions.add(Player.UP);
            directions.add(Player.RIGHT);
            directions.add(Player.LEFT);
        } else if (zone == 8) {
            // Doors can be up or left
            directions.add(Player.UP);
            directions.add(Player.LEFT);
        } else {
            throw new ArrayIndexOutOfBoundsException("YEET");
        }
        return directions;
    }
}