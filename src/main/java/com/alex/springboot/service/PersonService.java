package com.alex.springboot.service;



import com.alex.springboot.dao.PersonDAO;
import com.alex.springboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDAO personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDAO personDao) {

        this.personDao = personDao;
    }

    public int addPerson(Person person){

        return personDao.insertPerson(person);
    }
    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }
    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }
    public int updatePerson(UUID id, Person person){
        return personDao.updatePersonById(id,person);
    }

}
