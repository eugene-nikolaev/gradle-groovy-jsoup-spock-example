package com.eugnikolaev.linkparser
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class LinkParser {
	def html
	
	public LinkParser(String html) {
		this.html = html
	}
	
	def parse() {
		if (html == null) {
			throw RuntimeException("null payload is not allowed")
		}
		Document doc = Jsoup.parse(html)
		Elements links = doc.select("a[href]")
		links.collect { it.attr("href") }
	}
}
