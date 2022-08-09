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

    def "should darken lights on specified area"() {
        given: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)
        and: "Light lights on specified area."
            lights.lighten(Point.of(0, 0), Point.of(9, 9))

        when: "Turn off lights on specified area."
            lights.darken(Point.of(1, 1), Point.of(8, 8))

        then: "Some lights are darkened by 1."
            lights.countBrightness() == 36
    }

    def "should cannot darken lights to negative number of brightness"() {
        when: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)

        then: "Brightness is zero."
            lights.countBrightness() == 0

        when: "Darken lights on specified area."
            lights.darken(Point.of(0, 0), Point.of(9, 9))

        then: "Brightness is still zero."
            lights.countBrightness() == 0
    }
}
