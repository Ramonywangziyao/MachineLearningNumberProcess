package mp3;

public class LabelClass {
	public LabelClass(int label)
	{
		this.lable = label;
	}
	public double [][] pixelEmptyTotal = new double[28][28];//for training
	public double [][] pixelBoundTotal = new double[28][28];//for training
	public double [][] pixelPoundTotal = new double[28][28];//for training
	public int lable;
	public double totalInSample;
	public double myPrior;
	public Feature [][] probability = new Feature[28][28];
}
