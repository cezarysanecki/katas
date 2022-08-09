package pl.devcezz.katas.christmaslights;

import java.util.Arrays;

class RectangleLights {

    private final Light[][] area;

    RectangleLights(int side) {
        area = new Light[side][side];

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                area[i][j] = Light.turnedOff();
            }
        }
    }

    long countTurnedOffLights() {
        return Arrays.stream(area).flatMap(Arrays::stream).count() - countTurnedOnLights();
    }

    long countTurnedOnLights() {
        return Arrays.stream(area)
                .flatMap(Arrays::stream)
                .filter(Light::isTurnedOn)
                .count();
    }

    public void turnOn(Point leftBottomCorner, Point rightTopCorner) {
        for (int i = leftBottomCorner.x(); i <= leftBottomCorner.x() + (rightTopCorner.x() - leftBottomCorner.x()); i++) {
            for (int j = leftBottomCorner.y(); j <= leftBottomCorner.y() + (rightTopCorner.y() - leftBottomCorner.y()); j++) {
                area[i][j].turnOn();
            }
        }
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
