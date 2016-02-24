package mp3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
	

	
	public Queue<GraphicImage> testImages(LabelClass[] labelCounts) throws IOException, InterruptedException
	{
		System.out.println("Start testing");
		Thread.sleep(3000);
		String fileName = "src/testimages.txt";
		Queue<GraphicImage> imageList = new LinkedList<GraphicImage>();
		String line;
		int numCount = 28;
		int faceCount = 0;
		int numSize = 28;
		int faceSize = 0;
		GraphicImage newImage = new GraphicImage();
		FileReader fr = new FileReader(fileName);
		int x = 0;
		BufferedReader bufferNew = new BufferedReader(fr);
		while((line = bufferNew.readLine())!=null)
		{
			char [] vals = line.toCharArray();
	        if (newImage.pixelImage == null) 
	        {
	            newImage.setPixelImage(new Pixel[numCount][numSize]);
	        }
	        for (int col = 0; col < numSize; col++) {
	        	
	        	if(vals[col] == ' ')
	        	{
	        		newImage.pixelImage[x][col] = new Pixel();
	        		newImage.pixelImage[x][col].setFeature(0);
	        		newImage.pixelImage[x][col].setI(x);
	        		newImage.pixelImage[x][col].setJ(col);
	        	
	        	//	}
	        	}
	        	else
	            if(vals[col] == '+')
	           	{
	        		newImage.pixelImage[x][col] = new Pixel();
	        		newImage.pixelImage[x][col].setFeature(1);
	        		newImage.pixelImage[x][col].setI(x);
	        		newImage.pixelImage[x][col].setJ(col);
	        		
	           	}
	        	else
	            if(vals[col] == '#')
	            {
	        		newImage.pixelImage[x][col] = new Pixel();
	        		newImage.pixelImage[x][col].setFeature(2);
	        		newImage.pixelImage[x][col].setI(x);
	        		newImage.pixelImage[x][col].setJ(col);
	        	
	            }	
	            
	            System.out.print(newImage.pixelImage[x][col].getFeature());
	        }
	        x++;
	        if(x%28==0&&x!=0)
	        {
	        	     	
	        	imageList.add(newImage);
	        	newImage = new GraphicImage();
	        	newImage.setPixelImage(new Pixel[numCount][numSize]);
	        	x=0;
	        }
	        
	        System.out.println();			
		}
		ProbabilityCalculation calculator = new ProbabilityCalculation();
		GraphicImage temp;
		for(int i = 0;i<1000;i++)
		{
			 temp = imageList.poll();
			for(int j = 0;j<10;j++)
			{
				for(int l = 0;l<28;l++)
				{
					for(int n = 0;n<28;n++)
					{
						
			        	if(temp.pixelImage[l][n].getFeature() == 0)
			        	{
			        		temp.pixelImage[l][n].setProbability(labelCounts[j].probability[l][n].e);
			        	}
			        	else
			            if(temp.pixelImage[l][n].getFeature() == 1)
			           	{
			            	temp.pixelImage[l][n].setProbability(labelCounts[j].probability[l][n].b);	
			           	}
			        	else
			            if(temp.pixelImage[l][n].getFeature() == 2)
			            {
			            	temp.pixelImage[l][n].setProbability(labelCounts[j].probability[l][n].in);
			            }	
					}
				}
				temp.Probability[j] = new MapClass();
				temp.Probability[j].pro=calculator.testingProbability(temp,labelCounts[j].myPrior);
				temp.Probability[j].label = j;
				
				
				
			}
			Arrays.sort(temp.Probability);
			temp.setLabel(temp.Probability[temp.Probability.length-1].label);
			imageList.add(temp);
		}
		
		return imageList;
	}
	
}
