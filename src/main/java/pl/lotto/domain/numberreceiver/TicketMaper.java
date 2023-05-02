package pl.lotto.domain.numberreceiver;

public class TicketMaper {
    public static TicketDto mapFromTicket(Ticket ticket) {
        return TicketDto.builder()
                .ticketId(ticket.ticketId())
                .drawDate(ticket.drowData())
                .numbersFromUser(ticket.numbersfromUser())
                .build();
    }

}
