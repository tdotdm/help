package com.github.tdotdm;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/*
 * The following class details
 * examples of how a client may
 * extend 'HelpFactory' with
 * custom behaviour.
 *
 * To do this, create a class which
 * extends 'HelpFactory' and supply
 * overloaded 'help' methods.
 * */
public class ClientExample {
    @Test
    public void personExample() {
        //given
        final Person person = new Person("John", "Wick", "55");

        //when
        final String personGroupedName = ClientHelpFactory.help(person).byGroupingNames();
        final Optional<Integer> personAge = ClientHelpFactory.help(person.getAge()).byConvertingToInteger();

        //then
        assertEquals(personGroupedName, "John Wick");
        personAge.ifPresent(age -> {
            assertEquals(age, Integer.valueOf(55));
        });
    }

    @Test
    public void movieExample() {
        //given
        final Movie movie = new Movie("John Wick");

        //when
        final String movieSequelTitle = ClientHelpFactory.help(movie).byGettingTheNameOfTheSequel();
        final String movieNoWhitespaceTitle = ClientHelpFactory.help(movie.getTitle()).byRemovingWhitespace();

        //then
        assertEquals(movieSequelTitle, "John Wick 2");
        assertEquals(movieNoWhitespaceTitle, "JohnWick");
    }
}

final class ClientHelpFactory extends HelpFactory {
    public static PersonHelp help(final Person person) {
        return new PersonHelp(person);
    }

    public static MovieHelp help(final Movie movie) {
        return new MovieHelp(movie);
    }
}

final class Person {
    private final String givenName;
    private final String familyName;
    private final String age;

    public Person(final String givenName,
                  final String familyName,
                  final String age) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.age = age;
    }

    public final String getGivenName() {
        return this.givenName;
    }

    public final String getFamilyName() {
        return this.familyName;
    }

    public final String getAge() {
        return this.age;
    }
}

final class PersonHelp extends Help<Person> {
    public PersonHelp(final Person value) {
        super(value);
    }

    public String byGroupingNames() {
        final String givenName = this.value.getGivenName();
        final String familyName = this.value.getFamilyName();

        return givenName + " " + familyName;
    }
}

final class Movie {
    private final String title;

    public Movie(final String title) {
        this.title = title;
    }

    public final String getTitle() {
        return this.title;
    }
}

final class MovieHelp extends Help<Movie> {
    public MovieHelp(final Movie value) {
        super(value);
    }

    public String byGettingTheNameOfTheSequel() {
        return this.value.getTitle() + " 2";
    }
}



