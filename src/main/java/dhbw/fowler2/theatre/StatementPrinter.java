package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays) {
               
        var result = String.format("Statement for %s\n", invoice.customer);

        NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID);
            
            // print line for this order
            result += String.format("  %s: %s (%s seats)\n", play.name, frmt.format(perf.getCharge(play) / 100), perf.audience);
            
        }
        
        result += String.format("Amount owed is %s\n", frmt.format(getTotalAmountFor(invoice, plays) / 100));
        result += String.format("You earned %s credits\n", getTotalVolumeCreditsFor(invoice, plays));
        
        return result;
    }

    public int getTotalAmountFor(Invoice invoice, Map<String, Play> plays) {
        
        var totalAmount = 0;
        
        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID);
            
            // add amount
            totalAmount += perf.getCharge(play)
;        }
        
        return totalAmount;
        
    }
    
    public int getTotalVolumeCreditsFor(Invoice invoice, Map<String, Play> plays) {
        
        var totalVolumeCredits = 0;
        
        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID);
            
            // add amount
            totalVolumeCredits += perf.getVolumeCredits(play);
            
;        }
        
        return totalVolumeCredits;
        
    }
    
    
    

}
