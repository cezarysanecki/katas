package pl.devcezz.katas.christmaslights;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

class LightGrid {

    private final Light[][] area;

    LightGrid(int side) {
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

    @Deprecated
    void turnOn(Point leftBottomCorner, Point rightTopCorner) {
        if (leftBottomCorner == null || rightTopCorner == null) {
            throw new IllegalArgumentException("points cannot be null");
        }

        Area area = prepareArea(leftBottomCorner, rightTopCorner);

        makeActionOnEveryLightInArea(area, Light::turnOn);
    }

    @Deprecated
    void turnOff(Point leftBottomCorner, Point rightTopCorner) {
        if (leftBottomCorner == null || rightTopCorner == null) {
            throw new IllegalArgumentException("points cannot be null");
        }

        Area area = prepareArea(leftBottomCorner, rightTopCorner);

        makeActionOnEveryLightInArea(area, Light::turnOff);
    }

    @Deprecated
    void toggle(Point leftBottomCorner, Point rightTopCorner) {
        if (leftBottomCorner == null || rightTopCorner == null) {
            throw new IllegalArgumentException("points cannot be null");
        }

        Area area = prepareArea(leftBottomCorner, rightTopCorner);

        makeActionOnEveryLightInArea(area, Light::toggle);
    }

    @Deprecated
    long countTurnedOffLights() {
        return streamOfLights().count() - countTurnedOnLights();
    }

    @Deprecated
    long countTurnedOnLights() {
        return streamOfLights()
                .filter(Light::isTurnedOn)
                .count();
    }

    void brighten(Point leftBottomCorner, Point rightTopCorner) {
        if (leftBottomCorner == null || rightTopCorner == null) {
            throw new IllegalArgumentException("points cannot be null");
        }

        Area area = prepareArea(leftBottomCorner, rightTopCorner);

        makeActionOnEveryLightInArea(area, Light::brighten);
    }

    public void brightenMore(Point leftBottomCorner, Point rightTopCorner) {
        if (leftBottomCorner == null || rightTopCorner == null) {
            throw new IllegalArgumentException("points cannot be null");
        }

        Area area = prepareArea(leftBottomCorner, rightTopCorner);

        makeActionOnEveryLightInArea(area, Light::brightenMore);
    }

    public void darken(Point leftBottomCorner, Point rightTopCorner) {
        if (leftBottomCorner == null || rightTopCorner == null) {
            throw new IllegalArgumentException("points cannot be null");
        }

        Area area = prepareArea(leftBottomCorner, rightTopCorner);

        makeActionOnEveryLightInArea(area, Light::darken);
    }

    int countBrightness() {
        return streamOfLights().mapToInt(Light::getBright).sum();
    }

    private Stream<Light> streamOfLights() {
        return Arrays.stream(area).flatMap(Arrays::stream);
    }

    private Area prepareArea(Point leftBottomCorner, Point rightTopCorner) {
        int horizontalLengthOfArea = rightTopCorner.x() - leftBottomCorner.x();
        int verticalLengthOfArea = rightTopCorner.y() - leftBottomCorner.y();

        return new Area(
                leftBottomCorner.x(), leftBottomCorner.x() + horizontalLengthOfArea,
                leftBottomCorner.y(), leftBottomCorner.y() + verticalLengthOfArea);
    }

    private void makeActionOnEveryLightInArea(Area area, Consumer<Light> action) {
        for (int i = area.startingHorizontalPosition(); i <= area.endingHorizontalPosition(); i++) {
            for (int j = area.startingVerticalPosition(); j <= area.endingVerticalPosition(); j++) {
                Light light = this.area[i][j];
                action.accept(light);
            }
        }
    }

    private record Area(int startingHorizontalPosition, int endingHorizontalPosition,
                        int startingVerticalPosition, int endingVerticalPosition) {
        Area {
            if (startingHorizontalPosition > endingHorizontalPosition) {
                throw new IllegalArgumentException("left corner cannot be greater then right corner");
            }
            if (startingVerticalPosition > endingVerticalPosition) {
                throw new IllegalArgumentException("bottom corner cannot be greater then top corner");
            }
        }
    }
}

class Light {

    private boolean turnedOn;
    private int bright;

    private Light(boolean turnedOn, int bright) {
        this.turnedOn = turnedOn;
        this.bright = bright;
    }

    @Deprecated
    static Light turnedOff() {
        return new Light(false, 0);
    }

    static Light zeroBright() {
        return new Light(false, 0);
    }

    void brighten() {
        this.bright++;
    }

    void brightenMore() {
        this.bright += 2;
    }

    void darken() {
        if (this.bright == 0) {
            return;
        }
        this.bright--;
    }

    int getBright() {
        return bright;
    }

    @Deprecated
    void turnOn() {
        this.turnedOn = true;
    }

    @Deprecated
    void turnOff() {
        this.turnedOn = false;
    }

    @Deprecated
    void toggle() {
        this.turnedOn = !this.turnedOn;
    }

    @Deprecated
    boolean isTurnedOn() {
        return turnedOn;
    }
}
