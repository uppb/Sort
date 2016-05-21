public class HeapSort extends Sort{
	
	public HeapSort(int[] data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
/*	public static void main(String[] args){
		int data[] = {4,3,5,7,1,8,9,2,6};
		Build(data, 9);
		for (int j = 9; j > 0; j--){
			Delete(data,j);
		}
		for (int i = 0; i < 9; i++){
			System.out.println(data[i]);
		}
	}
	*/
	
	
	public void Build(int data[], int n){
		for (int i = (n-1)/2 - 1; i >= 0; i--){
			FixDown (data,i,n);
		}
	}
	public void Delete(int data[], int n){
		int tmp = data[0];
		data[0] = data[n-1];
		UPDATE_DTO.setUpdateSingle(0, data[n-1]);
		data[n-1] = tmp;
		UPDATE_DTO.setUpdateSingle(n-1, tmp);
		FixDown(data,0,n-1);
	}
	public void Insert(int data[],int n, int value){
		data[n] = value;
		FixUp(data, n+1);
	}
	public void FixUp(int data[],int n){
		int current = n - 1;
		int father = (n/2) - 1;
		
		int tmp = data[current];
		while (father > 0 && data[current] > data[father]){
			data[current] = data[father];
			UPDATE_DTO.setUpdateSingle(current, data[father]);
			current = father;
			father = (current-1)/2;
		}
		data[current] = tmp;
		UPDATE_DTO.setUpdateSingle(current, tmp);
	}
	public void FixDown(int data[],int root,int n){
		int current = root;
		int son = current*2 + 1;
		
		while(son < n){
			if (son+1 < n && data[son+1] > data[son]){
				son = son + 1;
			}
			if (data[current] > data[son]) break;
			int tmp = data[current];
			data[current] = data[son];
			UPDATE_DTO.setUpdateSingle(current, data[son]);
			data[son] = tmp;
			UPDATE_DTO.setUpdateSingle(son, tmp);
			current = son;
			son = current*2 + 1;
		}
	}
	public int[] sort (int[] data){
		int[] sorteddata = heapSort(data,data.length);
		UPDATE_DTO.setUpdateSingle(data.length-1, data[data.length-1]);
		return sorteddata;
	}
	private int[] heapSort(int[] data, int length) {
		// TODO Auto-generated method stub
		Build(data, length);
		for (int j = length; j > 0; j--){
			Delete(data,j);
		}
		return data;
	}
}
