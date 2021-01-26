import java.util.*;
class plant{
	private String[] typeOfPlants= {"Herbs","Shrubs","Trees","Climbers","Creepers"};
	private double[] typeOfPlantsPrice= {1,1.5,5,2,1.5}; //Price in USD
	private List<String> orderPlant = new ArrayList<String>(); //ordertype
	private String[] levelOfGrowth = {"Small", "Medium", "Large"}; 
	//Increase the price by do multiplying
	private double[] LevelofGrowthPrice= {1,2,3}; //Price in USD
	private List<String> orderSize = new ArrayList<String>(); //ordertype
	private List<Double> OrderPrice = new ArrayList<Double>(); //ordertype
	private double total_price;

	public void add_order(){
		Scanner sc = new Scanner(System.in);
		int k = 0,ch,unit,type;
		while(true){
			k=0;
			System.out.print("\n***Welcome to ordering system***");
			while(k < 5){
				System.out.printf("\nPress[%d] to order %s",k+1,typeOfPlants[k]);
				k++;
			}
			System.out.print("\nPress[0] exit the order");
			System.out.print("\nEnter your choice: ");
			ch = sc.nextInt();
			k=0;
			if((ch > 0) && (ch < 6)){
				System.out.print("\nThere are 3 level of growth with different price: ");
				while(k < 3){
					System.out.printf("\n%s size of %s price per unit is %f",levelOfGrowth[k],typeOfPlants[ch-1],LevelofGrowthPrice[k]*typeOfPlantsPrice[ch-1]);
					k++;
				}
				k=0;
				while(k < 3){
					System.out.printf("\nPress[%d] to order %s with size (%s)",k+1,typeOfPlants[ch-1],levelOfGrowth[k]);
					k++;
				}
				System.out.print("\nEnter your choice: ");
				type = sc.nextInt();
				System.out.print("Enter the total number to order: ");
				unit = sc.nextInt();
				if((type < 4)&&(type>0)){
					total_price = LevelofGrowthPrice[type-1]*typeOfPlantsPrice[ch-1]*unit;
					System.out.print("\nThe total price is " + total_price);
					orderPlant.add(typeOfPlants[ch-1]);
					orderSize.add(levelOfGrowth[type-1]);
					OrderPrice.add(total_price);
					System.out.print("\nSuccessfully stored in our system...\n");
				}
				else{
					System.out.print("\nInvalid choice\n");
				}
				
			}
			else if (ch == 0){
				break;
			}
			else{
				System.out.print("\nInvalid choice\n");
			}
		}
	}
	public void remove_order(){
		Scanner sc = new Scanner(System.in);
		System.out.print("\n***Welcome to ordering system***");
		int i=0;
		int ch;
		System.out.print("\nThere are "+OrderPrice.size()+" order(s)\n");
		while(i < OrderPrice.size()){
			System.out.printf("%d order : Plant %s size %s total price: %f\n",i+1,orderPlant.get(i),orderSize.get(i),OrderPrice.get(i));
			i++;
		}
		System.out.print("Enter the index to cancel the order: ");
		ch = sc.nextInt();
		if(ch < (orderPlant.size() + 1)){
			total_price = total_price - OrderPrice.get(ch-1);
			orderPlant.remove(ch-1);
			orderSize.remove(ch-1);
			OrderPrice.remove(ch -1);
			System.out.print("\nSuccessfully removed...\n");
		}else{
			System.out.print("\nInvalid choice\n");
		}
	}
	public void submit_order(){
		double discount=0;
		double priceDiscount;
		System.out.print("\nFinalizing the order: ");
		//adding the discount process
		if((total_price > 50) && (total_price < 100)){
			System.out.print("\nYou got 5% discount");
			discount = 0.05;
		}else if ((total_price >= 100) && (total_price < 200)){
			System.out.print("\nYou got 10% discount");
			discount = 0.1;
		}else if(total_price >= 200){
			System.out.print("\nYou got 15% discount");
			discount = 0.15;
		}else{
			System.out.print("\nWe don't have any promotion for you");	
		}
		priceDiscount = total_price * discount;
		total_price = total_price - priceDiscount;
		System.out.printf("\nThe total price to pay: %f",total_price);
		System.out.print("\nWe successfully got your order....\n");
	}
}
public class ex10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		plant p = new plant();
		int ch;
		while(true){
			System.out.print("***Welcome to planting shop***\nPress[1] Order the plant \nPress[2] Delete the order \nPress[3] Submit to the shop\nPress[4] Exit the program\nEnter your choice: ");
			ch = sc.nextInt();
			if(ch == 1){
				p.add_order();
			}else if(ch ==2){
				p.remove_order();
			}else if(ch ==3){
				p.submit_order();
			}
		}
	}
}
