package com.example.Restaurant.service;

import org.springframework.stereotype.Service;

import com.example.Restaurant.model.Client;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private static final List<Client> clients = new ArrayList<>();

    static {
        clients.add(new Client(1, "Rouve", "Jean-Paul", "jprouve@example.com", "+330658946325","Masculin", true));
        clients.add(new Client(2, "Obama", "Michelle", "mobama@example.com", "+330785412365","Féminin", true));
        clients.add(new Client(3, "Bretelle", "Jeff", "jbretelle@example.com", "+330651236978","Masculin", false));
    }

    public List<Client> findAll() {
        return clients;
    }

    public Client findById(Integer id) {
        return clients.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Client client) {
        Client existing = findById(client.getId());
        if (existing != null) {
            existing.setLastname(client.getLastname());
            existing.setFirstname(client.getFirstname());
            existing.setEmail(client.getEmail());
            existing.setPhoneNumber(client.getPhoneNumber());
            existing.setGender(client.getGender());
            existing.setIsVIP(client.isIsVIP());
        } else {
            clients.add(client);
        }
    }

    public void delete(Integer id) {
        clients.removeIf(c -> c.getId().equals(id));
    }

   
       
}

