package guest.data;

import org.springframework.data.jpa.repository.JpaRepository;

import person.data.PersonDto;

public interface GuestRepository extends JpaRepository<GuestDto, Integer>{

}
