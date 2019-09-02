import java.io.*;
import java.util.ArrayList;

public class Menu {
	private String restaurantName;
	private ArrayList<MenuItem> menuList= new ArrayList<MenuItem> ();
	
	public Menu (String restaurantName){
		this.restaurantName = restaurantName;
	}
	
	public void setRestaurantName (String restaurantName){
		this.restaurantName = restaurantName;
	}
	public String getRestaurantName () {
		return restaurantName;
	}
	public void addItem (MenuItem m) {
		menuList.add(m);//ToDo calls menu item construction
	}

	public MenuItem getItem (int num){
		return menuList.get(num);
	}

	public int getSize (){
		return menuList.size();
	}
	
	public void readFile (String fileName){
		String input = "";
		try(
			FileReader fr = new FileReader( fileName );
			BufferedReader br = new BufferedReader( fr );
		){
			do{
				input = br.readLine();
				if( input != null ){
					//System.out.println( input );
					//String[] temp = input.split(",");
					//Book tempBook = new Book( temp[ 0 ],
					//						  temp[ 1 ],
					//						  Integer.parseInt( temp[ 2 ] ) );
					switch (input.charAt(0)){
						case '0':
							this.addItem( new Entree ( input.split(",") ));
						break;
						case '1':
							this.addItem( new Dessert ( input.split(",") ));
						break;
						case '2':
							this.addItem( new Appetizer ( input.split(",") ));
						break;
						default :
							continue;
					}
					//MenuItem tempItem = new MenuItem( input.split(",") );
					
				}
				
			}while( input != null );
			
		}catch( IOException e ){
			e.printStackTrace();
		}
	}
	
	public String toString() {
		
		StringBuilder tempString = new StringBuilder();
		tempString.append ("---------------------\n<<"+restaurantName + ">>\n---------------------\n") ;
		for( MenuItem m : menuList ){
			tempString.append( m.toString() + "\n\n" );
		}
		return tempString.toString ();
	}
	
}