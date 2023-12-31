package ci.dojo.TondeuseKata.core;

import ci.dojo.TondeuseKata.core.input.Input;

import java.util.UUID;

public class endpoint {

    private Input input;
    private static String[] zoneOfWorking;
    private static String[] initializeTondeusePosition;

    private static String perimetter;

    public static void main(String[] args) {
        Input input = new FileSystemInput();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(1).split(" ");
        perimetter = input.sharePosition().get(2);

        // Given
        Terrain terrain = new Terrain(
                Integer.parseInt(zoneOfWorking[0]),
                Integer.parseInt(zoneOfWorking[1])
        );
        Coordonner coordonner = new Coordonner(
                Integer.parseInt(initializeTondeusePosition[0]),
                Integer.parseInt(initializeTondeusePosition[1]),
                initializeTondeusePosition[2]
        );
        Tondeuse tondeuse = new Tondeuse(UUID.randomUUID(), "V1.0", coordonner, terrain);

        // when
        tondeuse.pilot(perimetter);

        System.out.println(tondeuse);
    }
}
