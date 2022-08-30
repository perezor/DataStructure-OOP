public class MenuItem{
	private String name;
	private int id;
	private int price;

	public MenuItem(int id,String name,int price){
		this.id=id;
		this.name=name;
		this.price=price;
	}//constructor
	public String toString(){
		String ans =(id + " " + name + " Price: " + price);
		return ans;		
	}//string to string
	public int getId( )
	{
		return this.id;
	}//getter id
	public String getName( )
	{
		return this.name;
	}//getter name
	public int getPrice( )
	{
		return this.price;
	}//getter price
}//class MenuItem