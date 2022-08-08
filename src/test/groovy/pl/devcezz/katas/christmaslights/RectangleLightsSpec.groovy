package pl.devcezz.katas.christmaslights

import spock.lang.Specification

class RectangleLightsSpec extends Specification {

    def "should all lights be turned off on start when instantiate square of lights"() {
        when: "Prepare rectangle of lights."
            RectangleLights lights = new RectangleLights(firstSideOfRectagle, secondSideOfRectagle)

        then: "All lights are turned off."
            lights.countTurnedOffLights() == expectedTurnedOffLights

        where:
            firstSideOfRectagle | secondSideOfRectagle || expectedTurnedOffLights
            10                  | 10                   || 100
            2                   | 3                    || 6
            15                  | 12                   || 180
    }
}
