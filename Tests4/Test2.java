public class Test2{

	public static void main(String[] args){
		MenuItem m=new MenuItem(6,"Hamburger",57);
		Order o=new Order(5,2,m);
		System.out.println(m);
		System.out.println("---------");
		System.out.println(o);
	}
}