package dhbw.fowler2.theatre;

/**
 *
 * @author Team F
 */
abstract class Price {

    abstract int getCharge(int audience);

}

class TragedyPrice extends Price {

    @Override
    int getCharge(int audience) {

        var total = 40000;
        if (audience > 30) {
            total += 1000 * (audience - 30);
        }

        return total;

    }

}

class ComedyPrice extends Price {

    @Override
    int getCharge(int audience) {
        var total = 30000;
        if (audience > 20) {
            total += 10000 + 500 * (audience - 20);
        }
        
        return total + 300 * audience;
    }

}

class HistoryPrice extends Price {

    @Override
    int getCharge(int audience) {
        var total = 30000;
        if (audience > 20) {
            total += 10000 + 500 * (audience - 20);
        }
        
        return total + 300 * audience;
    }

}

class PastoralPrice extends Price {

    @Override
    int getCharge(int audience) {
        var total = 30000;
        if (audience > 20) {
            total += 10000 + 500 * (audience - 20);
        }
        
        return total + 300 * audience;
    }

}

class PastoralComicalPrice extends Price {

    @Override
    int getCharge(int audience) {
        var total = 30000;
        if (audience > 20) {
            total += 10000 + 500 * (audience - 20);
        }
        
        return total + 300 * audience;
    }

}

class HistoricalPastoralPrice extends Price {

    @Override
    int getCharge(int audience) {
        var total = 30000;
        if (audience > 20) {
            total += 10000 + 500 * (audience - 20);
        }
        
        return total + 300 * audience;
    }

}

class TragicalHistoricalPrice extends Price {

    @Override
    int getCharge(int audience) {
        var total = 30000;
        if (audience > 20) {
            total += 10000 + 500 * (audience - 20);
        }
        
        return total + 300 * audience;
    }

}

class TragicalcomicalhistoricalpastoralPrice extends Price {

    @Override
    int getCharge(int audience) {
        var total = 30000;
        if (audience > 20) {
            total += 10000 + 500 * (audience - 20);
        }
        
        return total + 300 * audience;
    }

}

class SceneIndividablePrice extends Price {

    @Override
    int getCharge(int audience) {
        var total = 30000;
        if (audience > 20) {
            total += 10000 + 500 * (audience - 20);
        }
        
        return total + 300 * audience;
    }

}

class PoemUnlimitedPrice extends Price {

    @Override
    int getCharge(int audience) {
        var total = 30000;
        if (audience > 20) {
            total += 10000 + 500 * (audience - 20);
        }
        
        return total + 300 * audience;
    }

}
