package racingcar;

import java.util.ArrayList;
import java.util.Random;

public class Racing {
    public static final int POS_BOUND = 10;
    public static final int POS_CAR_INIT = 1;

    private static int time;
    private ArrayList<Car> cars = new ArrayList<>();

    public Racing(String[] carNames) {
        init(carNames);
    }

    public void init(String[] carNames) {
        for (String carName : carNames) {
            Car car = new Car(carName, POS_CAR_INIT);
            cars.add(car);
        }
    }

    public void run() {
        for (int i = 0; i < time; i++) {
            selectCar();
        }
    }

    public void selectCar() {
        for (Car car : cars) {
            addPos(car);  // move each car
        }
    }

    public void addPos(Car car) {
        Random random = new Random();
        car.addPosition(random.nextInt(POS_BOUND));
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public static void main(String[] args) {
        ArrayList<String> racingInfos = InputView.userInput();
        Racing.time = Integer.parseInt(racingInfos.get(1));
        Racing racing = new Racing(racingInfos.get(0).split(","));
        racing.run();
        ResultView.printPos(racing.getCars());
        ResultView.printResult(racing.getCars());
    }
}
