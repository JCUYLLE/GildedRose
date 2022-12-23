package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQuality(items[i]);
            updateSellIn(items[i]);
        }
    }

    private void updateQuality(Item item) {
                if (!item.name.equals("Aged Brie")&& !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    decreaseQualityIfItemHasQuality(item);
                } else {
                    increaseQualityIncludingBackstagePasses(item);
                }
    }

    private static void decreaseQualityIfItemHasQuality(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }
    }

    private static void decreaseQuality(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
        }
    }
    private static void decreaseQuality_TMP(Item item) {
        decreaseQuality();
        }
    }

    private static void increaseQualityIncludingBackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            increaseQualityOfBackstagePasses(item);
        }
    }

    private static void increaseQualityOfBackstagePasses(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQualityIfFarFromExpiry(item);
            increaseQualityIfCloseToExpiry(item);
        }
    }

    private static void increaseQualityIfCloseToExpiry(Item item) {
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }

    private static void increaseQualityIfFarFromExpiry(Item item) {
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
        handleIfExpired(item);
    }

    private void handleIfExpired(Item item) {
        if (item.sellIn < 0) {
            handleExpired(item);
        }
    }

    private static void handleExpired(Item item) {
        if (!item.name.equals("Aged Brie")) {
            if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    decreaseQuality_TMP(item);
                }
            } else {
                item.quality = item.quality - item.quality;
            }
        } else {
            increaseQuality(item);
        }
    }


}