public class Broken implements Runnable {
   @Override
   public void run() throws Exception {
      String arg = "ex";

      if (arg.equals("ex")) {
         throw new Exception("ex was passed!");
      }
   }

   public static void main(String[] args) throws Exception {
      System.out.println("This is a great class.");
      new Broken().run();
   }
}
