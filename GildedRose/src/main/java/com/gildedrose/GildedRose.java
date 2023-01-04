package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    /**
     * for loop that goes over every item in the list items
     * and calls the method updateItem for every item.
     */
    void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQuality(items[i]);
            updateSellIn(items[i]);
        }
    }
    /**
     * Check if product is Sulfuras or AgedBrie or not. If not sellIn value should decrease. Else increase
     */
    void updateQuality(Item item) {
                if (!item.name.equals("Aged Brie")&& !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    decreaseQualityIfItemHasQuality(item);
                } else {
                    increaseQualityIncludingBackstagePasses(item);
                }
    }
    /**
     * Check if product has Quality or not. If so it will call decrease quality
     */
    static void decreaseQualityIfItemHasQuality(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }
    }
    /**
     * Check if product is Sulfuras or not. If not quality will be decreased
     */
    static void decreaseQuality(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
        }
    }

    /**
     *
     * Checks if quality is below 50. if yes it will call the methods increaseQuality & increaseQualityOfBackstagePasses
     */
    static void increaseQualityIncludingBackstagePasses(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
            increaseQualityOfBackstagePasses(item);
        }
    }

    /**
     * Backstage passes increase in quality with different values
     * the shorter to the concert date, the bigger the increase value
     */

    static void increaseQualityOfBackstagePasses(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityIfFarFromExpiry(item);
            increaseQualityIfCloseToExpiry(item);
        }
    }
    /**
     * Backstage passes increase in quality with different values
     * the shorter to the concert date, the bigger the increase value
     * less than 50 +1
     * if less than 10 +2
     * if less than 6 +3
     */
    static void increaseQualityIfCloseToExpiry(Item item) {
        if (item.sellIn < 6) {
            increaseQualityIfNotMax(item);
        }
    }
    /**
     * Backstage passes increase in quality with different values
     * the shorter to the concert date, the bigger the increase value
     * less than 50 +1
     * if less than 10 +2
     * if less than 6 +3
     */
    static void increaseQualityIfFarFromExpiry(Item item) {
        if (item.sellIn < 11) {
            increaseQualityIfNotMax(item);
        }
    }
    /**
     * checks if quality has not reached the max value
     */
    static void increaseQualityIfNotMax(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }
    }
    /**
     * this method increases the quality value by 1
     */
    static void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    /**
     *
     * checks if item is Sulfuras or not. If not, it will decrease the sellIn with 1.
     * If yes it will call the method handleIfExpired
     */
    void updateSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
        handleIfExpired(item);
    }

    /**
     * checks if sellIn value is below zero
     * if yes it calls the method handleExpired
     */
    void handleIfExpired(Item item) {
        if (item.sellIn < 0) {
            handleExpired(item);
        }
    }

    /**
     * Checks if item is AgedBrie or not. If not, it will call the method  handleExpiredItemNotAgedBrie.
     * It yes, it will call the method  increaseQualityIfNotMax.
     *
     */
    static void handleExpired(Item item) {
        if (!item.name.equals("Aged Brie")) {
            handleExpiredItemNotAgedBrie(item);
        } else {
            increaseQualityIfNotMax(item);
        }
    }

    /**
     *
     * Checks if item is backstage passes or not. If not, it calls the method  decreaseQualityIfItemHasQuality
     * if yes, it will set the quality to 0
     */
    static void handleExpiredItemNotAgedBrie(Item item) {
        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            decreaseQualityIfItemHasQuality(item);
        } else {
            item.quality = 0;
        }
    }


}