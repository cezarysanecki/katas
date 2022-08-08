package pl.devcezz.katas.christmaslights;

class RectangleLights {

    private final int side;

    RectangleLights(int side) {
        this.side = side;
    }

    int countTurnedOffLights() {
        return side * side;
    }

    int countTurnedOnLights() {
        return 0;
    }
}
