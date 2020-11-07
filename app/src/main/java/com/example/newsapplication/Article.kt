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

val testData : String = "{\n" +
        "  \"status\": \"ok\",\n" +
        "  \"totalResults\": 38,\n" +
        "  \"articles\": [\n" +
        "    {\n" +
        "      \"source\": { \"id\": null, \"name\": \"New York Times\" },\n" +
        "      \"author\": \"Maggie Haberman, Michael D. Shear\",\n" +
        "      \"title\": \"Mark Meadows, Trump’s Chief of Staff, Has the Coronavirus - The New York Times\",\n" +
        "      \"description\": \"Mr. Meadows aided President Trump’s efforts to play down the virus throughout the summer. A Trump campaign adviser and four other White House aides also tested positive.\",\n" +
        "      \"url\": \"https://www.nytimes.com/2020/11/06/us/politics/mark-meadows-coronavirus.html\",\n" +
        "      \"urlToImage\": \"https://static01.nyt.com/images/2020/12/06/world/06dc-meadows-1sub/06dc-meadows-1sub-facebookJumbo.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T08:24:00Z\",\n" +
        "      \"content\": \"Mr. Trump has spent most of the pandemic minimizing the threat of the virus, and several White House officials have nurtured his desire to treat it as a localized threat in Democratic-leaning states.… [+1372 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": \"cnn\", \"name\": \"CNN\" },\n" +
        "      \"author\": \"Jason Hanna, Rob Frehse and Sonia Moghe, CNN\",\n" +
        "      \"title\": \"Report: Armed men arrested in Philadelphia were trying to deliver fake ballots - CNN\",\n" +
        "      \"description\": \"Two armed Virginia men who were arrested Thursday outside the Philadelphia Convention Center were \\\"coming to deliver a truck full of fake ballots\\\" to the city, CNN affiliate KYW reported, citing prosecutors.\",\n" +
        "      \"url\": \"https://www.cnn.com/2020/11/07/us/pennsylvania-convention-center-arrests/index.html\",\n" +
        "      \"urlToImage\": \"https://cdn.cnn.com/cnnnext/dam/assets/201107003552-01-armed-men-philadelphia-fake-ballots-1106-super-tease.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T07:46:00Z\",\n" +
        "      \"content\": \"(CNN)Two armed Virginia men who were arrested Thursday outside the Philadelphia Convention Center were \\\"coming to deliver a truck full of fake ballots\\\" to the city, CNN affiliate KYW reported, citing… [+3865 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": \"nbc-news\", \"name\": \"NBC News\" },\n" +
        "      \"author\": \"David K. Li\",\n" +
        "      \"title\": \"Alex Cora, tainted by Houston Astros sign-stealing scandal, rehired by Boston Red Sox - NBC News\",\n" +
        "      \"description\": \"The Boston Red Sox rehired former manager Alex Cora, nine months after parting ways with him over his involvement in the Houston Astros sign-stealing scandal.\",\n" +
        "      \"url\": \"https://www.nbcnews.com/news/sports/alex-cora-tainted-houston-astros-sign-stealing-scandal-rehired-boston-n1246828\",\n" +
        "      \"urlToImage\": \"https://media3.s-nbcnews.com/j/newscms/2020_03/3186866/200115-alex-cora-mc-1103_6e1415b8a49d6c5777337d41e390547b.nbcnews-fp-1200-630.JPG\",\n" +
        "      \"publishedAt\": \"2020-11-07T05:31:00Z\",\n" +
        "      \"content\": \"The Boston Red Sox rehired former manager Alex Cora nine months after parting ways with him over his involvement in the Houston Astros sign-stealing scandal.\\r\\nCora led Boston to the World Series titl… [+1782 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": null, \"name\": \"HYPEBEAST\" },\n" +
        "      \"author\": \"Ambrose Leung\",\n" +
        "      \"title\": \"Johnny Depp Has Been Asked by Warner Bros to Resign from 'Fantastic Beasts' - HYPEBEAST\",\n" +
        "      \"description\": \"\\\"I have respected and agreed to that request.\\\"\",\n" +
        "      \"url\": \"https://hypebeast.com/2020/11/johnny-depp-fantastic-beasts-3-grindelwald-role-resignation-news\",\n" +
        "      \"urlToImage\": \"https://image-cdn.hypb.st/https%3A%2F%2Fhypebeast.com%2Fimage%2F2020%2F11%2FTW-johnny-depp-fantastic-beasts-3-grindelwald-role-resignation-news.jpg?w=960&cbr=1&q=90&fit=max\",\n" +
        "      \"publishedAt\": \"2020-11-07T04:56:00Z\",\n" +
        "      \"content\": \"Johnny Depp has just taken to his Instagram to announce that he will not be returning as Gellert Grindelwald in the third installment of Fantastic Beasts and Where to Find Them. In his post, Depp men… [+723 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": null, \"name\": \"MacRumors\" },\n" +
        "      \"author\": \"Arnold Kim\",\n" +
        "      \"title\": \"iOS 14.2 Features: Everything New in iOS 14.2 - Mac Rumors\",\n" +
        "      \"description\": \"Apple recently released iOS 14.2 and iPadOS 14.2, the second major updates to the iOS and iPadOS 14 operating system updates that were released in...\",\n" +
        "      \"url\": \"https://www.macrumors.com/guide/ios-14-2-features/\",\n" +
        "      \"urlToImage\": \"https://images.macrumors.com/t/0ncg6RwGimTn3MmscdKw6nMhI6I=/2904x/https://images.macrumors.com/article-new/2020/10/iOS14.2on-Phone-Feature-2.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T04:38:00Z\",\n" +
        "      \"content\": \"Apple recently released iOS 14.2 and iPadOS 14.2, the second major updates to the iOS and iPadOS 14 operating system updates that were released in September. iOS 14.2 and iPadOS 14.2 come two weeks a… [+4363 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": \"usa-today\", \"name\": \"USA Today\" },\n" +
        "      \"author\": \"Kelly Tyko\",\n" +
        "      \"title\": \"Romaine lettuce recall 2020: Tanimura & Antle recalls single heads of romaine for possible E. coli contamination - USA TODAY\",\n" +
        "      \"description\": \"Tanimura & Antle is voluntarily recalling select single heads of romaine lettuce distributed across the country for possible E. Coli contamination.\",\n" +
        "      \"url\": \"https://www.usatoday.com/story/money/food/2020/11/06/recall-romaine-lettuce-potential-e-coli-risk/6196187002/\",\n" +
        "      \"urlToImage\": \"https://www.gannett-cdn.com/presto/2020/11/07/USAT/8be190bb-b0b6-4219-bd15-d9a44042dce5-SingleHeadRomaine_2020.jpg?crop=1019,573,x1,y201&width=1600&height=800&fit=bounds\",\n" +
        "      \"publishedAt\": \"2020-11-07T03:51:27Z\",\n" +
        "      \"content\": \"E.Coli, metal and even a dead bat has have been found in recalled food. In fact, food recalls are increasing. Yet, that might actually be a good sign. Here's why.\\r\\nUSA TODAY\\r\\nTanimura &amp; Antle Inc… [+3995 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": \"associated-press\", \"name\": \"Associated Press\" },\n" +
        "      \"author\": \"Ben Nadler\",\n" +
        "      \"title\": \"Perdue, Ossoff head to Georgia US Senate runoff - The Associated Press\",\n" +
        "      \"description\": \"ATLANTA (AP) — Republican U.S. Sen. David Perdue and Democrat Jon Ossoff will face off in a Jan. 5 runoff in Georgia for Perdue’s Senate seat, one of two high-profile contests in the state that...\",\n" +
        "      \"url\": \"https://apnews.com/article/election-2020-donald-trump-senate-elections-georgia-elections-6f67f16a26d34a8503c6212585a931a6\",\n" +
        "      \"urlToImage\": \"https://storage.googleapis.com/afs-prod/media/00b593e01b3b4b818e3ac124dabfb7c2/3000.jpeg\",\n" +
        "      \"publishedAt\": \"2020-11-07T03:28:18Z\",\n" +
        "      \"content\": \"ATLANTA (AP) Republican U.S. Sen. David Perdue and Democrat Jon Ossoff will face off in a Jan. 5 runoff in Georgia for Perdues Senate seat, one of two high-profile contests in the state that could de… [+3612 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": \"fox-news\", \"name\": \"Fox News\" },\n" +
        "      \"author\": \"Julius Young\",\n" +
        "      \"title\": \"‘DWTS’ pro Gleb Savchenko, wife Elena Samodanova split after 14-year marriage - Fox News\",\n" +
        "      \"description\": \"The professional dancers tied the knot in 2006 and share two daughters together.\",\n" +
        "      \"url\": \"https://www.foxnews.com/entertainment/dwts-pro-gleb-savchenko-wife-elena-samodanova-split\",\n" +
        "      \"urlToImage\": \"https://static.foxnews.com/foxnews.com/content/uploads/2020/11/gleb-savchenko-elena-samodanova-2019-getty.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T03:19:22Z\",\n" +
        "      \"content\": \"Professional dancers Gleb Savchenko and wife Elena Samodanova won’t be waltzing to renew their wedding vows.\\r\\nThe pair just announced that they are calling it quits after more than a decade of marria… [+2969 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": \"cnn\", \"name\": \"CNN\" },\n" +
        "      \"author\": \"Rebekah Riess and Steve Almasy, CNN\",\n" +
        "      \"title\": \"Rapper King Von shot and killed outside Atlanta nightclub - CNN\",\n" +
        "      \"description\": \"Rapper King Von was one of two people fatally shot during an early Friday morning exchange of gunfire outside an Atlanta hookah lounge, authorities said.\",\n" +
        "      \"url\": \"https://www.cnn.com/2020/11/06/us/atlanta-king-von-killed-in-shootout/index.html\",\n" +
        "      \"urlToImage\": \"https://cdn.cnn.com/cnnnext/dam/assets/201106202453-rapper-king-von-0829-super-tease.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T02:47:00Z\",\n" +
        "      \"content\": null\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": null, \"name\": \"KOMO News\" },\n" +
        "      \"author\": \"Tammy Mutasa, KOMO News\",\n" +
        "      \"title\": \"King County in new COVID-19 peak, risk of getting COVID higher then ever - KOMO News\",\n" +
        "      \"description\": \"King County&mdash;Right now, the risk of getting COVID-19 is higher than ever before. That&rsquo;s the warning from the top King County Health Official who says we are in a new COVID-19 peak. &ldquo;Cases continue to accelerate in the wrong direction, and it&…\",\n" +
        "      \"url\": \"https://komonews.com/news/coronavirus/king-county-in-new-covid-19-peak\",\n" +
        "      \"urlToImage\": \"https://static-18.sinclairstoryline.com/resources/media/6d04975c-7aaa-482a-b69b-41e577507892-large16x9_AP20297646912035.jpg?1604716158639\",\n" +
        "      \"publishedAt\": \"2020-11-07T02:32:03Z\",\n" +
        "      \"content\": null\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": null, \"name\": \"TribLIVE\" },\n" +
        "      \"author\": \"The Philadelphia Inquirer\",\n" +
        "      \"title\": \"U.S. Supreme Court justice orders Pa. counties to separate, but keep counting, late-arriving mail ballots - TribLIVE\",\n" +
        "      \"description\": \"PHILADELPHIA — In a move that could signal the U.S. Supreme Court is one step closer to intervening in a fight over Pennsylvania’s grace-period for late-arriving mail ballots, Justice Samuel Alito on Friday ordered all counties to keep separate any ballots th…\",\n" +
        "      \"url\": \"https://triblive.com/news/pennsylvania/u-s-supreme-court-justice-orders-pa-counties-to-separate-but-keep-counting-late-arriving-mail-ballots/\",\n" +
        "      \"urlToImage\": \"https://triblive.com/wp-content/uploads/2020/11/3210566_web1_AP19204808453874.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T02:19:37Z\",\n" +
        "      \"content\": \"Our commenting has been temporarily disabled.\\r\\nYou are solely responsible for your comments and by using TribLive.com you agree to our\\r\\nTerms of Service.\\r\\nWe moderate comments. Our goal is to provide… [+1733 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": null, \"name\": \"Daily Beast\" },\n" +
        "      \"author\": \"Blake Montgomery\",\n" +
        "      \"title\": \"Tucker Carlson Imagines a Dystopian Biden Presidency Where Everyone MUST Drink Starbucks Every Day - The Daily Beast\",\n" +
        "      \"description\": \"The Fox host imagined government-mandated coffee consumption: “You’re happy with your corner coffee shop? These people want you to drink Starbucks from now until forever.”\",\n" +
        "      \"url\": \"https://www.thedailybeast.com/tucker-carlson-imagines-a-dystopian-biden-presidency-where-everyone-must-drink-starbucks-every-day\",\n" +
        "      \"urlToImage\": \"https://img.thedailybeast.com/image/upload/c_crop,d_placeholder_euli9k,h_576,w_1024,x_0,y_0/dpr_2.0/c_limit,w_740/fl_lossy,q_auto/v1604715123/GettyImages-1052719678_dyt39m\",\n" +
        "      \"publishedAt\": \"2020-11-07T02:17:00Z\",\n" +
        "      \"content\": \"Tucker Carlson laid out a fevered vision of American life under a Joe Biden presidency Friday night on his show, imagining government-mandated coffee consumption as the final modicum of freedom to be… [+500 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": \"nbc-news\", \"name\": \"NBC News\" },\n" +
        "      \"author\": \"Alicia Victoria Lozano, Dennis Romero\",\n" +
        "      \"title\": \"Criminal justice reformer unseats Los Angeles district attorney - NBC News\",\n" +
        "      \"description\": \"Criminal justice reformer George Gascón unseated Los Angeles District Attorney Jackie Lacey, a target of Black Lives Matter-L.A. protests in recent years.\",\n" +
        "      \"url\": \"https://www.nbcnews.com/news/us-news/criminal-justice-reformer-unseats-los-angeles-district-attorney-n1246871\",\n" +
        "      \"urlToImage\": \"https://media4.s-nbcnews.com/j/newscms/2020_45/3426626/201106-george-gascon-jm-1848_880b90d906e253449d0e76a06e3b11d8.nbcnews-fp-1200-630.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T02:08:00Z\",\n" +
        "      \"content\": \"After a bitter race to lead the largest district attorney's office in the nation, reform candidate and former San Francisco D.A. George Gascón unseated Los Angeles County's first Black chief prosecut… [+4318 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": null, \"name\": \"CBS Sports\" },\n" +
        "      \"author\": \"\",\n" +
        "      \"title\": \"College football picks, schedule: Predictions against the spread, odds for big top 25 games in Week 10 - CBS Sports\",\n" +
        "      \"description\": \"A closer look at the top games on the slate in Week 10 of the 2020 college football season\",\n" +
        "      \"url\": \"https://www.cbssports.com/college-football/news/college-football-picks-schedule-predictions-against-the-spread-odds-for-big-top-25-games-in-week-10/\",\n" +
        "      \"urlToImage\": \"https://sportshub.cbsistatic.com/i/r/2020/11/01/c58f1543-ccdd-47c8-9cf1-452b24183427/thumbnail/1200x675/85fbb883f06b513cbf85a98e062a8287/trask.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T00:54:00Z\",\n" +
        "      \"content\": \"After a couple of \\\"down\\\" weeks with lacking big-time games, Week 10 of the 2020 college football season is set to deliver. Not only are there two games between top 10 teams, they are marquee games th… [+4561 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": null, \"name\": \"TigerNet\" },\n" +
        "      \"author\": \"TigerNet Staff\",\n" +
        "      \"title\": \"Official Clemson-Notre Dame hype video: Next Man Up - TigerNet\",\n" +
        "      \"description\": \"The No. 1-ranked Tigers released a hype video for their matchup with No. 4 Notre Dame Saturday night in South Bend, Indiana. The video, featuring Colin Cowherd\",\n" +
        "      \"url\": \"https://www.tigernet.com/update/Official-Clemson-Notre-Dame-hype-video-Next-Man-Up-36732\",\n" +
        "      \"urlToImage\": \"https://2cic.nyc3.cdn.digitaloceanspaces.com/t/stories/20/facebook/beatnd2.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T00:44:48Z\",\n" +
        "      \"content\": \"The No. 1-ranked Tigers released a hype video for their matchup with No. 4 Notre Dame Saturday night in South Bend, Indiana. \\r\\nThe video, featuring Colin Cowherd and Joey Galloway among pundits' anal… [+253 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": \"the-verge\", \"name\": \"The Verge\" },\n" +
        "      \"author\": \"Jay Peters\",\n" +
        "      \"title\": \"Watch the PS5 play PS4 games better than ever before - The Verge\",\n" +
        "      \"description\": \"A new video from Digital Foundry makes it immediately clear that the PS5 brings notable performance improvements to many PS4 games. The 30-minute video shows off a lot of big PS4 titles running on PS5.\",\n" +
        "      \"url\": \"https://www.theverge.com/2020/11/6/21553494/sony-playstation-5-ps5-backward-compatibility-ps4-digital-foundry\",\n" +
        "      \"urlToImage\": \"https://cdn.vox-cdn.com/thumbor/9YqEHdh0CEj9KKf9tmAT4jOFaXs=/0x132:2040x1200/fit-in/1200x630/cdn.vox-cdn.com/uploads/chorus_asset/file/22015304/vpavic_4278_20201030_0247.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T00:34:04Z\",\n" +
        "      \"content\": \"Many PS4 games get notable performance improvements on PS5\\r\\nPhoto by Vjeran Pavic / The Verge\\r\\nA new video from Digital Foundry makes it immediately clear that the PS5 brings notable performance impr… [+1021 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": \"fox-news\", \"name\": \"Fox News\" },\n" +
        "      \"author\": \"Caitlin McFall\",\n" +
        "      \"title\": \"Melania speaks out for the first time since Election Day, reflects on Be Best initiative - Fox News\",\n" +
        "      \"description\": \"First lady Melania Trump posted her first message since Election Day on Friday, reflecting on her youth initiative that addresses cyberbullying as votes continue to pour in for the 2020 presidential election.\",\n" +
        "      \"url\": \"https://www.foxnews.com/politics/melania-speaks-first-time-election-day-be-best\",\n" +
        "      \"urlToImage\": \"https://static.foxnews.com/foxnews.com/content/uploads/2020/11/AP20307794275407.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T00:15:44Z\",\n" +
        "      \"content\": \"First lady Melania Trump posted her first message since Election Day on Friday, reflecting on her youth initiative that addresses cyberbullying as votes continue to pour in for the 2020 presidential … [+2610 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": \"the-washington-post\", \"name\": \"The Washington Post\" },\n" +
        "      \"author\": \"Lenny Bernstein, Jacqueline Dupree\",\n" +
        "      \"title\": \"U.S. sets another daily record for coronavirus cases as some states struggle - The Washington Post\",\n" +
        "      \"description\": \"Illinois and North Dakota, among others, are reeling under the impact of the pandemic.\",\n" +
        "      \"url\": \"https://www.washingtonpost.com/health/coronavirus-record-high-cases/2020/11/06/fe665856-2066-11eb-90dd-abd0f7086a91_story.html\",\n" +
        "      \"urlToImage\": \"https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/Y7VCQERARAI6XORB6LYAD4CVJM.jpg&w=1440\",\n" +
        "      \"publishedAt\": \"2020-11-07T00:15:00Z\",\n" +
        "      \"content\": \"It is community spread everywhere, said Jaline Gerardin, an epidemiologist at Northwestern University Feinberg School of Medicine in Chicago. In part, the greater numbers are the result of the increa… [+5057 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": null, \"name\": \"BBC News\" },\n" +
        "      \"author\": \"https://www.facebook.com/bbcnews\",\n" +
        "      \"title\": \"Vienna shooting: The night my safe city lost its innocence - BBC News\",\n" +
        "      \"description\": \"The Austrian capital had four decades of relative peace before a gunman's rampage.\",\n" +
        "      \"url\": \"https://www.bbc.com/news/world-europe-54838016\",\n" +
        "      \"urlToImage\": \"https://ichef.bbci.co.uk/news/1024/branded_news/42D2/production/_115260171_wien2.jpg\",\n" +
        "      \"publishedAt\": \"2020-11-07T00:01:00Z\",\n" +
        "      \"content\": \"By Bethany BellBBC News, Vienna\\r\\nimage copyrightGetty Images\\r\\nimage captionAustrians observed three days of mourning and lit candles at the scene of the Vienna attack\\r\\nIn recent years, Vienna has bui… [+5633 chars]\"\n" +
        "    },\n" +
        "    {\n" +
        "      \"source\": { \"id\": null, \"name\": \"Post Magazine\" },\n" +
        "      \"author\": null,\n" +
        "      \"title\": \"How new fintech rules stunned Jack Ma, wiped out Ant Group’s IPO - South China Morning Post\",\n" +
        "      \"description\": \"We lay out a timeline of the key events leading up to China halting Ant’s IPO in Shanghai and Hong Kong at the eleventh hour.\",\n" +
        "      \"url\": \"https://www.scmp.com/business/banking-finance/article/3108795/explainer-how-avalanche-rules-buries-ant-groups-us395\",\n" +
        "      \"urlToImage\": \"https://cdn.i-scmp.com/sites/default/files/styles/og_image_scmp_explainer/public/d8/images/methode/2020/11/07/b2bb2da6-1f48-11eb-99d6-deeedd63f648_image_hires_094058.jpg?itok=_cPsBSP9&v=1604713273\",\n" +
        "      \"publishedAt\": \"2020-11-07T00:00:30Z\",\n" +
        "      \"content\": \"Published: 8:00am, 7 Nov, 2020\\r\\nUpdated: 9:41am, 7 Nov, 2020\"\n" +
        "    }\n" +
        "  ]\n" +
        "}\n"