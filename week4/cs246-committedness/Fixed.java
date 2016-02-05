public class Fixed {
   public void run(String[] args) {
      for (int i = 0; i < 100; i++) {
         System.out.println(i);
      }

      for (String arg : args) {
         System.out.println(arg);
      }
   }

   public static void main(String[] args) {
      new Fixed().run(args);
   }
}
