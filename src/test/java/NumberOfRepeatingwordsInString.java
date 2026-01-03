import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfRepeatingwordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String str = sc.nextLine();
		str=str.toLowerCase();
		String [] strArray = str.split(" ");
		int count = 1;
		List<String> repeat = new ArrayList<>();
		for(int i=0;i<strArray.length;i++) {
			if(repeat.contains(strArray[i])){
				continue;
			}
			for(int j=0;j<strArray.length;j++) {
				if((strArray[i].equals(strArray[j]))&& (i!=j)) {
					count++;
				}
				
			}
			System.out.println(strArray[i] + " - " +count);
			repeat.add(strArray[i]);
			count=1;
		}
	}

}
