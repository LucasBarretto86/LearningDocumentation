# Random

- [Random](#random)
  - [Checking Computer Hostname](#checking-computer-hostname)
  - [Local Web Servers](#local-web-servers)
    - [Building Server with python3](#building-server-with-python3)
    - [Killing Server from a specific port](#killing-server-from-a-specific-port)
  - [Testing REST API](#testing-rest-api)
  - [Adding custom display resolutions ubuntu](#adding-custom-display-resolutions-ubuntu)
    - [Checking displays and resolutions](#checking-displays-and-resolutions)
    - [Checking compatibility and specs](#checking-compatibility-and-specs)
    - [Adding resolution](#adding-resolution)
    - [Setting new resolution](#setting-new-resolution)
    - [Ubuntu PPA's](#ubuntu-ppas)
      - [List PPA](#list-ppa)
    - [Adding PPA](#adding-ppa)
    - [Removing PPA](#removing-ppa)
  - [Emojis by Code](#emojis-by-code)
  - [Unicode Cards](#unicode-cards)
    - [Mixed](#mixed)
    - [Spades](#spades)
    - [Hearts](#hearts)
    - [Diamonds](#diamonds)
    - [Clubs](#clubs)

## Checking Computer Hostname

```shell
hostname --fqdn
```

## Local Web Servers

### Building Server with python3

```shell
python3 -m http.server 5505
```

### Killing Server from a specific port

To list any process listening to the port 8080

```shell
lsof -i:8080
```

To kill any process listening to the port 8080

```shell
kill $(lsof -t -i:8080)
```

or more violently

```shell
kill -9 $(lsof -t -i:8080)
```

## Testing REST API

```shell
curl -u marcondesv:a24d4e50c2c4298e34789fa84b0296f330ab7bdd 'https://api.name.com/v4/domains:checkAvailability' -X POST -H 'Content-Type: application/json' --data 
'{"domainNames":["lucasbarretto.us"]},' {"results":[{"domainName":"lucasbarretto.us","sld":"lucasbarretto","tld":"us","purchasable":true,"purchasePrice":8.99,"purchaseType":"registration","renewalPrice":10.99}]}
```

## Adding custom display resolutions ubuntu

### Checking displays and resolutions

```shell
xrandr
```

**Output:**

```bash
Screen 0: minimum 320 x 200, current 1920 x 1080, maximum 16384 x 16384
LVDS-1 connected (normal left inverted right x axis y axis)
...
VGA-1 connected primary 1920x1080+0+0 (normal left inverted right x axis y axis) 0mm x 0mm
   1024x768      60.00  
   800x600       60.32    56.25  
   848x480       60.00  
   640x480       59.94  
   1920x1080_60.00  59.96* 
HDMI-1 disconnected (normal left inverted right x axis y axis)
DP-1 disconnected (normal left inverted right x axis y axis)
HDMI-2 disconnected (normal left inverted right x axis y axis)
HDMI-3 disconnected (normal left inverted right x axis y axis)
DP-2 disconnected (normal left inverted right x axis y axis)
DP-3 disconnected (normal left inverted right x axis y axis)
```

> Notice that the connected display is on `VGA-1`, that's the display name used to set new resolution

### Checking compatibility and specs

```shell
cvt 1920 1080 60
```

**Output:**

```shell
# 1920x1080 59.96 Hz (CVT 2.07M9) hsync: 67.16 kHz; pclk: 173.00 MHz
Modeline "1920x1080_60.00"  173.00  1920 2048 2248 2576  1080 1083 1088 1120 -hsync +vsync
```

### Adding resolution

```shell
sudo xrandr --newmode "1920x1080_60.00"  173.00  1920 2048 2248 2576  1080 1083 1088 1120 -hsync +vsync
```

### Setting new resolution

To set the new added resolution we gonna use this line: `xrandr --addmode DISPLAY_NAME NEW_RESOLUTION`

```shell
xrandr --addmode VGA-1 "1920x1080_60.00"
```

### Ubuntu PPA's

#### List PPA

```shell
apt policy
```

**Output:**

```shell
Package files:
 100 /var/lib/dpkg/status
     release a=now
 500 https://dl.google.com/linux/chrome/deb stable/main amd64 Packages
     release v=1.0,o=Google LLC,a=stable,n=stable,l=Google,c=main,b=amd64
     origin dl.google.com
 500 https://packagecloud.io/github/git-lfs/ubuntu jammy/main i386 Packages
     release v=1,o=packagecloud.io/github/git-lfs,a=jammy,n=jammy,l=git-lfs,c=main,b=i386
     origin packagecloud.io

```

**Alternative:**

```shell
ls /etc/apt/sources.list.d
```

**Output:**

```shell
archive_uri-https_deb_tableplus_com_debian_22-jammy.list              github_git-lfs.list
archive_uri-https_deb_tableplus_com_debian_22-jammy.list.distUpgrade  github_git-lfs.list.distUpgrade
archive_uri-https_deb_tableplus_com_debian_22-jammy.list.save         google-chrome.list

```

### Adding PPA

```shell
sudo add-apt-repository -r ppa:PPA_NAME
```

### Removing PPA

```shell
sudo add-apt-repository -r ppa:PPA_NAME
```

OR

```shell
sudo rm /etc/apt/sources.list.d/PPA_FILE_NAME
```

**Example:**

```shell
sudo rm /etc/apt/sources.list.d/skype-stable.list
```

## Emojis by Code

|Emoji|Code|
| :-: | :--- |
| 😍 | &#128525 |
| 🤣 | &#129315 |
| 🌽 | &#127805 |
| ⚓ | &#9875   |
| 🦁 | &#129409 |
| 🧜 | &#129500 |
| 🎮 | &#127918 |
| 🐝 | &#128029 |
| 🦉 | &#129417 |
| 🎪 | &#127914 |
| 🔥 | &#128293 |
| 👀 | &#128064 |
| 🎉 | &#127881 |
| 🦄 | &#129412 |
| 🌈 | &#127752 |
| 🐚 | &#128026 |
| 🚜 | &#128668 |
| 🐮 | &#128046 |
| 🌦 | &#127782 |
| ☂ | &#9730 |
| 🦈 | &#129416 |
| 🌊 | &#127754 |
| ⚽ | &#9917 |
| 🏆 | &#127942 |
| 👸 | &#128120 |
| 🏰 | &#127984 |
| 🐒 | &#128018 |
| 🎵 | &#127925 |
| 💗 | &#128151 |
| 🤴 | &#129332 |
| 🦇 | &#129415 |
| 🃏 | &#127183 |
| 🤡 | &#129313 |
| 🍄 | &#127812 |
| 👻 | &#128123 |
| 🐠 | &#128032 |
| 🐙 | &#128025 |
| 🚢 | &#128674 |
| 🍯 | &#127855 |
| 🧹 | &#129529 |
| 🎆 | &#127878 |
| 👨‍🚀 | &#128104 &#8205 &#128640 |
| 🚀 | &#128640 |
| 🎃 | &#127875 |
| 🐇 | &#128007 |
| 🕓 | &#128339 |
| 🌴 | &#127796 |
| 🍍 | &#127821 |
| 🧙‍♀️ | &#129497 |
| ✨ | &#10024  |
| 🍺 | &#127866 |
| 🥃 | &#129347 |
| 🍖 | &#127830 |
| 🥂 | &#129346 |
| 🍾 | &#127870 |
| 😀 | &#128512 |
| ⛪ | &#9962   |

## Unicode Cards

### Mixed

| Symbol | Card Name         | Unicode     | Html        |
| :----: | :---------------- | :---------: | :---------: |
|   🂠   | Card Back         | `&#x1F0A0;` | `&#127136;` |
|   🃟   | White Joker       | `&#x1F0FF;` | `&#127199;` |
|   🃏   | Joker             | `&#x1F0CF;` | `&#127167;` |

### Spades

| Symbol | Card Name         | Unicode     | HTML        |
| :----: | :---------------- | :---------: | :---------: |
|   🂡   | Ace Of Spades     | `&#x1F0A1;` | `&#127137;` |
|   🂢   | Two Of Spades     | `&#x1F0A2;` | `&#127138;` |
|   🂣   | Three Of Spades   | `&#x1F0A3;` | `&#127139;` |
|   🂤   | Four Of Spades    | `&#x1F0A4;` | `&#127140;` |
|   🂥   | Five Of Spades    | `&#x1F0A5;` | `&#127141;` |
|   🂦   | Six Of Spades     | `&#x1F0A6;` | `&#127142;` |
|   🂧   | Seven Of Spades   | `&#x1F0A7;` | `&#127143;` |
|   🂨   | Eight Of Spades   | `&#x1F0A8;` | `&#127144;` |
|   🂩   | Nine Of Spades    | `&#x1F0A9;` | `&#127145;` |
|   🂪   | Ten Of Spades     | `&#x1F0AA;` | `&#127146;` |
|   🂫   | Jack Of Spades    | `&#x1F0AB;` | `&#127147;` |
|   🂬   | Knight Of Spades  | `&#x1F0AC;` | `&#127148;` |
|   🂭   | Queen Of Spades   | `&#x1F0AD;` | `&#127149;` |
|   🂮   | King Of Spades    | `&#x1F0AE;` | `&#127150;` |

### Hearts

| Symbol | Card Name        | Unicode     | HTML        |
| :----: | :--------------- | :---------: | :---------: |
|   🂱   | Ace Of Hearts    | `&#x1F0B1;` | `&#127153;` |
|   🂲   | Two Of Hearts    | `&#x1F0B2;` | `&#127154;` |
|   🂳   | Three Of Hearts  | `&#x1F0B3;` | `&#127155;` |
|   🂴   | Four Of Hearts   | `&#x1F0B4;` | `&#127156;` |
|   🂵   | Five Of Hearts   | `&#x1F0B5;` | `&#127157;` |
|   🂶   | Six Of Hearts    | `&#x1F0B6;` | `&#127158;` |
|   🂷   | Seven Of Hearts  | `&#x1F0B7;` | `&#127159;` |
|   🂸   | Eight Of Hearts  | `&#x1F0B8;` | `&#127160;` |
|   🂹   | Nine Of Hearts   | `&#x1F0B9;` | `&#127161;` |
|   🂺   | Ten Of Hearts    | `&#x1F0BA;` | `&#127162;` |
|   🂻   | Jack Of Hearts   | `&#x1F0BB;` | `&#127163;` |
|   🂼   | Knight Of Hearts | `&#x1F0BC;` | `&#127164;` |
|   🂽   | Queen Of Hearts  | `&#x1F0BD;` | `&#127165;` |
|   🂾   | King Of Hearts   | `&#x1F0BE;` | `&#127166;` |

### Diamonds

| Symbol | Card Name         | Unicode     | Html        |
| :----: | :---------------- | :---------: | :---------: |
|   🃁   | Ace Of Diamonds   | `&#x1F0C1;` | `&#127169;` |
|   🃂   | Two Of Diamonds   | `&#x1F0C2;` | `&#127170;` |
|   🃃   | Three Of Diamonds | `&#x1F0C3;` | `&#127171;` |
|   🃄   | Four Of Diamonds  | `&#x1F0C4;` | `&#127172;` |
|   🃅   | Five Of Diamonds  | `&#x1F0C5;` | `&#127173;` |
|   🃆   | Six Of Diamonds   | `&#x1F0C6;` | `&#127174;` |
|   🃇   | Seven Of Diamonds | `&#x1F0C7;` | `&#127175;` |
|   🃈   | Eight Of Diamonds | `&#x1F0C8;` | `&#127176;` |
|   🃉   | Nine Of Diamonds  | `&#x1F0C9;` | `&#127177;` |
|   🃊   | Ten Of Diamonds   | `&#x1F0CA;` | `&#127178;` |
|   🃋   | Jack Of Diamonds  | `&#x1F0CB;` | `&#127179;` |
|   🃌   | Knight Of Diamonds| `&#x1F0CC;` | `&#127180;` |
|   🃍   | Queen Of Diamonds | `&#x1F0CD;` | `&#127181;` |
|   🃎   | King Of Diamonds  | `&#x1F0CE;` | `&#127182;` |

### Clubs

| Symbol | Card Name         | Unicode     | Html        |
| :----: | :---------------- | :---------: | :---------: |
|   🃑   | Ace Of Clubs      | `&#x1F0D1;` | `&#127185;` |
|   🃒   | Two Of Clubs      | `&#x1F0D2;` | `&#127186;` |
|   🃓   | Three Of Clubs    | `&#x1F0D3;` | `&#127187;` |
|   🃔   | Four Of Clubs     | `&#x1F0D4;` | `&#127188;` |
|   🃕   | Five Of Clubs     | `&#x1F0D5;` | `&#127189;` |
|   🃖   | Six Of Clubs      | `&#x1F0D6;` | `&#127190;` |
|   🃗   | Seven Of Clubs    | `&#x1F0D7;` | `&#127191;` |
|   🃘   | Eight Of Clubs    | `&#x1F0D8;` | `&#127192;` |
|   🃙   | Nine Of Clubs     | `&#x1F0D9;` | `&#127193;` |
|   🃚   | Ten Of Clubs      | `&#x1F0DA;` | `&#127194;` |
|   🃛   | Jack Of Clubs     | `&#x1F0DB;` | `&#127195;` |
|   🃜   | Knight Of Clubs   | `&#x1F0DC;` | `&#127196;` |
|   🃝   | Queen Of Clubs    | `&#x1F0DD;` | `&#127197;` |
|   🃞   | King Of Clubs     | `&#x1F0DE;` | `&#127198;` |
