package studento;

import java.io.*;
import java.util.Scanner;

public class FileStudent {
    
    public static String findGrade(double mid, double fin) {
        double total = (mid + fin) / 2;
            if      (total >= 80) return "A";
            else if (total >= 75) return "B+";
            else if (total >= 70) return "B";
            else if (total >= 65) return "C+";
            else if (total >= 60) return "C";
            else if (total >= 55) return "D+";
            else if (total >= 50) return "D";
            else                  return "F";
    }
    
    public static double findAvg(double sum, int i) {
        return sum / i;
    }
    
    public static String formText(String con,int l) {
        int len = con.length();
        for (int i = len; i < l; i++) {
            con += " ";
        }
        return con;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sf = new Scanner (new FileReader ("info.txt"));
        int count = 0; String id, dept, name, grade; Double mid, fin, summid = .0 , sumfin = .0;
        
        System.out.println(" id name                   mid   final  grade");
        while(sf.hasNext()) {
            count++;
            id = sf.next();
            dept = sf.next();
            name = sf.next() + " " + sf.next();
            mid = sf.nextDouble();
            fin = sf.nextDouble();
            grade = findGrade(mid, fin);
            summid += mid;
            sumfin += fin;
                       
            System.out.printf("%3d %20s %6.2f %6.2f %5s", count, formText(name,20), mid, fin, formText(grade,2));
            System.out.println("");
            
        }
            double avgmid = findAvg(summid, count);
            double avgfin = findAvg(sumfin, count);
            System.out.printf("               average   %6.2f %6.2f",avgmid, avgfin);
            System.out.println("");
    }

}
