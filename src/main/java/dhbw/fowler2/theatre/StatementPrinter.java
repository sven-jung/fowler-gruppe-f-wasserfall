package dhbw.fowler2.theatre;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class StatementPrinter {

    public String print(Invoice invoice, Map<String, Play> plays) {

        return new TextStatement().value(invoice, plays);
    }

    public String printHTML(Invoice invoice, Map<String, Play> plays) {

        return new HtmlStatement().value(invoice, plays);
    }

    public int getTotalAmountFor(Invoice invoice, Map<String, Play> plays) {

        var totalAmount = 0;

        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID);

            // add amount
            totalAmount += perf.getCharge(play);
        }

        return totalAmount;

    }

    public int getTotalVolumeCreditsFor(Invoice invoice, Map<String, Play> plays) {

        var totalVolumeCredits = 0;

        for (var perf : invoice.performances) {
            var play = plays.get(perf.playID);

            // add amount
            totalVolumeCredits += perf.getVolumeCredits(play);
            ;
        }

        return totalVolumeCredits;

    }

    abstract class Statement {

        public String value(Invoice invoice, Map<String, Play> plays) {

            var result = headerString(invoice);

            for (var perf : invoice.performances) {
                var play = plays.get(perf.playID);

                // print line for this order
                result += eachPerformanceString(perf, play);

            }

            result += footerString(invoice, plays);

            return result;

        }

        abstract String headerString(Invoice invoice);

        abstract String eachPerformanceString(Performance perf, Play play);

        abstract String footerString(Invoice invoice, Map<String, Play> plays);

    }

    class TextStatement extends Statement {

        @Override
        String headerString(Invoice invoice) {
            return String.format("Statement for %s\n", invoice.customer);
        }

        @Override
        String eachPerformanceString(Performance perf, Play play) {
            NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
            return String.format("  %s: %s (%s seats)\n", play.name, frmt.format(perf.getCharge(play) / 100), perf.audience);
        }

        @Override
        String footerString(Invoice invoice, Map<String, Play> plays) {
            NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
            String result = String.format("Amount owed is %s\n", frmt.format(getTotalAmountFor(invoice, plays) / 100));
            result += String.format("You earned %s credits\n", getTotalVolumeCreditsFor(invoice, plays));
            return result;
        }
    }

    class HtmlStatement extends Statement {

        @Override
        String headerString(Invoice invoice) {
            return String.format("<H1>Statement for <EM>%s</EM></H1><P>\n", invoice.customer);
        }

        @Override
        String eachPerformanceString(Performance perf, Play play) {
            NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
            return String.format("  %s: %s (%s seats)<BR>\n", play.name, frmt.format(perf.getCharge(play) / 100), perf.audience);
        }

        @Override
        String footerString(Invoice invoice, Map<String, Play> plays) {
            NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
            String result = String.format("<P>Amount owed is <EM>%s</EM><P>\n", frmt.format(getTotalAmountFor(invoice, plays) / 100));
            result += String.format("You earned <EM>%s</EM> credits<P>\n", getTotalVolumeCreditsFor(invoice, plays));
            return result;
        }
    }

}
