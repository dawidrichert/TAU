package pl.edu.pjatk.tau.models;

import pl.edu.pjatk.tau.exceptions.NieudanyPsikusException;

interface Psikus {

    Integer cyfrokrad(Integer liczba);

    Integer hultajchochla(Integer liczba) throws NieudanyPsikusException;

    Integer nieksztaltek(Integer liczba);
}
