
public abstract class MenuItem{
	private String name;
	private double price;
	private String description;
	private int orderCode;
	
	public MenuItem (String name, double price, String description, int orderCode){
		this.name = name;
		this.price = price;
		this.description = description;
		this.orderCode = orderCode;
	}
	
	public MenuItem (String[] fromCSV){
		this.name = fromCSV[ 1 ];
		this.price = Double.parseDouble( fromCSV[ 2 ] );
		this.description =  fromCSV[ 3 ] ;
		this.orderCode = Integer.parseInt( fromCSV [ 4 ]);
	}
	
	public void setName (String name){
		this.name = name;
	} 
	public void setPrice (double price){
		this.price = price;
	} 
	public void setDescription (String description){
		this.description = description;
	} 
	public void setOrderCode (int orderCode){
		this.orderCode = orderCode;
	} 
	public String getName (){
		return name;
	} 
	public double getPrice (){
		return price;
	} 
	public String getDescription (){
		return description;
	} 
	public int getOrderCode (){
		return orderCode;
	} 
	
	public String toString (){
		return "___________\nName: " + name + "\nPrice: " + price + "\nDescription: " + description + "\nOrderCode: " + orderCode + '\n';
	}
}
