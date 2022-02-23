package com.quentinrouet.swapi.bo;

import java.util.ArrayList;

/**
 * Created by quentin for Constraint Layout on 23/02/2022.
 */
public class ResultPlanet {
   int count;
   String previous,next;
   ArrayList<Planet> results;

   public ResultPlanet(int count, String previous, String next, ArrayList<Planet> results) {
      this.count = count;
      this.previous = previous;
      this.next = next;
      this.results = results;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public String getPrevious() {
      return previous;
   }

   public void setPrevious(String previous) {
      this.previous = previous;
   }

   public String getNext() {
      return next;
   }

   public void setNext(String next) {
      this.next = next;
   }

   public ArrayList<Planet> getResults() {
      return results;
   }

   public void setResults(ArrayList<Planet> results) {
      this.results = results;
   }
}
