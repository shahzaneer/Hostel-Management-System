package FileOperations;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import ConcreteClasses.*;


public class AdminOperations {
    // collection of hostelites on which the admin can perform
    // Create , Read , update , Delete , Search operations

    private ArrayList<Hostelite> collectionHostelites;
    private File f = new File("hostelites.ser");

    public AdminOperations() {
        collectionHostelites = new ArrayList<Hostelite>();
    }

    //! Creation of the DATA 
    //* working 🎉

    public void addHostelite(Hostelite s) {
        ObjectOutputStream oos = null;
        // write to file
        try {
            if (!f.exists()) {
                f = new File("hostelites.ser");
            }
            if (f.exists()) {

                oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                oos.writeObject(s); // write object to file
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f, true));
                oos.writeObject(s); // it will write the object to the file.
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        catch (Exception e) {
            System.err.println("Cannot Write Object");
        }

        // For closing File

        if (oos != null) {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //! Reading of the DATA
    //* working 🎉

    public ArrayList<Hostelite> viewAllProfiles() {

        ArrayList<Hostelite> a = new ArrayList<>();
        ObjectInputStream oo = null;

        if (!f.exists())
            return a;
            
    if (f.exists()) {
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                a.add(s);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {
            }

        }

    }

    return a;
    }

    //! Searching of DATA with different Aspects 
    //* working 🎉
    
    public ArrayList<Hostelite> searchByName(String firstName) {

        ArrayList<Hostelite> a = new ArrayList<>();

        ObjectInputStream oo = null;

        if (!f.exists()) {
            return a;
        }

        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {
                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getFirstName().equalsIgnoreCase(firstName)) {
                    a.add(s);
                
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();

            } catch (IOException e) {
            }

        }


        return a;

    }

