package domain.car;

import exception.GameException;
import java.util.Objects;
import messages.ErrorMessage;

public class Car {

    private static final int CAR_NAME_LIMIT_LENGTH = 5;
    private static final int MOVE_FORWARD_THRESOLD = 4;
    private final String carName;
    private int position;

    public static Car from(String carName) {
        return new Car(carName, 0);
    }

    public static Car from(String carName, int position) {
        return new Car(carName, position);
    }

    public void moveForward(int moveThresold) {
        if (canMove(moveThresold)) {
            this.position++;
        }
    }

    private boolean canMove(int moveThresold) {
        if (validateMoveThresold(moveThresold)) {
            throw new GameException(ErrorMessage.invalidCarMoveThresold);
        }

        return moveThresold >= MOVE_FORWARD_THRESOLD;
    }

    private boolean validateMoveThresold(int moveThresold) {
        return moveThresold < 0 || moveThresold > 9;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }

    private Car(String carName, int position) {
        if (doesCarNameLengthZeroOrGreaterThanLimit(carName)) {
            throw new GameException(ErrorMessage.invalidCarName);
        }

        this.carName = carName;
        this.position = position;
    }

    private static boolean doesCarNameLengthZeroOrGreaterThanLimit(String carName) {
        return isNullOrEmpty(carName) || isGreaterThanLimit(carName);
    }

    private static boolean isGreaterThanLimit(String carName) {
        return carName.length() > CAR_NAME_LIMIT_LENGTH;
    }

    private static boolean isNullOrEmpty(String carName) {
        return carName == null || carName.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return position == car.position && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

}
