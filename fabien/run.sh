#!/bin/bash
pegjs grammar/grammar.pegjs parser/parser.js
node test.js