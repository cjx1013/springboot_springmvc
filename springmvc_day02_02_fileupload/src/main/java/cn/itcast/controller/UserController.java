package cn.itcast.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    //传统文件上传
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("fileUpload1执行了……");
        //获取上传路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //创建工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for(FileItem item:items){
            //进行判断，当前items是否是文件上传项
            if(item.isFormField()){
                //说明是普通表单项
            }else {
                //说明是文件上传项
                //获取上传文件名称
                String filename = item.getName();
                //把文件名称设置为唯一值
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                filename = uuid + "_" + filename;
                //完成上传
                item.write(new File(path,filename));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    //springMVC文件上传
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("fileUpload1执行了……");
        //获取上传路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        //把文件名称设置为唯一值
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        filename = uuid + "_" + filename;
        //完成上传
        upload.transferTo(new File(path,filename));

        return "success";
    }

    //springMVC跨服务器文件上传
    @RequestMapping("/fileUpload3")
    public String fileUpload3( MultipartFile upload) throws Exception {
        System.out.println("fileUpload3执行了……");
        String path = "http://localhost:9090/uploads/";
        //获取上传文件名称
        String filename = upload.getOriginalFilename();
        //把文件名称设置为唯一值
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        filename = uuid + "_" + filename;
        //完成上传
        upload.transferTo(new File(path,filename));
        //创建客户端对象
        Client client = Client.create();
        //和图片服务器连接
        WebResource webResource = client.resource(path+filename);
        //上传文件
        webResource.put(upload.getBytes());
        return "success";
    }
}
