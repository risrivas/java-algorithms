package com.hacker.rank.ctci;

import java.util.Scanner;

public class DateDiff {

   private static final int YEARS_FINE = 10_000;
   private static final int MONTHS_FINE = 500;
   private static final int DAYS_FINE = 15;

   public static void main(String[] args) {
      /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scan = new Scanner(System.in);
      int da = scan.nextInt();
      int ma = scan.nextInt();
      int ya = scan.nextInt();

      int de = scan.nextInt();
      int me = scan.nextInt();
      int ye = scan.nextInt();

      scan.close();

      int fine = 0;

      if(ya > ye) {
         fine+= yearFine(ya, ye);
         fine+= (monthFine((12-ma), me));
         fine+= (dayFine((31-da), de));
      } else if (ya == ye) {
         if(ma > me) {
            fine+= monthFine(ma, me);
            fine+= (dayFine((31-da), de));
         } else if (ma == me) {
            fine+= dayFine(da, de);
         }
      }

      System.out.println(fine);

   }

   private static int yearFine(int ya, int ye) {
      if(ya > ye) {
         return (ya-ye) * YEARS_FINE;
      }
      return 0;
   }

   private static int monthFine(int ma, int me) {
      if(ma > me) {
         return (ma-me) * MONTHS_FINE;
      }
      return 0;
   }

   private static int dayFine(int da, int de) {
      if(da > de) {
         return (da-de) * DAYS_FINE;
      }
      return 0;
   }


}
