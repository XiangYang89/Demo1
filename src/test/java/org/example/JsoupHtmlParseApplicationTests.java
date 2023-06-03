package org.example;


import org.example.domain.Book;
import org.example.mapper.BookMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URL;

@SpringBootTest(classes = JsoupDemoDay3App.class)
@RunWith(SpringRunner.class)
public class JsoupHtmlParseApplicationTests {
    @Autowired
    private BookMapper bookMapper;
    @Test
    public void contextLoads() throws IOException {
        String url = "http://search.jd.com/Search?keyword=java";
        Document document = Jsoup.parse(new URL(url), 30000);
        Element jGoodsList = document.getElementById("J_goodsList");
        Elements elements = jGoodsList.getElementsByTag("li");
        int id = 0;
        for (Element el : elements) {
            Book book = new Book();
            id++;
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String name = el.getElementsByClass("p-name").eq(0).text();
            book.setId(id);
            book.setImg(img);
            book.setName(name);
            book.setPrice(price);
            bookMapper.insert(book);
            System.out.println(book);
        }
        System.out.println("批量插入数据成功");
    }
}
