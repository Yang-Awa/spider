package edu.csuft.wxy.spider;

/**
 * 影片
 * @author 19812
 *
 */

public class Film implements Comparable<Film>{
	
	/**
	 * 名称
	 */
    String title;
    
    /**
           * 相关信息
     */
    String info;
    
    /**
           *评分
     */
    double rating;
    
    /**
           *评分人数
     */
    int num;
    
    /**
           *排名
     */
    int id;
    
    /**
           *海报
     */
    String poster;
    
    /**
           *短评
     */
    String quote;
    
    /**
     * 影片详细信息的路径
     * @return
     */
    String url;
    
    //无参数的构造方法
    public Film() {	
    }
    
    //getter/setter
    public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getInfo() {
		return info;
	}




	public void setInfo(String info) {
		this.info = info;
	}




	public double getRating() {
		return rating;
	}




	public void setRating(double rating) {
		this.rating = rating;
	}




	public int getNum() {
		return num;
	}




	public void setNum(int num) {
		this.num = num;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getPoster() {
		return poster;
	}




	public void setPoster(String poster) {
		this.poster = poster;
	}




	public String getQuote() {
		return quote;
	}




	public void setQuote(String quote) {
		this.quote = quote;
	}




	public String getUrl() {
		return url;
	}




	public void setUrl(String url) {
		this.url = url;
	}




	public String toCSV() {
    	return String.format("%d,%s,%d,%.1f\n", 
    			id,
    			title,
    			num,
    			rating);
    }

	

	@Override
	public String toString() {
		return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", url=" + url + "]";
	}



	@Override
	public int compareTo(Film o) {
		
		return id - o.id;
	}
    
    
    
}
