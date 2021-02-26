import java.util.*;
import java.lang.*;
import java.io.*;

public class Key {

   private ArrayList<String> alphabet;
   private ArrayList<String> key;
   private ArrayList<Stat> stats;

   public Key() {
      alphabet = new ArrayList<String>();
      alphabet.add("a");
      alphabet.add("b");
      alphabet.add("c");
      alphabet.add("d");
      alphabet.add("e");
      alphabet.add("f");
      alphabet.add("g");
      alphabet.add("h");
      alphabet.add("i");
      alphabet.add("j");
      alphabet.add("k");
      alphabet.add("l");
      alphabet.add("m");
      alphabet.add("n");
      alphabet.add("o");
      alphabet.add("p");
      alphabet.add("q");
      alphabet.add("r");
      alphabet.add("s");
      alphabet.add("t");
      alphabet.add("u");
      alphabet.add("v");
      alphabet.add("w");
      alphabet.add("x");
      alphabet.add("y");
      alphabet.add("z");
      ArrayList<String> temp = new ArrayList<String>(alphabet);
      key = new ArrayList<String>();
      for(int i = 0; i < alphabet.size(); i++) {
         int max = alphabet.size() - 1;
         int min = i;
         int range = max - min + 1;
         int random = (int)(Math.random() * range);
         String t = temp.get(random);
         String c = t.toUpperCase();
         key.add(c);
         temp.remove(random);
      }
      stats = new ArrayList<Stat>();
   }
   
   public void addStats(String letter, double occ) {
      stats.add(new Stat(letter, occ));
      Collections.sort(stats, new SortingStats()); 
   }
   
   public String getStatVal(int index) {
      return stats.get(index).toString();
   }
   
   public int statSize() {
      return stats.size();
   }
   
   public String reEn(int s) {
      return key.get(s);
   }
   
   public String reAlpha(int s) {
      return alphabet.get(s);
   }
   
   public String findKeyValue(String a) {
      int g = alphabet.indexOf(a);
      return key.get(g);
   }
   
   public String findAlphaValue(String e) {
      int q = key.indexOf(e);
      return alphabet.get(q);
   }
   
   public void createBlank() {
      for(int i = 0; i < key.size(); i++) {
         key.set(i, " ");
      }
   }
   
   public int setLetter(String a, String e) {
      int index = alphabet.indexOf(a);
      key.set(index, e);
      return index;
   }
   
   public String alphabetPri() {
      String upper = "";
      for (int j = 0; j < alphabet.size(); j++) {
         if(j == alphabet.size() - 1) {
            upper += alphabet.get(j);
         } else {
            upper += alphabet.get(j) + "|";
         }
      }
      return upper;
   }
   
   public String keyPri() {
      String lower = "";
      for (int z = 0; z < key.size(); z++) {
         if(z == key.size() - 1) {
            lower += key.get(z);
         } else {
            lower += key.get(z) + "|";
         }
      }
      return lower;
   }
   
   public String toString() {
      return alphabetPri() + "\n----------------------------------------------------------------------" + "\n" + keyPri();
   }
}