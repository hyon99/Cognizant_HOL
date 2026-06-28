//Implementing the Singleton Pattern
public class Exercise_1 {
    static class Singleton 
    {
        private static Singleton instance;
        private Singleton() 
        {
            System.out.println("Singleton Instance Created");
        }
        public static Singleton getInstance() 
        {
            if (instance == null) 
            {
                instance = new Singleton();
            }
            return instance;
        }
        public void showMessage() 
        {
            System.out.println("Hello from Singleton Pattern!");
        }
    }
    public static void main(String[] args) 
    {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        obj1.showMessage();
        System.out.println("Are both objects same? " + (obj1 == obj2));
    }
}