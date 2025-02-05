package com.alice.other;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.Element;
import org.dom4j.dom.DOMElement;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

/**
 * 传统项目转maven 生成pom 依赖jar
 * 2020年7月28日18:08:07
 */
public class Print_jarTopom {

    public static void main(String[] args) {
        Element dependencys = new DOMElement("dependencys");
        File dir = new File("D:\\isoftstone\\dev_20200616\\branch_init\\rules_nvhl\\WebRoot\\WEB-INF\\lib"); //需生成pom.xml 文件的 lib路径

//        D:\isoftstone\dev_20200616\branch_init\rules_nvhl\WebRoot\WEB-INF\lib

        //C:/Users/huanglei/Desktop/KinderGartenManage (1)/WebRoot/WEB-INF/lib
        try {
            for (File jar : dir.listFiles()) {
                JarInputStream jis = new JarInputStream(new FileInputStream(jar));
                Manifest mainmanifest = jis.getManifest();
                jis.close();
                String bundleName = mainmanifest.getMainAttributes().getValue("Bundle-Name");
                String bundleVersion = mainmanifest.getMainAttributes().getValue("Bundle-Version");
                Element ele = null;
                /* System.out.println(jar.getName());*/
                StringBuffer sb = new StringBuffer(jar.getName());
                if (bundleName != null) {
                    bundleName = bundleName.toLowerCase().replace(" ", "-");
                    sb.append(bundleName + "\t").append(bundleVersion);
                    ele = getDependices(bundleName, bundleVersion);
     /* System.out.println(sb.toString());
     System.out.println(ele.asXML());*/
                }
                if (ele == null || ele.elements().size() == 0) {
                    bundleName = "";
                    bundleVersion = "";
                    String[] ns = jar.getName().replace(".jar", "").split("-");
                    for (String s : ns) {
                        if (Character.isDigit(s.charAt(0))) {
                            bundleVersion += s + "-";
                        } else {
                            bundleName += s + "-";
                        }
                    }
                    if (bundleVersion.endsWith("-")) {
                        bundleVersion = bundleVersion.substring(0, bundleVersion.length() - 1);
                    }
                    if (bundleName.endsWith("-")) {
                        bundleName = bundleName.substring(0, bundleName.length() - 1);
                    }
                    ele = getDependices(bundleName, bundleVersion);
                    sb.setLength(0);
                    sb.append(bundleName + "\t").append(bundleVersion);
                    /* System.out.println(sb.toString());*/
                    System.out.println(ele.asXML());
                    /* savepomFile(dependencys.asXML()+"\r\n");*/
                }
                ele = getDependices(bundleName, bundleVersion);
                if (ele.elements().size() == 0) {
                    ele.add(new DOMElement("groupId").addText("not find"));
                    ele.add(new DOMElement("artifactId").addText(bundleName));
                    ele.add(new DOMElement("version").addText(bundleVersion));
                }
                dependencys.add(ele);
                /* System.out.println();*/
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* System.out.println(dependencys.asXML());*/
        savepomFile(dependencys.asXML());
    }

    private static void savepomFile(String asXML) {
        FileWriter fwriter;
        fwriter = null;
        try {
            fwriter = new FileWriter("C:\\Users\\liusc\\Desktop\\pom.txt");
            fwriter.write(asXML);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fwriter.flush();
                fwriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static Element getDependices(String key, String ver) {
        Element dependency = new DOMElement("dependency");
        // 设置代理
        // System.setProperty("http.proxyHost", "127.0.0.1");
        // System.setProperty("http.proxyPort", "8090");
        try {
            String url = "http://search.maven.org/solrsearch/select?q=a%3A%22" + key + "%22%20AND%20v%3A%22" + ver + "%22&rows=3&wt=json";
            org.jsoup.nodes.Document doc = Jsoup.connect(url).ignoreContentType(true).timeout(30000).get();
            String elem = doc.body().text();
            JSONObject response = JSONObject.parseObject(elem).getJSONObject("response");
            if (response.containsKey("docs") && response.getJSONArray("docs").size() > 0) {
                JSONObject docJson = response.getJSONArray("docs").getJSONObject(0);
                Element groupId = new DOMElement("groupId");
                Element artifactId = new DOMElement("artifactId");
                Element version = new DOMElement("version");
                groupId.addText(docJson.getString("g"));
                artifactId.addText(docJson.getString("a"));
                version.addText(docJson.getString("v"));
                dependency.add(groupId);
                dependency.add(artifactId);
                dependency.add(version);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dependency;
    }
}

