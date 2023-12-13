package ci.dojo.TondeuseKata;

import ci.dojo.TondeuseKata.core.Coordonner;
import ci.dojo.TondeuseKata.core.Terrain;
import ci.dojo.TondeuseKata.core.Tondeuse;
import ci.dojo.TondeuseKata.core.input.Input;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TondeuseTest {

    private Input input;
    private String[] zoneOfWorking;
    private String[] initializeTondeusePosition;


    @Test void shoudValidateInputWithPattern_2INTSpaceBetween_2INT1CHARSpaceBetween_DrivenWithAlowinCharDGA(){

        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(1).split(" ");
        

        assertEquals(2, zoneOfWorking.length);
        assertEquals(3, initializeTondeusePosition.length);

        assertDoesNotThrow(()-> {
            Integer.parseInt(zoneOfWorking[0]);
            Integer.parseInt(zoneOfWorking[1]);

            Integer.parseInt(initializeTondeusePosition[0]);
            Integer.parseInt(initializeTondeusePosition[1]);
        });

        assertThrows(NumberFormatException.class, ()-> {
            Integer.parseInt(initializeTondeusePosition[2]);
        });

        String inputString = "GAGAGAGAA";
        String regex = "[DGA]*";
        boolean matcher = inputString.matches(regex);
        assertTrue(matcher);
    }

    @Test void shouldRotatedTo_WEST_If_NORTH_take_G(){

        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(1).split(" ");

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
        tondeuse.pilot("G");
        // then
        assertEquals("1 2 W", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void should_GOTOCASE_02W_take_GA(){

        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(1).split(" ");

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
        tondeuse.pilot("G A");
        // then
        assertEquals("0 2 W", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shouldRotatedTo_SOUTH_If_NORTH_take_GAG(){

        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(1).split(" ");


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
        tondeuse.pilot("G A G");
        // then
        assertEquals("0 2 S", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void should_GOTO_01S_take_GAGA() {

        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(1).split(" ");
        

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
        tondeuse.pilot("G A G A");
        // then
        assertEquals("0 1 S", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shouldRotatedTo_EAST_If_SOUTH_take_GAGAG(){

        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(1).split(" ");
        

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
        tondeuse.pilot("G A G A G");
        // then
        assertEquals("0 1 E", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void should_GOTOCASE_11E_If_take_GAGAGA(){

        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(1).split(" ");
        

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
        tondeuse.pilot("G A G A G A");
        // then
        assertEquals("1 1 E", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shouldRotatedTo_NORTH_If_EAST_take_GAGAGAG(){

        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(1).split(" ");
        

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
        tondeuse.pilot("G A G A G A G");
        // then
        assertEquals("1 1 N", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void should_GOTO_12N_IF_11N_TAKE_GAGAGAGA(){

        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(1).split(" ");
        

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
        tondeuse.pilot("G A G A G A G A");
        // then
        assertEquals("1 2 N", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void should_GOTO_13N_IF_12N_TAKE_GAGAGAGAA(){

        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(1).split(" ");
        

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
        tondeuse.pilot("G A G A G A G A A");
        // then
        assertEquals("1 3 N", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shoud_return_43E_if_passed_A(){
        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(3).split(" ");
        

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
        tondeuse.pilot("A");
        // then
        assertEquals("4 3 E", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shoud_return_53E_if_passed_AA(){
        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(3).split(" ");
        

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
        tondeuse.pilot("A A");
        // then
        assertEquals("5 3 E", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shoud_return_53S_if_passed_AAD(){
        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(3).split(" ");
        

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
        tondeuse.pilot("A A D");
        // then
        assertEquals("5 3 S", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shoud_return_52S_if_passed_AADA(){
        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(3).split(" ");
        

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
        tondeuse.pilot("A A D A");
        // then
        assertEquals("5 2 S", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shoud_return_51S_if_passed_AADAA(){
        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(3).split(" ");
        

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
        tondeuse.pilot("A A D A A");
        // then
        assertEquals("5 1 S", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shoud_return_51W_if_passed_AADAAD(){
        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(3).split(" ");
        

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
        tondeuse.pilot("A A D A A D");
        // then
        assertEquals("5 1 W", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shoud_return_41W_if_passed_AADAADA(){
        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(3).split(" ");
        

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
        tondeuse.pilot("A A D A A D A");
        // then
        assertEquals("4 1 W", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shoud_return_41N_if_passed_AADAADAD(){
        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(3).split(" ");
        

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
        tondeuse.pilot("A A D A A D A D");
        // then
        assertEquals("4 1 N", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shoud_return_41E_if_passed_AADAADADD(){
        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(3).split(" ");
        

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
        tondeuse.pilot("A A D A A D A D D");
        // then
        assertEquals("4 1 E", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void should_GOTO_13N_IF_12N_TAKE_AADAADADDA(){

        input = new StringListInputImpl();
        zoneOfWorking = input.sharePosition().get(0).split(" ");
        initializeTondeusePosition = input.sharePosition().get(3).split(" ");
        

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
        tondeuse.pilot("A A D A A D A D D A");
        // then
        assertEquals("5 1 E", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shoud_00W_IF_00W_passed_A(){
        // Given
        Terrain terrain = new Terrain(
                5,
                5
        );
        Coordonner coordonner = new Coordonner(
                0,
                0,
                "W"
        );
        Tondeuse tondeuse = new Tondeuse(UUID.randomUUID(), "V1.0", coordonner, terrain);
        // when
        tondeuse.pilot("A");
        // then
        assertEquals("0 0 W", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }

    @Test void shoud_55E_IF_55E_passed_A(){
        // Given
        Terrain terrain = new Terrain(
                5,
                5
        );
        Coordonner coordonner = new Coordonner(
                5,
                5,
                "E"
        );
        Tondeuse tondeuse = new Tondeuse(UUID.randomUUID(), "V1.0", coordonner, terrain);
        // when
        tondeuse.pilot("A");
        // then
        assertEquals("5 5 E", String.format("%s %s %s",
                tondeuse.getCoordonner().getX(),
                tondeuse.getCoordonner().getY(),
                tondeuse.getCoordonner().getDirection())
        );
    }
}