package person.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class PersonDao {
	private PersonRepository personRepository;
	
	// 추가
	public void insertPerson(PersonDto dto)
	{
		personRepository.save(dto);
	}
	
	// 전체 출력
	public List<PersonDto> getAllPersons()
	{
		return personRepository.findAll();
	}
	
	// 삭제
	public void deletePerson(int num) {
		personRepository.deleteById(num);
	}
	
	public PersonDto getSelectData(int pnum) {
		return personRepository.getReferenceById(pnum);
	}
	
	public void updatePerson(PersonDto dto) {
		// dto에 pnum이 포함되어 있어야 수정이 됨
		// 없을 경우 추가가됨
		personRepository.save(dto);
	}
} 