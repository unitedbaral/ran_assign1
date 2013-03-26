
package displayingform;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 *
 
 */
public class Extract {
       Field[] fields;
        String[] valextract;
    public void printAttribute(Class cl){
       fields = cl.getFields();
        valextract = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            valextract[i] = fields[i].getName().toString();
   
        }
        

    }

    public void javaToHtmlConverter() throws IOException {
        String str; 
        StringBuilder htmlform = new StringBuilder();
        htmlform.append("<html><head><title>Java To HTML</title></head><body><table><tr>");
        try {   
               File file = new File("myform.html");
                 FileWriter writer = new FileWriter(file);
            try (BufferedWriter bufferwriter = new BufferedWriter(writer)) {
                int i =0;
                
                while(i<valextract.length){
                    str= valextract[i];
                    htmlform.append("<td>");
                    htmlform.append(str);
                    htmlform.append("</td><td><input type=text name="+str+"name");
                    htmlform.append("</td></tr>");
                    i++;
               }
                htmlform.append("</table></body>");
                htmlform.append("<input type=submit value=submit>");
//                 System.out.println("output is:"+htmlform);
               
               bufferwriter.write(htmlform.toString());
            }
                
        }
           catch (Exception ex) {
                System.out.println(ex);
            }
        }
       
        


    

    public static void main(String[] args) throws Exception {
        Extract ext = new Extract();
        ext.printAttribute(Class.forName("displayingform.ClassEntity"));
        ext.javaToHtmlConverter();
    }
    }

