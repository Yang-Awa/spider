package edu.csuft.wxy.spider;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 程序的入口/起点
 * @author 19812
 *
 */
public class App {

	// alt + /  快捷键     先打main
 	
	public static void main(String[] args) {
		
		//线程池
		//固定大小
		ExecutorService pool = Executors.newFixedThreadPool(4);
		
		//无限（缓存）
		pool = Executors.newCachedThreadPool();
		//一个线程
//		pool = Executors.newSingleThreadExecutor();
		
		ArrayList<Film> list = new ArrayList<>();
		String url = "https://movie.douban.com/top250?start=";
		for (int i = 0;i < 10; i++) {
			String path = String .format("%s%d", url, i*25);
			pool.submit(new Spider(path,list));
		}
		pool.shutdown();
		System.out.println(pool.isTerminated());
		
		while(!pool.isTerminated()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//数据排序
		Collections.sort(list);
		System.out.println(list.size());
				
		//导入数据库中
		//myBatis/iBatis
		try {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("conlig.xml"));
			//打开会话
			SqlSession session = factory.openSession();
			
			//动态代理
			FilmMapper mapper = (FilmMapper) session.getMapper(FilmMapper.class);
			
			for (Film f : list) {
				//使用注解中INSERT语句存储到数据库
				mapper.save(f);
			}
			
			session.commit();
			session.close();
			System.out.println("完成存储");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		ExecutorService pool2 = Executors.newFixedThreadPool(4);
//		
//		for(Film film:list) {
//			System.out.println(film.url);
//			pool2.execute(new SpiderFilmDetail(film.url,null));
//		}
//		pool2.shutdown();
		
//		//写入文件 电子表格兼容模式
//		String file = "d:/film.csv";    //绝对路径
//		file = "film.csv";              //当前位置
//		//排序
//		Collections.sort(list);
//		//io
//		try (FileWriter out = new FileWriter(file)) {
//			//FileWriter(file true) file后面加入ture ->可以在之前的数据后面追加数据
//			//FileWriter(file,Charset.)
//			//写数据
//			for (Film film : list) {
//				out.write(film.toCSV());
//			}
//			System.out.println("ok");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		
		
		
		
	}
	
}
