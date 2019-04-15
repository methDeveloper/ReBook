/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPack;

import Entities.Book;
import Entities.User;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lokesh
 */
public class ServerConnection {
    
    private static ServerConnection serverConnection;
    private String serverIP;
    private Socket s;
    DataOutputStream dos;
    ObjectOutputStream os;
    ObjectInputStream ois;
    DataInputStream dis;
    private ServerConnection(String ip)
    {
        this.serverIP = ip;
        try{
        
        s=new Socket();
        s.connect(new InetSocketAddress(serverIP,4208),1000);
        dos=new DataOutputStream(s.getOutputStream());
        os=new ObjectOutputStream(s.getOutputStream());
        ois=new ObjectInputStream(s.getInputStream());
        dis=new DataInputStream(s.getInputStream());
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Can not connect to server!",
                "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public static ServerConnection getInstance(String ip) throws IOException{
        
        if(serverConnection == null)
        {
            serverConnection = new ServerConnection(ip);
        }
        
        return serverConnection;
    }
    public void saveBook(Book book){
        try{
    
//        dos.write(1);
        dos.writeUTF("1");
        dos.flush();
        os.writeObject(book);
        os.flush();
        JOptionPane.showMessageDialog(null,"Book details saved!","Success",JOptionPane.OK_OPTION);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Could not save details",
                "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public ArrayList<Book> getList(String selected_category,String selected_programme) throws ClassNotFoundException{
//        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        ArrayList<Book> bookList = new ArrayList<>();

        try{
            dos.writeUTF("0");
            dos.flush();
    //        dos.close();
            String query="SELECT * FROM Book WHERE Course=\""+selected_category+"\" and Programme=\""+selected_programme+"\"";
            dos.writeUTF(query);
            dos.flush();
            bookList =(ArrayList<Book>) ois.readObject();
            return bookList;
        
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Could not save details",
                "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return bookList;
    }
    public void addUser(User user){
        try{
        dos.writeUTF("2");
        dos.flush();
        os.writeObject(user);
        JOptionPane.showMessageDialog(null,"User details saved!","Success",JOptionPane.OK_OPTION);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Could not save details",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void updateUser(String query){
        try{
            dos.writeUTF("5");
        dos.flush();
        dos.writeUTF(query);
        JOptionPane.showMessageDialog(null,"User details saved!","Success",JOptionPane.OK_OPTION);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Could not save details",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public User confirmLogin(String login,String pass){
        try{
        dos.writeUTF("6");
        dos.flush();
        dos.writeUTF(login);
        dos.flush();
        dos.writeUTF(pass);
        dos.flush();
        
        return (User)ois.readObject();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Could not get details",
                "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
