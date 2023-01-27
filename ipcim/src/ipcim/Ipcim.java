package ipcim;

import java.util.Scanner;

public class Ipcim {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("IP cím: ");
        String ipv4 = in.nextLine();
        String[] ipfelbont = ipv4.split("\\.");
        boolean error = false;
        
        for (String string : ipfelbont) {
            int szam;
            try {
                szam = Integer.valueOf(string);
                if (szam > 255) {
                    error = true;
                    break;
                }
            } catch (Exception e) {
                error = true;
                break;
            }
        }
        
        while (ipfelbont.length != 4 || error) {
            error = false;
            System.out.println("Ez nem egy IP cím");
            System.out.print("IP cím: ");
            ipv4 = in.nextLine();
            ipfelbont = ipv4.split("\\.");
            
            for (String string : ipfelbont) {
                int szam;
                try {
                    szam = Integer.valueOf(string);
                    if (szam > 255) {
                        error = true;
                        break;
                    }
                } catch (Exception e) {
                    error = true;
                    break;
                }
            }
            if (error) continue;
            if (Integer.valueOf(ipfelbont[0]) == 0) continue;
        }
        
        int szam = Integer.valueOf(ipfelbont[0]);
        char type = '0';
        
        if (szam <= 127) {
            System.out.println("Osztály: A");
            System.out.println("Subnet Mask: 255.0.0.0");
            type = 'A';
        } else if (szam <= 191) {
            System.out.println("Osztály: B");
            System.out.println("Subnet Mask: 255.255.0.0");
            type = 'B';
        } else if (szam <= 223) {
            System.out.println("Osztály: C");
            System.out.println("Subnet Mask: 255.255.255.0");
            type = 'C';
        } else if (szam <= 239) {
            System.out.println("Osztály: D");
            type = 'D';
        } else {
            System.out.println("Osztály: E");
            type = 'E';
        }
        
        if (type == 'C') {
            System.out.println();
            int hanyFele = 4;
            int lepes = (255/hanyFele)+1;
            System.out.println("Lépés: " + lepes);
            String halozat = ipfelbont[0] + "." + ipfelbont[1] + "." + ipfelbont[2] + ".";
            
            for (int i = 0; i < hanyFele; i++) {
                System.out.println((i+1) + ". hálózat");
                System.out.println("\tHálózati cím: " + halozat + lepes*i);
                System.out.println("\tElső kiosztható cím: " + halozat + (lepes*i+1));
                System.out.println("\tUtolsó kiosztható cím: " + halozat + (lepes*(i+1)-2));
                System.out.println("\tBroadcast cím: " + halozat + (lepes*(i+1)-1));
                System.out.println();
            }
        }
    }
    
}
