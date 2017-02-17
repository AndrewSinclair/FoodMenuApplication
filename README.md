# food menu application

This is the api component for our food menu app. The front end is [here](https://github.com/AndrewSinclair/food-menu-front)

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.
You will need PostgreSQL installed.

[leiningen]: https://github.com/technomancy/leiningen

## Init the Dev environment

To bootstrap the dev environment, run:

    init

To preload the dev database, run:

    gen-menus


## Running

To start a web server for the application, run:

    dev


And connect to `http://localhost:3000`

## Docker

If you have Docker installed and wish to use that to run the application, run:

    docker-compose build
    docker-compose up



## License

Copyright © 2017
