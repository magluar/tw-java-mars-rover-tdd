package com.afs.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarsRover {
    private RoverStatus roverStatus;

    public MarsRover(RoverStatus roverStatus) {
        this.roverStatus = roverStatus;
    }

    public void executeCommand(String command) {
        if(command.length() > 1){
            executeCommands(command);
        }
        if (command.equals("M")){
            move();
        }
        if (command.equals("L")){
            turnLeft();
        }
        if (command.equals("R")){
            turnRight();
        }
    }

    private void executeCommands(String command) {
        List<String> commands = Arrays.asList(command.split(""));
        commands.forEach(toExecute -> executeCommand(String.valueOf(toExecute)));
    }

    private void turnRight() {
        final int locationX = roverStatus.getLocationX();
        final int locationY = roverStatus.getLocationY();
        final String direction = roverStatus.getDirection();
        String newDirection = direction;

        if (direction.equals("N")){
            newDirection = "E";
        }
        if (direction.equals("S")){
            newDirection = "W";
        }
        if (direction.equals("E")){
            newDirection = "S";
        }
        if (direction.equals("W")){
            newDirection = "N";
        }
        roverStatus = new RoverStatus(locationX, locationY, newDirection);
    }

    private void turnLeft() {
        final int locationX = roverStatus.getLocationX();
        final int locationY = roverStatus.getLocationY();
        final String direction = roverStatus.getDirection();
        String newDirection = direction;

        if (direction.equals("N")){
            newDirection = "W";
        }
        if (direction.equals("S")){
            newDirection = "E";
        }
        if (direction.equals("E")){
            newDirection = "N";
        }
        if (direction.equals("W")){
            newDirection = "S";
        }
        roverStatus = new RoverStatus(locationX, locationY, newDirection);
    }

    private void move() {
        final int locationX = roverStatus.getLocationX();
        final int locationY = roverStatus.getLocationY();
        final String direction = roverStatus.getDirection();

        if(direction.equals("N")){
            roverStatus = new RoverStatus(locationX, locationY + 1, direction);
        }
        if(direction.equals("S")){
            roverStatus = new RoverStatus(locationX, locationY - 1, direction);
        }
        if(direction.equals("E")){
            roverStatus = new RoverStatus(locationX + 1, locationY, direction);
        }
        if(direction.equals("W")){
            roverStatus = new RoverStatus(locationX - 1, locationY, direction);
        }
    }

    public RoverStatus getRoverStatus() {
        return roverStatus;
    }
}
