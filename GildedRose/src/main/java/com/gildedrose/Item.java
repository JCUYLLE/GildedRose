package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    /**
     * Check if product is Sulfuras or not. If not sellIn value should decrease
     */
    public void updateSellIn() {
        this.sellIn = (name.equals("Sulfuras, Hand of Ragnaros"))? this.sellIn : this.sellIn-1;
        }

    /**
     * This method updates the quality depending on which product it is as every product has its own characteristics
     */
    public void updateQuality() {
        if (name.equals("Aged Brie")) {
            this.quality= this.quality < 50 ? quality+1 : 50;
        }
        else if (name.equals("Sulfuras, Hand of Ragnaros")){
            this.quality=80;
        }
        else if (name.equals("Backstage passes to a TAFKAL80ETC concert")){
            setQualityBackstagePasses();
            notBelow0AndNotOver50();
        }
        else if (name.equals("Conjured Mana Cake")){
            this.quality=this.sellIn <0 ? this.quality-4 : this.quality-2;
            notBelow0AndNotOver50();
        }
        else{
            this.quality=this.sellIn <0 ? this.quality-2 : this.quality-1;
            notBelow0AndNotOver50();
        }

    }

    /**
     * calling the methods to update Quality and SellIn values
     */
    public void updateItem() {
        updateQuality();
        updateSellIn();
    }

    /**
     * Backstage passes increase in quality with different values
     * the shorter to the concert date, the bigger the increase value
     */
    public void setQualityBackstagePasses(){
        if (this.sellIn < 0) {
            this.quality= 0;
        }
        else if (this.sellIn <= 5) {
            this.quality= this.quality+3;
        }
        else if (this.sellIn <= 10) {
            this.quality= this.quality+2;
        }
        else {
            this.quality++;
        }
    }

    /**
     * Value of quality cannot go over 50
     */
    public void notBelow0AndNotOver50(){
        if (this.quality<0){
            this.quality=0;
        }
        if (this.quality>50){
            this.quality=50;
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}