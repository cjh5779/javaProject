package exam.instarray;

public class Customer {
	String customerNo;
	String customerName;
	String phoneNumber;
	String job;
	String gender;
	int age;
	
	public Customer(String customerNo, String customerName, String phoneNumber, String job, String gender, int age) {
		this.customerNo = customerNo;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.job = job;
        this.gender = gender;
        this.age = age;
	}
	
	public void showCustomerInfo() {
        System.out.println(customerNo + " " + customerName + " " + phoneNumber + " " + job + " " + gender + " " + age);
    }
}
