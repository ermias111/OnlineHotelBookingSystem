import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class TestFactory {

    static public Hotel createHotel(String name){
        Hotel hotel=new Hotel();
        hotel.setReservations(new ArrayList<>());
        hotel.setEmployees(new ArrayList<>());
        hotel.setName(name);
        return hotel;
    }
    static public Person createPassenger(String first,String last){
        Person person=new Person();
        person.setRoles(new ArrayList<>());
        Passenger passenger=new Passenger();
        passenger.setPerson(person);
        person.getRoles().add(passenger);
        passenger.setReservations(new ArrayList<>());
        person.setFirstName(first);
        person.setLastName(last);
        return person;
    }
    static public Person createEmployee(String first,String last){
        Person person=new Person();
        person.setRoles(new ArrayList<>());
        Employee employee=new Employee();
        employee.setPerson(person);
        person.getRoles().add(employee);
        person.setFirstName(first);
        person.setLastName(last);
        return person;
    }

    static public Reservation createReservation(Long dayDiff,int year,Boolean isVip){
        Reservation reservation=new Reservation();
        reservation.setSuite(isVip);
        LocalDateTime basetime=LocalDateTime.now().withYear(year);
        reservation.setCheckIn(basetime);
        reservation.setCheckOut(basetime.plusDays(dayDiff));
        return reservation;
    }
    static public Reservation assignReservation(Person person,Hotel hotel,Reservation reservation){
        Passenger passenger=person.getRoles().stream().filter(r->r instanceof Passenger).map(r->(Passenger)r).findFirst().get();
        hotel.getReservations().add(reservation);
        passenger.getReservations().add(reservation);
        reservation.setPassenger(passenger);
        reservation.setHotel(hotel);

        return reservation;
    }


}
