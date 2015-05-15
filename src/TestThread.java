public class TestThread {
    public static void main(String args[]) throws InterruptedException {
        

        RunnableDemo R1 = new RunnableDemo("Thread-1");
        R1.start();
        
        //Will create DL
        Thread.currentThread().join();

        RunnableDemo R2 = new RunnableDemo("Thread-2");
        R2.start();

        RunnableDemo R3 = new RunnableDemo("Thread-3");
        R3.start();

        RunnableDemo1 R4 = new RunnableDemo1("Thread-4");
        Thread t4 = new Thread(R4);
        t4.start();

        RunnableDemo1 R5 = new RunnableDemo1("Thread-5");
        Thread t5 = new Thread(R5);
        t5.start();

        RunnableDemo1 R6 = new RunnableDemo1("Thread-6");
        Thread t6 = new Thread(R6);
        t6.start();

    }
}