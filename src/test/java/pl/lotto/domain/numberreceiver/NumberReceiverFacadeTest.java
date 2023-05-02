package pl.lotto.domain.numberreceiver;

import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.Test;
import pl.lotto.domain.numberreceiver.dto.ImputNumbersResaultDto;

import java.awt.*;
import java.time.*;
import java.util.List;
import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberReceiverFacadeTest {
    NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacade(
            new NumberValidator(),
            new InMemeoryNumberReciverRepositoryTestImpl(),
            Clock.fixed(LocalDateTime.of(2022,12,12,11,0,0,0).toInstant(ZoneOffset.UTC),ZoneId.systemDefault())
    );
    @Test
    public void schoud_return_succes_when_user_gave_six_numbers(){
        //given
        Set<Integer> imputNumbers = Set.of(1,2,3,4,5,6);
        //when
        ImputNumbersResaultDto resault = numberReceiverFacade.imputNumbers(imputNumbers);
        //then
        assertThat(resault.message()).isEqualTo("succes");


    }
    @Test
    public void schoud_return_fail_when_user_gave_less_than_six_numbers(){
        //given

        //when
        ImputNumbersResaultDto resault = numberReceiverFacade.imputNumbers(Set.of(1,2,3,4,5));
        //then
        assertThat(resault.message()).isEqualTo("failed");

    }

    @Test
    public void schoud_return_fail_when_user_gave_more_than_six_numbers(){
        //given

        //when
        ImputNumbersResaultDto resault = numberReceiverFacade.imputNumbers(Set.of(1,2,3,4,5,6,7,8));
        //then
        assertThat(resault.message()).isEqualTo("failed");

    }
    @Test
    public void schoud_return_fail_when_user_gave_a_least_one_number_out_off_1_to_99(){
        //given

        //when
        ImputNumbersResaultDto resault = numberReceiverFacade.imputNumbers(Set.of(1,2000,3,4,5,6));
        //then
        assertThat(resault.message()).isEqualTo("failed");

    }
    @Test
    public void schoud_return_save_to_databasewhen_user_gave_six_numbers() {
        //given
        Set<Integer> imputNumbers = Set.of(1, 2, 3, 4, 5, 6);
        ImputNumbersResaultDto resault = numberReceiverFacade.imputNumbers(imputNumbers);
        LocalDateTime drowDate = LocalDateTime.of(2022,12,12,12,0,0,0);
        //when
        List<TicketDto> ticetsDto = numberReceiverFacade.userNumbers(drowDate);
        //then

        assertThat(ticetsDto).contains(
                TicketDto.builder()
                        .ticketId(resault.ticketId())
                        .drawDate(drowDate)
                        .numbersFromUser(resault.numbersFromUser())
                        .build()
        );


    }
    }
