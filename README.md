# Help
Help is a collection of utility methods with a fluent interface. 
#### Inspiration
I dislike having several utility classes with their own interface, style and approach. Therefore, I wanted to create a suite of utility
classes that were all accessible through one standard entry point. Second, I like the intuitive nature of fluent interfaces, [AssertJ](https://assertj.github.io/doc/) as an example,
and felt implementing a utility suite through a fluent interface was a great solution to my problem.  
#### Available Methods
See below for details on all available methods. 

| Id           | Method        | Parameter           | Return           | Comment  |
| :-------------: | :-------------: |  :-------------: |:-------------:| :-------------:|
| 1 | byCheckingNotExceedingBoundary| Integer | boolean | Confirm whether an Integer is within a specified boundary. |
| 2 | byRemovingDuplicates | List | List | Remove duplicate entries from a List. |
| 3 | byChangingToList | Set |List | Convert a Set into a List. |
| 4 | byRemovingWhitespace | String | String | Remove all whitespace from a String. |
| 5 | byConvertingToInteger | String | Optional | Convert a String into an Integer. |
| 6 | byReturning | String, String | String | Return a given value (excluding a default value) depending on the state of a Boolean value. |
| 7 | byReturning | String, String, String | String | Return a given value (including a default value) depending on the state of a Boolean value. |

For a more concrete example, to use the method with id 5 (`byConvertingToInteger`), you can do the following:

`final Optional<Integer> myInteger = HelpFactory.help("1").byConvertingToInteger();`
#### Installation
You can download the Jar from [the Packages page](https://github.com/tdotdm/help/packages) or, alternatively, if you are using Maven/Gradle,
you can add a new dependency. See below for an example.  

```
<dependency>
    <groupId>com.github.tdotdm</groupId> 
    <artifactId>help</artifactId>
    <version>2.0.1</version>
</dependency>
```

As Help is stored on GitHub Packages, you will need to update your `settings.xml` file with a new profile and server. See below for an example.

```
<profiles>
    <profile>
        <id>github</id>
        <repositories>
            <repository>
                <id>central</id>
                <url>https://repo1.maven.org/maven2</url>
                <releases>
                    <enabled>true</enabled>
                </releases>
                <snapshots>
                    <enabled>false</enabled>
                </snapshots>
            </repository>
            <repository>
                <id>github</id>
                <name>GitHub tdotdm Apache Maven Packages</name>
                <url>https://maven.pkg.github.com/tdotdm/help</url>
            </repository>
        </repositories>
    </profile>
</profiles>
<servers>
    <server>
        <id>github</id>
        <username>YOUR_USERNAME</username>
        <password>YOUR_GITHUB_TOKEN</password>
    </server>
</servers>
```

#### Extending the API
See below for an example of how a client may extend Help with custom behaviour. 
To extend Help with custom behaviour, simply extend 'HelpFactory' and supply overloaded 'help' methods.

```
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
```

#### Notes
* Read more about GitHub and GitHub Packages [here](https://help.github.com/en/packages/using-github-packages-with-your-projects-ecosystem/configuring-apache-maven-for-use-with-github-packages).


