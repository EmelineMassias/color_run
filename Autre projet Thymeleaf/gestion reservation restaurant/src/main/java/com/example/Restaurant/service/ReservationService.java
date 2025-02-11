package com.example.Restaurant.service;

import org.springframework.stereotype.Service;

import com.example.Restaurant.model.Reservation;
import com.example.Restaurant.model.Client;
import com.example.Restaurant.model.Table;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class ReservationService {

    private static final List<Reservation> reservations = new ArrayList<>();

    static {
        reservations.add(new Reservation(1,3, 1, LocalDate.of(2025, 1, 1), LocalTime.of(10, 0), 4));
        reservations.add(new Reservation(2, 1, 3, LocalDate.of(2025, 1, 16), LocalTime.of(11, 0), 2));
        reservations.add(new Reservation(3, 2, 2, LocalDate.of(2025, 1, 16), LocalTime.of(10, 0), 6));
    }

    public List<Reservation> findAll() {
        return reservations;
    }

    public Reservation findById(Integer id) {
        return reservations.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Reservation reservation, Client client, Table table) {
        Reservation existing = findById(reservation.getId());
        if (existing != null) {
            existing.setNumberOfCovers(reservation.getNumberOfCovers());
            existing.setReservationDate(reservation.getReservationDate());
            existing.setReservationTime(reservation.getReservationTime());
            existing.setClientId(client.getId());
            existing.setTableId(table.getId());
        } else {
            reservations.add(reservation);
        }
    }

    public void delete(Integer id) {
        reservations.removeIf(r -> r.getId().equals(id));
    }

    public List<Reservation> reservationOfTheDay(List<Reservation> reservations) {
        
        List<Reservation> returningList = new ArrayList<>();
        LocalDate today = LocalDate.now();
    
        if(!reservations.isEmpty()) {
            for (Reservation reservation : reservations) {
                LocalDate reservationDate = reservation.getReservationDate();
                if(reservationDate.isEqual(today)) {
                    returningList.add(reservation);
                }
            }
        }
        
        return returningList;
    }
/* 
///////Tentative de fonction pour la réservation des tables en fonction du nombre de places assises/couverts

    public void save(Reservation reservation, Client client, Table table) {
        if (table == null) {
            throw new IllegalArgumentException("La table est nulle");
        }
    
        Reservation existing = findById(reservation.getId());
        Integer numberOfCovers = reservation.getNumberOfCovers();
    
        if (existing != null) {
            existing.setNumberOfCovers(reservation.getNumberOfCovers());
            existing.setReservationDate(reservation.getReservationDate());
            existing.setReservationTime(reservation.getReservationTime());
            existing.setClientId(client.getId());
            existing.setTableId(table.getId());
        } else if (numberOfCovers <= table.getSeatingCapacity()) {
            table.setSeatingCapacity(table.getSeatingCapacity() - numberOfCovers);
            table.setStatus("Réservée");
    
            reservations.add(reservation);
        } else {
            throw new IllegalArgumentException("Le nombre de couverts dépasse la capacité de la table");
        }
    }*/
 
}
        


