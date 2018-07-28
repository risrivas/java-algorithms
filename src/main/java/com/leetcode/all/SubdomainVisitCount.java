package com.leetcode.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

   public static void main(String[] args) {
      System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
   }

   private static List<String> subdomainVisits(String[] cpdomains) {
      List<String> result = new ArrayList<>();
      Map<String, Integer> countMap = new HashMap<>();

      for (String cpdomain : cpdomains) {
         String[] domains = cpdomain.split("\\s+");
         int count = Integer.parseInt(domains[0]);
         String domain = domains[1];
         countMap.merge(domain, count, Integer::sum);
         int index = domain.indexOf(".");
         while (index != -1) {
            domain = domain.substring(index + 1);
            countMap.merge(domain, count, Integer::sum);
            index = domain.indexOf(".");
         }
      }

      for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
         result.add("" + entry.getValue() + " " + entry.getKey());
      }

      return result;
   }

}
