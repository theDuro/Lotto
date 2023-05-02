package pl.lotto.domain.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;

public interface NumberReciverRepository {
    Ticket save(Ticket ticket);
    List<Ticket> findAllByDrowDate(LocalDateTime date);
}
