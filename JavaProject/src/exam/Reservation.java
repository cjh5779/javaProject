package exam;

public class Reservation {
	String flight;
    String name;
    String departure;
    String arrival;
    int price;
    String seatNo;
    
    public Reservation(String flight, String name, String departure, String arrival, int price, String seatNo) {
        this.flight = flight;
        this.name = name;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.seatNo = seatNo;
    }
    
    public void showRsvInfo() {
        System.out.println("**항공권 예약 정보**");
        System.out.println("항공기 : " + flight);
        System.out.println("예약자 : " + name);
        System.out.println("출발지 : " + departure);
        System.out.println("도착지 : " + arrival);
        System.out.println("금액 : " + price);
        System.out.println("좌석번호 : " + seatNo);
    }
}
