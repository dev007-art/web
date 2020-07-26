package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public uploadServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    protected String uploadFile(HttpServletRequest request) {
        String savePath = request.getServletContext().getRealPath("/WEB-INF/uploadFile");
        File file=new File(savePath);
        if(!file.exists()){
            file.mkdirs();
            System.out.println("文件夹不存在，已自动创建成功!");
        }
        //获取上传的文件集合
        Part part;
        try {
            part = request.getPart("file");
            String header = part.getHeader("content-disposition");
            String fileName = getFileName(header);
            part.write(savePath+File.separator+fileName);
            System.out.println("上传成功");
            return savePath+File.separator+fileName;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }
    public String getFileName(String header) {
        String[] tempArr1 = header.split(";");
        String[] tempArr2 = tempArr1[2].split("=");
        String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
        return fileName;
    }
}

