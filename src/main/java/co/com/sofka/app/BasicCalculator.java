package co.com.sofka.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator {

    private static final Logger logger = LoggerFactory.getLogger(BasicCalculator.class);

    public Long sum(Long number1, Long number2) {
        logger.info( "Summing {} + {}", number1, number2 );
        return number1 + number2;
    }

    public Long substract(Long number1, Long number2) {
        logger.info( "Resting {} - {}", number1, number2 );
        return number1 - number2;
    }
    public Long multiply(Long number1, Long number2) {
        logger.info( "Summing {} x {}", number1, number2 );
        return number1 * number2;
    }
    public double div(Long number1, Long number2) {
            if(number2 != 0){
                logger.info( "Summing {} / {}", number1, number2 );
                return (double) number1 / number2;
            }
            throw new IllegalArgumentException("Ningun numero puede ser dividido entre 0");
    }
}
