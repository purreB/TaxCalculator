import javax.swing.*;

public class Inkomstskatt {
    public static void main(String[] args) {
        boolean igen = true;
        while (igen) {

            String s = JOptionPane.showInputDialog("Årsinkomst?");
            int inkomst = 0;
            int BrytPunktLåg = 468700;
            int BrytPunktHög = 675700;
            int BetalaPå = 0;
            int AttBetala = 0;
            boolean försökIgen = true;
            while (försökIgen) {
                if (s == null)
                    System.exit(0); // Användaren tryckte på avbryt.
                try {
                    inkomst = Integer.parseInt(s); // Försök omvandla texten till numeriskt värde.
                    försökIgen = false; // Ändra försökIgen till false om omvandlingen lyckades.
                } catch (NumberFormatException e) { // Omvandlingen misslyckades
                    s = JOptionPane.showInputDialog("Felaktigt tal! \nAnge bara siffror: ");
                }
            }

            if (inkomst > BrytPunktHög) { // Testar om inkomsten är högre än högsta brytpunkten.
                BetalaPå = inkomst - BrytPunktHög;// om den är det så skapa en int vid namn BetalaPå som skall räkna ut
                                                  // hur mycket över brytpunkten är.
            } else if (inkomst > BrytPunktLåg) { // Om inte inkomsten är över högsta brytpunkten, testar om den är över
                                                 // lägsta.
                BetalaPå = inkomst - BrytPunktLåg;
            } else {
                JOptionPane.showMessageDialog(null, "Du behöver inte betala statlig inkomstskatt."); // Om årsinkomst är
                                                                                                     // under
                                                                                                     // brytpunkten
                                                                                                     // behöver man inte
                                                                                                     // betala.
            }

            if (inkomst > BrytPunktHög) { // Är inkomsten högre än högsta brytpunkt = betala 25% på det som är över
                                          // gränsen
                AttBetala = BetalaPå / 4;
                JOptionPane.showMessageDialog(null, "Du skall betala: " + AttBetala + "kr");
            } else if (inkomst > BrytPunktLåg) { // Annars betala 20% på det som är över lägsta brytpunkt
                AttBetala = BetalaPå / 5;
                JOptionPane.showMessageDialog(null, "Du skall betala " + AttBetala + "kr");
            }
        }
    }
}