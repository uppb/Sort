import java.util.Random;

public class QuickSort extends Sort{
	public QuickSort(int[] data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	public int[] sort (int[] data){
		quickSort(data, 0 , data.length-1);
		return data;
	}
	private void quickSort(int[] data, int L,  int R){
		if(L >= R){
			return;
		}
		Random rand = new Random();
		int rn = rand.nextInt(R-L+1)+L;
		int tmp = data[rn];
		data[rn] = data[L];
		UPDATE_DTO.setUpdateSingle(rn,data[L]);
		data[L] = tmp;
		UPDATE_DTO.setUpdateSingle(L,tmp);
		int i, j;
		i = L;
		j = R;
		
		int pos = i;
		while (i < j){
			 while (i < j && data[j] >= tmp)
	        {
	            j--;
	        }
	        if (i < j)
	        {
	            data[pos] = data[j];
	            UPDATE_DTO.setUpdateSingle(pos, data[j]);
	            pos = j;
	            
	        }
	        
	        while (i < j && data[i] < tmp)
	        {
	            i++;			       
	        }
	        if (i < j)
	        {
	            data[pos] = data[i];
	            UPDATE_DTO.setUpdateSingle(pos, data[i]);
	            pos = i;
	            
	        } 
		}
		data[pos] = tmp;
		UPDATE_DTO.setUpdateSingle(pos, tmp);
		quickSort(data,L,pos-1);
		quickSort(data,pos+1,R);
		return;

	}
	
}