    public ArrayList<Hostelite> searchByHostelID(String hostelID) {
        ArrayList<Hostelite> a = new ArrayList<>();
    
        ObjectInputStream oo = null;

        if (!f.exists()) {
            return a;
        }
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getHostelID().equalsIgnoreCase(hostelID)) {
                    a.add(s);
                    break; // as hostelID is only one!
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();

            } catch (IOException e) {
            }

        }

    

        return a;

    }

    public ArrayList<Hostelite> searchByYear(String year) {
        ArrayList<Hostelite> a = new ArrayList<>();

        ObjectInputStream oo = null;

        if (!f.exists()) {
            return a;
        }
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getRegistrationDateAndTime().getYear().equals(year)) {
                    a.add(s);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();

            } catch (IOException e) {
            }

        }

        

        return a;
    }
    
    public ArrayList<Hostelite> searchByRoomType(String roomType) {
        ArrayList<Hostelite> a = new ArrayList<>();
        ObjectInputStream oo = null;
        

        if (!f.exists()) {
            return a;
        }
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getRoom().getRoomType().equalsIgnoreCase(roomType)) {
                    a.add(s);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();

            } catch (IOException e) {
            }

        }


        return a;
    }

    
    //! UPDATION of DATA with different Aspects

    //* working 🎉

    public boolean updateRoom(String hostelID, String roomNo, String roomType) {

        boolean found = false;

        ObjectInputStream oo = null;
        try {

            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            try {
                while (true) {

                    Hostelite k = (Hostelite) oo.readObject();
                    collectionHostelites.add(k);
                }
            } catch (EOFException e) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {

            }
        }

        // Manipulating the object for 

        for (int i = 0; i < collectionHostelites.size(); i++) {

            if (collectionHostelites.get(i).getHostelID().equalsIgnoreCase(hostelID)) {

                found = true;

                collectionHostelites.get(i).getRoom().setRoomNo(roomNo);
                collectionHostelites.get(i).getRoom().setRoomType(roomType);

                // again setting the main bill 
                double totalBill = collectionHostelites.get(i).totalBillOfHostelite();
                collectionHostelites.get(i).setTotalBill(totalBill);       
                
            }
        }

        //* now again writing the Arraylist Objects to the file. first time it will create the file again and only then it will append!

        ObjectOutputStream oos = null;
        int counter = 0;

        try {
            for (int i = 0; i < collectionHostelites.size(); i++) {
                if (counter > 0) {
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionHostelites.get(i));

                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(collectionHostelites.get(i));
                    counter++;
                }
            }

            // For closing File

            if (oos != null) {
                oos.close();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return found;

    }

    public boolean updateParking(String hostelID, String vehicleType, String vehicleNumber) {

        boolean found = false;

        ObjectInputStream oo = null;
        try {

            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            try {
                while (true) {

                    Hostelite k = (Hostelite) oo.readObject();
                    collectionHostelites.add(k);
                }
            } catch (EOFException e) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {

            }
        }

        // firstly manipulating the object

        for (int i = 0; i < collectionHostelites.size(); i++) {

            if (collectionHostelites.get(i).getHostelID().equalsIgnoreCase(hostelID)) {
                found = true;
                // if vehicle type and vehicle number are null set it null
                if (vehicleNumber.equalsIgnoreCase("null") || vehicleType.equalsIgnoreCase("null")) {
                    collectionHostelites.get(i).getParking().setParkingBill(0);
                }

                collectionHostelites.get(i).getParking().setVehicleType(vehicleType);
                collectionHostelites.get(i).getParking().setVehicleNumber(vehicleNumber);

                // again setting the main bill 
                double totalBill = collectionHostelites.get(i).totalBillOfHostelite();
                collectionHostelites.get(i).setTotalBill(totalBill);       
                

            }
        }

        //* now again writing the Arraylist Objects to the file. first time it will create the file again and only then it will append!
    
        ObjectOutputStream oos = null;
        int counter = 0;

        try {
            for (int i = 0; i < collectionHostelites.size(); i++) {
                if (counter > 0) {
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionHostelites.get(i));

                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(collectionHostelites.get(i));
                    counter++;
                }
            }

            // For closing File

            if (oos != null) {
                oos.close();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return found;

    }

    public boolean setOffDaysInMess(String hostelID, int offDays) {

        boolean found = false;

        ObjectInputStream oo = null;
        try {

            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            try {
                while (true) {

                    Hostelite k = (Hostelite) oo.readObject();
                    collectionHostelites.add(k);
                }
            } catch (EOFException e) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {

            }
        }

        // firstly manipulating the object

        for (int i = 0; i < collectionHostelites.size(); i++) {
            if (collectionHostelites.get(i).getHostelID().equalsIgnoreCase(hostelID)) {
                found = true;
                collectionHostelites.get(i).getMess().offDays(offDays);

                // again setting the main bill 
                double totalBill = collectionHostelites.get(i).totalBillOfHostelite();
                collectionHostelites.get(i).setTotalBill(totalBill);       
                

            }
        }

        //* now again writing the Arraylist Objects to the file. first time it will create the file again and only then it will append!
        // file object
        // f = new File("Students.ser");
        ObjectOutputStream oos = null;
        int counter = 0;

        try {
            for (int i = 0; i < collectionHostelites.size(); i++) {
                if (counter > 0) {
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionHostelites.get(i));

                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(collectionHostelites.get(i));
                    counter++;
                }
            }

            // For closing File

            if (oos != null) {
                oos.close();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return found;

    }

    public boolean updateName(String hostelID, String firstName, String lastName) {

        boolean found = false;

        ObjectInputStream oo = null;
        try {

            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            try {
                while (true) {

                    Hostelite k = (Hostelite) oo.readObject();
                    collectionHostelites.add(k);
                }
            } catch (EOFException e) {

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {

            }
        }

        // firstly manipulating the object

        for (int i = 0; i < collectionHostelites.size(); i++) {
            if (collectionHostelites.get(i).getHostelID().equalsIgnoreCase(hostelID)) {

                found = true;
                collectionHostelites.get(i).setFirstName(firstName);
                collectionHostelites.get(i).setLastName(lastName);
            }
        }

        //* now again writing the Arraylist Objects to the file. first time it will create the file again and only then it will append!
        // file object
        // f = new File("Students.ser");
        ObjectOutputStream oos = null;
        int counter = 0;

        try {
            for (int i = 0; i < collectionHostelites.size(); i++) {
                if (counter > 0) {
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionHostelites.get(i));

                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                    oos.writeObject(collectionHostelites.get(i));
                    counter++;
                }
            }

            // For closing File

            if (oos != null) {
                oos.close();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        return found;

    }
    
    
    //! Deletion of DATA 
    //* working 🎉

    public boolean removeHostelite(String hostelID) {

        boolean found = false;
        ObjectInputStream oo = null;

        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            try {
                while (true) {

                    Hostelite s = (Hostelite) oo.readObject();
                    collectionHostelites.add(s);

                }
            } catch (EOFException e) {
                // Move to the next line broda
            }
            // now we will move sequentially..

            oo.close();

            // removing the specified object from the arraylist
            for (int i = 0; i < collectionHostelites.size(); i++) {
                if (collectionHostelites.get(i).getHostelID().equals(hostelID) ) {
                    found = true;
                    collectionHostelites.remove(i);
                }
            }


            // now again writing the Arraylist objects in the file first time we will create a new file and then we will append
            // Object for writing class (ObjectOutputStream)
            ObjectOutputStream oos = null;
            // write to file
            int counter = 0;

            if (collectionHostelites.size() > 0) {
                for (int i = 0; i < collectionHostelites.size(); i++) {

                    System.out.println("Writing again to the file");

                    if (counter > 0) {
                        // when you are running it for the second and afterwards iterations you will append the file
                        oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                        oos.writeObject(collectionHostelites.get(i));

                    } else {
                        // for the first time you will create a new file
                        oos = new ObjectOutputStream(new FileOutputStream(f));
                        oos.writeObject(collectionHostelites.get(i));
                        counter++;
                    }

                }

                // For closing File

                if (oos != null) {
                    oos.close();
                }

            }
            else if (collectionHostelites.size() == 0) {
                // System.out.println("File deleting");
                f.delete();
                // System.out.println("File deleted");
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }


        return found;

    }

    public boolean removeHostelite(String firstName , String secondName ) {

        boolean found = false;
        ObjectInputStream oo = null;

        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            try {
                while (true) {

                    Hostelite s = (Hostelite) oo.readObject();
                    collectionHostelites.add(s);

                }
            } catch (EOFException e) {
                // Move to the next line broda
            }
            // now we will move sequentially..

            oo.close();

            // removing the specified object from the arraylist
            for (int i = 0; i < collectionHostelites.size(); i++) {
                if (collectionHostelites.get(i).getFirstName().equalsIgnoreCase(firstName) && collectionHostelites.get(i).getLastName().equalsIgnoreCase(secondName)) {
                    found = true;
                    collectionHostelites.remove(i);
                }
            }


            // now again writing the Arraylist objects in the file first time we will create a new file and then we will append
            // Object for writing class (ObjectOutputStream)
            ObjectOutputStream oos = null;
            // write to file
            int counter = 0;

            if (collectionHostelites.size() > 0) {
                for (int i = 0; i < collectionHostelites.size(); i++) {

                    System.out.println("Writing again to the file");

                    if (counter > 0) {
                        // when you are running it for the second and afterwards iterations you will append the file
                        oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                        oos.writeObject(collectionHostelites.get(i));

                    } else {
                        // for the first time you will create a new file
                        oos = new ObjectOutputStream(new FileOutputStream(f));
                        oos.writeObject(collectionHostelites.get(i));
                        counter++;
                    }

                }

                // For closing File

                if (oos != null) {
                    oos.close();
                }

            }
            else if (collectionHostelites.size() == 0) {
                // System.out.println("File deleting");
                f.delete();
                // System.out.println("File deleted");
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }


        return found;

    }

    //! Forgot Password
    //* working 🎉
    public String getPass(String hostelID) {
        StringBuilder passwordDetails = new StringBuilder();
        ObjectInputStream oo = null;

        if (!f.exists()) {
            return "NO Such ID found !";
        }
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getHostelID().equalsIgnoreCase(hostelID)) {
                    passwordDetails.append("Name :" + s.getFirstName() + " " + s.getLastName() + "\n" + "Hostel ID :"
                            + s.getHostelID() + "\n" + "Password : " + s.getPassword());
                    break;
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();

            } catch (IOException e) {
            }

        }

        String details = passwordDetails.toString();

        return details;

    }
    
    
    //! To check if the current HostelID exists
    public boolean hostelIDExists(String hostelID) {

        
        ObjectInputStream oo = null;

        if (!f.exists())
            return false;
            
    if (f.exists()) {
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getHostelID().equalsIgnoreCase(hostelID)) {
                    return true;
                }

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch (EOFException e) {

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            try {
                oo.close();
            } catch (IOException e) {
            }

        }

    }

    return false;
    }

    

    
}
