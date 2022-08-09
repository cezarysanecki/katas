package pl.devcezz.katas.christmaslights;

import java.util.Arrays;
import java.util.function.Consumer;

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

    void brighten(Point leftBottomCorner, Point rightTopCorner) {
        makeActionOnEveryLightInArea(
                prepareArea(leftBottomCorner, rightTopCorner),
                Light::brighten);
    }

    void brightenMore(Point leftBottomCorner, Point rightTopCorner) {
        makeActionOnEveryLightInArea(
                prepareArea(leftBottomCorner, rightTopCorner),
                Light::brightenMore);
    }

    void darken(Point leftBottomCorner, Point rightTopCorner) {
        makeActionOnEveryLightInArea(
                prepareArea(leftBottomCorner, rightTopCorner),
                Light::darken);
    }

    int countBrightness() {
        return Arrays.stream(area)
                .flatMap(Arrays::stream)
                .mapToInt(Light::getBright).sum();
    }

    private Area prepareArea(Point leftBottomCorner, Point rightTopCorner) {
        if (leftBottomCorner == null || rightTopCorner == null) {
            throw new IllegalArgumentException("points cannot be null");
        }

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

