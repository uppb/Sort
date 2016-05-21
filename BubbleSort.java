public class BubbleSort extends Sort{
	public BubbleSort(int[] data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public int[] sort(int[] data){
		for (int i = 0; i < data.length - 1; i++){
			for (int j = i+1; j < data.length; j++){
				if (data[i] > data[j]){
					int t = data[i];
					data[i] = data[j];
					UPDATE_DTO.setUpdateSingle(i, data[j]);
					data[j] = t;
					UPDATE_DTO.setUpdateSingle(j, t);
					
				}
			}
		}
		return data;
	}
}
