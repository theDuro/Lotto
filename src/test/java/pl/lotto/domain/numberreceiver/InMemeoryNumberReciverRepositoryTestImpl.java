package pl.lotto.domain.numberreceiver;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemeoryNumberReciverRepositoryTestImpl implements NumberReciverRepository{
    Map<String,Ticket> inMemeoryDatabase = new ConcurrentHashMap<>();


    @Override
    public Ticket save(Ticket ticket) {
        inMemeoryDatabase.put(ticket.ticketId(),ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findAllByDrowDate(LocalDateTime date) {
        return inMemeoryDatabase.values()
                .stream()
                .filter(ticket-> ticket.drowData().equals(date))
                .toList();
    }
}
