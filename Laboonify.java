import java.util.Arrays;

public class Laboonify {
	public static void main(String [] args) {
		
	}
	public static int[] laboonify(int[]inputArray){
		//size of output array will be one more because we will put the sum of the values at the last index of the array
		int []squaredArray = new int[inputArray.length+1];
		int sumOfSquared = 0;
		Arrays.sort(inputArray);
		for (int i=0;i<inputArray.length;i++)
		{
			//put input number into array index
			int number = inputArray[i];
			//square the number
			number = number*number;
			//input squared number into output array
			squaredArray[i] = number;
			//continue to keep a sum of the values
			sumOfSquared = sumOfSquared + number;
		}
		//then add the sum of the values and put it at the end of the array
		squaredArray[inputArray.length] = sumOfSquared;
		return squaredArray;
	}
}
