package ua.epam.sergiishapoval.homework.hw17.jaxb;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат+
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"+
Вывести на консоль все теги, которые соответствуют заданному тегу+
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле+
Количество пробелов, \n, \r не влияют на результат+
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету+
Тег может содержать вложенные теги+
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми+
*/


public class MyJaxb {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Path path = Paths.get("src/ua/epam/sergiishapoval/homework/hw17/jaxb/test1.html");
        
        String string = path.toAbsolutePath().toString();

        BufferedReader fileReader1 = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString()),"UTF-8"));
        ArrayList<String> content = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        StringBuilder allContent= new StringBuilder();
        boolean isFirst = true;
        while (fileReader1.ready()) {
            if (isFirst){
                isFirst = false;
            }else {
                allContent.append("\n");
            }
            allContent.append(fileReader1.readLine());
        }
        
        fileReader1.close();

        System.out.println("Please, enter tag to look for");
        String tag = reader.readLine();
        reader.close();
        
        String[] beginTagStrings = allContent.toString().split("<\\s*" + tag + "\\s*>");
        String endTagPattern ="<\\s*/\\s*" + tag + "\\s*>";
        isFirst = true;
        for (String tagPossibleBody : beginTagStrings){
            if (isFirst) {
                isFirst = false;
                continue;
            }

            String[] tagBodiesFict = tagPossibleBody.split(endTagPattern);
            if (tagBodiesFict.length > 0){
                System.out.println(tagBodiesFict[0]);
            }
        }
        
    }
}
