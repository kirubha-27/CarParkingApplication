package com.carparking.dto;

import java.util.List;

public class ParkingLot {
    private String parkingId;
    private String address;
    private int no_of_floors;
    private int lotCapacity;
    private float prices;
    private List<String> no_of_vehicles;

    public ParkingLot(String parkingId, String address, int no_of_floors, int lotCapacity, float prices, List<String> no_of_vehicles) {
        this.parkingId = parkingId;
        this.address = address;
        this.no_of_floors = no_of_floors;
        this.lotCapacity = lotCapacity;
        this.prices = prices;
        this.no_of_vehicles = no_of_vehicles;
    }


    public float getPrices() {
        return prices;
    }

    public void setPrices(float prices) {
        this.prices = prices;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNo_of_floors() {
        return no_of_floors;
    }

    public void setNo_of_floors(int no_of_floors) {
        this.no_of_floors = no_of_floors;
    }

    public int getLotCapacity() {
        return lotCapacity;
    }

    public void setLotCapacity(int lotCapacity) {
        this.lotCapacity = lotCapacity;
    }

    public List<String> getNo_of_vehicles() {
        return no_of_vehicles;
    }

    public void setNo_of_vehicles(List<String> no_of_vehicles) {
        this.no_of_vehicles = no_of_vehicles;
    }
}
