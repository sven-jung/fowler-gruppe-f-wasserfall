package dhbw.fowler2.theatre;

public class Performance {

    public String playID;
    public int audience;

    public Performance(String playID, int audience) {
        this.playID = playID;
        this.audience = audience;
    }
    
    public int getCharge(Play play) {

        return play.getCharge(audience);

    }
    
    public int getVolumeCredits(Play play) {

        return play.getVolumeCredits(audience);
        
    }
    
}
