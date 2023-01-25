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
        
        if (szam <= 127) {
            System.out.println("Osztály: A");
            System.out.println("Subnet Mask: 255.0.0.0");
        } else if (szam <= 191) {
            System.out.println("Osztály: B");
            System.out.println("Subnet Mask: 255.255.0.0");
        } else if (szam <= 223) {
            System.out.println("Osztály: C");
            System.out.println("Subnet Mask: 255.255.255.0");
        } else if (szam <= 239) {
            System.out.println("Osztály: D");
        } else {
            System.out.println("Osztály: E");
        }
    }
    
}
