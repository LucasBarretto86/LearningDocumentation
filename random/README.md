# Random

- [Random](#random)
  - [Checking Computer Hostname](#checking-computer-hostname)
  - [Local Web Servers](#local-web-servers)
    - [Building Server with python3](#building-server-with-python3)
    - [Killing Server from a specific port](#killing-server-from-a-specific-port)
  - [Testing REST API](#testing-rest-api)
  - [Emojis by Code](#emojis-by-code)

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
'{"domainNames":["marcosemariaw.us"]},' {"results":[{"domainName":"marcosemariaw.us","sld":"marcosemariaw","tld":"us","purchasable":true,"purchasePrice":8.99,"purchaseType":"registration","renewalPrice":10.99}]}
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
