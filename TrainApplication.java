package TrainTicketReservation;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Scanner;
public class TrainApplication {

		public static void main(String[] args) {
			
		    TrainDao trainDao=new TrainDao();
		    Ticket ticket=null;
		    double ticketPrice=0;
		    System.out.println("=========Welcom to the Train ===========");
			System.out.println("Enter the train no");
			Scanner sc=new Scanner(System.in);
			int trainNo=sc.nextInt();
			
			
			System.out.println("Enter the travel date in dd/MM/yyyy format");
		    String date=sc.next();
		    try {
		    	
			Date travelDate=new SimpleDateFormat("dd/MM/yyyy").parse(date);
				

			
			Train train= trainDao.findTrain(trainNo);
			   ticket=new Ticket(travelDate,train);
			  
				
		} catch (ParseException e) {
			
			e.printStackTrace();
		} 
		   
			
			System.out.println("Enter the no. of passengers:");
					int passengerNo=sc.nextInt();
			
			for(int i=0;i<passengerNo;i++)
			{
				System.out.println("Enter the passenger name: ");
				String name=sc.nextLine();
				sc.nextLine();
				System.out.println("Enter the passenger age: ");
				int age=sc.nextInt();
				System.out.println("Enter the  gender (M/F): ");
				char gender=sc.next().charAt(0);
				Passenger passenger=new Passenger(name,age,gender);
				ticket.addPassenger(name, age, gender);
				 ticketPrice=ticketPrice+ticket.calculateTotalTicketPrice();
			}
			 String pnr=ticket.generatePNR();
			 System.out.println("Train booked with PNR No.: "+pnr);
			
			 System.out.println("totalFare: "+ticketPrice);
			
				
		}
}