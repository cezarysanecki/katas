package pl.devcezz.katas.christmaslights;

class Lights {

    private int firstSide;
    private int secondSide;

    Lights(int firstSide, int secondSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
    }


    public int getTurnedOffLights() {
        return firstSide * secondSide;
    }
}
