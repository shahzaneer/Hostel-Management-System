import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class AdminInsightsAndBills {

    private File f = new File("hostelites.ser");

    public AdminInsightsAndBills() {
        collectionHostelites = new ArrayList<Hostelite>();
    }


    public String totalIncomeOfHostel() {

        StringBuilder details = new StringBuilder();
        boolean foundSome = false;
        double totalIncomeOfHostel= 0;
        ObjectInputStream oo = null;
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                foundSome = true;
                Hostelite s = (Hostelite) oo.readObject();
                totalIncomeOfHostel += s.getTotalBill();
            }
        }

        catch (ClassNotFoundException e) {
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

        details.append("The total Income of the Hostel is :" + totalIncomeOfHostel);

        return details.toString();

        
    }


    public String viewBillOfAHostelite(String hostelID) {

        StringBuilder details = new StringBuilder();
        boolean foundSome = false;
        ObjectInputStream oo = null;
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                if (s.getHostelID().equalsIgnoreCase(hostelID)) {
                    double bill = s.getTotalBill();
                    details.append(bill + "");
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
            return "No Student Found !";
        }

        return details.toString();

    }

    public String getAllComplains() {
        StringBuilder details = new StringBuilder();
        boolean foundSome = false;
        ObjectInputStream oo = null;
        try {
            oo = new ObjectInputStream(new FileInputStream("hostelites.ser"));

            while (true) {

                // Reading object is below
                Hostelite s = (Hostelite) oo.readObject();
                    details.append(s.getComplain() + "\n");
                    foundSome = true;
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





}
