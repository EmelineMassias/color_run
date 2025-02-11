package com.example.Restaurant.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;


public class Reservation {
    @NotNull
    private Integer id; 

    private Integer tableId;
   
    private  Integer clientId;

    @NotNull
    private LocalDate reservationDate;

    @NotNull
    private LocalTime reservationTime;

    @NotNull
    private Integer numberOfCovers;
    
    public Reservation() {}


    public Reservation(Integer id, Integer tableId, Integer clientId, LocalDate reservationDate, LocalTime reservationTime, Integer numberOfCovers) {
        this.id = id;
        this.tableId = tableId;
        this.clientId = clientId;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.numberOfCovers = numberOfCovers;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTableId() {
        return this.tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getClientId() {
        return this.clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public LocalDate getReservationDate() {
        return this.reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getReservationTime() {
        return this.reservationTime;
    }

    public void setReservationTime(LocalTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Integer getNumberOfCovers() {
        return this.numberOfCovers;
    }

    public void setNumberOfCovers(Integer numberOfCovers) {
        this.numberOfCovers = numberOfCovers;
    }

   
}
