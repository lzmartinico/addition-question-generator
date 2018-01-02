# Addition question generation #
Service to generate an integer addition question within a certain range and provide four answers, three incorrect.
Requests should be made to [http://localhost:8080/question](/question). Output will be in JSON format
## Build & Run ##

```sh
$ cd Addition_question_generation
$ ./sbt
> jetty:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.
