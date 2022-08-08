package pl.devcezz.katas.christmaslights;

class RectangleLights {

    private final int firstSide;
    private final int secondSide;

    RectangleLights(int firstSide, int secondSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }

    int countTurnedOffLights() {
        return firstSide * secondSide;
    }
}
