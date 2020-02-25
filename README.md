# Help
Written in Java, Help is a collection of utility methods with a fluent interface. 
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

For a more concrete example, to use the method with id 5 (`byConvertingToInteger`), you can do the following:
`final Optional<Integer> myInteger = Help.help("1").byConvertingToInteger();`
#### Installation
You can download the Jar from [the Packages page](https://github.com/tdotdm/help/packages) or, alternatively, if you are using Maven/Gradle,
you can add a new dependency. See below for an example.  

```
<dependency>
    <groupId>com.github.tdotdm</groupId> 
    <artifactId>help</artifactId>
    <version>1.0.0</version>
</dependency>
```


