package FilingData;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// - Can read his profile and get his details
// - Can submit his Complain

// Hostelite can update some of the features
    // -1 Change Password
    // -2 Email
    // -3 Phone No
    // -4 add a visitor to mess
    // -5 add extra garmets to the laundry



public class HosteliteOperations {

    private ArrayList<Hostelite> collectionHostelites;
    private File f = new File("hostelites.ser");


    public HosteliteOperations() {
        collectionHostelites = new ArrayList<Hostelite>();
    }

    public String getProfileInfo(String HostelID, String Password) {
        
        StringBuilder details = new StringBuilder();

        ObjectInputStream oo = null;

        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getHostelID().equals(HostelID) && s.getPassword().equals(Password)) {
                    details.append(s.toString());
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

        return details.toString();

    }


    public boolean changePassword(String hostelID, String password) {

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

        // firstly manipulating the Object

        for (int i = 0; i < collectionHostelites.size(); i++) {
            if (collectionHostelites.get(i).getHostelID().equals(hostelID)) {
                found = true;
                collectionHostelites.get(i).setPassword(password);
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

    public boolean updateEmail(String hostelID, String email) {

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

        // firstly manipulating the Object

        for (int i = 0; i < collectionHostelites.size(); i++) {
            if (collectionHostelites.get(i).getHostelID().equals(hostelID)) {
                found = true;
                collectionHostelites.get(i).setEmail(email);
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


    public boolean updatePhoneNumber(String hostelID, String phoneNo) {

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

        // firstly manipulating the Object

        for (int i = 0; i < collectionHostelites.size(); i++) {
            if (collectionHostelites.get(i).getHostelID().equals(hostelID)) {
                found = true;
                collectionHostelites.get(i).setPhoneNo(phoneNo);
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

    public boolean addVisitorToMess(String hostelID, int visitors, int days) {

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

        // firstly manipulating the Object

        for (int i = 0; i < collectionHostelites.size(); i++) {
            if (collectionHostelites.get(i).getHostelID().equals(hostelID)) {
                found = true;
                collectionHostelites.get(i).getMess().addVisitors(visitors, days);
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

    public boolean addExtraGarmetsToLaundry(String hostelID, double newGarments) {

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

        // firstly manipulating the Object

        for (int i = 0; i < collectionHostelites.size(); i++) {
            if (collectionHostelites.get(i).getHostelID().equals(hostelID)) {
                found = true;
                collectionHostelites.get(i).getLaundry().increaseGarmentLimits(newGarments);
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


    public boolean recordComplain(String hostelID, String complain) {

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

        // firstly manipulating the Object

        for (int i = 0; i < collectionHostelites.size(); i++) {
            if (collectionHostelites.get(i).getHostelID().equals(hostelID)) {
                found = true;
                collectionHostelites.get(i).setComplain(complain);
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







}
