package io_utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SalesRecord {
    private String region;
    private String country;
    private String itemType;
    private String salesChannel;
    private String orderPriority;
    private LocalDate orderDate;
    private long orderID;
    private LocalDate shipDate;
    private int unitsSold;
    private double unitPrice;
    private double unitCost;
    private double totalRevenue;
    private double totalCost;
    private double totalProfit;

    public SalesRecord populateFromLine(Map<String, String> csvLine){
        this.region = csvLine.get("Region");
        this.country = csvLine.get("Country");
        this.itemType = csvLine.get("Item Type");
        this.salesChannel = csvLine.get("Sales Channel");
        this.orderPriority = csvLine.get("Order Priority");
        this.orderDate = parseDate(csvLine.get("Order Date"));
        this.orderID = Long.parseLong(csvLine.get("Order ID"));
        this.shipDate = parseDate(csvLine.get("Ship Date"));
        this.unitsSold = Integer.parseInt(csvLine.get("Units Sold"));
        this.unitPrice = Double.parseDouble(csvLine.get("Unit Price"));
        this.unitCost = Double.parseDouble(csvLine.get("Unit Cost"));
        this.totalRevenue = Double.parseDouble(csvLine.get("Total Revenue"));
        this.totalCost = Double.parseDouble(csvLine.get("Total Cost"));
        this.totalProfit = Double.parseDouble(csvLine.get("Total Profit"));

        return this;
    }

    private LocalDate parseDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(date, formatter);
    }

    private String toStringDate(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return date.format(formatter);
    }

    @Override
    public String toString() {
        return "SaleRecord{" +
                "region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", itemType='" + itemType + '\'' +
                ", salesChannel='" + salesChannel + '\'' +
                ", orderPriority='" + orderPriority + '\'' +
                ", orderDate=" + orderDate +
                ", orderID=" + orderID +
                ", shipDate=" + shipDate +
                ", unitsSold=" + unitsSold +
                ", unitPrice=" + unitPrice +
                ", unitCost=" + unitCost +
                ", totalRevenue=" + totalRevenue +
                ", totalCost=" + totalCost +
                ", totalProfit=" + totalProfit +
                '}';
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getItemType() {
        return itemType;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public String getOrderPriority() {
        return orderPriority;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public long getOrderID() {
        return orderID;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
