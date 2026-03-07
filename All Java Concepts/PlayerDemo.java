class Player{

	int runs;
	String name;
	static int total;
	
	Player(String name,int runs){
		this.runs=runs;
		this.name=name;
		this.total+=runs;
	}

	static{
		total=0;
	}

	
	public void displayRuns(){
		System.out.println(name+" Runs "+runs);
		
	}

	public void displayName(){
		System.out.println("Player Name : "+name);
	}

	public static void displayTotal(){
		System.out.println("Total Runs : "+total);
	}
}

class PlayerDemo{
	public static void main(String args[]){
			System.out.println();
		Player virat=new Player("Virat",18);
			virat.displayRuns();
			virat.displayName();
			System.out.println();
		Player msd=new Player("MSD",07);
			msd.displayRuns();
			msd.displayName();	
			System.out.println();	
		Player rohit=new Player("Rohit",45);
			rohit.displayRuns();
			rohit.displayName();
			System.out.println();

		Player.displayTotal();
	}
}