package lmc.entity;
import java.io.Serializable;
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bookName = null;
	private float bookPrice = 0.0f;
	public Book(String bookName, float bookPrice) {
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
}