package pl.devcezz.katas.christmaslights;

class Light {

    private int bright;

    private Light(int bright) {
        this.bright = bright;
    }

    static Light turnedOff() {
        return new Light(0);
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

}
