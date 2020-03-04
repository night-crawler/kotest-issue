# kotest-issue


Steps to reproduce:

```bash
./gradlew test --info
```

It will fail:
```bash
org.example.SsnTest.invalid ssn FAILED
    Error: Timeout of 2000ms exceeded. For async tests and hooks, ensure "done()" is called; if returning a Promise, ensure it resolves.
```
