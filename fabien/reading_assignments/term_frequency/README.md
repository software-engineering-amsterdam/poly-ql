Term Frequency
==============

A nodeJS program to output a list of the N (default 25) most 
frequently-occurring (non stop) words (ordered by decreasing frequency), 
given an english text file.

## Dependencies

`Minimist` is used for easier command line argument support. Mocha / lint for testing and
development. Everything can be installed using:

`npm install`


## Usage

The program can be run using the following command:
`node main.js -f input_files/test.txt`

The amount can be set. The following command limits it to the top ten frequent words:
`node main.js -f input_files/test.txt -c 10`

Additional language is supported, but for now only dutch/english stop words exist. 
The following works for dutch:
`node main.js -f input_files/test.txt -l nl`


## Notes

This program is created for the Software Construction course. It is adjusted to
comply to the "Object Calisthenics" rules.