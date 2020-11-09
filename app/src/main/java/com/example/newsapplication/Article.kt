package com.example.newsapplication

data class Article(
    val source:Source,
    val author:String,
    val title : String,
    val description:String,
    val url : String,
    val urlToImage : String,
    val publishedAt : String,
    val content : String
)

data class Source(
    val id : String,
    val name : String
)

val testData : String = "{\"status\":\"ok\",\"totalResults\":70,\"articles\":[{\"source\":{\"id\":\"the-verge\",\"name\":\"The Verge\"},\"author\":\"Sam Byford\",\"title\":\"Apple puts major supplier Pegatron on probation for labor violations - The Verge\",\"description\":\"Apple has cut off major supplier Pegatron from new contracts following the reveal of student labor violations. Pegatron is one of Apple’s biggest supply chain partners, manufacturing various products including some of the newest iPhone 12 models.\",\"url\":\"https://www.theverge.com/2020/11/9/21556154/apple-supplier-pegatron-student-labor-violation\",\"urlToImage\":\"https://cdn.vox-cdn.com/thumbor/A4GbD38aRWm23QuI-etYxiA5RZA=/0x0:2040x1068/fit-in/1200x630/cdn.vox-cdn.com/uploads/chorus_asset/file/21973366/akrales_201018_4238_0435.0.jpg\",\"publishedAt\":\"2020-11-09T07:28:29Z\",\"content\":\"Pegatron falsified paperwork for a student worker program\\r\\nPhoto by Amelia Holowaty Krales / The Verge\\r\\nApple has cut off major supplier Pegatron from new contracts following the reveal of student la… [+1691 chars]\"},{\"source\":{\"id\":\"engadget\",\"name\":\"Engadget\"},\"author\":\"\",\"title\":\"The world’s first crewed Hyperloop trip was a success - Engadget\",\"description\":\"Company co-founder Josh Giegel and Sara Lucian are the first people in history to ride in a Hyperloop.\",\"url\":\"https://www.engadget.com/virgin-hyperloop-one-crewed-test-trip-success-070619690.html\",\"urlToImage\":\"https://o.aolcdn.com/images/dims?resize=1200%2C630&crop=1200%2C630%2C0%2C0&quality=95&image_uri=https%3A%2F%2Fs.yimg.com%2Fos%2Fcreatr-uploaded-images%2F2020-11%2Faa162110-2033-11eb-afff-829f8b5ad9d1&client=amp-blogside-v2&signature=54f06dc9918c44f48caaa6b351946b0e97d25dc1\",\"publishedAt\":\"2020-11-09T07:07:54Z\",\"content\":\"In a call with Engadget ahead of the test, Virgin Hyperloop’s representatives told us there was a heavy focus on safety, given the level of attention the journey was likely to provoke. Both were walk… [+1534 chars]\"},{\"source\":{\"id\":null,\"name\":\"Investing.com\"},\"author\":\"Reuters\",\"title\":\"Brent crude tops \$40 after Biden's win lifts risk-takers - Investing.com\",\"description\":\"Brent crude tops \$40 after Biden's win lifts risk-takers\",\"url\":\"https://www.investing.com/news/commodities-news/brent-crude-tops-40-a-barrel-after-biden-clinches-us-presidency-2343390\",\"urlToImage\":\"https://i-invdn-com.akamaized.net/trkd-images/LYNXMPEGA801D_L.jpg\",\"publishedAt\":\"2020-11-09T05:05:00Z\",\"content\":\"By Florence Tan\\r\\nSINGAPORE (Reuters) - Oil prices gained more than 2% on Monday, with Brent futures rising above \$40 a barrel, after Joe Biden clinched the U.S. presidency and buoyed risk appetites, … [+2638 chars]\"},{\"source\":{\"id\":null,\"name\":\"CNET\"},\"author\":\"Oscar Gonzalez\",\"title\":\"These 5 benefits will flame out if no new stimulus money is settled by the end of 2020 - CNET\",\"description\":\"If another stimulus package doesn't go into effect by Dec. 31, some much-needed benefits are going away.\",\"url\":\"https://www.cnet.com/personal-finance/these-5-benefits-will-flame-out-if-no-new-stimulus-money-by-the-end-of-2020/\",\"urlToImage\":\"https://cnet2.cbsistatic.com/img/9bRequKoqxwirGBCff7VLace-KA=/1200x630/2020/10/07/702b587e-1602-4451-8ecc-5486c934dff7/042-cash-burning-cut-up-stimulus-fail-trump-2020-october.jpg\",\"publishedAt\":\"2020-11-09T04:00:00Z\",\"content\":\"There's an expiration date to the final remaining COVID-19 relief benefits, before they go up in smoke.\\r\\nCNET Staff\\r\\nIn just over seven weeks, America's remaining coronavirus relief programs will exp… [+5042 chars]\"},{\"source\":{\"id\":null,\"name\":\"Teslarati\"},\"author\":\"Maria Merano\",\"title\":\"Tesla China’s RHD Model 3 with new center console and black trim spotted in Hong Kong - Teslarati\",\"description\":\"Tesla Gigafactory Shanghai has sent six new Model 3s with updated interior and exterior elements to Hong Kong. Even more notable was the fact that all the refreshed Model 3s spotted in the Southeast Asian country were Right-Hand-Drive (RHD).  Tesla owner-enth…\",\"url\":\"https://www.teslarati.com/tesla-china-model-3-rhd-spotted-in-hong-kong/\",\"urlToImage\":\"https://www.teslarati.com/wp-content/uploads/2020/11/2021-Tesla-Model-3-right-hand-drive.jpg\",\"publishedAt\":\"2020-11-09T03:58:31Z\",\"content\":\"Tesla Gigafactory Shanghai has sent six new Model 3s with updated interior and exterior elements to Hong Kong. Even more notable was the fact that all the refreshed Model 3s spotted in the Southeast … [+2919 chars]\"},{\"source\":{\"id\":\"reuters\",\"name\":\"Reuters\"},\"author\":\"Aluisio Alves\",\"title\":\"Amazon expands in Brazil, riding e-commerce boom set off by COVID-19 distancing - Reuters\",\"description\":\"Amazon <AMZN.O> said on Monday it had opened three more logistics centers in Brazil to take advantage of the boost the COVID-19 pandemic has given to e-commerce in South America's largest economy.\",\"url\":\"https://www.reuters.com/article/amazon-com-brazil-idINKBN27P09P\",\"urlToImage\":\"https://static.reuters.com/resources/r/?m=02&d=20201109&t=2&i=1540473928&r=LYNXMPEGA804R&w=800\",\"publishedAt\":\"2020-11-09T03:52:00Z\",\"content\":\"SAO PAULO (Reuters) - Amazon AMZN.O said on Monday it had opened three more logistics centers in Brazil to take advantage of the boost the COVID-19 pandemic has given to e-commerce in South America's… [+1790 chars]\"},{\"source\":{\"id\":\"the-wall-street-journal\",\"name\":\"The Wall Street Journal\"},\"author\":\"Lukas I. Alpert\",\"title\":\"Uzabase Agrees to Sell Business News Site Quartz - The Wall Street Journal\",\"description\":\"CEO Zach Seward, Editor in Chief Katherine Bell will buy Quartz from parent company\",\"url\":\"https://www.wsj.com/articles/uzabase-agrees-to-sell-business-news-site-quartz-11604890781\",\"urlToImage\":\"https://images.wsj.net/im-257043/social\",\"publishedAt\":\"2020-11-09T03:17:00Z\",\"content\":\"The co-founder of Quartz and its editor in chief agreed to buy the business news website from Japanese financial data and media company Uzabase Inc., a deal that comes as Quartz has suffered from the… [+1306 chars]\"},{\"source\":{\"id\":null,\"name\":\"CleanTechnica\"},\"author\":\"Tina Casey\",\"title\":\"Green Hydrogen Nail, Meet Shale Gas Coffin (& Nuclear Could Be Next) - CleanTechnica\",\"description\":\"Presidents come and go, but the green hydrogen trend is here to stay and that spells bad news for US shale gas exporters.\",\"url\":\"https://cleantechnica.com/2020/11/08/green-hydrogen-nail-meet-shale-gas-coffin-nuclear-could-be-next/\",\"urlToImage\":\"https://cleantechnica.com/files/2020/11/INL-PIC-860x574-1.jpg\",\"publishedAt\":\"2020-11-09T03:12:51Z\",\"content\":\"Clean PowerPublished on November 8th, 2020 |\\r\\n by Tina Casey\\r\\n0\\r\\nNovember 8th, 2020 by Tina Casey \\r\\nIf US President-Elect Joe Biden doesn’t do the fossil fuel industry any favors, he’ll only be follo… [+10683 chars]\"},{\"source\":{\"id\":null,\"name\":\"WLS-TV\"},\"author\":\"ABC 7 Chicago Digital Team\",\"title\":\"Chicago woman, Yaazmina Payton, arrested for illegally boarding plane without ticket at O'Hare International Airport - WLS-TV\",\"description\":\"A Chicago woman has been charged with criminal trespassing after boarding an airplane at O'Hare International Airport without a ticket, according to police.\",\"url\":\"https://abc7chicago.com/ohare-international-airport-woman-arrested-trespassing-yaazmina-payton/7783519/\",\"urlToImage\":\"https://cdn.abcotvs.com/dip/images/7785582_110820-wls-ohare-img.jpg?w=1600\",\"publishedAt\":\"2020-11-09T03:00:09Z\",\"content\":\"CHICAGO (WLS) -- A Marquette Park woman was arrested Sunday morning for illegally boarding a plane at O'Hare International Airport.Yaazmina Payton, 23 of Chicago, was removed from the plane just afte… [+417 chars]\"},{\"source\":{\"id\":null,\"name\":\"NBC Connecticut\"},\"author\":\"NBC Connecticut\",\"title\":\"Shake Shack in West Hartford Temporarily Closed Amid Coronavirus Pandemic - NBC Connecticut\",\"description\":\"Shake Shack in West Hartford is just one of eight restaurant locations in the United States to close amid the COVID-19 pandemic. No other Shake Shack locations…\",\"url\":\"https://www.nbcconnecticut.com/news/coronavirus/shake-shack-in-west-hartford-temporarily-closed-amid-coronavirus-pandemic/2357260/\",\"urlToImage\":\"https://media.nbcconnecticut.com/2019/09/shake-shack-corbins-3.jpg?resize=1200%2C675\",\"publishedAt\":\"2020-11-09T02:57:28Z\",\"content\":\"Shake Shack in West Hartford is just one of eight restaurant locations in the United States to close amid the COVID-19 pandemic.\\r\\nNo other Shake Shack locations in Connecticut are affected by the clo… [+434 chars]\"},{\"source\":{\"id\":null,\"name\":\"WFLA\"},\"author\":\"Julia Palazzo and Nexstar Media Wire\",\"title\":\"Shortage of pasta, baking supplies possible amid rise in COVID-19 cases - WFLA\",\"description\":\"With case counts increasing across the United States, there are concerns about the supply chain’s ability to keep up again with cleaning supplies, toilet paper and paper towels.\",\"url\":\"https://www.wfla.com/news/national/shortage-of-pasta-baking-supplies-possible-amid-rise-in-covid-19-cases/\",\"urlToImage\":\"https://www.wfla.com/wp-content/uploads/sites/71/2020/11/Capture1-1.jpg?w=1280\",\"publishedAt\":\"2020-11-09T02:10:00Z\",\"content\":\"NASHVILLE, Tenn. (WKRN) With COVID-19 case counts increasing across the US, there are concerns again about the supply chain’s ability to keep up with cleaning supplies, toilet paper and paper towels.… [+2437 chars]\"},{\"source\":{\"id\":\"reuters\",\"name\":\"Reuters\"},\"author\":\"Swati Pandey\",\"title\":\"Biden win pumps up risk assets, dollar nurses losses - Reuters\",\"description\":\"Shares surged, oil prices jumped and the U.S. dollar remained weak on Monday as expectations of fewer regulatory reforms and more monetary stimulus under U.S. President-elect Joe Biden supported risk appetite.\",\"url\":\"https://www.reuters.com/article/global-markets-idUSKBN27O0WX\",\"urlToImage\":\"https://static.reuters.com/resources/r/?m=02&d=20201109&t=2&i=1540466793&r=LYNXMPEGA8022&w=800\",\"publishedAt\":\"2020-11-09T02:05:00Z\",\"content\":\"SYDNEY (Reuters) - Shares surged, oil prices jumped and the U.S. dollar remained weak on Monday as expectations of fewer regulatory reforms and more monetary stimulus under U.S. President-elect Joe B… [+4572 chars]\"},{\"source\":{\"id\":\"the-wall-street-journal\",\"name\":\"The Wall Street Journal\"},\"author\":\"Lukas I. Alpert\",\"title\":\"Bloomberg’s Streaming News Channel Deepens Push in Consumer Media - The Wall Street Journal\",\"description\":\"QuickTake service will cover general interest and lifestyle news, starting with 10-and-a-half hours of daily programming\",\"url\":\"https://www.wsj.com/articles/bloombergs-streaming-news-channel-deepens-push-in-consumer-media-11604880000\",\"urlToImage\":\"https://images.wsj.net/im-257000/social\",\"publishedAt\":\"2020-11-09T02:03:00Z\",\"content\":\"Bloomberg LP built its multibillion-dollar business selling high-priced data terminals to institutional customers such as financial-services companies. These days, it is focusing much of its energy o… [+4775 chars]\"},{\"source\":{\"id\":null,\"name\":\"Benzinga\"},\"author\":\"Chris Katje\",\"title\":\"Kids Pushing Parents To Buy Electric Vehicles: Study - Benzinga\",\"description\":\"A new study from French automaker Peugeot shows kids are pushing their parents to consider buying electric vehicles, reports CleanTechnica. Two notable ...\",\"url\":\"https://www.benzinga.com/news/20/11/18235209/kids-pushing-parents-to-buy-electric-vehicles-study\",\"urlToImage\":\"https://cdn.benzinga.com/files/imagecache/og_image_social_share_1200x630/images/story/2012/electric-car-1458836_1920_4_0.jpg\",\"publishedAt\":\"2020-11-09T01:45:48Z\",\"content\":\"A new study from French automaker Peugeot shows kids are pushing their parents to consider buying electric vehicles, reports CleanTechnica. Two notable investors and Tesla bears also got pressure fro… [+2290 chars]\"},{\"source\":{\"id\":null,\"name\":\"Yahoo Entertainment\"},\"author\":\"Takahiko Hyuga and Jeffrey Hernandez\",\"title\":\"375% Return on One Startup to Help SoftBank Get Past WeWork - Yahoo Finance\",\"description\":\"(Bloomberg) -- As Softbank Group Corp. tries to rebuild its reputation as a startup investor, the Japanese conglomerate will be able to point to several...\",\"url\":\"https://finance.yahoo.com/news/375-return-one-startup-help-210000752.html\",\"urlToImage\":\"https://s.yimg.com/uu/api/res/1.2/q4Myan7BKifkmMxlTHhHpw--~B/aD03NTY7dz0xMjk2O2FwcGlkPXl0YWNoeW9u/https://media.zenfs.com/en/bloomberg_technology_68/2bbbd5411aa8afd1c36f895ee2e74d12\",\"publishedAt\":\"2020-11-09T01:39:00Z\",\"content\":\"(Bloomberg) -- As Softbank Group Corp. tries to rebuild its reputation as a startup investor, the Japanese conglomerate will be able to point to several recent successes, including an obscure Chinese… [+4588 chars]\"},{\"source\":{\"id\":null,\"name\":\"Kitco NEWS\"},\"author\":\"http://www.facebook.com/kitconews\",\"title\":\"Gold price holding gains after last week's breakout - Kitco NEWS\",\"description\":\"(Kitco News) - The gold market is starting the week on solid footing with modest gains following last week's nearly 4% rally.\",\"url\":\"https://www.kitco.com/news/2020-11-08/Gold-price-holding-gains-after-last-week-s-breakout.html\",\"urlToImage\":\"https://www.kitco.com/news/2020-11-08/images/shutterstock_1482617498.jpg\",\"publishedAt\":\"2020-11-09T01:33:00Z\",\"content\":\"Editor's Note: With so much market volatility, stay on top of daily news! Get caught up in minutes with our speedy summary of today's must-read news and expert opinions. Sign up here! \\r\\n(Kitco News) … [+3681 chars]\"},{\"source\":{\"id\":\"bloomberg\",\"name\":\"Bloomberg\"},\"author\":null,\"title\":\"Ant Group’s Stalled IPO Seen Slashing Its Value by \$140 Billion - Bloomberg\",\"description\":null,\"url\":\"https://www.bloomberg.com/tosv2.html?vid=&uuid=8133cc50-2247-11eb-86b1-a365fed7db02&url=L25ld3MvYXJ0aWNsZXMvMjAyMC0xMS0wOS9hbnQtZ3JvdXAtcy1zdGFsbGVkLWlwby1zZWVuLXNsYXNoaW5nLWl0cy12YWx1ZS1ieS0xNDAtYmlsbGlvbg==\",\"urlToImage\":null,\"publishedAt\":\"2020-11-09T01:32:00Z\",\"content\":\"To continue, please click the box below to let us know you're not a robot.\"},{\"source\":{\"id\":null,\"name\":\"Cbslocal.com\"},\"author\":\"CBSLA Staff\",\"title\":\"Strong Wind Causes Hazards In Los Angeles, Orange Counties - CBS Los Angeles\",\"description\":\"Strong wind throughout the Southland caused several hazards throughout the day Sunday.\",\"url\":\"https://losangeles.cbslocal.com/2020/11/08/wind-los-angeles-orange-county-power-lines-trees/\",\"urlToImage\":\"https://losangeles.cbslocal.com/wp-content/uploads/sites/14984641/2020/11/downed-street-Westchester-no-credit-from-desk.png?w=1252\",\"publishedAt\":\"2020-11-09T01:15:00Z\",\"content\":\"Heavy wind toppled trees in several areas, including Westchester, Bell Gardens, Irvine and Ladera Heights, impacting the Metrolink between Fullerton and Anaheim and putting some evening commutes at a… [+549 chars]\"},{\"source\":{\"id\":null,\"name\":\"Simple Flying\"},\"author\":\"\",\"title\":\"Why The Airbus A319neo Hasn’t Been Popular - Simple Flying\",\"description\":\"The Airbus A319neo is by far the least successful A320neo variant out there. Overshadowed heavily by the A320neo…\",\"url\":\"https://simpleflying.com/airbus-a319neo-not-popular/\",\"urlToImage\":\"https://simpleflying.com/wp-content/uploads/2020/11/A319neo_First-flight-2-scaled.jpeg\",\"publishedAt\":\"2020-11-09T01:01:33Z\",\"content\":\"The Airbus A319neo is by far the least successful A320neo variant out there. Overshadowed heavily by the A320neo and A321neo, Airbus has persisted with the aircraft. Airbus continues to describe the … [+3764 chars]\"},{\"source\":{\"id\":\"the-hill\",\"name\":\"The Hill\"},\"author\":null,\"title\":\"Dow futures rise as part of post-election rally - msnNOW\",\"description\":\"A post-election rally on the stock market appeared to be set to continue Monday as Dow futures surged on Sunday.Projections from CNBC indicated that futures on the Dow were up 220 points by Sunday evening, indicating a gain of around 200 points as the trading…\",\"url\":\"https://thehill.com/policy/finance/banking-financial-institutions/525070-dow-futures-rise-as-part-of-post-election-rally\",\"urlToImage\":\"https://img-s-msn-com.akamaized.net/tenant/amp/entityid/BB17X7To.img?h=315&w=600&m=6&q=60&o=t&l=f&f=jpg\",\"publishedAt\":\"2020-11-09T00:09:00Z\",\"content\":\"A post-election rally on the stock market appeared to be set to continue Monday as Dow futures surged on Sunday.\\r\\n© Getty Images\\r\\n Dow futures rise as part of post-election rally\\r\\nProjections from CN… [+1229 chars]\"}]}"