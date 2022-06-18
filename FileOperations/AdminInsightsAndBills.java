package FileOperations;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import ConcreteClasses.*;

public class AdminInsightsAndBills {
    
    
    public AdminInsightsAndBills() {

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
                totalIncomeOfHostel += s.totalBillOfHostelite();
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
                    details.append("The total bill is : "+ bill);
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
                if (s.getComplain() != "") {
                    details.append(s.getComplain() + "\n");
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
            return "No Record for Complains Found!";
        }

        return details.toString();

    }





}
