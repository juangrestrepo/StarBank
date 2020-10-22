/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import bussiness.account.Account;
import bussiness.BranchOffice;
import bussiness.client.Client;
import bussiness.operation.Operation;

/**
 *
 * @author user
 */
public class Serializacion {
    
    //Escribe en el archivo json de cuentas correspondiente, dependiendo del parámetro archivo que se ingrese
    public static void createFile(Account[] file, Account newAccount, String archivo){
        Gson gson = new Gson();
        String json = "[";
        if(file == null){
            if(newAccount != null){
                json += gson.toJson(newAccount);
            }
            json += "]";
        }else{
            if(newAccount != null){
                for(Account account : file){
                    json += gson.toJson(account)+",";
                }
                json += gson.toJson(newAccount)+"]";
            }else{
                for (int i = 0; i < file.length; i++) {
                    json += gson.toJson(file[i]);
                    if(file.length - i != 1){
                        json += ",";
                    }
                }
                json += "]";
            }
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo+".json"))){
            bw.write(json);
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
     //Escribe en el archivo json de clientes correspondiente, dependiendo del parámetro archivo que se ingrese
    public static void createFile(Client[] file, Client newClient, String archivo){
        Gson gson = new Gson();
        String json = "[";
        
        if(file == null){
            if(newClient != null){
                json += gson.toJson(newClient);
            }
            json += "]";
        }else{
            if(newClient != null){
                for(Client client : file){
                    json += gson.toJson(client)+",";
                }
                json += gson.toJson(newClient)+"]";
            }else{
                for (int i = 0; i < file.length; i++) {
                    json += gson.toJson(file[i]);
                    if(file.length - i != 1){
                        json += ",";
                    }
                }
                json += "]";
            }
        }
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo+".json"))){
            bw.write(json);
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    //Escribe en el archivo json de operaciones correspondiente, dependiendo del parámetro archivo que se ingrese
    public static void createFile(Operation[] file, Operation newOperation, String archivo){
        Gson gson = new Gson();
        String json = "[";
        
        if(file != null){
            for(Operation operation : file){
                json += gson.toJson(operation)+",";
            }
        }
        json += gson.toJson(newOperation)+"]";
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo+".json"))){
            bw.write(json);
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    //Lee el archivo json de cuentas correspondiente, dependiendo del parámetro file
    //En caso que el archivo no exista, lo crea
    public static Account[] readAccount(String file){
        Gson gson = new Gson();
        String json = "";
        
        try(BufferedReader br = new BufferedReader(new FileReader(file+".json"))){
            String line;
            while((line = br.readLine()) != null){
                json += line;
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file+".json"))){
                bw.write("");
                readAccount(file);
            }catch(FileNotFoundException exe){
                System.out.println(exe.getMessage());
            }catch(IOException exe){
             System.out.println(exe.getMessage());
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        if(json == ""){
            return null;
        }
        Account[] cuentas = gson.fromJson(json, Account[].class);
        return cuentas;
    }
    
    //Lee el archivo json de clientes correspondiente, dependiendo del parámetro file
    public static Client[] readClient(String file){
        Gson gson = new Gson();
        String json = "";
        
        try(BufferedReader br = new BufferedReader(new FileReader(file+".json"))){
            String line;
            while((line = br.readLine()) != null){
                json += line;
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file+".json"))){
                bw.write("");
                readAccount(file);
            }catch(FileNotFoundException exe){
                System.out.println(exe.getMessage());
            }catch(IOException exe){
             System.out.println(exe.getMessage());
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        if(json == ""){
            return null;
        }
        Client[] cliente = gson.fromJson(json, Client[].class);
        return cliente;
    }
    
    //Lee el archivo json de sucursales
    public static BranchOffice[] readBranchOffice(){
        Gson gson = new Gson();
        String json = "";
        
        try(BufferedReader br = new BufferedReader(new FileReader("branchOffice.json"))){
            String line;
            while((line = br.readLine()) != null){
                json += line;
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("branchOffice.json"))){
                bw.write("");
                readAccount("branchOffice");
            }catch(FileNotFoundException exe){
                System.out.println(exe.getMessage());
            }catch(IOException exe){
             System.out.println(exe.getMessage());
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        if(json == ""){
            return null;
        }
        BranchOffice[] bo = gson.fromJson(json, BranchOffice[].class);
        return bo;
    }
    
    //Lee el archivo de operaciones correspondiente, dependiendo del parámetro file
    public static Operation[] readOperations(String file){
        Gson gson = new Gson();
        String json = "";
        
        try(BufferedReader br = new BufferedReader(new FileReader(file+".json"))){
            String line;
            while((line = br.readLine()) != null){
                json += line;
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file+".json"))){
                bw.write("");
                readOperations(file);
            }catch(FileNotFoundException exe){
                System.out.println(exe.getMessage());
            }catch(IOException exe){
             System.out.println(exe.getMessage());
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        if(json == ""){
            return null;
        }
        Operation[] op = gson.fromJson(json, Operation[].class);
        return op;
    }
}
