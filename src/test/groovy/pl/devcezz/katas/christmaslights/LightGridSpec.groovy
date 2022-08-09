package pl.devcezz.katas.christmaslights

import spock.lang.Specification

class LightGridSpec extends Specification {

    def "should all lights be turned off on start when instantiate square of lights"() {
        when: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(side)

        then: "All lights are turned off."
            lights.countTurnedOffLights() == expectedTurnedOffLights
        and: "None of lights are turned on."
            lights.countTurnedOnLights() == 0

        where:
            side || expectedTurnedOffLights
            10   || 100
            2    || 4
            15   || 225
    }

    def "should turn lights on on specified area"() {
        given: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)

        when: "Turn on lights on specified area."
            lights.turnOn(Point.of(firstX, firstY), Point.of(secondX, secondY))

        then: "Lights are turned on on specified area"
            lights.countTurnedOnLights() == expectedTurnedOnLights

        where:
            firstX | firstY | secondX | secondY || expectedTurnedOnLights
            0      | 0      | 3       | 4       || 20
            2      | 3      | 4       | 5       || 9
            1      | 1      | 9       | 9       || 81
            4      | 4      | 7       | 9       || 24
    }

    def "should turn lights off on specified area"() {
        given: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)
        and: "Turn on lights on specified area."
            lights.turnOn(Point.of(0, 0), Point.of(9, 9))

        when: "Turn off lights on specified area."
            lights.turnOff(Point.of(1, 1), Point.of(8, 8))

        then: "Lights are turned on on specified area"
            lights.countTurnedOnLights() == 36
    }

    def "should toggle lights on specified area"() {
        given: "Prepare rectangle of lights."
            LightGrid lights = new LightGrid(10)

        when: "Toggle lights on specified area."
            lights.toggle(Point.of(0, 0), Point.of(9, 9))

        then: "All lights are turned on."
            lights.countTurnedOnLights() == 100
        and:
            lights.countTurnedOffLights() == 0

        when: "Toggle lights on specified area."
            lights.toggle(Point.of(0, 0), Point.of(9, 9))

        then: "All lights are turned off."
            lights.countTurnedOnLights() == 0
        and:
            lights.countTurnedOffLights() == 100
    }
}
