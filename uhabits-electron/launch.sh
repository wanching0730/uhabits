#!/bin/bash
gradle :uhabits-electron:build || exit
build/app/node_modules/.bin/electron build/app
