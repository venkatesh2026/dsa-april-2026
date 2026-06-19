import java.util.*;
import java.util.stream.Collectors;

public class CarFleet {

    public static void main(String[] args) {

        int target = 10;
        int[] positions = {0, 4, 2};
        int[] speeds = {2, 1, 3};
        System.out.println(carFleet(target, positions, speeds));

    }

    public static int carFleet(int target, int[] position, int[] speed) {
        List<Map.Entry<Integer, Float>> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            AbstractMap.SimpleEntry<Integer, Float> car = new AbstractMap.SimpleEntry<>(position[i], (float) (target - position[i]) / speed[i]);
            cars.add(car);
        }
        Collections.sort(cars, (Map.Entry<Integer, Float> e1, Map.Entry<Integer, Float> e2) -> e2.getKey() - e1.getKey());
        int count = 1;
        float lastCarRequiredTime = 0;
        for (Map.Entry<Integer, Float> entry : cars) {
            if (lastCarRequiredTime == 0) {
                lastCarRequiredTime = entry.getValue();
            } else {
                if (lastCarRequiredTime >= entry.getValue()) {
                    //last car take more time so will both form single fleet,so need to increase fleet count
                    continue;
                } else {
                    count++;
                    lastCarRequiredTime = entry.getValue();
                }
            }
        }
        return count;
    }
}
