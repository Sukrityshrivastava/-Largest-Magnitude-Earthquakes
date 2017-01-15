
/**
 * Write a description of LargestMagnitudeQuake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class LargestMagnitudeQuake {
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("Quakes read :"+list.size());
        /*for(QuakeEntry qe:list){
            System.out.println(qe);
        }*/
        System.out.println("Quakes read :"+list.size());        
        ArrayList<QuakeEntry> large=getLargest(list,20);
        for(QuakeEntry qe:large){
             System.out.println(qe);
        }
        System.out.println("Quakes found :"+large.size());
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> quakeData){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>(quakeData);
        int largeIndex=0;
        double maxMagnitude=0.0;
        for(int k=1;k<answer.size();k++){
            QuakeEntry quake=answer.get(k);
            double mag=quake.getMagnitude();
            if(mag>maxMagnitude){
                largeIndex=k;
                maxMagnitude=mag;
            }
        }
        return largeIndex;   
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData,int howMany){
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
		ArrayList<QuakeEntry> result = new ArrayList<QuakeEntry>();
		if(howMany > copy.size()) {
			howMany = copy.size();
        }
		int largeIndex = 0;
		for(int j=0; j<howMany; j++){
			largeIndex = indexOfLargest(copy);
			result.add(copy.get(largeIndex));
			copy.remove(largeIndex);
		}
        return result;
    }
}
