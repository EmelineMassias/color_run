package com.example.Restaurant.service;

import org.springframework.stereotype.Service;

import com.example.Restaurant.model.Table;

import java.util.ArrayList;
import java.util.List;



@Service
public class TableService {


    private static final List<Table> tables = new ArrayList<>();
    static {
        tables.add(new Table(1,  2,"Réservée" ));
        tables.add(new Table(2, 6, "Réservée" ));
        tables.add(new Table(3, 4, "Réservée" ));
        tables.add(new Table(4, 8, "En Entretien" ));
        tables.add(new Table(5, 4, "Disponible" ));
    }

    public List<Table> findAll() {
        return tables;
    }

    public Table findById(Integer id) {
        return tables.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Table table) {
        Table existing = findById(table.getId());
        if (existing != null) {
            existing.setSeatingCapacity(table.getSeatingCapacity());
            existing.setStatus(table.getStatus());
        } else {
            tables.add(table);
        }
    }

    public void delete(Integer id) {
        tables.removeIf(t -> t.getId().equals(id));
    }

    public List<Table> availableTables(List<Table> tables) {
        List<Table> availableTables = new ArrayList<>();
        
        if (!tables.isEmpty()) {
            for (Table table : tables) {
                if ("Disponible".equals(table.getStatus())) {
                    availableTables.add(table);
                }
            }
        }
        
        return availableTables;
    }

 }

