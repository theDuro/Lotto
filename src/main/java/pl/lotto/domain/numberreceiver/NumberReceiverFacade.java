package pl.lotto.domain.numberreceiver;


import lombok.AllArgsConstructor;
import pl.lotto.domain.numberreceiver.dto.ImputNumbersResaultDto;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@AllArgsConstructor
public class NumberReceiverFacade {
    private final NumberValidator numberValidator;
    private final NumberReciverRepository repository;
    private final Clock clock;
    public ImputNumbersResaultDto imputNumbers(Set<Integer> numbersfromUser) {
        if (numberValidator.areAllNumrsInRande(numbersfromUser)) {
            String ticketId = UUID.randomUUID().toString();
            LocalDateTime drowData = LocalDateTime.now(clock);
            Ticket savedTicket = repository.save( new Ticket(ticketId,drowData,numbersfromUser));
            return ImputNumbersResaultDto.builder()
                    .message("succes")
                    .ticketId(savedTicket.ticketId())
                    .drowDate(savedTicket.drowData())
                    .numbersFromUser(numbersfromUser)
                    .build();

        } else {
            return  ImputNumbersResaultDto.builder()
                    .message("failed")
                    .build();
        }
    }

    public List<TicketDto> userNumbers(LocalDateTime date){
       List<Ticket> allTicketByDrowDate= repository.findAllByDrowDate(date);
        return allTicketByDrowDate.stream()
               .map(TicketMaper::mapFromTicket)
               .toList();


    }


}
