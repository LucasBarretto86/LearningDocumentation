#!/bin/bash

echo "ATTENTION! Project structure needs to be as follows:"
echo ""     
echo "      ProjectFolder"
echo "        |__assets/*"
echo "        |__build/"
echo "        |__main.cpp"
echo ""

echo "Compiling"
g++ "$PWD/main.cpp" -lsfml-graphics -lsfml-window -lsfml-system -o "$PWD/build/main"

echo "Compiled!"