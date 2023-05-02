package pl.lotto.domain.numberreceiver;

import lombok.AllArgsConstructor;

import java.util.Set;
@AllArgsConstructor
class NumberValidator {
    public static final int CORECT_NUMBERS_FROM_USER =6;
    public static final int MINIMAl_NUMBER_FROM_USER =1;
    public static final int  MAXIMAL_NUMBERS_FROM_USER =99;
    boolean areAllNumrsInRande(Set<Integer> numbersfromUser){
        return   numbersfromUser.stream()
                .filter(i -> i >= MINIMAl_NUMBER_FROM_USER)
                .filter(i -> i <= MAXIMAL_NUMBERS_FROM_USER)
                .count() == CORECT_NUMBERS_FROM_USER;
    }

}
