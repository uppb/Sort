
public class MergeSort extends Sort{
	public MergeSort(int[] data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	public int[] sort (int[] data){
		int[] sorteddata = mergeSort(data, 0 , data.length);
		UPDATE_DTO.setUpdateSingle(data.length-1, data[data.length-1]);
		return sorteddata;
	}
	
	private int[] mergeSort(int[] data, int start,  int end){
		if(start==end-1){

			int[] t = new int[]{ data[start] };
			return t;
		}
		int[] m1 = mergeSort(data, start, (start+end)/2);
		int[] m2 = mergeSort(data, (start+end)/2, end);
		
		int[] merge = merge(m1, m2, start, end);
		return merge;
}

private int[] merge(int[] dataA, int[] dataB, int start, int end){
		int[] orderData = new int[dataA.length+dataB.length];
		int indexA = 0, indexB = 0;
		
		for(int i=0; i<orderData.length; i++){
			if(indexA>=dataA.length){
				orderData[i] = dataB[indexB++];
			}else if(indexB>=dataB.length){
				orderData[i] = dataA[indexA++];
			}else if(dataA[indexA] > dataB[indexB]){
				orderData[i] = dataB[indexB++];
			}else{
				orderData[i] = dataA[indexA++];
			}
			UPDATE_DTO.setUpdateSingle(start+i, orderData[i]);
			//System.out.println(start+i + " " + orderData[i]);
		}
		return orderData;
}
}
