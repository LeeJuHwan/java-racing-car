package domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }
}
