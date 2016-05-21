

public class UpdateDTO {

	private volatile int singleIndex = -1;
	private volatile int singleValue = -1;

	public void setUpdateSingle(int index, int data) {
		synchronized (this) {
			while(this.isHaveSingle()){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.singleIndex = index;
			this.singleValue = data;
			this.notifyAll();
		}
	}
	public boolean isHaveSingle(){
		return singleIndex!=-1;
	}
	public int getSingleIndex(){
		return singleIndex;
	}
	public int getSingleValue() {
		return singleValue;
	}
	public void clearSingle(){
		this.singleIndex = -1;
		this.singleValue = -1;
		this.notifyAll();
	}
}
