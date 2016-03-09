package com.eugnikolaev.linkparser
import com.eugnikolaev.linkparser.LinkParser;

import spock.lang.Specification;

class LinkParserSpec extends Specification {

	def "Parses links"() {
		given:
		String html = new File("src/test/resources/coap.technology.html").text
		def instance = new LinkParser(html)

		when:
		def result = instance.parse()

		then:
		result.size() == 11
		result.contains("/spec.html")
	}

	def "null payload is not allowed"() {
		when:
		new LinkParser(null).parse()
		
		then:
		thrown(RuntimeException)
	}
}

