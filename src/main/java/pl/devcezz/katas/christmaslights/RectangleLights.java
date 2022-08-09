package pl.devcezz.katas.christmaslights;

import java.util.Arrays;
import java.util.stream.Stream;

class RectangleLights {

    private final Light[][] area;

    RectangleLights(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("side must be positive");
        }

        area = new Light[side][side];

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                area[i][j] = Light.turnedOff();
            }
        }
    }

    long countTurnedOffLights() {
        return streamOfLights().count() - countTurnedOnLights();
    }

    long countTurnedOnLights() {
        return streamOfLights()
                .filter(Light::isTurnedOn)
                .count();
    }

    public void turnOn(Point leftBottomCorner, Point rightTopCorner) {
        if (leftBottomCorner == null || rightTopCorner == null) {
            throw new IllegalArgumentException("points cannot be null");
        }
        if (leftBottomCorner.x() > rightTopCorner.x()) {
            throw new IllegalArgumentException("left corner cannot be greater then right corner");
        }
        if (leftBottomCorner.y() > rightTopCorner.y()) {
            throw new IllegalArgumentException("bottom corner cannot be greater then top corner");
        }

        int horizontalLengthOfArea = rightTopCorner.x() - leftBottomCorner.x();
        int verticalLengthOfArea = rightTopCorner.y() - leftBottomCorner.y();

        int startingHorizontalPosition = leftBottomCorner.x();
        int endingHorizontalPosition = leftBottomCorner.x() + horizontalLengthOfArea;

        int startingVerticalPosition = leftBottomCorner.y();
        int endingVerticalPosition = leftBottomCorner.y() + verticalLengthOfArea;

        for (int i = startingHorizontalPosition; i <= endingHorizontalPosition; i++) {
            for (int j = startingVerticalPosition; j <= endingVerticalPosition; j++) {
                Light light = area[i][j];
                light.turnOn();
            }
        }
    }

    private Stream<Light> streamOfLights() {
        return Arrays.stream(area).flatMap(Arrays::stream);
    }
}

class Light {

    private boolean turnedOn;

    private Light(boolean turnedOn) {
        this.turnedOn = turnedOn;
    }

    static Light turnedOff() {
        return new Light(false);
    }

    void turnOn() {
        this.turnedOn = true;
    }

    boolean isTurnedOn() {
        return turnedOn;
    }
}
