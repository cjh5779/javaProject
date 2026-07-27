package exam;

public class SavingsMain {
    public static void main(String[] args) {
        Savings account = new Savings();

        account.setName();
        account.setBalance();

        System.out.println("예금주 : " + account.getName());
        System.out.println("입금전 잔액 : " + account.getBalance());
        
        account.inputDeposit();
        
        System.out.println("이자 : " + account.getInterest());
        System.out.println("최종 잔액: " + account.getBalance());
    }
}