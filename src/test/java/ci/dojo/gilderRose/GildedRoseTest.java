package ci.dojo.gilderRose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {

    @Test @Disabled
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test void shoudReturnMangue1010WhenPassedMangue1010(){
        Item[] items = new Item[]{ new Item("Mangue", 10, 10) };
        GildedRose app = new GildedRose(items);
        assertEquals("Mangue", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }

    @Test void shoudReturn10firstDayAnd9TwoDay(){
        Item[] items = new Item[]{ new Item("Mangue", 10, 10) };
        GildedRose app = new GildedRose(items);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(10, app.items[0].sellIn);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(9, app.items[0].sellIn);
    }

    @Test void shouldReturn8QualityIfPassed10QualityAndProductTimeIsOut(){
        Item[] items = new Item[]{ new Item("Mangue", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test void shouldReturn0QualityIfPassed0QualityAndTime10(){
        Item[] items = new Item[]{ new Item("Mangue", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test void shouldReturn11QualityIfPassedQuality10ForAbegBriceProductAndTimeDiscrease(){
        Item[] items = new Item[]{ new Item("Aged Brie", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    // j'arrive a exposer mon pproduire dans l'app meme avec un quality 60
    @Test void shouldNotAllowConstructWithQualityMoreThan50(){
        Item[] items = new Item[]{ new Item("Aged Brie", 10, 60) };
        assertThrows(RuntimeException.class, () -> new GildedRose(items));
    }

    @Test void shouldReturn50IfProductActualQualityIs50AndIsAbegBriceProduct(){
        Item[] items = new Item[]{ new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test void shouldReturn50IfProductActualQualityIs50AndIsAbegBriceProductV2(){
        Item[] items = new Item[]{ new Item("aother", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test void shouldReturn40ifPassed40AndTime10Return09(){
        Item[] items = new Item[]{ new Item("Sulfuras, Hand of Ragnaros", 10, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(40, app.items[0].quality);
    }

    @Test void shouldReturn12QualityIfPassed10QualityAnd10dayForAbegBackStage(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test void shouldReturn12QualityIfPassed10QualityAnd8dayForBackStage(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 8, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test void shouldReturn13QualityIfPassed10QualityAnd5dayForBackStage(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test void shouldReturn13QualityIfPassed10QualityAnd3dayForBackStage(){
        Item[] items = new Item[]{ new Item("Backstage passes to a TAFKAL80ETC concert", 3, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test void shouldReturned8QualityIfPassed10QualityForConjured(){
        Item[] items = new Item[]{ new Item("Conjured", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

}