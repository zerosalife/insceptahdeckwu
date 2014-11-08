# insceptahdeckwu

`insceptahdeckwu` is a parody twitter bot that tweets based on a
markov chain text generation derived from a corpus of Wu-tang Clan
lyrics.  I wrote [a blog post about how it works.](http://zerosalife.github.io/blog/2014/11/08/insceptahdeckwu/)

You can follow it on twitter at http://twitter.com/insceptahdeckwu

## Dependencies
All of the dependencies are included in the `project.clj`, but I
wanted to shout out some of them here.

- [twitter-api](https://github.com/adamwynne/twitter-api)
- [markov](https://github.com/Janiczek/markov)

## Installation

Download from http://github.com/zerosalife/insceptahdeckwu

## Usage
To run:
```
$ crontab cronjob.txt
```

To quit:
```
crontab -r
```

Note if you have other cron jobs running, you can add and remove the
cronjob for `insceptahdeckwu` on your own.

## Examples

Call the binary with the `-h` to get help.  Use the `-s` flag to
generate a string.  Use the `-t` flag to tweet.  (You must have the
oauth tokens configured correctly to tweet).  If this is your first
time using the bot, you can generate a new corpus file using the `-c`
flag.

```
$ targets/insceptahdeckwu -s
furs in here Yo yo Curses from the tape
```




## License

Copyright © 2014 zerosalife

Distributed under the Eclipse Public License version 1.0.
