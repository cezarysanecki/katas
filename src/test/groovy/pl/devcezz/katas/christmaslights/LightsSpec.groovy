package pl.devcezz.katas.christmaslights

import spock.lang.Specification

class LightsSpec extends Specification {

    def "should all lights be turned off on start"() {
        when: "Prepare rectangle of lights."
            Lights Lights = new Lights(firstSideOfRectagle, secondSideOfRectagle)

        then: "All lights are turned off."
            Lights.countTurnedOffLights() == expectedTurnedOffLights

        where:
            firstSideOfRectagle | secondSideOfRectagle || expectedTurnedOffLights
            10                  | 10                   || 100
            2                   | 3                    || 6
            15                  | 12                   || 180
    }
}
