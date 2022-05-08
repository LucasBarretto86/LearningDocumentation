# 16 Games Tutorial

## Config
### Add lib SFML
Simply put SFML is a multimedia library for C++ with bindings available for other languages such as Python, Rust, etc. It does not just let you use hardware-accelerated 2D Graphics with OpenGL but also has a variety of methods related to different types of media such as fonts, audio, etc. It stands for Simple and Fast Multimedia Library.

~~~
sudo apt-get install libsfml-dev
~~~

### Compiling using sfml libs
~~~
g++ main.cpp -lsfml-graphics -lsfml-window -lsfml-system -o main
~~~

### Compiling using compile.sh
~~~
.././compile.sh
~~~

### Run compiled file
~~~
./main
~~~



