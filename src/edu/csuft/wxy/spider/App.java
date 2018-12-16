package edu.csuft.wxy.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * ��������/���
 * @author 19812
 *
 */
public class App {

	// alt + /  ��ݼ�     �ȴ�main
 	
	public static void main(String[] args) {
		
		//Ŀ�� URL
		String url="https://movie.douban.com/top250";
		
		//ʹ��JSOUP ץȡ�ĵ�
		//alt +/
		try {
			Document doc = Jsoup.connect(url).get();
			
			Elements es =doc.select(".grid_view .item");
//			classǰ��Ҫ�ӡ�.��
			System.out.println(es.size());
			
			for(Element e :es) {
//				ÿһ��ӰƬ
			Element t=e.select(".title").first();
			String num=e.select(".star span").last().text();
				System.out.println(t.text()+","+num);
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
