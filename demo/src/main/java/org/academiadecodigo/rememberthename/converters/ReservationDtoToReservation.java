package org.academiadecodigo.rememberthename.converters;

import org.academiadecodigo.rememberthename.command.ReservationDto;
import org.academiadecodigo.rememberthename.persistence.model.Reservation;
import org.academiadecodigo.rememberthename.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationDtoToReservation extends AbstractConverter<ReservationDto, Reservation>{

    private ReservationService reservationService;

    @Autowired
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @Override
    public Reservation convert(ReservationDto reservationDto) {

        Reservation reservation = (reservationDto.getId()) != null ? reservationService.get(reservationDto.getId()) : new Reservation();

        reservation.setId(reservationDto.getId());
        reservation.setName(reservationDto.getName());
        reservation.setNumberOfClients(reservationDto.getNumberOfClients());

        return reservation;

    }

}
