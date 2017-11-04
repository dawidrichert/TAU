package pl.edu.pjatk.tau.models;

import pl.edu.pjatk.tau.exceptions.NieudanyPsikusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GotowyPsikus implements Psikus {

    private Random rand = new Random();

    @Override
    public Integer cyfrokrad(Integer liczba) {
        if (liczba != null && liczba > 9) {
            StringBuilder sb = new StringBuilder(liczba.toString());
            removeRandomCharacter(sb);

            return Integer.parseInt(sb.toString());
        }
        return null;
    }

    @Override
    public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
        if (liczba != null && liczba > 9) {
            StringBuilder sb = new StringBuilder(liczba.toString());

            char firstNumber = returnAndRemoveRandomCharacter(sb);
            char secondNumber = returnAndRemoveRandomCharacter(sb);

            insertCharacterToRandomPlace(firstNumber, sb);
            insertCharacterToRandomPlace(secondNumber, sb);

            return Integer.parseInt(sb.toString());
        }
        throw new NieudanyPsikusException();
    }

    @Override
    public Integer nieksztaltek(Integer liczba) {
        List<String> list = new ArrayList<>();
        String text = liczba.toString();

        if (text.contains("3")) {
            list.add(text.replaceAll("3", "8"));
        }
        if (text.contains("7")) {
            list.add(text.replaceAll("7", "1"));
        }
        if (text.contains("6")) {
            list.add(text.replaceAll("6", "9"));
        }

        if (list.size() != 0) {
            int randomIndex = rand.nextInt(list.size());
            text = list.get(randomIndex);
            return Integer.parseInt(text);
        }

        return liczba;
    }

    private int getRandomIndex(StringBuilder sb) {
        return rand.nextInt(sb.length());
    }

    private void insertCharacterToRandomPlace(char character, StringBuilder sb) {
        int randomIndex = 0;
        if (sb.length() > 0) {
            randomIndex = getRandomIndex(sb);
        }

        sb.insert(randomIndex, character);
    }

    private char returnAndRemoveRandomCharacter(StringBuilder sb) {
        int randomIndex = getRandomIndex(sb);
        char character = sb.charAt(randomIndex);
        sb.deleteCharAt(randomIndex);
        return character;
    }

    private void removeRandomCharacter(StringBuilder sb) {
        int randomIndex = getRandomIndex(sb);
        sb.deleteCharAt(randomIndex);
    }
}
