import java.util.Scanner;

/*
 *This program is an interactive menu and ticket system, which utilizes polymorphism 
 *for the "MenuItem" objects
 *
 *Java @ TCC
 *Arick Mounts 
 */

public class Driver {
	public static void main (String[] args) {
		char input;
		int tableNum;
		Scanner s1 = new Scanner(System.in);
		Ticket t = null;
		Menu m1 = new Menu ("Food Place");
		m1.readFile( "menu.csv");
		
		System.out.println("(h to show commands) Input:");
		input = s1.nextLine().toString().charAt(0);
		while(input != 'q'){
			switch (input){
				case 'm':
					System.out.print(m1.toString());
					break;
				case 'n':

					System.out.println("Enter the ticket number");
					tableNum = Integer.parseInt( s1.nextLine().toString());
					t = new Ticket( tableNum);
					System.out.println("You created Ticket " + tableNum);
					break;
				case 'a':
					if (t != null){
						System.out.print(m1.toString());
						System.out.println("Enter the order number");
						int oC = Integer.parseInt( s1.nextLine().toString());
						t.addOrderCode( m1, oC );
					}else{
						System.out.println("Please create a ticket first.");
					}
					break;
				case 'p':
					if (t != null){
					System.out.print(t.getContents());
					}else{
						System.out.println("Please create a ticket first.");
					}
					break;
				case 't':
					if (t != null){
						System.out.println("$" + t.totalPrice());
					}else{
						System.out.println("Please create a ticket first.");
					}
					break;
				case 'd':
				    if (t != null){
						System.out.println( "Ticket " + t.getTableNumber() +" deleted");
						t = null;
					}else{
						System.out.println("No ticket to delete");
					}
					break;
				case 'h': 
					System.out.println("----Commands----");
					System.out.println("m - Show Menu");
					System.out.println("n - Create new ticket");
					System.out.println("a - Add item to ticket");
					System.out.println("p - Print contents of ticket");
					System.out.println("t - Print total price of ticket");
					System.out.println("d - Delete ticket");
					System.out.println("h - Print all commands");
					System.out.println("q - Quit the program");

			}
			System.out.println("Input:");
			input = s1.nextLine().toString().charAt(0);
		}

	}
		
}