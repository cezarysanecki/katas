package pl.devcezz.katas.christmaslights;

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
