public class Test3{

	public static void main(String[] args){
		CashRegister r=new CashRegister();
		r.addMenuItem(1,"Green Salad",21);
		r.addMenuItem(2,"Tomato Salad",24);
		r.addMenuItem(3,"Hummus",23);
		r.addMenuItem(4,"Chicken Breast",52);
		r.addMenuItem(5,"Dennis",79);
		r.addMenuItem(6,"Hamburger",57);
		r.addMenuItem(7,"Salmon",54);
		r.addMenuItem(8,"Kebab",37);
		r.addMenuItem(9,"Fish Patties",21);
		r.addMenuItem(10,"Tomato Salad",24);
		r.addMenuItem(11,"Potatoes",16);
		r.addMenuItem(12,"French Fries",16);
		r.addMenuItem(13,"Small Rice",9);
		r.addMenuItem(14,"Big Rice",14);
		r.addMenuItem(15,"Small Mashed Potatoes",10);
		r.addMenuItem(16,"Big Mashed Potatoes",37);
		r.addMenuItem(17,"Kadaif",32);
		r.addMenuItem(18,"Mouse",22);
		r.addMenuItem(19,"Cola",10);
		r.addMenuItem(20,"Orange Juice",10);
		r.addMenuItem(21,"Apple Juice",10);
		r.addMenuItem(22,"Beer",17);
		System.out.println("========== 1. Print Menu ==========");
		r.printMenu();

		r.addOrder(3,2,2);
		r.addOrder(3,1,8);
		r.addOrder(3,1,12);
		r.addOrder(3,1,6);
		r.addOrder(3,2,19);
		r.addOrder(3,2,75);
		r.addOrder(5,1,22);
		r.addOrder(5,1,9);
		r.addOrder(5,3,7);
		r.addOrder(5,1,9);
		System.out.println("========== 2. Print Report ==========");
		r.printReport();
		System.out.println("========== 3. Print ChefsQue ==========");
		r.printChefsQue();
		r.serve(3,2,2);
		r.serve(3,1,12);
		r.serve(5,1,9);
		r.serve(5,3,7);
		
		System.out.println("========== 4. Print Check Table 5 ==========");
		r.printCheck(5);
		System.out.println("========== 5. Print Check Table 3 ==========");
		r.printCheck(3);
		System.out.println("========== 6. Print Report ==========");
		r.printReport();

		r.addOrder(5,3,7);
		r.addOrder(5,1,9);
		
		System.out.println("========== 7. Print Check Table 5 ==========");
		r.printCheck(5);
		
		System.out.println("========== 8. Print Check Table 7 ==========");
		r.printCheck(7);

		System.out.println("========== 9. Print Report ==========");
		r.printReport();
	}
}