import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ArtistRank {
	
	String user, artist,song;
	ArtistRank(String u, String a, String s)
	{
		user=u;
		artist=a;
		song = s;
		
	}
	
	class Songs{
		int frequency;
		String artist,song;
		Songs( String ar, String so, int fr){
			frequency=fr;
			artist=ar;
			song=so;
		}
		int getFreq(){
			return this.frequency;
		}
		void setFreq(int fr){
			this.frequency=fr;
		}
	}
	 

	private static HashMap<String, HashMap<String, Integer>> getFrequency(ArrayList<ArtistRank> artist2) {
		// TODO Auto-generated method stub
		HashMap<String, HashMap<String,Integer>> h = new HashMap<String, HashMap<String,Integer>>();
		HashMap<String,Integer> h1 = new HashMap<String,Integer>();
		for(ArtistRank ar : artist2){
			if(h.containsKey(ar.artist)){
				h1 = h.get(ar.artist);
				if(h1.containsKey(ar.song)){
					h1.put(ar.song, h1.get(ar.song)+1);
				}
				else
					h1.put(ar.song, 1);
			}
			else{
				h1=new HashMap<String,Integer>();
				h1.put(ar.song, 1);
				h.put(ar.artist, h1);
			}	
		}
		return h;
	}
	 static Map<String, Integer> sortByComparator(HashMap<String, Integer> unsortMap, final boolean order)
    {

        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
	
	
	public static void main(String args[])
	{
		ArrayList<ArtistRank> artist = new ArrayList<ArtistRank>();
		HashMap<String, String> FinalPlaylist = new HashMap<String, String>();
		
		artist.add(new ArtistRank("Soumya","Coldplay","Hymn For the Weekend"));
		artist.add(new ArtistRank("Soumya"," Coldplay","Hymn For the Weekend"));
		artist.add(new ArtistRank("Soumya","Coldplay","Fix You"));
		artist.add(new ArtistRank("Soumya","Coldplay","Strawberry Swing"));
		artist.add(new ArtistRank("Soumya","Coldplay","Fix You"));
		artist.add(new ArtistRank("Soumya","Coldplay","The Scientist"));
		artist.add(new ArtistRank("Soumya","Rihana","Oned"));
		artist.add(new ArtistRank("Soumya","Rihana","Oned"));
		artist.add(new ArtistRank("Soumya","Rihana","Work"));
		artist.add(new ArtistRank("Soumya","Rihana","Work"));
		artist.add(new ArtistRank("Soumya","Rihana","Unfaithful"));
		artist.add(new ArtistRank("Soumya","Coldplay","Fix You"));
		artist.add(new ArtistRank("Soumya","Coldplay","Strawberry Swing"));
		artist.add(new ArtistRank("Soumya","Coldplay","Fix You"));
		artist.add(new ArtistRank("Soumya","Coldplay","The Scientist"));
		HashMap<String, HashMap<String, Integer>>  result = new HashMap<String, HashMap<String, Integer>> ();
		//System.out.println(artist.contains(new ArtistRank("Soumya","Coldplay","The Scientist")));
		
		result= getFrequency(artist);
		boolean DESC=false;
		for(String s : result.keySet()){
			
			HashMap<String, Integer> h1= result.get(s);
			System.out.println("Artist is "+s + " list");
			Map<String, Integer> sortedMapAsc = sortByComparator(h1, DESC);
	        printMap(sortedMapAsc);
			
		}

	}
	public static void printMap(Map<String, Integer> map)
    {
        for (Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + " Value : "+ entry.getValue());
        }
    }

}