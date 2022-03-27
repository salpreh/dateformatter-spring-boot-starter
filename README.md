# dateformatter-spring-boot-starter
Toy project to test how spring-boot starters work.

## Structure
This project is a maven multi-module project. Modules that compose it are:

- `dateformatter`: Simple date formatter library.
- `dateformatter-spring-boot-autoconfigure`: Spring auto configurations for `dateformatter` lib.
- `dateformatter-spring-boot-starter`: A module with just a pom, wiring previous two libs to create the starter.