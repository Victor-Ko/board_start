package com.victor.board.common.util;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(XmlUtil.class);


	/**
	 * Document의 Root엘리먼트를 반환한다.
	 * @param xmlStr 
	 * @return Root엘리먼트
	 */
	public static Element getDocumentElements(String xmlStr) {
		
		DocumentBuilderFactory factory = null;
		DocumentBuilder loader = null;
		Document document = null;
		Element root = null;
		try {
			factory = DocumentBuilderFactory.newInstance();
			loader = factory.newDocumentBuilder();

			document = loader.parse(new InputSource(new StringReader(xmlStr)));
			root = document.getDocumentElement();

			return root;
			
		} catch (IOException ex) {
			logger.info("", ex);
		} catch (SAXException ex) {
			logger.info("", ex);
		} catch (ParserConfigurationException ex) {
			logger.info("", ex);
		} catch (FactoryConfigurationError ex) {
			logger.info("", ex);
		} catch (NullPointerException ex) {
			logger.info("", ex);
		}
		
		return null;
	}
	
	/**
	 * XML로부터 주어진 노드의 값을 반환한다.
	 * @param strXml XML
	 * @param unqKey 지정노드 이름
	 * @return 지정노드의 값 (지정 노드가 복수의 경우 첫번째 노드의 값)
	 */
	public static String getValueFromUnqItem(String strXml, String unqKey) {
		Element root = getDocumentElements(strXml);
		return getValueFromUnqItem(root, unqKey);
	}

	/**
	 * Root엘리먼트로부터 주어진 노드의 값을 반환한다.
	 * @param el 검색을 시작할 최상위 엘리먼트
	 * @param unqKey 지정노드 이름
	 * @return 지정노드의 값 (지정 노드가 복수의 경우 첫번째 노드의 값)
	 */
	public static String getValueFromUnqItem(Element el, String unqKey) {
		if (el != null) {
			NodeList items = el.getElementsByTagName(unqKey);
			if (items.getLength() > 0) {
				return items.item(0).getFirstChild().getNodeValue();
			}
		} 

		return null;
	}
}
