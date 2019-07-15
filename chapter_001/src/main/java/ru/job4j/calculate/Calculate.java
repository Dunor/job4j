package ru.job4j.calculate;

/**
 * Class Calculate выводит в консоль текст Hello, Job4j.
 * @author Максим К.
 */
public class Calculate {   

   /**
    * Выводит строку в консоль.
    * @param args - args.
    */
   public static void main(String[] args) {
      System.out.println("Hello, Job4j.");
   }
   
   /**
    * Method echo.
    * @param name Your name.
    * @return Echo plus your name.
    */
   public String echo(String name) {
	   return "Echo, echo, echo : " + name;
 }
}