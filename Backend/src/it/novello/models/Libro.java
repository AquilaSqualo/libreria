package it.novello.models;

public class Libro {
	private int id;
	private String title;
	private String subTitle;
	private Autore author;
	private String editor;
	private int year;
	private int pages;
	private int bookmark = 0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public Autore getAuthor() {
		return author;
	}
	public void setAuthor(Autore author) {
		this.author = author;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getBookmark() {
		return bookmark;
	}
	public void setBookmark(int bookmark) {
		this.bookmark = bookmark;
	}
}
