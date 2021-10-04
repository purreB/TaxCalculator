import javax.swing.*;

public class TaxCalculator {
    static void main(String[] args) {
        boolean again = true;
        while (again) {

            String s = JOptionPane.showInputDialog("Yearly Income?");
            int income = 0;
            int BreakPointLow = 468700;
            int BreakPointHigh = 675700;
            int toPayOn = 0;
            int toPay = 0;
            boolean tryAgain = true;
            while (tryAgain) {
                if (s == null)
                    System.exit(0); // User pressed abort
                try {
                    income = Integer.parseInt(s); // Try to convert string to numeric value
                    tryAgain = false; // Change tryAgain to false if conversion succeeded
                } catch (NumberFormatException e) { // Conversion failed
                    s = JOptionPane.showInputDialog("Wrongly number! \nUse only numbers: ");
                }
            }

            if (income > BreakPointHigh) { // Tests if income is higher than highest breakpoint
                toPayOn = income - BreakPointHigh;// If it is, create a int named toPayOn which calculates
                                                  // How much over the breakpoint the income is
            } else if (income > BreakPointLow) { // If income is not over highest breakpoint
                                                 // test if its over the lowest breakpoint
                toPayOn = income - BreakPointLow;
            } else {
                JOptionPane.showMessageDialog(null, "You dont need to pay federal incometax"); // If yearlyincome is
                                                                                               // under
                                                                                               // breakpoint
                                                                                               // you dont have
                                                                                               // to pay.
            }

            if (income > BreakPointHigh) { // If income iis higher than highest breakpoint
                                           // pay 25% on the ammount that is over the limit
                toPay = toPayOn / 4;
                JOptionPane.showMessageDialog(null, "You shall pay: " + toPay + "SEK");
            } else if (income > BreakPointLow) { // Otherwise, pay 20% of the ammount over the lowest breakpoint
                toPay = toPayOn / 5;
                JOptionPane.showMessageDialog(null, "You shall pay " + toPay + "SEK");
            }
        }
    }
}