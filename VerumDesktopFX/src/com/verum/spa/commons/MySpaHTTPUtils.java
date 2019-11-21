/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verum.spa.commons;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
* Esta clase nos sirve para leer las respuestas que 
* nos envia un servidor web así como el pasarle parametros a las 
* peticiones que le haremos
*     
*/
public class MySpaHTTPUtils {
    
    /**
     * This method allow us to read the data 
     * from a conection prevoiously stablished     
     * @param httpConn
     * @return
     * @throws Exception
     */
    public static String read(HttpURLConnection httpConn)throws Exception{
        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(),"UTF-8");
        
        BufferedReader br = new BufferedReader(isr);
        String content = "";
        String actualLine = null;
        
        while((actualLine = br.readLine())!=null)
            content += actualLine;
            
        return content;        
    }
    
    
    /**
     * Este metodo nos permite enviar datos a un servidor
     * a traves de una conexion HTTP previamente establecida
     * @param httpConn
     * @param content
     * @throws Exception
     */
    public static void write(HttpURLConnection httpConn, String content)throws Exception{        
        byte [] bytes = content.getBytes();
        DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
        dos.write(bytes);
        dos.close();
    }
    
    /**
     * Este metodo devuelve la longitud en bytes de una cadena
     * @param s
     * @return
     */
    public static int size(String s){
        return s!= null ? s.getBytes().length : 0;
    }
}
