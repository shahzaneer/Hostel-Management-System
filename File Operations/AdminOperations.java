import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class AdminOperations {
    // collection of hostelites on which the admin can perform
    // Create , Read , update , Delete , Search operations

    private ArrayList<Hostelite> collectionHostelites;
    private File f = new File("hostelites.ser");

    public Admin() {
        collectionHostelites = new ArrayList<Hostelite>();
    }

    //! Creation of the DATA 

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

    public String viewAllProfiles() {

        ObjectInputStream oo = null;
        StringBuilder details = new StringBuilder();

        if (!f.exists())
        return "File Not Found No Record!";

    if (f.exists()) {
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                details.append(s.toString());
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

        return details.toString();

    }

    return "File Not Found No Record!";

    }

    //! Searching of DATA with different Aspects

    public String searchByName(String firstName) {
        StringBuilder details = new StringBuilder();
        boolean foundSome = false;
        ObjectInputStream oo = null;
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getFirstName().equalsIgnoreCase(firstName)) {
                    details.append(s.toString());
                    foundSome = true;
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

        if (!foundSome) {
            return "No Student Found !";
        }

        return details.toString();

    }

    public String searchByHostelID(String hostelID) {
        StringBuilder details = new StringBuilder();
        boolean foundSome = false;
        ObjectInputStream oo = null;
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getHostelID().equalsIgnoreCase(hostelID)) {
                    details.append(s.toString());
                    foundSome = true;
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

        if (!foundSome) {
            return "No Such Hostel ID Found !";
        }

        return details.toString();

    }

    public String searchByYear(String year) {
        StringBuilder details = new StringBuilder();
        ObjectInputStream oo = null;
        boolean foundSome = false;
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getRegistrationDateAndTime().getYear().equals(year)) {
                    details.append(s.toString());
                    foundSome = true;
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

        if (!foundSome) {
            return "No Data Against this year Found!";
        }

        return details.toString();
    }
    
    public String searchByRoomType(String roomType) {
        StringBuilder details = new StringBuilder();
        ObjectInputStream oo = null;
        boolean foundSome = false;
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getRoom().getRoomType().equalsIgnoreCase(roomType)) {
                    details.append(s.toString());
                    foundSome = true;
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

        if (!foundSome) {
            return "No Such Department Found !";
        }

        return details.toString();
    }

    
    //! UPDATION of DATA with different Aspects


    boolean updateRoom(String hostelID, String roomNo, String roomType) {

        boolean found = false;

        ObjectInputStream oo = null;
        try {

            oo = new ObjectInputStream(new FileInputStream("hostelite.ser"));

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

            if (collectionHostelites.get(i).getHostelID().equals(hostelID)) {

                found = true;

                collectionHostelites.get(i).getRoom().setRoomNo(roomNo);
                collectionHostelites.get(i).getRoom().setRoomType(roomType);

                if (roomType.equalsIgnoreCase("singleseater")) {
                    collectionHostelites.get(i).getRoom().setRoomRent(12000);

                }
                else if (roomType.equalsIgnoreCase("biseater")) {
                    collectionHostelites.get(i).getRoom().setRoomRent(10000);

                }

                else if (roomType.equalsIgnoreCase("triseater")) {
                    collectionHostelites.get(i).getRoom().setRoomRent(8000);

                }
                
            }
        }

        //* now again writing the Arraylist Objects to the file. first time it will create the file again and only then it will append!
        // file object
        // f = new File("Students.ser");
        ObjectOutputStream oos = null;
        int counter = 0;

        try {
            for (int i = 0; i < collectionHostelites.size(); i++) {
                // System.out.println("After Manipulation reading loop - size of arraylist"+ i);
                if (counter > 0) {
                    // System.out.println("counter greater then 0");
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionHostelites.get(i));

                } else {
                    // System.out.println("counter is 0");
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

    boolean updateParking(String hostelID, String vehicleType, String vehicleNumber) {

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

            if (collectionHostelites.get(i).getHostelID().equals(hostelID)) {
                found = true;
                // if vehicle type and vehicle number are null set it null
                if (vehicleNumber.equals("null") || vehicleType.equals("null")) {
                    collectionHostelites.get(i).getParking().setParkingFee(0);
                }

                collectionHostelites.get(i).getParking().setVehicleType(vehicleType);
                collectionHostelites.get(i).getParking().setVehicleNumber(vehicleNumber);

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
                    // System.out.println("counter is 0");
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

    boolean setOffDaysInMess(String hostelID, int offDays) {

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
            if (collectionHostelites.get(i).getHostelID().equals(hostelID)) {
                found = true;
                collectionHostelites.get(i).getMess().setOffDays(offDays);

            }
        }

        //* now again writing the Arraylist Objects to the file. first time it will create the file again and only then it will append!
        // file object
        // f = new File("Students.ser");
        ObjectOutputStream oos = null;
        int counter = 0;

        try {
            for (int i = 0; i < collectionHostelites.size(); i++) {
                // System.out.println("After Manipulation reading loop - size of arraylist"+ i);
                if (counter > 0) {
                    // System.out.println("counter greater then 0");
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionHostelites.get(i));

                } else {
                    // System.out.println("counter is 0");
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

    boolean updateName(String hostelID, String firstName, String lastName) {

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
            if (collectionHostelites.get(i).getHostelID().equals(hostelID)) {

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
                // System.out.println("After Manipulation reading loop - size of arraylist"+ i);
                if (counter > 0) {
                    // System.out.println("counter greater then 0");
                    oos = new MyObjectOutputStream(new FileOutputStream(f, true));
                    oos.writeObject(collectionHostelites.get(i));

                } else {
                    // System.out.println("counter is 0");
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

    boolean removeHostelite(String hostelID) {

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
            for (int i = 0; i < a.size(); i++) {
                if (collectionHostelites.get(i).getHostelID().equals(hostelID) ) {
                    found = true;
                    a.remove(i);
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

    boolean removeHostelite(String firstName , String secondName ) {

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
            for (int i = 0; i < a.size(); i++) {
                if (collectionHostelites.get(i).getFirstName().equalsIgnoreCase(firstName) && collectionHostelites.get(i).getLastName().equalsIgnoreCase(secondName)) {
                    found = true;
                    a.remove(i);
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


    
    

    
}
