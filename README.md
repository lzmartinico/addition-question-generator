# Addition question generation #
Service to generate an integer addition question within a certain range and provide four answers, three incorrect.
Requests should be made to [http://localhost:8080/question](/question) with URL parameters min and max being integers between 0 and 1,000,000 ([http://localhost:8080/question?min=4&max=20](example)). A request will return a JSON object with schema:

```json
{
    addends: [integer, integer],
    sol: integer,
    wrong: [integer, integer, integer]
}
```

## Build & Run ##

```sh
$ cd Addition_question_generation
$ ./sbt
> jetty:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.
