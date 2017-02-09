# food menu application

This is the api component for our food menu app.

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.
You will need PostgreSQL installed.

[leiningen]: https://github.com/technomancy/leiningen

## Init the Dev environment

To bootstrap the dev environment, run:

    init

To preload the dev database, run:

    gen-menu


## Running

To start a web server for the application, run:

    lein ring server


And connect to `http://localhost:3000`

## License

Copyright © 2017
