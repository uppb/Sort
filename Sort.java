import java.util.Random;


public abstract class Sort {

	public final UpdateDTO UPDATE_DTO = new UpdateDTO();
	public int[] data;
	public boolean isSort;
	public Sort(int[] data){
		if(data==null)
			throw new NullPointerException("Do not let the data array null");
		this.data = data;
	}
	
	public int[] startSort(int[] data){
		isSort = true;
		
		int[] sorted = sort(data);
		
		isSort = false;
		return sorted;
	}
	
	public abstract int[] sort(int[] data);
	
	
}