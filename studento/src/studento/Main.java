package studento;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sq = new Scanner (new FileReader("info.txt"));
        int count = 0;
        String id, dept, name, grade;
        double mid, fin, summid = 0, sumfin = 0;
        //System.out.println("ID Name                           mid    final  grade");
        while (sq.hasNext()) {
            if (count%5 == 0){
                System.out.println(" ID Name                           mid    final  grade");
            }
            count++;
            id = sq.next();
            dept = sq.next();
            name = sq.next() + " " + sq.next();
            mid = sq.nextDouble();
            fin = sq.nextDouble();
            grade = calGrade(mid, fin);
            summid += mid;
            sumfin += fin;
            System.out.printf("%3d %28s %6.2f %6.2f %5s", count, formText(name,28), mid, fin, formText(grade,2));
            System.out.println("");
            }

        double avgmid = findAvg(summid, count);
        double avgfin = findAvg(sumfin, count);
        System.out.printf("               average   %6.2f %6.2f",avgmid, avgfin);
        System.out.println("");
    }


    public static String calGrade(double mid, double fin) {
        String grade;
        double tscore = (mid+fin)/2;
        if (tscore >= 80) {
            grade = "A";
        } else if (tscore >= 75) {
            grade = "B+";
        } else if (tscore >= 70){
            grade = "B";
        } else if (tscore >= 65){
            grade = "C+";
        } else if (tscore >= 60){
            grade = "C";
        } else if (tscore >= 55){
            grade = "D+";
        } else if (tscore >= 50){
            grade = "D";
        } else grade = "F";

        return grade;
    }

    private static String formText(String con, int l){
        int len = con.length();
        for (int i = len; i < l; i++) {
            con += " ";
        }
        return con;
    }

    private static double findAvg(double sum, int i) {
        return sum / i;
    }
}
