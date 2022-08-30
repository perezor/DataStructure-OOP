public class Order{
	private int table;
	private int ordered;
	private int served;
	private MenuItem item;

	public Order(int table,int count,MenuItem item){
		this.table=table;
		this.ordered=count;
		this.item=item;
		this.served=0;
	}
	public int getOrdered( )
	{
		return ordered;
	}//getter number of ordered from an item
	
	public void setOrdered(int count1)
	{
		 this.ordered = count1;
	}//getter number of ordered from an item
	
	public void setServed(int count1)
	{
		 this.served = count1;
	}//getter number of ordered from an item

	public int getServed( )
	{
		return served;
	}//getter number of served dish
	
	public MenuItem getItem( )
	{
		return item;
	}//getter number of served dish

	public int getTable( )
	{
		return table;
	}//getter number of ordered from an item

	public void serve(int count){
		if(count>=(ordered-served))
			this.served=ordered;
		else
			this.served+=count;	
	}
	public int getTotal( )
	{
		return (served*item.getPrice());
	}//getter number of ordered from an item


	public String toString(){
		String str =(item.toString() + " Table: "+table+" Served: "+served+" Total: "+(served*item.getPrice())); 	
		return str;
	}

}