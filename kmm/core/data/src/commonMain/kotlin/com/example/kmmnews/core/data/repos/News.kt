package com.example.kmmnews.core.data.repos

import com.example.kmmnews.core.data.dtos.ApiResponse
import com.example.kmmnews.core.data.dtos.NewsArticle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface News {
    suspend fun getNewForCountry(name: String): Flow<ApiResponse<List<NewsArticle>>>
}

class FakeNews : News {
    override suspend fun getNewForCountry(name: String): Flow<ApiResponse<List<NewsArticle>>> {
        return flow {
            emit(
                ApiResponse.Success(
                    newsArticles
                )
            )
        }
    }
}


val newsArticles = listOf(
    NewsArticle(
        source = NewsArticle.Source(
            "engadget",
            "Engadget"
        ),
        author = "Lawrence Bonk",
        title = "Venmo now lets you send crypto to other users for some reason",
        description = "Paypal-owned money transfer service Venmo dipped its toes into cryptocurrencies in 2021 after opening up an in-app trading platform.\r\n That was just for individuals to buy or sell crypto. Now, the company is going further into the once-heralded digital curren…",
        url = "",
        urlToImage = "https://s.yimg.com/uu/api/res/1.2/LKRH31mzL9wqtcqoQ_lkjw--~B/Zmk9ZmlsbDtoPTYzMDtweW9mZj0wO3c9MTIwMDthcHBpZD15dGFjaHlvbg--/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-uploaded-images/2023-04/835a5670-e5f4-11ed-9db6-3febf57b7a4a.cf.jpg",
        publishedAt = "2023-04-28T19:20:15Z",
        content = "Paypal-owned money transfer service Venmo dipped its toes into cryptocurrencies in 2021 after opening up an in-app trading platform.\r\n That was just for individuals to buy or sell crypto. Now, the co… [+1625 chars]"
    ),
    NewsArticle(
        source = NewsArticle.Source(
            name ="Gizmodo.com"
        ),
        author = "Kyle Barr",
        title = "Bitcoin Pyramid Scheme Fraudster Ordered to Pay \$3.4 Billion",
        description = "The Commodities Futures Trading Commission patted itself on the back for winning one of the largest civil cases against a crypto crook, even if most—or any—of those affected will see any of their money returned. On Thursday, a Texas judge issued a default jud…",
        url = "",
        urlToImage = "https://i.kinja-img.com/gawker-media/image/upload/c_fill,f_auto,fl_progressive,g_center,h_675,pg_1,q_80,w_1200/16e5700ae24064ff50deef40ec83875d.jpg",
        publishedAt = "2023-04-28T14:35:25Z",
        content = "The Commodities Futures Trading Commission patted itself on the back for winning one of the largest civil cases against a crypto crook, even if mostor anyof those affected will see any of their money… [+3594 chars]"
    ),
    NewsArticle(
        source = NewsArticle.Source(
            "engadget",
            "Engadget"
        ),
        author = "Mariella Moon",
        title = "White House proposes 30 percent tax on electricity used for crypto mining",
        description = "The Biden administration wants to impose a 30 percent tax on the electricity used by cryptocurrency mining operations, and it has included the proposal in its budget for the fiscal year of 2024. In a blog post on the White House website, the administration ha…",
        url = "",
        urlToImage = "https://s.yimg.com/uu/api/res/1.2/_0lUWxV0epaYKnRPQ1.Jxw--~B/Zmk9ZmlsbDtoPTYzMDtweW9mZj0wO3c9MTIwMDthcHBpZD15dGFjaHlvbg--/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-uploaded-images/2023-05/5d8f2740-e97d-11ed-b4b3-dfb213c6d348.cf.jpg",
        publishedAt = "2023-05-03T09:03:42Z",
        content = "The Biden administration wants to impose a 30 percent tax on the electricity used by cryptocurrency mining operations, and it has included the proposal in its budget for the fiscal year of 2024. In a… [+3408 chars]"
    ),
)