# IMAGES CONVERSION

- [IMAGES CONVERSION](#images-conversion)
  - [SVG TO PNG](#svg-to-png)
  - [PSD TO PNG](#psd-to-png)
  - [Potrace](#potrace)
    - [Potrace install](#potrace-install)
    - [BMP to SVG](#bmp-to-svg)

## SVG TO PNG

```shell
convert -background -quality 100 *.svg -set filename:base "%[basename]" "%[filename:base].png"
```

## PSD TO PNG

```shell
convert  *.psd -set filename:base "%[basename]" -quality 100 "%[filename:base].png"
convert cover.ai cover.png
```

## Potrace

Potrace(TM) is a tool for tracing a bitmap, which means, transforming a bitmap into a smooth, scalable image. It only traces black and white input images

### Potrace install

```shell
sudo apt install potrace
```

### BMP to SVG

```shell
potrace example.bmp -s -o example.svg
```

![original BMP](images/example.bmp)
![Converted](images/example.svg)
