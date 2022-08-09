package pl.devcezz.katas.christmaslights

import spock.lang.Specification

class LightGridBrightnessSpec extends Specification {

    def "should brightness be zero when instantiate light gird"() {
        when: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)

        then: "Brightness is zero."
            lights.countBrightness() == 0
    }
}
