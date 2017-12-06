package com.jeju.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.jeju.dto.JejuDto;

import com.jeju.dao.SqlMapConfig;

public class JejuDao_bar extends SqlMapConfig implements JejuDao {

	public static void main(String[] args) throws IOException {
		JejuDao_bar dao = new JejuDao_bar();
		dao.foodInsert();
		dao.beachInsert();
		dao.gallary();
		dao.stay();
	}

	public void beachInsert() throws IOException {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(false);
		int res = 0;
		int i = 1;
		int j = 0;
		String url = "http://extinfo.seantour.com/acd/api/tour_api.do?sortCode=00100300" + i
				+ "&sido=5000000000&pageIndex=" + j
				+ "&serviceKey=t7MsNQbKeAKtZGJGk32fV1v5MEBVD9TyD7xdXh8Ly%2Fy4PV9yRkLObgx40ZG%2BsG6ThfXRGz3iuqrJ6l5YhTHtwA%3D%3D";

		for (i = 1; i < 3; i++) {
			Document doc = Jsoup.connect(url).get();
			int count = Integer.parseInt(doc.select("response body totalCount").text());
			for (j = 0; j < count; j++) {
				url = "http://extinfo.seantour.com/acd/api/tour_api.do?sortCode=00100300" + i
						+ "&sido=5000000000&pageIndex=" + j
						+ "&serviceKey=t7MsNQbKeAKtZGJGk32fV1v5MEBVD9TyD7xdXh8Ly%2Fy4PV9yRkLObgx40ZG%2BsG6ThfXRGz3iuqrJ6l5YhTHtwA%3D%3D";
				doc = Jsoup.connect(url).get();

				if (count > 0) {
					Elements items = doc.select("item:nth-of-type(1)");

					try {
						for (Element item : items) {
							JejuDto dto = new JejuDto();
							res = 0;
							session = getSqlSessionFactory().openSession(false);
							dto.setTemaNo(1);
							dto.setSortName(item.select("sortname").text());
							dto.setTitle(item.select("title").text());
							dto.setxMap(Double.parseDouble(item.select("xmap").text()));
							dto.setyMap(Double.parseDouble(item.select("ymap").text()));
							dto.setAddr(item.select("addr").text());
							dto.setPhone(item.select("phone").text());
							dto.setHomePage(item.select("homepage").text());
							dto.setDescription(item.select("description").text());

							res = session.insert("com.jeju.insert", dto);

							if (res > 0) {
								session.commit();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						session.rollback();
					} finally {
						session.close();
					}
				}
			}
		}
		System.out.println("완료");
	}

	public void gallary() throws IOException {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(false);
		int res = 0;
		int i = 1;
		int j = 0;
		String url = "http://extinfo.seantour.com/acd/api/tour_api.do?sortCode=00100600" + i
				+ "&sido=5000000000&pageIndex=" + j
				+ "&serviceKey=t7MsNQbKeAKtZGJGk32fV1v5MEBVD9TyD7xdXh8Ly%2Fy4PV9yRkLObgx40ZG%2BsG6ThfXRGz3iuqrJ6l5YhTHtwA%3D%3D";

		for (i = 1; i < 3; i++) {
			Document doc = Jsoup.connect(url).get();
			int count = Integer.parseInt(doc.select("response body totalCount").text());
			for (j = 0; j < count; j++) {
				url = "http://extinfo.seantour.com/acd/api/tour_api.do?sortCode=00100600" + i
						+ "&sido=5000000000&pageIndex=" + j
						+ "&serviceKey=t7MsNQbKeAKtZGJGk32fV1v5MEBVD9TyD7xdXh8Ly%2Fy4PV9yRkLObgx40ZG%2BsG6ThfXRGz3iuqrJ6l5YhTHtwA%3D%3D";
				doc = Jsoup.connect(url).get();

				if (count > 0) {
					Elements items = doc.select("item:nth-of-type(1)");

					try {
						for (Element item : items) {
							JejuDto dto = new JejuDto();
							res = 0;
							session = getSqlSessionFactory().openSession(false);
							dto.setTemaNo(2);
							dto.setSortName(item.select("sortname").text());
							dto.setTitle(item.select("title").text());
							dto.setxMap(Double.parseDouble(item.select("xmap").text()));
							dto.setyMap(Double.parseDouble(item.select("ymap").text()));
							dto.setAddr(item.select("addr").text());
							dto.setPhone(item.select("phone").text());
							dto.setHomePage(item.select("homepage").text());
							dto.setDescription(item.select("description").text());

							res = session.insert("com.jeju.insert", dto);

							if (res > 0) {
								session.commit();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						session.rollback();
					} finally {
						session.close();
					}
				}

			}
		}
		System.out.println("완료");
	}

	public void stay() throws IOException {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(false);
		int res = 0;
		int i = 1;
		int j = 0;
		String url = "http://extinfo.seantour.com/acd/api/tour_api.do?sortCode=00200" + i
				+ "&sido=5000000000&pageIndex=" + j
				+ "&serviceKey=t7MsNQbKeAKtZGJGk32fV1v5MEBVD9TyD7xdXh8Ly%2Fy4PV9yRkLObgx40ZG%2BsG6ThfXRGz3iuqrJ6l5YhTHtwA%3D%3D";

		
		for (i = 1; i < 7; i++) {
			Document doc = Jsoup.connect(url).get();
			int count = Integer.parseInt(doc.select("response body totalCount").text());
			for (j = 0; j < count; j++) {
				url = "http://extinfo.seantour.com/acd/api/tour_api.do?sortCode=00200" + i
						+ "&sido=5000000000&pageIndex=" + j
						+ "&serviceKey=t7MsNQbKeAKtZGJGk32fV1v5MEBVD9TyD7xdXh8Ly%2Fy4PV9yRkLObgx40ZG%2BsG6ThfXRGz3iuqrJ6l5YhTHtwA%3D%3D";
				doc = Jsoup.connect(url).get();

				if (count > 0) {
					Elements items = doc.select("item:nth-of-type(1)");

					try {
						for (Element item : items) {
							JejuDto dto = new JejuDto();
							res = 0;
							session = getSqlSessionFactory().openSession(false);
							dto.setTemaNo(3);
							dto.setSortName(item.select("sortname").text());
							dto.setTitle(item.select("title").text());
							dto.setxMap(Double.parseDouble(item.select("xmap").text()));
							dto.setyMap(Double.parseDouble(item.select("ymap").text()));
							dto.setAddr(item.select("addr").text());
							dto.setPhone(item.select("phone").text());
							dto.setHomePage(item.select("homepage").text());
							dto.setDescription(item.select("description").text());

							res = session.insert("com.jeju.insert", dto);

							if (res > 0) {
								session.commit();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						session.rollback();
					} finally {
						session.close();
					}
				}
			}
		}
		System.out.println("완료");
	}

	public void foodInsert() throws IOException {
		SqlSession session = null;
		session = getSqlSessionFactory().openSession(false);
		int res = 0;
		int i = 1;
		int j = 0;
		String url = "http://extinfo.seantour.com/acd/api/tour_api.do?sortCode=00300" + i
				+ "&sido=5000000000&pageIndex=" + j
				+ "&serviceKey=t7MsNQbKeAKtZGJGk32fV1v5MEBVD9TyD7xdXh8Ly%2Fy4PV9yRkLObgx40ZG%2BsG6ThfXRGz3iuqrJ6l5YhTHtwA%3D%3D";

		for (i = 1; i < 5; i++) {
			Document doc = Jsoup.connect(url).get();
			int count = Integer.parseInt(doc.select("response body totalCount").text());
			for (j = 0; j < count; j++) {
				url = "http://extinfo.seantour.com/acd/api/tour_api.do?sortCode=00300" + i
						+ "&sido=5000000000&pageIndex=" + j
						+ "&serviceKey=t7MsNQbKeAKtZGJGk32fV1v5MEBVD9TyD7xdXh8Ly%2Fy4PV9yRkLObgx40ZG%2BsG6ThfXRGz3iuqrJ6l5YhTHtwA%3D%3D";
				doc = Jsoup.connect(url).get();

				if (count > 0) {
					Elements items = doc.select("item:nth-of-type(1)");

					try {
						for (Element item : items) {
							JejuDto dto = new JejuDto();
							res = 0;
							session = getSqlSessionFactory().openSession(false);
							dto.setTemaNo(4);
							dto.setSortName(item.select("sortname").text());
							dto.setTitle(item.select("title").text());
							dto.setxMap(Double.parseDouble(item.select("xmap").text()));
							dto.setyMap(Double.parseDouble(item.select("ymap").text()));
							dto.setAddr(item.select("addr").text());
							dto.setPhone(item.select("phone").text());
							dto.setHomePage(item.select("homepage").text());
							dto.setDescription(item.select("description").text());

							res = session.insert("com.jeju.insert", dto);

							if (res > 0) {
								session.commit();
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
						session.rollback();
					} finally {
						session.close();
					}
				}
			}
		}
		System.out.println("완료");
	}
}
