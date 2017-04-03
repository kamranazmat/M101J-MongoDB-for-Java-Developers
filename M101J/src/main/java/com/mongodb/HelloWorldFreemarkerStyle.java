package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kamran on 3/26/2017.
 */
public class HelloWorldFreemarkerStyle {
    public static void main(String[] args) {
        //Freemarker configuration object
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");

        try {
            //Load template from source folder
            Template helloTemplate = configuration.getTemplate("hello.ftl");

            // Build the data-model
            Map<String, Object> helloMap = new  HashMap<String, Object>();
            helloMap.put("name", "Kamran");

            // Console output
            StringWriter writer = new StringWriter();
            helloTemplate.process(helloMap, writer);
            System.out.println(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}