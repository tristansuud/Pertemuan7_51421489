/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpl2tugasm1;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
public class Rpl2tugasm1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih bangun datar");
        System.out.println("1. Persegi");
        System.out.println("2. Segitiga");
        System.out.println("3. Lingkaran");
        System.out.println("4. Trapesium");
        System.out.print("Pilih (1-4): ");
        
        int choice = scanner.nextInt();
        double area = 0;

        switch (choice) {
            case 1: // Persegi
                System.out.print("Masukkan panjang sisi persegi:  ");
                double side = scanner.nextDouble();
                area = side * side;
                break;

            case 2: // Segitiga
                System.out.print("Masukkan alas dari segitiga:  ");
                double base = scanner.nextDouble();
                System.out.print("masukkan tinggi segitiga: ");
                double height = scanner.nextDouble();
                area = 0.5 * base * height;
                break;

            case 3: // Lingkaran
                System.out.print("Masukkan jari-jari lingkaran: ");
                double radius = scanner.nextDouble();
                area = Math.PI * radius * radius;
                break;

            case 4: // Trapesium
                System.out.print("Masukkan nilai alas: ");
                double base1 = scanner.nextDouble();
                System.out.print("Masukkan nilai atap: ");
                double base2 = scanner.nextDouble();
                System.out.print("Masukkan tinggi: ");
                double heightTrapezoid = scanner.nextDouble();
                area = 0.5 * (base1 + base2) * heightTrapezoid;
                break;

            default:
                System.out.println("Tidak ada pilihan tersebut...");
                System.exit(0);
        }

        System.out.println("Luas dari bangun datar tsb adalah: " + area);
    }
    
}
