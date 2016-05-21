

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SortDemo {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				JFrame frame = new JFrame("Sort");
				frame.setLayout(null);
				frame.setSize(900, 500);
				int[] sortData = gererateSortData(10);
				
				
				SortPanel sortpanel = new SortPanel(900, 400, 1, sortData);
				frame.getContentPane().add(sortpanel);
				sortpanel.setBounds(0, 60, 900, 400);
				
				JButton button = new JButton("ShellSort");
				frame.getContentPane().add(button);
				button.setBounds(10, 10, 100, 30);
				button.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						//sortpanel.clear();
						sortpanel.setSort(new InsertSort(sortData.clone()));
						sortpanel.startSort();
					}
					} );
				
				JButton button2 = new JButton("BubbleSort");
				frame.getContentPane().add(button2);
				button2.setBounds(120, 10, 100, 30);
				button2.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						sortpanel.setSort(new BubbleSort(sortData.clone()));
						sortpanel.startSort();
					}
					} );
				
				JButton button3 = new JButton("QuickSort");
				frame.getContentPane().add(button3);
				button3.setBounds(230, 10, 100, 30);
				button3.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						sortpanel.setSort(new QuickSort(sortData.clone()));
						sortpanel.startSort();
					}
					} );
				
				JButton button4 = new JButton("MergeSort");
				frame.getContentPane().add(button4);
				button4.setBounds(340, 10, 100, 30);
				button4.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						sortpanel.setSort(new MergeSort(sortData.clone()));
						sortpanel.startSort();
					}
					} );
				
				
				
				//frame.pack();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

	public static int[] gererateSortData(int num) {
		Random rand = new Random();
		int[] data = new int[num];
		int i=0;
		while(i<num){
			int rn = rand.nextInt(num)+1;
			if(isNotIn(rn, data)){
				data[i++] = rn;
			}
		}
		return data;
	}

	private static boolean isNotIn(int rn, int[] data) {
		for(int d : data){
			if(d==rn)
				return false;
		}
		return true;
	}

}