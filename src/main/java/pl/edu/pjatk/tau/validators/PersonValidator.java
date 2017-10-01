package pl.edu.pjatk.tau.validators;

import pl.edu.pjatk.tau.models.Person;

public class PersonValidator implements Validator {

    private Person person;

    public PersonValidator(Person person) {
        this.person = person;
    }

    @Override
    public boolean isValid() {
        return new PeselValidator(person.getPesel()).isValid()
                && new EmailValidator(person.getEmail()).isValid()
                && new PasswordValidator(person.getPassword()).isValid();
    }
}
