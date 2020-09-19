package cinemaapp.services.implementations;

import cinemaapp.models.Ticket;
import cinemaapp.repositories.ITicketRepository;
import cinemaapp.services.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private ITicketRepository ticketRepository;

    @Override
    public List<Ticket> getByShowing_Id(long id) {
        return ticketRepository.findByShowing_Id(id);
    }

    @Override
    public List<Ticket> getByReservation_IsPayed(boolean isPayed) {
        return ticketRepository.findByReservation_IsPayed(isPayed);
    }

    @Override
    public Ticket getById(long id) {
        return ticketRepository.findById(id).get();
    }

    @Override
    public Ticket save(Ticket ticket) {
        Ticket persistedTicket = ticketRepository.save(ticket);

        return persistedTicket;
    }

    @Override
    public void deleteById(long id) {
        this.ticketRepository.deleteById(id);
    }
}
