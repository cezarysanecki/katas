package pl.devcezz.katas.christmaslights

import spock.lang.Specification

class LightGridBrightnessSpec extends Specification {

    def "should brightness be zero when instantiate light gird"() {
        when: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)

        then: "Brightness is zero."
            lights.countBrightness() == 0
    }

    def "should lighten lights on specified area"() {
        given: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)

        when: "Lighten lights on specified area."
            lights.lighten(Point.of(firstX, firstY), Point.of(secondX, secondY))

        then: "All lights are brightened by 1."
            lights.countBrightness() == expectedBrightness

        where:
            firstX | firstY | secondX | secondY || expectedBrightness
            0      | 0      | 3       | 4       || 20
            2      | 3      | 4       | 5       || 9
            1      | 1      | 9       | 9       || 81
            4      | 4      | 7       | 9       || 24
    }
}
