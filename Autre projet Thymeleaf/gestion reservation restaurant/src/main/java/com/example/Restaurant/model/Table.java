package com.example.Restaurant.model;


import jakarta.validation.constraints.NotNull;

public class Table {
    @NotNull
    private Integer id;

    @NotNull
    private Integer seatingCapacity;         

    @NotNull
    private String status;    

    public Table() {}


    public Table(Integer id, Integer seatingCapacity, String status) {
        this.id = id;
        this.seatingCapacity = seatingCapacity;
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeatingCapacity() {
        return this.seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}

