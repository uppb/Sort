

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SortPanel extends JPanel{

	private static final long serialVersionUID = 7714161543529302169L;

	private int gridWidth;
	private int gridHeight;
	private int height;
	private int gap;
	private Sort sort;
	private boolean isClear;
	private  int[] sortData;
	
	private static final Color NORMAL_COLOR = new Color(50, 50, 50);
	private static final Color SINGLE_COLOR =  new Color(200, 50, 50);

	protected static final long FPS = 24;
	protected static final long SPF = 1000/FPS;
	

	
	public SortPanel(int width, int height, int gap, int[] sortData){
		
		if(sortData==null)
			throw new NullPointerException("排序数据不应为空");
		
		//setPreferredSize(new Dimension(width, height));
		
		this.gap = gap;
		this.height = height;
		this.gridWidth  = (width-gap*sortData.length)/sortData.length;
		this.gridHeight = height/getMaxData(sortData);
		
		if(gridWidth<=0)
			throw new IllegalArgumentException("减少gap或sortData的长度、或增加width");
		if(gridHeight<=0)
			throw new IllegalArgumentException("增加height或减少sortData的最大值");
		isClear = false;
		this.sortData = sortData;

		startPaintThread();
	}
	
	public void setSort(Sort sort){
		this.sort = sort;
		this.sortData = sort.data;
	}
	
	public void startSort() {
		new Thread  (new Runnable(){
			public void run() {
				sortData = sort.startSort(sortData.clone());
			}
		}).start();
	}
	private void startPaintThread() {
		new Thread(){
			public void run(){
				while (true) {
					try {
						repaint();
						Thread.sleep(SPF);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	private int getMaxData(int[] sortData) {
		int tmp = sortData[0];
		for(int i=1; i<sortData.length; i++){
				tmp = tmp<sortData[i] ? sortData[i] : tmp;
		}
		return tmp;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//if(isClear){
		//	clearAll(g);
		//	isClear = false;
		//}
		//else {
			drawAll(g);
			drawSingle(g);
		//	System.out.println(sortData.length);
		//}
	}

	private void drawSingle(Graphics g) {
		if (sort != null && sort.isSort){
			synchronized (sort.UPDATE_DTO) {
				while(!sort.UPDATE_DTO.isHaveSingle()){
					try {
							sort.UPDATE_DTO.wait();
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				g.setColor(SINGLE_COLOR);
				int index = sort.UPDATE_DTO.getSingleIndex();
				
				sortData[index] = sort.UPDATE_DTO.getSingleValue();
				StdAudio.play(StdAudio.note(440.0 * Math.pow(2, sortData[index] / 24.0), 0.05 , 0.5));
				g.fillRect(index*(gridWidth+gap), height-gridHeight*sortData[index] , gridWidth, gridHeight*sortData[index]);
				sort.UPDATE_DTO.clearSingle();

			}
		}
	}

	private void drawAll(Graphics g) {
		drawAll(g, sortData);
	}

	private void drawAll(Graphics g, int[] sortData) {
		g.setColor(NORMAL_COLOR);
		for(int i=0; i<sortData.length; i++){
			g.fillRect(i*(gridWidth+gap), height-gridHeight*sortData[i], gridWidth, gridHeight*sortData[i]);
			
		}

	}
	public void clear(){
		//isClear = true;
		for(int i=0; i<sortData.length; i++){
			sortData[i]=0;
		}
	}
	public void clearAll(Graphics g){
		g.clearRect(0, 0, 1000, 1000);
	}
	
}