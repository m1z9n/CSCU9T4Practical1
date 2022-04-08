package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry{
private String tempo;
private String terrain;
	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String tempo, String terrain) {
		super(n, d, m, y, h, min, s, dist);
		this.tempo= tempo;
		this.terrain=terrain;
		// TODO Auto-generated constructor stub
	}
     public String getTempo() {
    	 return this.tempo;
     }
      public String getTerrain() {
    	 return this.terrain;
     }
     public String getEntry () {
    	   String result = getName()+" ran " + getDistance() + " km in "
    	             +getHour()+":"+getMin()+":"+ getSec() + " on "
    	             +getDay()+"/"+getMonth()+"/"+getYear()+"/"+getTempo()+"/"+getTerrain()+"\n";
    	   return result;
}
}
