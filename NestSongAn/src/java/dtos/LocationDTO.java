/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Admin
 */
public class LocationDTO {
    private int location_id;
    private String name;

    public LocationDTO() {
    }

    public LocationDTO(int location_id) {
        this.location_id = location_id;
    }
    
    public LocationDTO(int location_id, String name) {
        this.location_id = location_id;
        this.name = name;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
