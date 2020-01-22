public class SynchronizedLogic {
    public static Account account;

    class Account{
        public double money;
    }

    public static void main(String[] args) {
        account=new SynchronizedLogic().new Account();
        account.money=100.;
        Client client1=new Client(account);
        Client client2=new Client(account);
        client1.start();
        client2.start();
    }

}

class Client extends Thread {
    SynchronizedLogic.Account account;

    public Client(SynchronizedLogic.Account acc) {
        account = acc;
    }

    @Override
    public void run() {
        synchronized (account) {
        if (account.money - 70 > 0) { // достаточно ли средств ?
            try {
                sleep((long) (1000 * Math.random()));  // имитируем задержку банкомата
            } catch (InterruptedException e) {}
            account.money -= 70;  // снимаем со счета нужную сумму
            System.out.println(account.money);
        }
        else System.out.println("there are not enough funds on your account");
        }
    }
}