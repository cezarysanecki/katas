package pl.devcezz.katas.christmaslights

import spock.lang.Specification

class RectangleLightsSpec extends Specification {

    def "should all lights be turned off on start when instantiate square of lights"() {
        when: "Prepare rectangle of lights."
            RectangleLights lights = new RectangleLights(side)

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

    def "should turn lights on specified area"() {
        given: "Prepare rectangle of lights."
            RectangleLights lights = new RectangleLights(10)

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
}
