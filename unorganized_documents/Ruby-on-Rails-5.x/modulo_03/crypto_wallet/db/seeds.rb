mining_types = [{
                    name: "Proof of Stake",
                    acronym: "PoS"},

                {
                    name: "Proof of Work",
                    acronym: "PoW"

                },

                {
                    name: "Proof of Capacity",
                    acronym: "PoC",
                }

]

coins = [{
             name: "Bitcoin",
             acronym: "BTC",
             url_image: "https://i.ibb.co/LZqpRMG/btc.png",
             mining_types_id: 1
         },

         {
             name: "Ethereum",
             acronym: "ETH",
             url_image: "https://i.ibb.co/68gNH2c/eth.png",
             mining_types_id: 1
         },

         {
             name: "Dash",
             acronym: "DSH",
             url_image: "https://i.ibb.co/L0jCtjD/dsh.png",
             mining_types_id: 1
         },

         {
             name: "Smartcash",
             acronym: "SMART",
             url_image: "https://i.ibb.co/NW0nJ5K/smart.png",
             mining_types_id: 1
         },

         {
             name: "Zcash",
             acronym: "ZEC",
             url_image: "https://i.ibb.co/mNL3pWp/zec.png",
             mining_types_id: 1
         },

         {
             name: "Decred",
             acronym: "DCR",
             url_image: "https://i.ibb.co/RY55NdR/dcr.png",
             mining_types_id: 1
         },

         {
             name: "Tether",
             acronym: "USDT",
             url_image: "https://i.ibb.co/pW1Hq18/usdt.png",
             mining_types_id: 1
         }]

mining_types.each do |mining_type|
  MiningType.find_or_create_by!(mining_type)
end

coins.each do |coin|
  Coin.find_or_create_by!(coin)
end