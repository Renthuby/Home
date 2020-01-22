public class ParalleLogic {
    public static void main(String[] args) {
        Work work1 = new Work("A");
        Work work2 = new Work("B");
        Work work3 = new Work("C");
        work1.start();
        work2.start();
        work3.start();
    }
}

class Work extends Thread {
    String threadName;

    public Work(String name) {
        threadName = name;
    }

    @Override
    public void run() {
        int max=(int) (20*Math.random());
        for (int i = 0; i < max; i++) {
            try {
                sleep((long)(1000*Math.random()));
                System.out.print(threadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
