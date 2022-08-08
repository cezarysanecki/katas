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
}
