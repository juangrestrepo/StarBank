/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness.client;

/**
 *
 * @author user
 */
public class Company extends Client{
    private String nit;
    private String compName;
    private String commercialSection;
    
    public Company(String id,String name,String phone,String address,String occupation,String compName, String nit, String commercialSection) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.occupation = occupation;
        this.isSubscribed = false;
        this.compName = compName;
        this.nit = nit;
        this.commercialSection = commercialSection;
    }
}
