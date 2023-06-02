/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import models.Note;

/**
 *
 * @author danielchow
 */
public class NoteServlet extends HttpServlet {
    
    Note note = new Note();

    //@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(path));
        // to read files
        note.setTitle(br.readLine());  // 1st lline -- > title
        note.setContent(br.readLine()); // 2nd line --> content
        // create a model --> Note
        
        request.setAttribute("title", note.getTitle());
        request.setAttribute("content", note.getContent());

        String action = request.getParameter("edit");

        if (action != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // to write to a file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        String newTitle = request.getParameter("newT");
        String newContent = request.getParameter("newC");
        
        request.setAttribute("object", note.getTitle());
        
        note.setTitle(newTitle);
        note.setContent(newContent);
        
        pw.println(newTitle);
        pw.println(newContent);     

        // to close 
        pw.close();
        
        BufferedReader br = new BufferedReader(new FileReader(path));
        
        request.setAttribute("title", note.getTitle());
        request.setAttribute("content", note.getContent());
        
        
        br.close();


        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);

    }

}
