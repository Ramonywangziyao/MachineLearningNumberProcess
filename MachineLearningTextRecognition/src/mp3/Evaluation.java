package mp3;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JComponent;

import mp3.MoverImage;

public class Evaluation extends JComponent implements ActionListener{
	LabelClass[] drawCounts;
	int imgNumber = 0;
	static GraphicImage zeroMax,zeroMin,oneMax,oneMin,twoMax,twoMin,threeMax,threeMin,fourMax,fourMin,fiveMax,fiveMin,sixMax,sixMin,sevenMax,sevenMin,eightMax,eightMin,nineMax,nineMin;

	public Evaluation(Queue<GraphicImage> imageList,LabelClass[] labelCounts) throws NumberFormatException, IOException
	{
		drawCounts = labelCounts;
		String labelFile = "src/testlabels.txt";
		String labelline;
		double [] totalSepLabel = new double [10];
		double [] correctSepLabel = new double [10];
		double correctTotal = 0.0000;
		int[][] wrongRightMatrix = new int[10][10];
		Queue<Integer> labelLists = new LinkedList<Integer>();
		Queue<GraphicImage> correctList = new LinkedList<GraphicImage>();
		FileReader labelReader = new FileReader(labelFile);
		BufferedReader labelBuffer = new BufferedReader(labelReader);
		DecimalFormat df2 = new DecimalFormat("00.00");
		while((labelline = labelBuffer.readLine())!=null)
		{
			int label = Integer.parseInt(labelline);
			totalSepLabel[label]+=1.0;
			GraphicImage tImg = imageList.poll();
			int tempLabel = tImg.getLabel();
			//System.out.println(tempLabel+"   "+label);
			if(tempLabel==label)
			{
				correctTotal+=1;
				correctSepLabel[tempLabel]+=1.0;
				correctList.add(tImg);
				
			}
			else
			{
				wrongRightMatrix[tempLabel][label]+=1;
			}
			labelLists.add(label);
		}
		double correctRate = correctTotal/(double)labelLists.size();
		System.out.println("The correct rate is:    "+correctRate*100+"%");
		for(int i = 0;i<10;i++)
		{
			System.out.println("The accuracy for label "+i+" is:    "+df2.format(((double)correctSepLabel[i]/(double)totalSepLabel[i])*100)+"%");
		}
		for(int i = 0;i<10;i++)
		{
			if(i==0)
			{
				for(int k = 0;k<10;k++)
				{
					if(k==0)
					{System.out.print("test/labl"+k);}
					else
					{
						System.out.print("             "+k);
					}
					
				}
				System.out.println();
			}
			System.out.print(i+"        ");
			for(int j = 0;j<10;j++)
			{
				
				if(i==j)
				{
					System.out.print((df2.format(((double)correctSepLabel[i]/(double)totalSepLabel[i])*100))+"%"+"        ");
				}else
				{
					System.out.print((df2.format(((double)wrongRightMatrix[i][j]/(double)totalSepLabel[i])*100))+"%"+"        ");
				}
			}
			System.out.println();
		}
		//display
		System.out.println();
		System.out.println("Now showing the highest/lowest for each label:   ");
		GraphicImage tempImg;
		for(int i = 0;i<correctList.size();i++)
		{
			 tempImg = correctList.poll();
		if(tempImg.getLabel() == 0)
		{
			if(zeroMax == null && zeroMin == null)
			{
			zeroMax = tempImg;
			zeroMin = tempImg;

			}
			else
			{
				if(tempImg.Probability[tempImg.Probability.length-1].pro>zeroMax.Probability[tempImg.Probability.length-1].pro)
				{
					zeroMax = tempImg;
		
				}
				else if(tempImg.Probability[tempImg.Probability.length-1].pro<zeroMin.Probability[tempImg.Probability.length-1].pro)
				{
					zeroMin = tempImg;
				}
				
			}
		}
		if(tempImg.getLabel() == 1)
		{
			if(oneMax == null && oneMin == null)
			{
			oneMax = tempImg;
			oneMin = tempImg;
		
			}
			else
			{
				if(tempImg.Probability[tempImg.Probability.length-1].pro>oneMax.Probability[tempImg.Probability.length-1].pro)
				{
					oneMax = tempImg;

				}
				else if(tempImg.Probability[tempImg.Probability.length-1].pro<oneMin.Probability[tempImg.Probability.length-1].pro)
				{
					oneMin = tempImg;
				}
				
			}
		}
		if(tempImg.getLabel() == 2)
		{
			if(twoMax == null && twoMin == null)
			{
			twoMax = tempImg;
			twoMin = tempImg;
		
			}
			else
			{
				if(tempImg.Probability[tempImg.Probability.length-1].pro>twoMax.Probability[tempImg.Probability.length-1].pro)
				{
					twoMax = tempImg;
				
				}
				else if(tempImg.Probability[tempImg.Probability.length-1].pro<twoMin.Probability[tempImg.Probability.length-1].pro)
				{
					twoMin = tempImg;
				}
				
			}
		}
		if(tempImg.getLabel() == 3)
		{
			if(threeMax == null && threeMin == null)
			{
			threeMax = tempImg;
			threeMin = tempImg;

			}
			else
			{
				if(tempImg.Probability[tempImg.Probability.length-1].pro>threeMax.Probability[tempImg.Probability.length-1].pro)
				{
					threeMax = tempImg;
			
				}
				else if(tempImg.Probability[tempImg.Probability.length-1].pro<threeMin.Probability[tempImg.Probability.length-1].pro)
				{
					threeMin = tempImg;
				}
				
			}
		}
		if(tempImg.getLabel() == 5)
		{
			if(fiveMax == null && fiveMin == null)
			{
			fiveMax = tempImg;
			fiveMin = tempImg;

			}
			else
			{
				if(tempImg.Probability[tempImg.Probability.length-1].pro>fiveMax.Probability[tempImg.Probability.length-1].pro)
				{
					fiveMax = tempImg;

				}
				else if(tempImg.Probability[tempImg.Probability.length-1].pro<fiveMin.Probability[tempImg.Probability.length-1].pro)
				{
					fiveMin = tempImg;
				}
				
			}
		}
		if(tempImg.getLabel() == 4)
		{
			if(fourMax == null && fourMin == null)
			{
			fourMax = tempImg;
			fourMin = tempImg;
			
			}
			else
			{
				if(tempImg.Probability[tempImg.Probability.length-1].pro>fourMax.Probability[tempImg.Probability.length-1].pro)
				{
					fourMax = tempImg;
				
				}
				else if(tempImg.Probability[tempImg.Probability.length-1].pro<fourMin.Probability[tempImg.Probability.length-1].pro)
				{
					fourMin = tempImg;
				}
				
			}
		}
		if(tempImg.getLabel() == 6)
		{
			if(sixMax == null && sixMin == null)
			{
			sixMax = tempImg;
			sixMin = tempImg;
		
			}
			else
			{
				if(tempImg.Probability[tempImg.Probability.length-1].pro>sixMax.Probability[tempImg.Probability.length-1].pro)
				{
					sixMax = tempImg;
			
				}
				else if(tempImg.Probability[tempImg.Probability.length-1].pro<sixMin.Probability[tempImg.Probability.length-1].pro)
				{
					sixMin = tempImg;
				}
				
			}
		}
		if(tempImg.getLabel() == 7)
		{
			if(sevenMax == null && sevenMin == null)
			{
			sevenMax = tempImg;
			sevenMin = tempImg;

			}
			else
			{
				if(tempImg.Probability[tempImg.Probability.length-1].pro>sevenMax.Probability[tempImg.Probability.length-1].pro)
				{
					sevenMax = tempImg;

				}
				else if(tempImg.Probability[tempImg.Probability.length-1].pro<sevenMin.Probability[tempImg.Probability.length-1].pro)
				{
					sevenMin = tempImg;
				}
				
			}
		}
		if(tempImg.getLabel() == 8)
		{
			if(eightMax == null && eightMin == null)
			{
			eightMax = tempImg;
			eightMin = tempImg;
		
			}
			else
			{
				if(tempImg.Probability[tempImg.Probability.length-1].pro>eightMax.Probability[tempImg.Probability.length-1].pro)
				{
					eightMax = tempImg;
		
				}
				else if(tempImg.Probability[tempImg.Probability.length-1].pro<eightMin.Probability[tempImg.Probability.length-1].pro)
				{
					eightMin = tempImg;
				}
				
			}
		}
		if(tempImg.getLabel() == 9)
		{
			if(nineMax == null && nineMin == null)
			{
			nineMax = tempImg;
			nineMin = tempImg;
	
			}
			else
			{
				if(tempImg.Probability[tempImg.Probability.length-1].pro>nineMax.Probability[tempImg.Probability.length-1].pro)
				{
					nineMax = tempImg;
		
				}
				else if(tempImg.Probability[tempImg.Probability.length-1].pro<nineMin.Probability[tempImg.Probability.length-1].pro)
				{
					nineMin = tempImg;
				}
				
			}
		}
		}
		
		Queue<GraphicImage> tempQ = new LinkedList<GraphicImage>();
	
		tempQ.add(zeroMax);
		tempQ.add(zeroMin);

		
		tempQ.add(oneMax);
		tempQ.add(oneMin);
	
		
		tempQ.add(twoMax);
		tempQ.add(twoMin);
		
	
		tempQ.add(threeMax);
		tempQ.add(threeMin);

		
		tempQ.add(fourMax);
		tempQ.add(fourMin);

		
		tempQ.add(fiveMax);
		tempQ.add(fiveMin);
	
	
		tempQ.add(sixMax);
		tempQ.add(sixMin);
	
	
		tempQ.add(sevenMax);
		tempQ.add(sevenMin);

		
		tempQ.add(eightMax);
		tempQ.add(eightMin);


		tempQ.add(nineMax);
		tempQ.add(nineMin);

		
		for(int n = 0;n < 20;n++)
		{
			GraphicImage t = tempQ.poll();
			
			System.out.println("Posterior:    "+t.Probability[t.Probability.length-1].pro);
			for(int i = 0;i<28;i++)
			{
				for(int j = 0;j<28;j++)
				{
					System.out.print(t.pixelImage[i][j].getFeature());
				}
				System.out.println();
			}
			System.out.println();
			System.out.println();
		}
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.repaint();
	}


	
	public void paintComponent(Graphics g)
	{
		int[][] rgb = {
				{0,0,149},
				{0,0,177},
				{0,0,195},
				{0,0,227},
				{0, 0, 250},
				{0, 44, 255},
				{0, 67, 255},
				{0, 88, 255},
				{0, 113, 255},
				{0, 156, 255},
				{0, 189, 255},
				{0, 210, 255},
				{0, 233, 255},
				{0, 255, 255},
				{0, 255, 222},
				{0, 255, 205},
				{103, 255, 138},
				{126, 255, 114},
				{204, 255, 0}, 
				{222, 255, 0}, 
				{231, 255, 0}, 
				{244, 255, 0},
				{255, 255, 0}, 
				{255, 235, 0},
				{255, 224, 0},
				{255, 201 ,0},
				{255, 174, 0}, 
				{255, 128, 0},
				{255, 98, 0},
				{255, 78, 0},
				{255, 40, 0},
				{255, 0, 0},
				{234, 0, 0},
				{198, 0, 0},
				{177, 0, 0},
				{147, 0, 0},
				{135, 0, 0}
    
	          };
		for(int i =0;i<28;i++)
		{
			for(int j = 0;j<28;j++)
			{
				double temp = Math.round((drawCounts[MoverImage.imgNumber].probability[i][j].in)*100.0)/100.0;		
				double odd = Math.round((drawCounts[1].probability[i][j].in/drawCounts[8].probability[i][j].in)*100.0)/100.0;
				
				//System.out.println(odd);
				int newValue = (int)Math.round(temp*MoverImage.mul);
				//int newValue = (int)Math.round(odd*26);
				if(newValue>=37)
				{	newValue = 36;}

				
				
		
				
				Color newC = new Color(rgb[newValue][0],rgb[newValue][1],rgb[newValue][2]);
				g.setColor(newC);
				g.fillRect(j*5, i*5, 5, 5);
//				g.setColor(Color.white);	
//				g.drawString(""+MoverImage.mul, 5,130);
				repaint();
			
			}
		}
	
	}
}
