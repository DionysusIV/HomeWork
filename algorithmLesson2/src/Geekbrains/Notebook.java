package Geekbrains;


import lombok.*;

import java.math.BigDecimal;

@Value
public class Notebook implements Comparable <Notebook> {
   BigDecimal price;
    int memory;
    Producer producer;

   public enum Producer{
    Lenuvo,Asos,MacNote,Eser,Xamiou
   }

 @Override
 public int compareTo(Notebook o) {
    int result = price.compareTo(o.getPrice());
    if(result == 0){
     result = Integer.compare(memory,o.getMemory());
     if(result == 0){
     }
     return result;
    }
  return result;
 }

}
