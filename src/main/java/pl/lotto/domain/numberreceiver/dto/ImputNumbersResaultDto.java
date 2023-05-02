package pl.lotto.domain.numberreceiver.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Set;

@Builder
public record ImputNumbersResaultDto(String message, LocalDateTime drowDate, String ticketId, Set<Integer> numbersFromUser) {
}
