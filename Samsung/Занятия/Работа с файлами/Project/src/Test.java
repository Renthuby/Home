public class Test {

    MyHouse myHouse;

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            myHouse.eatPizza();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.myHouse = new MyHouse();
        MyThread thread = test.new MyThread();
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.myHouse.pizzaGuy();
    }

}

class MyHouse {
    private boolean pizzaArrived = false;

    public void eatPizza() {
        synchronized (this) {
            while (!pizzaArrived) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }
        System.out.println("yumyum...");
    }

    public void pizzaGuy() {
        synchronized (this) {
            pizzaArrived = true;
            notifyAll();
        }
    }
}