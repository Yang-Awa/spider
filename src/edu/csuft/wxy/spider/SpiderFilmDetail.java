package edu.csuft.wxy.spider;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class SpiderFilmDetail implements  Runnable{
	/**
	 * 影片的URL
	 */
	String url;
	
	/**
	 * 影片列表
	 */
	List<Film> list;
	
	public SpiderFilmDetail(String url, List<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}

	public void run() {
		
		try {
			Document doc = Jsoup.connect(url).get();
			Element e =doc.getElementById("content");
			
			String name = e.selectFirst("h1 span").text(); 
			String year = e.selectFirst(".year").text();
			
			String director = e.select("#info span").get(0).selectFirst(".attrs a").text();
			String script = e.select("#info .attrs").get(1).text();
			String actor = e.selectFirst(".actor .attrs").text();
			
			System.out.println(name);
			System.out.println(year);
			System.out.println(director);
			System.out.println(script);
			System.out.println(actor);
			
			System.out.printf("%s,%s,%s,%s\n",
					name,
					year,
					director,
					script);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}

