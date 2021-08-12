package com.afs.tdd;

public class MarsRover {
    private RoverStatus roverStatus;

    public MarsRover(RoverStatus roverStatus) {
        this.roverStatus = roverStatus;
    }

    public void executeCommand(String command) {
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

    private void turnRight() {
        final int locationX = roverStatus.getLocationX();
        final int locationY = roverStatus.getLocationY();
        final String direction = roverStatus.getDirection();
        String newDirection = direction;

        if (direction.equals("N")){
            newDirection = "E";
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
        roverStatus = new RoverStatus(locationX, locationY, newDirection);
    }

    private void move() {
        final int locationX = roverStatus.getLocationX();
        final int locationY = roverStatus.getLocationY();
        final String direction = roverStatus.getDirection();
        roverStatus = new RoverStatus(locationX, locationY + 1, direction);
    }

    public RoverStatus getRoverStatus() {
        return roverStatus;
    }
}
