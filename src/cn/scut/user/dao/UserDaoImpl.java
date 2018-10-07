package cn.scut.user.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.tree.BaseElement;
import org.dom4j.tree.DefaultEntity;

import cn.scut.domain.User;
import cn.scut.domain.User_login;

public class UserDaoImpl implements UserDao {
	private String path = "D:/Programming/Workspaces/MyEclipse 2015/user/WebRoot/userpage/users.xml";

	public User findByName(String username)  {
		SAXReader sReader = new SAXReader();
		Document document=null;
		try {
			document = sReader.read(path);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element element = document.getRootElement();
		User user = new User();
		if (element.element("user") != null) {
			Iterator<Element> iterator = element.elementIterator("user");
			for (Iterator<Element> it = iterator; it.hasNext();) {
				Element userElement = it.next();
				Attribute usernameAttribute = userElement.attribute("username");
				if (username.equals(usernameAttribute.getText())) {
					user.setUsername(usernameAttribute.getText());
					user.setPassword(userElement.attributeValue("password"));
					
					return user;

				}
			}
		}

		return null;
	}

	public User_login findByNames(String username)  {
		SAXReader sReader = new SAXReader();
		Document document=null;
		try {
			document = sReader.read(path);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element element = document.getRootElement();
		User_login user = new User_login();
		if (element.element("user") != null) {
			Iterator<Element> iterator = element.elementIterator("user");
			for (Iterator<Element> it = iterator; it.hasNext();) {
				Element userElement = it.next();
				Attribute usernameAttribute = userElement.attribute("username");
				if (username.equals(usernameAttribute.getText())) {
					user.setUsername(usernameAttribute.getText());
					user.setPassword(userElement.attributeValue("password"));
					
					return user;

				}
			}
		}

		return null;
	}

	public void add(User user) throws DocumentException, IOException  {
		SAXReader sReader = new SAXReader();
		Document document = sReader.read(new File(path));
		Element element = document.getRootElement();
		Element userElement = element.addElement("user");
		
		
		userElement.addAttribute("username", user.getUsername());
		userElement.addAttribute("password", user.getPassword());
		
		

		XMLWriter xWriter = new XMLWriter(new FileOutputStream(path),
				OutputFormat.createPrettyPrint());
		xWriter.write(document);
	}
}
