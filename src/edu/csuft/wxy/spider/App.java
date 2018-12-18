package edu.csuft.wxy.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 程序的入口/起点
 * @author 19812
 *
 */
public class App {

	// alt + /  快捷键     先打main
 	
	public static void main(String[] args) {
		
		//目标 URL
		String url="https://movie.douban.com/top250";
		
		//使用JSOUP 抓取文档
		//alt + /
		try {
			Document doc = Jsoup.connect(url).get();
//			集合多个
			Elements es =doc.select(".grid_view .item");
//			class前需要加“.”
//			集合一个
//			Elements e =doc.selectFirst("");
			System.out.println(es.size());
			
			//创建一个存储影片的列表
			ArrayList<Film> list = new ArrayList<>();
			
			for(Element e :es) {
				Film f = new Film();
////				每一部影片
//			Element t=e.select(".title").first();
//			String num=e.select(".star span").last().text();
//				System.out.println(t.text()+","+num);
				
				f.id=Integer.parseInt(e.select(".pic em").first().text());
				f.poster = e.select("img").first().attr("src");
				f.info = e.select(".bd p").first().text();
				f.title = e.select(".title").first().text();
				f.rating =Double.parseDouble( e.select(".rating_num").first().text());
				String num =e.select(".star span").last().text();
				f.num =Integer.parseInt(num.substring(0, num.length()-3));
				f.quote = e.select(".inq").first().text();
				
				System.out.println(f);
				list.add(f);
			}
			
//			String title=doc.title();
//			String html=doc.html();
//			String data=doc.data();
//			
//			System.out.println(title);
//			System.out.println(html);
//			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
