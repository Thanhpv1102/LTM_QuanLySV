/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.Student;

/**
 *
 * @author phamv
 */
public class ClientCtr {
    private int port;
    private String host;
    private Socket mySocket;

    public ClientCtr() {
        host = "localhost";
        port = 8888;
    }
    
    public void openSocket(){
        try {
            mySocket = new Socket(host, port);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void sendStudent(Student s){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(mySocket.getOutputStream());
            oos.writeObject(s); //gui student sang server
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getResult(){
        String res = "";
        try {
            ObjectInputStream ois = new ObjectInputStream(mySocket.getInputStream());
            res = (String)ois.readObject(); //nhan ve thong diep
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return res;
    }
    
    public void closeConnection(){
        try {
            mySocket.close();
        }catch (Exception e){
        }
    }
}
