package pl.devcezz.katas.christmaslights

import spock.lang.Specification

class LightsSpec extends Specification {

    def "should all lights be turned off on start"() {
        when: "Prepare rectangle of lights."
            Lights Lights = new Lights(firstSideOfRectagle, secondSideOfRectagle)

        then: "All lights are turned off."
            Lights.getTurnedOffLigths().size() == turnedOffLights

        where:
            firstSideOfRectagle | secondSideOfRectagle || turnedOffLights
            10                  | 10                   || 100
            2                   | 3                    || 3
            15                  | 12                   || 180
    }
}
