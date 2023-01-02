package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
   void systemLowersValues() {
        Item[] items = new Item[]{new Item("foo", 15, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(24, app.items[0].quality);
}
    @Test
    void qualityDegradesTwiceAsFast() {
        Item[] items = new Item[] { new Item("foo", 0, 25) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
 }
    @Test
    void qualityIsNeverNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 25)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
 }


    }
