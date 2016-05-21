
public class InsertSort extends Sort {
	public InsertSort(int[] data) {
		super(data);
		// TODO Auto-generated constructor stub
	}

	public int[] sort(int[] data){
		for (int step = data.length/2; step > 0; step /= 2){
			for (int i = step; i < data.length ; i++){
				int j = i;
				int t = data [i];
				while (j > step - 1 && t < data[j-step] ){
					data[j] = data[j-step];
					UPDATE_DTO.setUpdateSingle(j, data[j-step]);
					j -= step;
				}
				data[j] = t;
				UPDATE_DTO.setUpdateSingle(j, t);
			}
		}
		return data;
	}

}
