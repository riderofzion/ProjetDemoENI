package com.quentinrouet.swapi.bo;

/**
 * Created by quentin for Constraint Layout on 23/02/2022.
 */
public class Planet {
   String name, diameter, population,climate;

   public Planet(String name, String diameter, String population, String climate) {
      this.name = name;
      this.diameter = diameter;
      this.population = population;
      this.climate = climate;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDiameter() {
      return diameter;
   }

   public void setDiameter(String diameter) {
      this.diameter = diameter;
   }

   public String getPopulation() {
      return population;
   }

   public void setPopulation(String population) {
      this.population = population;
   }

   public String getClimate() {
      return climate;
   }

   public void setClimate(String climate) {
      this.climate = climate;
   }
}
