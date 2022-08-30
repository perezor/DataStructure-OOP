public class CashRegister{
	private List<MenuItem> menu;
	private List<Order> chefsQue;
	private List<Order> pending;
	private List<Order> paid;

	public CashRegister(){
		menu=new List<MenuItem>();
		chefsQue=new List<Order>();
		pending=new List<Order>();
		paid=new List<Order>();
	}
	public void addMenuItem(int id,String name,int price){
		MenuItem item = new MenuItem(id,name,price);
		Node <MenuItem> pos = menu.getFirst();
		Node <MenuItem> prePos = null;
		while(pos!=null && id > pos.getData().getId() ){
			prePos=pos;
			pos=pos.getNext();
		}	
		menu.insert(prePos,item);
	}
	public void addOrder(int table,int count,int itemId){
		Node <MenuItem> itemNode = menu.getFirst();
		while(itemNode!=null && itemId != itemNode.getData().getId()) 
			itemNode = itemNode.getNext();
		if(itemNode!=null){
			Node <Order> chefNode = chefsQue.getFirst();
			while(chefNode!=null && chefNode.getNext()!=null)
				chefNode = chefNode.getNext();
			chefsQue.insert(chefNode,new Order(table,count,itemNode.getData()));

			Node <Order> pendNode = pending.getFirst();
			boolean fuzed = false;
			Node<Order> tempNode = null;
			while(pendNode!=null && itemId>=pendNode.getData().getItem().getId()) {
				
				if(itemId == pendNode.getData().getItem().getId() && table == pendNode.getData().getTable()) {
					fuzed=true;
					pendNode.getData().setOrdered(count + pendNode.getData().getOrdered());
				}
				tempNode = pendNode;
				pendNode = pendNode.getNext();
			}//while
			if(fuzed==false)
				pending.insert(tempNode, new Order(table,count,itemNode.getData()));
		}
	}
	public void printCheck(int table){
		Node <Order> chefNode = chefsQue.getFirst(); 
		while(chefNode!=null){
			if(table == chefNode.getData().getTable())
				chefsQue.remove(chefNode);
			chefNode = chefNode.getNext();	
		}//while

		Node <Order> pendNode = pending.getFirst();
		int temp = 0; //help variable
		while(pendNode!=null){
			if(table == pendNode.getData().getTable()) {
				pending.remove(pendNode);
				if (pendNode.getData().getServed() != 0){
					System.out.println(pendNode.getData().toString());
					temp += pendNode.getData().getTotal();
				}
				Node <Order> paidNode = paid.getFirst();
				boolean fuzed=false;
				Node<Order> prevpaidNode = null;
				while(paidNode!=null && (paidNode.getData().getItem().getId() < pendNode.getData().getItem().getId() || paidNode.getData().getItem().getId() == pendNode.getData().getItem().getId() && paidNode.getData().getTable() < pendNode.getData().getTable())) {
					prevpaidNode = paidNode;
					paidNode = paidNode.getNext();
				}//while
				if(paidNode!=null && pendNode.getData().getItem().getId() == paidNode.getData().getItem().getId() && table == paidNode.getData().getTable()) {
					fuzed=true;
					paidNode.getData().setOrdered(pendNode.getData().getOrdered() + paidNode.getData().getOrdered());
					paidNode.getData().setServed(pendNode.getData().getServed() + paidNode.getData().getServed());
				}
				if(fuzed==false)
					paid.insert(prevpaidNode, pendNode.getData());
			}
			pendNode = pendNode.getNext();
		}//while
     System.out.println("Total: "+temp);
	}
	public void printChefsQue(){
		Node<Order> chefsNode = chefsQue.getFirst();
		while (chefsNode != null) {
			System.out.println(chefsNode.getData().getItem() + " Table: " + chefsNode.getData().getTable() + " Not Served: " + (chefsNode.getData().getOrdered() - chefsNode.getData().getServed()));
			chefsNode = chefsNode.getNext();
		}
	}
	public void serve(int table,int count,int itemId){
		Node<Order> findMatch = pending.getFirst();
		while(findMatch!= null){
			if(table == findMatch.getData().getTable() && itemId == findMatch.getData().getItem().getId())
				findMatch.getData().serve(count);
			findMatch = findMatch.getNext();
		}//while

		findMatch = chefsQue.getFirst(); //check both lists once
		while(findMatch!= null && count>0){
			if(table == findMatch.getData().getTable() && itemId == findMatch.getData().getItem().getId())
				if (count >= (findMatch.getData().getOrdered() - findMatch.getData().getServed())) {
					chefsQue.remove(findMatch);
					count -= (findMatch.getData().getOrdered() - findMatch.getData().getServed());
				}
				else {
					findMatch.getData().serve(count);
					count = 0;
				}
			findMatch = findMatch.getNext();
		}

	}//serve
	public void printReport(){
		Node<Order> paidNode = paid.getFirst();
		int temp1=0;
		while(paidNode != null){
			System.out.println(paidNode.getData().toString()+" Not Served: "+(paidNode.getData().getOrdered()-paidNode.getData().getServed()));
			temp1 += paidNode.getData().getTotal();
			paidNode = paidNode.getNext();
		}
		System.out.println("Total price: "+ (temp1));
	}
	public void printMenu(){
		Node<MenuItem> item = menu.getFirst();
		while(item != null){
			System.out.println(item.getData().toString());
			item = item.getNext();
		}//while
	}//printMenu
}//CashRegister