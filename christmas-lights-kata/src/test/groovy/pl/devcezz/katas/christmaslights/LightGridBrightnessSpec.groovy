package pl.devcezz.katas.christmaslights

import spock.lang.Specification

class LightGridBrightnessSpec extends Specification {

    def "should brightness be zero when instantiate light gird"() {
        when: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)

        then: "Brightness is zero."
            lights.countBrightness() == 0
    }

    def "should brighten lights on specified area"() {
        given: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)

        when: "Brighten lights on specified area."
            lights.brighten(Point.of(firstX, firstY), Point.of(secondX, secondY))

        then: "All lights are brightened by 1."
            lights.countBrightness() == expectedBrightness

        where:
            firstX | firstY | secondX | secondY || expectedBrightness
            0      | 0      | 3       | 4       || 20
            2      | 3      | 4       | 5       || 9
            1      | 1      | 9       | 9       || 81
            4      | 4      | 7       | 9       || 24
    }

    def "should darken lights on specified area"() {
        given: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)
        and: "Brighten all lights."
            lights.brighten(Point.of(0, 0), Point.of(9, 9))

        when: "Darken lights on specified area."
            lights.darken(Point.of(1, 1), Point.of(8, 8))

        then: "Some lights are darkened by 1."
            lights.countBrightness() == 36
    }

    def "should not be able to darken lights to negative number of brightness"() {
        when: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)

        then: "Brightness is zero."
            lights.countBrightness() == 0

        when: "Darken lights on specified area."
            lights.darken(Point.of(0, 0), Point.of(9, 9))

        then: "Brightness is still zero."
            lights.countBrightness() == 0
    }

    def "should brighten more lights"() {
        given: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)

        when: "Brighten more all lights."
            lights.brightenMore(Point.of(0, 0), Point.of(9, 9))

        then: "All lights are brightened by 2."
            lights.countBrightness() == 200
    }
}
