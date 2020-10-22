/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness.client;

import persistence.Serializacion;

/**
 *
 * @author user
 */
public class Client {
    protected String id;
    protected String name;
    protected String phone;
    protected String address;
    protected String occupation;
    protected boolean isSubscribed;
    
    //Verifica que el cliente exista, y en caso de que su estado sea "no suscrito", lo cambia a "suscrito"
    public static boolean verifyClient(Client[] client, String idOwner, String typeOwner){
        boolean success = false;
        if(client != null){
            for(Client cli : client){
                if(cli.id.equalsIgnoreCase(idOwner)){
                    if(cli.isSubscribed == false){
                        cli.isSubscribed = true;
                    }
                    success = true;
                }
            }
            Serializacion.createFile(client, null, typeOwner);
        }
        return success;
    }

    public String getId() {
        return id;
    }
    
    
}
