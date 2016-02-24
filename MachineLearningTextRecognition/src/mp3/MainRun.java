package mp3;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainRun{
	Queue<GraphicImage> tested;
	LabelClass zero = new LabelClass(0);
	LabelClass one = new LabelClass(1);
	LabelClass two = new LabelClass(2);
	LabelClass three = new LabelClass(3);
	LabelClass four = new LabelClass(4);
	LabelClass five = new LabelClass(5);
	LabelClass six = new LabelClass(6);
	LabelClass seven = new LabelClass(7);
	LabelClass eight = new LabelClass(8);
	LabelClass nine = new LabelClass(9);
	LabelClass [] labelCounts = {zero,one,two,three,four,five,six,seven,eight,nine};
	Evaluation ev;
	public MainRun() throws IOException, InterruptedException
	{
	
	

	//read Labels	

	String labelFile = "src/traininglabels.txt";
	String labelline;
	Queue<Integer> labelLists = new LinkedList<Integer>();
	FileReader labelReader = new FileReader(labelFile);
	BufferedReader labelBuffer = new BufferedReader(labelReader);
	while((labelline = labelBuffer.readLine())!=null)
	{
		int label = Integer.parseInt(labelline);
		labelLists.add(label);
	}
		
		
	//read Images	
	String fileName = "src/trainingimages.txt";
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
        		labelCounts[labelLists.peek()].pixelEmptyTotal[x][col] += 1;
        	
        	//	}
        	}
        	else
            if(vals[col] == '+')
           	{
        		newImage.pixelImage[x][col] = new Pixel();
        		newImage.pixelImage[x][col].setFeature(1);
        		newImage.pixelImage[x][col].setI(x);
        		newImage.pixelImage[x][col].setJ(col);
        		labelCounts[labelLists.peek()].pixelBoundTotal[x][col] += 1;
           	}
        	else
            if(vals[col] == '#')
            {
        		newImage.pixelImage[x][col] = new Pixel();
        		newImage.pixelImage[x][col].setFeature(2);
        		newImage.pixelImage[x][col].setI(x);
        		newImage.pixelImage[x][col].setJ(col);
        		labelCounts[labelLists.peek()].pixelPoundTotal[x][col] += 1;
            }	
            
            System.out.print(newImage.pixelImage[x][col].getFeature());
        }
        x++;
        if(x%28==0&&x!=0)
        {
        	labelCounts[labelLists.peek()].totalInSample+=1;
        	newImage.setLabel(labelLists.poll());
        	
        	imageList.add(newImage);
        	newImage = new GraphicImage();
        	newImage.setPixelImage(new Pixel[numCount][numSize]);
        	x=0;
        }
        
        System.out.println();			
	}
	Train newTrain = new Train();
	newTrain.trainData(labelCounts);
	System.out.println("Training complete!  Ready to take the test!");
	
	Test newTest = new Test();
	tested = newTest.testImages(labelCounts);
	
	ev = new Evaluation(tested,labelCounts);
	
	
	}
}