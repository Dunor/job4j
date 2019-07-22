package ru.job4j.calculate;

/**
 * Class Calculate выполняет арифметические действия(сложение, вычетание, умножение, деление),
 * и выводит результаты в консоль.
 * @author Максим К.
 */
public class Calculate {   

   /**
    * @param args - args.
    */
   public static void main(String[] args) {
      add(1, 1 );
      div(4, 2);
      multiply(2, 1);
      subtrack(10, 5);
   }

   /**
    * Метод add складывает значения параметров first и second
    * выводит результат в консоль
    * @param first - первое слагаемое
    * @param second - второе слагаемое
    */
   public static void add(double first, double second) {
      double result =  first + second;
      System.out.println(first + " + " + second + " = " + result);
   }

   /**
    * Метод div делит значение параметра first на second
    * выводит результат в консоль
    * @param first - делимое
    * @param second - делитель
    */
   public static void div(double first, double second) {
      double result =  first / second;
      System.out.println(first + " / " + second + " = " + result);
   }

   /**
    * Метод multiply перемножает значения параметров first и second
    * выводит результат в консоль
    * @param first - первый множетель
    * @param second - второй множетель
    */
   public static void multiply(double first, double second) {
      double result =  first * second;
      System.out.println(first + " * " + second + " = " + result);
   }

   /**
    * Метод subtrack вычитает из значения параметра first значение second
    * выводит результат в консоль
    * @param first - уменьшаемое
    * @param second - вычитаемое
    */
   public static void subtrack(double first, double second) {
      double result =  first - second;
      System.out.println(first + " - " + second + " = " + result);
   }

}