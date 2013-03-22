/**
 * 
 */
package com.dehoo.softdownload;

import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author dehoo-ZhongHeliang 2013-3-21下午21:00:34
 * @version jdk 1.6; sdk 4.2.0
 */
public class ParseXmlService
{
	public HashMap<String, String> parseXml(InputStream inStream) throws Exception
	{
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		// 实例化一个文档构建器工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// 通过文档构建器工厂获取一个文档构建器
		DocumentBuilder builder = factory.newDocumentBuilder();
		// 通过文档通过文档构建器构建一个文档实例
		Document document = builder.parse(inStream);
		//获取XML文件根节点
		Element root = document.getDocumentElement();
		//获得所有子节点------------很关键
		NodeList childNodes = root.getChildNodes();
		for (int j = 0; j < childNodes.getLength(); j++)
		{
			//遍历子节点
			Node childNode = (Node) childNodes.item(j);
			if (childNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element childElement = (Element) childNode;
				// 获取版本号
				if ("version".equals(childElement.getNodeName()))
				{
					hashMap.put("version",childElement.getFirstChild().getNodeValue());
				}
				// 得到软件名称
				else if (("name".equals(childElement.getNodeName())))
				{
					hashMap.put("name",childElement.getFirstChild().getNodeValue());
				}
				// 获取下载地址
				else if (("url".equals(childElement.getNodeName())))
				{
					hashMap.put("url",childElement.getFirstChild().getNodeValue());
				}
			}
		}
		return hashMap;
	}
}
