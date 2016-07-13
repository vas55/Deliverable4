import java.util.Random;
import java.util.Arrays;


import static org.junit.Assert.*;
import org.junit.Test;


public class LaboonifyTest {
	Random rng = new Random();

	public int[] generateRandomArray(){
		int[] randArr= new int[rng.nextInt(100)+1];
		for (int i=0;i<randArr.length;i++){
			randArr[i]=rng.nextInt(100)+1;
		}
    	return randArr;
	}
	
	/*
	 * We will test if the size of the input array is always one less than the output array. 
	 */
	@Test
	public void firstInvariant() {
		for (int i=0; i<100;i++){
			int[] arr = generateRandomArray();
			int[] outputArray = Laboonify.laboonify(arr);
			int x = outputArray.length - arr.length;
			// fail if output array is not exactly one more than input array (so x = 1)
			assertEquals(x,1);
		}
	}
	/*
	 * We will test that the output array will be sorted after given the values from the input array.  
	 */
	@Test
	public void secondInvariant () {
		
		for (int i = 0; i<100; i++)
		{
			int[] arr = generateRandomArray();
			int outputArray[] = Laboonify.laboonify(arr);
			//The sum will always be the largest value so it will always be at the end
			Arrays.sort(outputArray);
			
			for (int j = 0; j<outputArray.length-1;j++){
				if (outputArray[j] > outputArray[j+1]){
					fail();
				}
				else {
					assertTrue(true);
				}
			}
		}
	}

	/*
	 * We will test that the last value in the ouput array is correctly equal to the sum of all the rest of the values in the output array. 
	 */
	@Test
	public void thirdInvariant() {
		
		for (int i = 0; i<100; i++){
			int sumOfOutputVal = 0;
			int[] arr = generateRandomArray();
			int outputArray[] = Laboonify.laboonify(arr);
			for (int j = 0; j<outputArray.length - 1; j++)
			{
				sumOfOutputVal = sumOfOutputVal + outputArray[j];
			}
			if (sumOfOutputVal == outputArray[outputArray.length-1]) {
				assertTrue(true);
			}
			else {
				fail();
			}
		}
		
		
	}
}
