# advent-of-code-24

Built using Spring Boot to solve the advent of code problems and expose the solutions through a web api interface.

https://adventofcode.com/2024/about

## Development

This project uses dev containers. To start development, open the project in a dev container. This should pull all images needed for development.

### Run in debug mode

`shift` + `cmd` + `d`

## Build

To build the application

```sh
docker build -f ./Dockerfile -t "theithorian/oac:0.0.1" .
```

## Run

To run the application

```sh
docker run -p 127.0.0.1:8080:8080  theithorian/oac:0.0.1
```
