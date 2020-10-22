/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness;

/**
 *
 * @author user
 */
public class BranchOffice {
    private String id;
    private String address;
    private String name;
    private String city;
    private float balance;
    private static BranchOffice instance;
    
    private BranchOffice(String id, String address, String name, String city){
        this.id = id;
        this.address = address;
        this.name = name;
        this.city = city;
    }
    
    public static BranchOffice getInstance(String id, String address, String name, String city){
        if(BranchOffice.instance == null){
            BranchOffice.instance = new BranchOffice(id, address, name, city);
        }return BranchOffice.instance;
    }
    
    public static BranchOffice getInstance(){
        return BranchOffice.instance;
    }
    
    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
    
    
}
