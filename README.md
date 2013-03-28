# gaem-templage

A Leiningen template for gaem-plugin-managed appengine-magic applications.

** WARNING ** Alpha software.  Works for me (Mac only) but hasn't been
   tested really thoroughly.

## Installation

Download from https://github.com/greynolds/gaem-template, cd to the dir and run "lein install".

## Usage

    $ lein new gaem myapp:appid /path/to/gae/sdk

Here myapp is the name of your clojure app (in project.clj) and appid is the GAE application ID (as used in appengine-web.xml).

The result is a little web app designed to be useful for exploring
webapp development on GAE and appengine-magic.  You can easily
subtract stuff if you want to use it as a starting point for a real
app.

It is designed to work with the gaem plugin which can be found at
https://github.com/greynolds/gaem.

## License

Copyright © 2013 Gregg Reynolds

Distributed under the Eclipse Public License, the same as Clojure.
