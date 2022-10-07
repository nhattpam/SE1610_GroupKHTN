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
public class BranchDTO {
    private int branch_id;
    private String name;
    private LocationDTO location_id;

    public BranchDTO() {
    }

    public BranchDTO(int branch_id, String name, LocationDTO location_id) {
        this.branch_id = branch_id;
        this.name = name;
        this.location_id = location_id;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationDTO getLocation_id() {
        return location_id;
    }

    public void setLocation_id(LocationDTO location_id) {
        this.location_id = location_id;
    }
    
}
