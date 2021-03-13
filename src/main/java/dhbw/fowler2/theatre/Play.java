package dhbw.fowler2.theatre;

public class Play {

    public String name;
    public String type;
    private Price price;

    public Play(String name, String type) {
        this.name = name;
        this.type = type;
        setPrice(type);
    }
    
    private void setPrice(String type) {
        
        switch (type) {
            case "tragedy":
                price = new TragedyPrice();
                break;
            case "comedy":
                price = new ComedyPrice();
                break;
            default:
                throw new Error("unknown type: ${play.type}");
        }
        
    }
        
    public int getCharge(int audience) {

        return price.getCharge(audience);

    }
    
    public int getVolumeCredits(int audience) {

        var volumeCredits = 0;
        // add volume credits
        volumeCredits += Math.max(audience - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy" == type) {
            volumeCredits += Math.floor(audience / 5);
        }

        return volumeCredits;
    }
    
}
