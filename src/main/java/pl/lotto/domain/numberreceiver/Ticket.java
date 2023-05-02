package pl.lotto.domain.numberreceiver;

 record Ticket(String ticketId, java.time.LocalDateTime drowData, java.util.Set<Integer> numbersfromUser) {
}
